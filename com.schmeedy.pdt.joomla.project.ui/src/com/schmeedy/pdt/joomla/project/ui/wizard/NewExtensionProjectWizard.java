package com.schmeedy.pdt.joomla.project.ui.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.ui.wizards.NewElementWizard;
import org.eclipse.php.internal.ui.PHPUIMessages;
import org.eclipse.php.internal.ui.wizards.PHPProjectWizardSecondPage;
import org.eclipse.php.internal.ui.wizards.PHPProjectWizardThirdPage;

@SuppressWarnings("restriction")
public class NewExtensionProjectWizard extends NewElementWizard {

	private NewExtensionProjectWizardFirstPage firstPage;
	private PHPProjectWizardSecondPage secondPage;
	private PHPProjectWizardThirdPage thirdPage;

	@Override
	public void addPages() {
		firstPage = new NewExtensionProjectWizardFirstPage();
		addPage(firstPage);

		secondPage = new PHPProjectWizardSecondPage(firstPage);
		secondPage.setTitle(PHPUIMessages.PHPProjectCreationWizard_Page2Title);
		secondPage.setDescription(PHPUIMessages.PHPProjectCreationWizard_Page2Description);
		addPage(secondPage);

		thirdPage = new PHPProjectWizardThirdPage(firstPage);
		thirdPage.setTitle(PHPUIMessages.PHPProjectCreationWizard_Page3Title);
		thirdPage.setDescription(PHPUIMessages.PHPProjectCreationWizard_Page3Description);
		addPage(thirdPage);
	}

	@Override
	public boolean performFinish() {
		final boolean success = super.performFinish();
		if (success) {
			selectAndReveal(thirdPage.getScriptProject().getProject());
		}
		return success;
	}
	
	@Override
	public boolean performCancel() {
		secondPage.performCancel();
		return true;
	}

	@Override
	protected void finishPage(IProgressMonitor monitor) throws InterruptedException, CoreException {
		final int work = (firstPage == null ? 0 : 1000) + (secondPage == null ? 0 : 1000) + (thirdPage == null ? 0 : 1000);
		try {
			monitor.beginTask("Finish all pages.", work);
			if (firstPage != null) {
				firstPage.performFinish(new SubProgressMonitor(monitor, 1000));
			}
			if (secondPage != null) {
				secondPage.performFinish(new SubProgressMonitor(monitor, 1000));
			}
			if (thirdPage != null) {
				thirdPage.performFinish(new SubProgressMonitor(monitor, 1000));
			}
		} finally {
			monitor.done();
		}
	}

	@Override
	public IModelElement getCreatedElement() {
		return DLTKCore.create(firstPage.getProjectHandle());
	}

}
