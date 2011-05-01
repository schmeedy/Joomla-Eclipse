package com.schmeedy.pdt.joomla.ui.server.wizard;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;

import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;

public class AddOrRemoveExtensionsWizard extends Wizard {

	private final AddOrRemoveExtensionsWizardSetupPage setupPage;
	private final AddOrRemoveExtensionsWizardPerformReviewPage resultPage;
	
	public AddOrRemoveExtensionsWizard(List<JoomlaExtensionProject> extensionProjects, DeploymentRuntime targetRuntime, IJoomlaDeployer deployer) {
		this.setupPage = new AddOrRemoveExtensionsWizardSetupPage(extensionProjects, targetRuntime, deployer);
		this.resultPage = new AddOrRemoveExtensionsWizardPerformReviewPage(setupPage, targetRuntime, deployer);
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		addPage(setupPage);
		addPage(resultPage);
	}
	
	@Override
	public boolean performFinish() {
		return true;
	}

}
