package com.schmeedy.pdt.joomla.ui.project.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.ui.wizards.NewElementWizard;

public class NewExtensionProjectWizard extends NewElementWizard {

	private NewExtensionProjectWizardFirstPage firstPage;
	private NewExtensionProjectWizardSecondPage secondPage;
	
	public NewExtensionProjectWizard() {
		setWindowTitle("New Joomla! Extension Project");
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public void addPages() {
		firstPage = new NewExtensionProjectWizardFirstPage();
		addPage(firstPage);

		secondPage = new NewExtensionProjectWizardSecondPage(firstPage);
		addPage(secondPage);
	}
	
	@Override
	protected void finishPage(IProgressMonitor monitor) throws InterruptedException, CoreException {
		if (secondPage != null) {
			secondPage.performFinish(monitor);
		}
	}

	@Override
	public IModelElement getCreatedElement() {
		return secondPage == null ? null : secondPage.getCreatedProject();
	}

}
