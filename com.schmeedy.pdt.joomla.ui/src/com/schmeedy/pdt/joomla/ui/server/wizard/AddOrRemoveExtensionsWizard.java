package com.schmeedy.pdt.joomla.ui.server.wizard;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;

import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;

public class AddOrRemoveExtensionsWizard extends Wizard {

	private final AddOrRemoveExtensionsWizardSetupPage setupPage;
	private final AddOrRemoveExtensionsWizardResultPage resultPage;
	private final List<JoomlaExtensionProject> extensionProjects;
	private final DeploymentRuntime targetRuntime;
	
	public AddOrRemoveExtensionsWizard(List<JoomlaExtensionProject> extensionProjects, DeploymentRuntime targetRuntime) {
		this.extensionProjects = extensionProjects;
		this.targetRuntime = targetRuntime;
		this.setupPage = new AddOrRemoveExtensionsWizardSetupPage(extensionProjects, targetRuntime);
		this.resultPage = new AddOrRemoveExtensionsWizardResultPage();
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
