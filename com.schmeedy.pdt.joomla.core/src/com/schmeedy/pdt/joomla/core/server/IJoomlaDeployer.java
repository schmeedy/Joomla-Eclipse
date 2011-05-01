package com.schmeedy.pdt.joomla.core.server;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;

public interface IJoomlaDeployer {

	DeploymentDescriptor getDeploymentDescriptor();

	IStatus install(BasicExtensionModel extension, DeploymentRuntime runtime, IProgressMonitor progressMonitor);
	
	IStatus uninstall(JoomlaExtensionDeployment extensionDeployment, IProgressMonitor progressMonitor);
	
}
