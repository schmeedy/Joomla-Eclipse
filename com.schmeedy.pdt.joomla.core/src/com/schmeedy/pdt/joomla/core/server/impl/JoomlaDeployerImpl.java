package com.schmeedy.pdt.joomla.core.server.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.htmlcleaner.TagNode;
import org.osgi.framework.BundleContext;

import com.schmeedy.pdt.joomla.core.JoomlaCorePlugin;
import com.schmeedy.pdt.joomla.core.project.IExtensionModelChangeListener;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.IJoomlaHttpSession;
import com.schmeedy.pdt.joomla.core.server.IJoomlaHttpSession.IMethodFactory;
import com.schmeedy.pdt.joomla.core.server.ServerUtils;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationFactory;
import com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion;
import com.schmeedy.pdt.joomla.core.server.impl.JoomlaSystemMessage.MessageSeverity;

@SuppressWarnings("restriction")
public class JoomlaDeployerImpl implements IJoomlaDeployer, IExtensionModelChangeListener {

	private static final String DESCRIPTOR_FILENAME = "deployment.xmi";
	
	private URI descriptorResourceUri;
	private DeploymentDescriptor deploymentDescriptor;
	
	public void activate(BundleContext bundleContext) {
		final IPath stateArea = InternalPlatform.getDefault().getStateLocation(bundleContext.getBundle(), true);
		descriptorResourceUri = URI.createFileURI(new File(stateArea.toFile(), DESCRIPTOR_FILENAME).getAbsolutePath());
	}
	
	public void deactivate() {
		deploymentDescriptor = null;
	}
	
	@Override
	public void onExtensionModelChange(BasicExtensionModel extensionModel) {
		final JoomlaExtensionDeployment deployment = ServerUtils.getExtensionDeployment(extensionModel, getDeploymentDescriptor());
		if (deployment != null) {
			ServerUtils.copyAttributes(extensionModel, deployment.getExtension());
			saveDescriptor();
		}
	}
	
	@Override
	public DeploymentDescriptor getDeploymentDescriptor() {
		if (deploymentDescriptor == null) {
			final ResourceSet resourceSet = new ResourceSetImpl();
			final File descriptorFile = new File(descriptorResourceUri.toFileString());
			final Resource descriptorResource;
			descriptorResource = descriptorFile.exists() ? resourceSet.getResource(descriptorResourceUri, true) : resourceSet.createResource(descriptorResourceUri);
			if (descriptorResource.getContents().isEmpty()) {
				deploymentDescriptor = JoomlaServerConfigurationFactory.eINSTANCE.createDeploymentDescriptor();
				descriptorResource.getContents().add(deploymentDescriptor);
			} else {
				deploymentDescriptor = (DeploymentDescriptor) descriptorResource.getContents().get(0);
			}
		}
		return deploymentDescriptor;
	}
	
	void saveDescriptor() {
		try {
			deploymentDescriptor.eResource().save(Collections.singletonMap(XMLResource.OPTION_ENCODING, "UTF-8"));
		} catch (final IOException e) {
			throw new RuntimeException("Failed to save deployment descriptor.", e);
		}
	}

	@Override
	public IStatus install(BasicExtensionModel extension, DeploymentRuntime transientRuntime, IProgressMonitor progressMonitor) {
		try {
			progressMonitor.beginTask("Install " + extension.getName(), 2000);
			final DeploymentRuntime persistentRuntime = ServerUtils.getPersistentDeploymentRuntime(transientRuntime, getDeploymentDescriptor());
			final IJoomlaHttpSession session = persistentRuntime.getHttpSession();
			final String extensionDir = ResourcesPlugin.getWorkspace().getRoot().getFile(extension.getManifestPath()).getLocation().toFile().getParent();
			
			final TagNode installPage = session.executeAndParseResponseBody(new PrepareInstallationRequest(persistentRuntime), true, new SubProgressMonitor(progressMonitor, 1000));
			final String adminFormAttribute = persistentRuntime.getServer().getMajorVersion() == MajorJoomlaVersion.ONE_SIX ? "id" : "name";
			final List<NameValuePair> installParams = ServerUtils.extractInputNameValuePairs("//form[@" + adminFormAttribute + "='adminForm']//input[@type='hidden']", installPage);
			final Iterator<NameValuePair> i = installParams.iterator();
			while (i.hasNext()) {
				final NameValuePair param = i.next();
				if ("installtype".equals(param.getName())) {
					i.remove();
				}
			}
			installParams.add(new NameValuePair("installtype", "folder"));
			installParams.add(new NameValuePair("install_directory", extensionDir));
			
			final TagNode result = session.executeAndParseResponseBody(new GenericPostRequest("administrator/index.php?option=com_installer&view=install", persistentRuntime, installParams), true, new SubProgressMonitor(progressMonitor, 1000));
			final JoomlaSystemMessage systemMessage = ServerUtils.extractFirstSystemMessage(result);
			if (systemMessage == null || systemMessage.getSeverity() == MessageSeverity.INFO) {
				newDeployment(extension, persistentRuntime);
				return systemMessage == null ? JoomlaCorePlugin.newStatus(IStatus.WARNING, "No confirmation message. Installation likely failed.") : JoomlaCorePlugin.newStatus(IStatus.OK, systemMessage.getMessage());
			} else {
				// really a warning, because it might be "extension already installed" type of message
				// TODO: possibly try to distinguish between failure & "already installed" - fetch list of extensions
				newDeployment(extension, persistentRuntime);
				return JoomlaCorePlugin.newStatus(IStatus.WARNING, systemMessage.getMessage());
			}
		} catch (final RuntimeException e) {
			final String message = "Unexpected exception while installing extension " + extension.getName();
			JoomlaCorePlugin.logError(message, e);
			return JoomlaCorePlugin.newStatus(IStatus.ERROR, message, e);
		} finally {
			progressMonitor.done();
		}
	}
	
	private void newDeployment(BasicExtensionModel extension, DeploymentRuntime persistentRuntime) {
		final BasicExtensionModel copy = EcoreUtil.copy(extension); // safety copy
		final JoomlaExtensionDeployment deployment = JoomlaServerConfigurationFactory.eINSTANCE.createJoomlaExtensionDeployment();
		deployment.setExtension(copy);
		boolean alreadyDeployed = false;
		for (final JoomlaExtensionDeployment currentDeployment : persistentRuntime.getDeployedExtensions()) {
			if (ServerUtils.equals(extension, currentDeployment.getExtension())) {
				alreadyDeployed = true;
			}
		}
		if (!alreadyDeployed) {
			persistentRuntime.getDeployedExtensions().add(deployment);
			boolean success = false;
			try {
				saveDescriptor();
				success = true;
			} finally {
				if (!success) { // rollback to persistent state
					persistentRuntime.getDeployedExtensions().remove(deployment);
				}
			}
		}
	}

	@Override
	public IStatus uninstall(JoomlaExtensionDeployment transientDeployment, IProgressMonitor progressMonitor) {
		try {
			final JoomlaExtensionDeployment persistentDeployment = ServerUtils.getPersistentExtensionDeployment(transientDeployment, getDeploymentDescriptor());
			final MajorJoomlaVersion joomlaVersion = persistentDeployment.getRuntime().getServer().getMajorVersion();
			switch (joomlaVersion) {
				case ONE_FIVE:
					return uninstallFromJoomlaOneFive(persistentDeployment, progressMonitor);
				case ONE_SIX:
					return uninstallFromJoomlaOneSix(persistentDeployment, progressMonitor);
				default:
					return JoomlaCorePlugin.newStatus(IStatus.ERROR, "Uninstallation not supported for Joomla! version: " + joomlaVersion);
			}
		} catch (final RuntimeException e) {
			final String message = "Unexpected exception while installing extension" + transientDeployment.getExtension().getName();
			JoomlaCorePlugin.logError(message, e);
			return JoomlaCorePlugin.newStatus(IStatus.ERROR, message, e);
		}
	}

	private IStatus uninstallFromJoomlaOneFive(JoomlaExtensionDeployment persistentDeployment, IProgressMonitor progressMonitor) {
		try {
			progressMonitor.beginTask("Uninstall " + persistentDeployment.getExtension().getName(), 2000);
			
			final DeploymentRuntime runtime = persistentDeployment.getRuntime();
			final IJoomlaHttpSession session = runtime.getHttpSession();
			final BasicExtensionModel extension = persistentDeployment.getExtension();
			
			final TagNode extensionManagementPage = session.executeAndParseResponseBody(new PrepareRemovalRequestOneFive(runtime, extension), true, new SubProgressMonitor(progressMonitor, 1000));
			final String extensionId = getExtensionIdOneFive(extension.getName(), extensionManagementPage);
			if (extensionId == null) {
				removeDeployment(persistentDeployment);
				return JoomlaCorePlugin.newStatus(IStatus.WARNING, "Extension " + extension.getName() + " has not been found on server. It's possible it's already been uninstalled.");
			}
			
			final List<NameValuePair> uninstallRequestParams = new LinkedList<NameValuePair>();
			uninstallRequestParams.add(new NameValuePair("task", "manage"));
			uninstallRequestParams.add(new NameValuePair("option", "com_installer"));
			uninstallRequestParams.add(new NameValuePair("task", "remove"));
			uninstallRequestParams.add(new NameValuePair("eid[]", extensionId));
			uninstallRequestParams.add(ServerUtils.extractSessionTokenParam(extensionManagementPage));
			final TagNode result = session.executeAndParseResponseBody(new GenericPostRequest("administrator/index.php", runtime, uninstallRequestParams), true, new SubProgressMonitor(progressMonitor, 1000));
			return processUninstallationResult(persistentDeployment, result);
		} finally {
			progressMonitor.done();
		}
	}

	private IStatus uninstallFromJoomlaOneSix(final JoomlaExtensionDeployment persistentDeployment, IProgressMonitor progressMonitor) {
		try {
			progressMonitor.beginTask("Uninstall " + persistentDeployment.getExtension().getName(), 2000);
			
			final DeploymentRuntime runtime = persistentDeployment.getRuntime();
			final IJoomlaHttpSession session = runtime.getHttpSession();
			final BasicExtensionModel extension = persistentDeployment.getExtension();
			
			final TagNode extensionManagementPage = session.executeAndParseResponseBody(new PrepareRemovalRequestOneSix(runtime, extension), true, new SubProgressMonitor(progressMonitor, 1000));
			final String extensionId = getExtensionIdOneSix(extension.getName(), extensionManagementPage);
			if (extensionId == null) {
				removeDeployment(persistentDeployment);
				return JoomlaCorePlugin.newStatus(IStatus.WARNING, "Extension " + extension.getName() + " has not been found on server. It's possible it's already been uninstalled.");
			}
			
			final List<NameValuePair> uninstallRequestParams = new LinkedList<NameValuePair>();
			uninstallRequestParams.add(new NameValuePair("task", "manage.remove"));
			uninstallRequestParams.add(new NameValuePair("cid[]", extensionId));
			uninstallRequestParams.add(ServerUtils.extractSessionTokenParam(extensionManagementPage));
			final TagNode result = session.executeAndParseResponseBody(new GenericPostRequest("administrator/index.php?option=com_installer&view=manage", runtime, uninstallRequestParams), true, new SubProgressMonitor(progressMonitor, 1000));
			return processUninstallationResult(persistentDeployment, result);
		} finally {
			progressMonitor.done();
		}
	}

	private IStatus processUninstallationResult(final JoomlaExtensionDeployment persistentDeployment, final TagNode uninstallationResultPage) {
		final JoomlaSystemMessage systemMessage = ServerUtils.extractFirstSystemMessage(uninstallationResultPage);
		if (systemMessage == null || systemMessage.getSeverity() == MessageSeverity.INFO) {
			removeDeployment(persistentDeployment);
			return systemMessage == null ? JoomlaCorePlugin.newStatus(IStatus.WARNING, "No confirmation message. Uninstallation likely failed.") : JoomlaCorePlugin.newStatus(IStatus.OK, systemMessage.getMessage());
		} else {
			// warning as it might be "already uninstalled" type of message
			// TODO: same as with install - try to verify it's uninstalled
			removeDeployment(persistentDeployment);
			return JoomlaCorePlugin.newStatus(IStatus.WARNING, systemMessage.getMessage());
		}
	}
		
	private void removeDeployment(JoomlaExtensionDeployment extensionDeployment) {
		if (extensionDeployment.getRuntime() != null) {
			extensionDeployment.getRuntime().getDeployedExtensions().remove(extensionDeployment);
			boolean success = false;
			try {
				saveDescriptor();
				success = true;
			} finally {
				if (!success) { // rollback to persistent state (not respecting original index, but should be good enough :)
					extensionDeployment.getRuntime().getDeployedExtensions().add(extensionDeployment);
				}
			}
		}
	}

	private String getExtensionIdOneFive(String extensionName, TagNode extensionManagementPage) {
		return internalGetExtensionId(extensionName, extensionManagementPage, "eid");
	}
	
	private String getExtensionIdOneSix(String extensionName, TagNode extensionManagementPage) {
		return internalGetExtensionId(extensionName, extensionManagementPage, "cid[]");
	}

	private String internalGetExtensionId(String extensionName, TagNode extensionManagementPage, String extensionIdInputName) {
		final TagNode adminTableBody = ServerUtils.evaluateXPathForSingleTag("//table[@class='adminlist']//tbody", extensionManagementPage);;
		if (adminTableBody == null) {
			return null;
		}
		
		for (final TagNode rowNode : adminTableBody.getElementsByName("tr", true)) {
			final TagNode inputNode = ServerUtils.evaluateXPathForSingleTag("//input[@name='" + extensionIdInputName + "']", rowNode);
			if (inputNode == null) {
				continue;
			}
			final String extensionId = inputNode.getAttributeByName("value");
			for (final TagNode columnNode : rowNode.getElementsByName("td", false)) {
				if (extensionName.equalsIgnoreCase(columnNode.getText().toString().trim())) {
					return extensionId;
				}
			}
		}
		return null;
	}
	
	private static class PrepareInstallationRequest implements IMethodFactory {
		private final DeploymentRuntime runtime;
		
		public PrepareInstallationRequest(DeploymentRuntime runtime) {
			this.runtime = runtime;
		}

		@Override
		public HttpMethod createMethod() {
			final String url = ServerUtils.getUrl(runtime, "administrator/index.php?option=com_installer&view=install");
			final GetMethod request = new GetMethod(url);			
			return request;
		}
	}
	
	private static class GenericPostRequest implements IMethodFactory {
		private final String pageUrl;
		private final DeploymentRuntime runtime;
		private final List<NameValuePair> requestParams;
		
		public GenericPostRequest(String pageUrl, DeploymentRuntime runtime, List<NameValuePair> requestParams) {
			super();
			this.pageUrl = pageUrl;
			this.runtime = runtime;
			this.requestParams = requestParams;
		}
		
		@Override
		public HttpMethod createMethod() {
			final String url = ServerUtils.getUrl(runtime, pageUrl);
			final PostMethod request = new PostMethod(url);
			request.setRequestBody(requestParams.toArray(new NameValuePair[requestParams.size()]));
			return request;
		}
	}
	
	private static class PrepareRemovalRequestOneFive implements IMethodFactory {
		private final DeploymentRuntime runtime;
		private final String extensionType;

		public PrepareRemovalRequestOneFive(DeploymentRuntime runtime, BasicExtensionModel extension) {
			this.runtime = runtime;
			this.extensionType = extension.getType().name().toLowerCase() + "s";
		}
		
		@Override
		public HttpMethod createMethod() {
			final String url = ServerUtils.getUrl(runtime, "administrator/index.php");
			final PostMethod request = new PostMethod(url);
			request.setRequestBody(new NameValuePair[] {
					new NameValuePair("task", "manage"),
					new NameValuePair("option", "com_installer"),
					new NameValuePair("type", extensionType) ,
					new NameValuePair("limit", "0")
			});
			return request;
		}
	}
	
	private static class PrepareRemovalRequestOneSix implements IMethodFactory {
		private final DeploymentRuntime runtime;
		private final String extensionName;

		public PrepareRemovalRequestOneSix(DeploymentRuntime runtime, BasicExtensionModel extension) {
			super();
			this.runtime = runtime;
			this.extensionName = extension.getName();
		}
		
		@Override
		public HttpMethod createMethod() {
			final String url = ServerUtils.getUrl(runtime, "administrator/index.php?option=com_installer&view=manage");
			final PostMethod request = new PostMethod(url);
			request.setRequestBody(new NameValuePair[] { new NameValuePair("filters[search]", extensionName) });
			return request;
		}
	}
	
}
