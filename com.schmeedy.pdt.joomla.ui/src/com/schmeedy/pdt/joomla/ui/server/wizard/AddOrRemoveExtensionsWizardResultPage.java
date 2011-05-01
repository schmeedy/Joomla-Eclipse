package com.schmeedy.pdt.joomla.ui.server.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class AddOrRemoveExtensionsWizardResultPage extends WizardPage {

	public AddOrRemoveExtensionsWizardResultPage() {
		super("Add or remove extensions - results");
		setDescription("Review result of requested additions / removals");
		setTitle("Add or remove extensions");
	}
	
	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container); 
	}

}
