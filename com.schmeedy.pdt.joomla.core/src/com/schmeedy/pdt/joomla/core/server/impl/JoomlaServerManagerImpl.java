package com.schmeedy.pdt.joomla.core.server.impl;

import java.io.ByteArrayInputStream;
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

import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationFactory;

public class JoomlaServerManagerImpl implements IJoomlaServerManager {

	private static final String CONFIGURATION_PREFERENCE_KEY = "cfg";
	
	private BundleContext bundleContext;
	private IEclipsePreferences preferences;
	private IJoomlaDeployer deployer;
	
	private AvailableServers availableServers;
		
	public void activate(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
		this.preferences = new InstanceScope().getNode(bundleContext.getBundle().getSymbolicName());
	}
	
	public void deactivate() {
		this.bundleContext = null;
		this.preferences = null;
	}

	@Override
	public AvailableServers getAvailableServers() {
		if (availableServers == null) {
			final String serializedModel = preferences.get(CONFIGURATION_PREFERENCE_KEY, null);
			if (serializedModel == null) {
				availableServers = JoomlaServerConfigurationFactory.eINSTANCE.createAvailableServers();
			} else {
				final InputStream in = new ByteArrayInputStream(serializedModel.getBytes(Charset.forName("UTF-8")));
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
		
	}
	
	public void setDeployer(IJoomlaDeployer deployer) {
		this.deployer = deployer;
	}

	public void unsetDeployer(IJoomlaDeployer deployer) {
		this.deployer = null;
	}
	
}
