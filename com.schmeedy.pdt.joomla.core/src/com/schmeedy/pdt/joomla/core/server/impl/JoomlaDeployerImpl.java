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
			final List<NameValuePair> installParams = ServerUtils.extractInputNameValuePairs("//form[@id='adminForm']//input[@type='hidden']", installPage);
			final Iterator<NameValuePair> i = installParams.iterator();
			while (i.hasNext()) {
				final NameValuePair param = i.next();
				if ("installtype".equals(param.getName())) {
					i.remove();
				}
			}
			installParams.add(new NameValuePair("installtype", "folder"));
			installParams.add(new NameValuePair("install_directory", extensionDir));
			
			final TagNode result = session.executeAndParseResponseBody(new GenericPostRequest("administrator/index.php?option=com_installer&amp;view=install", persistentRuntime, installParams), true, new SubProgressMonitor(progressMonitor, 1000));
			final JoomlaSystemMessage systemMessage = ServerUtils.extractFirstSystemMessage(result);
			if (systemMessage == null || systemMessage.getSeverity() == MessageSeverity.INFO) {
				newDeployment(extension, persistentRuntime);
				return JoomlaCorePlugin.newStatus(IStatus.OK, systemMessage == null ? "Extension successfully installed." : systemMessage.getMessage());
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
			progressMonitor.beginTask("Uninstall " + transientDeployment.getExtension().getName(), 2000);			
			final JoomlaExtensionDeployment persistentDeployment = ServerUtils.getPersistentExtensionDeployment(transientDeployment, getDeploymentDescriptor());
			final DeploymentRuntime runtime = persistentDeployment.getRuntime();
			final IJoomlaHttpSession session = runtime.getHttpSession();
			final String extensionName = persistentDeployment.getExtension().getName();
			
			final TagNode extensionManagementPage = session.executeAndParseResponseBody(new PrepareRemovalRequest(runtime, extensionName), true, new SubProgressMonitor(progressMonitor, 1000));
			final String extensionId = getExtensionId(extensionName, extensionManagementPage);
			if (extensionId == null) {
				removeDeployment(persistentDeployment);
				return JoomlaCorePlugin.newStatus(IStatus.WARNING, "Extension " + extensionName + " has not been found on server. It's possible it's already been uninstalled.");
			}
			
			final List<NameValuePair> uninstallRequestParams = new LinkedList<NameValuePair>();
			uninstallRequestParams.add(new NameValuePair("task", "manage.remove"));
			uninstallRequestParams.add(new NameValuePair("cid[]", extensionId));
			uninstallRequestParams.add(ServerUtils.extractSessionTokenParam(extensionManagementPage));
			final TagNode result = session.executeAndParseResponseBody(new GenericPostRequest("administrator/index.php?option=com_installer&view=manage", runtime, uninstallRequestParams), true, new SubProgressMonitor(progressMonitor, 1000));
			final JoomlaSystemMessage systemMessage = ServerUtils.extractFirstSystemMessage(result);
			if (systemMessage == null || systemMessage.getSeverity() == MessageSeverity.INFO) {
				removeDeployment(persistentDeployment);
				return JoomlaCorePlugin.newStatus(IStatus.OK, systemMessage == null ? "Extension successfully uninstalled." : systemMessage.getMessage());
			} else {
				// warning as it might be "already uninstalled" type of message
				// TODO: same as with install - try to verify it's uninstalled
				removeDeployment(persistentDeployment);
				return JoomlaCorePlugin.newStatus(IStatus.WARNING, systemMessage.getMessage());
			}
		} catch (final RuntimeException e) {
			final String message = "Unexpected exception while installing extension" + transientDeployment.getExtension().getName();
			JoomlaCorePlugin.logError(message, e);
			return JoomlaCorePlugin.newStatus(IStatus.ERROR, message, e);
		} finally  {
			progressMonitor.done();
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

	private String getExtensionId(String extensionName, TagNode extensionManagementPage) {
		final TagNode adminTableBody = ServerUtils.evaluateXPathForSingleTag("//table[@class='adminlist']//tbody", extensionManagementPage);;
		if (adminTableBody == null) {
			return null;
		}
		
		for (final TagNode rowNode : adminTableBody.getElementsByName("tr", true)) {
			final TagNode inputNode = ServerUtils.evaluateXPathForSingleTag("//input[@name='cid[]']", rowNode);
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
			final String url = ServerUtils.getUrl(runtime, "administrator/index.php?option=com_installer&amp;view=install");
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
	
	private static class PrepareRemovalRequest implements IMethodFactory {
		private final DeploymentRuntime runtime;
		private final String extensionName;

		public PrepareRemovalRequest(DeploymentRuntime runtime, String extensionName) {
			super();
			this.runtime = runtime;
			this.extensionName = extensionName;
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
