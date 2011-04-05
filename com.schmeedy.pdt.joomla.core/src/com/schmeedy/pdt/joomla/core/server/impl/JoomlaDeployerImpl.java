package com.schmeedy.pdt.joomla.core.server.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.osgi.framework.BundleContext;

import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor;
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
			final File descriptorFile = new File(descriptorResourceUri.opaquePart());
			final Resource descriptorResource;
			descriptorResource = descriptorFile.exists() ? resourceSet.getResource(descriptorResourceUri, true) : resourceSet.createResource(descriptorResourceUri);
			if (descriptorResource.getContents().isEmpty()) {
				deploymentDescriptor = JoomlaServerConfigurationFactory.eINSTANCE.createDeploymentDescriptor();
				descriptorResource.getContents().add(deploymentDescriptor);
				saveDescriptor();
			} else {
				deploymentDescriptor = (DeploymentDescriptor) descriptorResource.getContents().get(0);
			}
		}
		return deploymentDescriptor;
	}
	
	private void saveDescriptor() {
		try {
			deploymentDescriptor.eResource().save(Collections.singletonMap(XMLResource.OPTION_ENCODING, "UTF-8"));
		} catch (final IOException e) {
			throw new RuntimeException("Failed to save deployment descriptor.", e);
		}
	}

}
