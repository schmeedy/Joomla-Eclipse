package com.schmeedy.pdt.joomla.ui.project.wizard;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.ui.wizards.NewElementWizard;

import com.schmeedy.pdt.joomla.core.project.importer.IJoomlaExtensionPackageImporter;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

public class ImportExtensionWizard extends NewElementWizard {
	
	private final IJoomlaExtensionPackageImporter importer = ServiceRegistry.getInstance().getService(IJoomlaExtensionPackageImporter.class);

	private ImportExtensionWizardFirstPage firstPage;
	private ImportExtensionWizardSecondPage secondPage;
	
	public ImportExtensionWizard() {
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public void addPages() {
		firstPage = new ImportExtensionWizardFirstPage();
		secondPage = new ImportExtensionWizardSecondPage(firstPage, importer);

		addPage(firstPage);
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
		if (secondPage != null) {
			final List<IScriptProject> projects = secondPage.getImportedProjects();
			return projects.isEmpty() ? null : projects.get(0);
		} else {
			return null;
		}
	}

}
