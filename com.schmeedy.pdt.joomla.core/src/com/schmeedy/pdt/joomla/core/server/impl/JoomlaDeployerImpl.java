package com.schmeedy.pdt.joomla.core.server.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.htmlcleaner.TagNode;
import org.osgi.framework.BundleContext;

import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.IJoomlaHttpSession;
import com.schmeedy.pdt.joomla.core.server.IJoomlaHttpSession.IMethodFactory;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationFactory;

@SuppressWarnings("restriction")
public class JoomlaDeployerImpl implements IJoomlaDeployer {

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

	// TEMPORARY
	public void install(DeploymentRuntime runtime, String extensionDir) {
		final IJoomlaHttpSession session = runtime.getHttpSession();
		final TagNode installPage = session.executeAndParseResponseBody(new PrepareInstallationRequest(runtime), true);
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
		
		final TagNode result = session.executeAndParseResponseBody(new InstallRequest(runtime, installParams), true);
		System.out.println(ServerUtils.serialize(result)); // TODO: verify result
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
	
	private static class InstallRequest implements IMethodFactory {
		private final DeploymentRuntime runtime;
		private final List<NameValuePair> requestParams;
		
		public InstallRequest(DeploymentRuntime runtime, List<NameValuePair> requestParams) {
			super();
			this.runtime = runtime;
			this.requestParams = requestParams;
		}
		
		@Override
		public HttpMethod createMethod() {
			final String url = ServerUtils.getUrl(runtime, "administrator/index.php?option=com_installer&amp;view=install");
			final PostMethod request = new PostMethod(url);
			request.setRequestBody(requestParams.toArray(new NameValuePair[requestParams.size()]));
			return request;
		}
	}
	
}
