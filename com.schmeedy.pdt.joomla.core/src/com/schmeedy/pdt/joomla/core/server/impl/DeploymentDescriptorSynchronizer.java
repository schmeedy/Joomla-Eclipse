package com.schmeedy.pdt.joomla.core.server.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
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
				copyAttributes(currentServerConfiguration, runtime.getServer());
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

	private void copyAttributes(EObject source, EObject target) {
		Assert.isTrue(source.eClass() == target.eClass(), "Cannot copy attributes between instances of two distinct EClasses.");
		for (final EAttribute attribute : source.eClass().getEAllAttributes()) {
			final Object sourceValue = source.eGet(attribute);
			final Object targetValue = target.eGet(attribute);
			if (!areEqual(sourceValue, targetValue)) {
				target.eSet(attribute, sourceValue);
			}
		}
	}
	
	private boolean areEqual(Object o1, Object o2) {
		return o1 == null ? o2 == null : o1.equals(o2);
	}
	
}
