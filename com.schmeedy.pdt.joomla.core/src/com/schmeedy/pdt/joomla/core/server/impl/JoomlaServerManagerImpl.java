package com.schmeedy.pdt.joomla.core.server.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.osgi.framework.BundleContext;
import org.osgi.service.prefs.BackingStoreException;

import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationFactory;

public class JoomlaServerManagerImpl implements IJoomlaServerManager {

	private static final String CONFIGURATION_PREFERENCE_KEY = "cfg";
	private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");;
	
	private DeploymentDescriptorSynchronizer deploymentDescriptorSynchronizer;
	
	private IEclipsePreferences preferences;
	
	private AvailableServers availableServers;

		
	public void activate(BundleContext bundleContext) {
		this.preferences = new InstanceScope().getNode(bundleContext.getBundle().getSymbolicName());
	}
	
	public void deactivate() {
		this.preferences = null;
	}

	@Override
	public AvailableServers getAvailableServers() {
		if (availableServers == null) {
			final String serializedModel = preferences.get(CONFIGURATION_PREFERENCE_KEY, null);
			if (serializedModel == null) {
				availableServers = JoomlaServerConfigurationFactory.eINSTANCE.createAvailableServers();
			} else {
				final InputStream in = new ByteArrayInputStream(serializedModel.getBytes(UTF8_CHARSET));
				final Resource modelResource = new XMIResourceImpl(URI.createURI("preferences:" + preferences.name() + "." + CONFIGURATION_PREFERENCE_KEY));
				try {
					modelResource.load(in, Collections.singletonMap(XMLResource.OPTION_ENCODING, "UTF-8"));
				} catch (final IOException e) {
					throw new RuntimeException("Failed to load server configuration resource.", e);
				}
				availableServers = (AvailableServers) modelResource.getContents().get(0);
			}
		}
		return EcoreUtil.copy(availableServers);
	}
	
	@Override
	public void updateAvailableServers(AvailableServers availableServers) {
		boolean success = false;
		
		try {
			deploymentDescriptorSynchronizer.synchronizeDeploymentRuntimes(availableServers);

			final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			final Resource modelResource;
			if (availableServers.eResource() == null) {
				modelResource = new XMIResourceImpl();
				modelResource.getContents().add(availableServers);
			} else {
				modelResource = availableServers.eResource();
			}
			modelResource.save(buffer, Collections.singletonMap(XMLResource.OPTION_ENCODING, "UTF-8"));
			final String stringSerialization = buffer.toString(UTF8_CHARSET.name());
			
			preferences.put(CONFIGURATION_PREFERENCE_KEY, stringSerialization);
			preferences.flush();
			
			this.availableServers = availableServers;
			success = true;
		} catch (final IOException e) {
			throw new RuntimeException("Failed to save server configuration resource.", e);
		} catch (final BackingStoreException e) {
			throw new RuntimeException("Failed to flush changes to the preference store.", e);
		}
		
		if (!success) { // attempt to roll-back changes upon failure to persist available servers into preferences
			deploymentDescriptorSynchronizer.synchronizeDeploymentRuntimes(this.availableServers);
		}
	}
	
	public void setDeployer(IJoomlaDeployer deployer) {
		deploymentDescriptorSynchronizer = new DeploymentDescriptorSynchronizer(deployer);
	}

	public void unsetDeployer(IJoomlaDeployer deployer) {
		deploymentDescriptorSynchronizer = null;
	}
	
}
