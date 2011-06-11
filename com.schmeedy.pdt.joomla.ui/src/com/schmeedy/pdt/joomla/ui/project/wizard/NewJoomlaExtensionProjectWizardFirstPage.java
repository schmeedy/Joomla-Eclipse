package com.schmeedy.pdt.joomla.ui.project.wizard;

import org.eclipse.dltk.ui.wizards.NewElementWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class NewJoomlaExtensionProjectWizardFirstPage extends NewElementWizardPage {

	public NewJoomlaExtensionProjectWizardFirstPage() {
		super("New Joomla! Extension Project");
		setTitle("New Joomla! Extension Project");
		setDescription("Create a new workspace project for Joomla! extension.");
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
	}

}
