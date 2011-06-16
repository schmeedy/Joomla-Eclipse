package com.schmeedy.pdt.joomla.ui.project.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.ui.wizards.NewElementWizard;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestFactory;
import com.schmeedy.pdt.joomla.ui.project.ExtensionProjectFactory;

public class NewExtensionProjectWizard extends NewElementWizard {

	private final JoomlaExtensionManifest manifest = JoomlaExtensionManifestFactory.eINSTANCE.createJoomlaExtensionManifest();
	
	private NewExtensionProjectWizardFirstPage firstPage;
	
	public NewExtensionProjectWizard() {
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public void addPages() {
		firstPage = new NewExtensionProjectWizardFirstPage(manifest, new ExtensionProjectFactory());
		addPage(firstPage);
	}
	
	@Override
	protected void finishPage(IProgressMonitor monitor) throws InterruptedException, CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IModelElement getCreatedElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
