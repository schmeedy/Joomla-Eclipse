package com.schmeedy.pdt.joomla.core.server.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.ServerUtils;
import com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationFactory;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;

class DeploymentDescriptorSynchronizer {

	private final IJoomlaDeployer deployer;

	public DeploymentDescriptorSynchronizer(IJoomlaDeployer deployer) {
		Assert.isNotNull(deployer);
		this.deployer = deployer;
	}
	
	public void synchronizeDeploymentRuntimes(AvailableServers availableServers) {
		final Map<String, LocalJoomlaServer> serverIdToConfigurationMap = new HashMap<String, LocalJoomlaServer>();
		for (final LocalJoomlaServer server : availableServers.getServers()) {
			serverIdToConfigurationMap.put(server.getId(), server);
		}
		
		final DeploymentDescriptor deploymentDescriptor = deployer.getDeploymentDescriptor();
		final Iterator<DeploymentRuntime> i = deploymentDescriptor.getRuntimes().iterator();
		while (i.hasNext()) {
			final DeploymentRuntime runtime = i.next();
			final String serverId = runtime.getServer().getId();
			if (serverIdToConfigurationMap.containsKey(serverId)) {
				final LocalJoomlaServer currentServerConfiguration = serverIdToConfigurationMap.get(serverId);
				if (currentServerConfiguration.getAdminUserCredentials() == null) {
					runtime.getServer().setAdminUserCredentials(null);
				} else {
					if (runtime.getServer().getAdminUserCredentials() == null) {
						runtime.getServer().setAdminUserCredentials(JoomlaServerConfigurationFactory.eINSTANCE.createUserCredentials());
					}
					ServerUtils.copyAttributes(currentServerConfiguration.getAdminUserCredentials(), runtime.getServer().getAdminUserCredentials());
				}
				ServerUtils.copyAttributes(currentServerConfiguration, runtime.getServer());
				serverIdToConfigurationMap.remove(serverId); // remove to leave only unmatched servers in the map
			} else {
				i.remove();
			}
		}
		
		for (final LocalJoomlaServer newServer : serverIdToConfigurationMap.values()) {
			final DeploymentRuntime newRuntime = JoomlaServerConfigurationFactory.eINSTANCE.createDeploymentRuntime();
			newRuntime.setServer(EcoreUtil.copy(newServer));
			deploymentDescriptor.getRuntimes().add(newRuntime);
		}
		
		((JoomlaDeployerImpl) deployer).saveDescriptor();
	}	
	
}
