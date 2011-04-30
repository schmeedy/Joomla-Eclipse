package com.schmeedy.pdt.joomla.ui.server.wizard;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;

import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;

public class AddOrRemoveExtensionsWizard extends Wizard {

	private final AddOrRemoveExtensionsWizardSetupPage firstPage;
	private final List<JoomlaExtensionProject> extensionProjects;
	private final DeploymentRuntime targetRuntime;
	
	public AddOrRemoveExtensionsWizard(List<JoomlaExtensionProject> extensionProjects, DeploymentRuntime targetRuntime) {
		this.extensionProjects = extensionProjects;
		this.targetRuntime = targetRuntime;
		this.firstPage = new AddOrRemoveExtensionsWizardSetupPage(extensionProjects, targetRuntime);
	}

	@Override
	public void addPages() {
		addPage(firstPage);
	}
	
	@Override
	public boolean performFinish() {
		return true;
	}

}
