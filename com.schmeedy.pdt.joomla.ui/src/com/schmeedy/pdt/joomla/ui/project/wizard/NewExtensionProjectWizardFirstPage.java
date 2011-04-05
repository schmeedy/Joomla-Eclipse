package com.schmeedy.pdt.joomla.ui.project.wizard;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.php.internal.ui.wizards.CompositeData;
import org.eclipse.php.internal.ui.wizards.PHPProjectWizardFirstPage;
import org.eclipse.php.internal.ui.wizards.WizardFragment;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("restriction")
public class NewExtensionProjectWizardFirstPage extends PHPProjectWizardFirstPage {

	public NewExtensionProjectWizardFirstPage() {
		setPageComplete(false);
		setTitle("New Joomla! Extension Project");
		setDescription("Create a Joomla! extension project in the workspace or in an external location.");
		fInitialName = ""; //$NON-NLS-1$
	}
	
	@Override
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		final Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		composite.setLayout(initGridLayout(new GridLayout(1, false), false));
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		// create UI elements
		fNameGroup = new NameGroup(composite, fInitialName);
		fPHPLocationGroup = new LocationGroup(composite);

		final CompositeData data = new CompositeData();
		data.setParetnt(composite);
		data.setSettings(getDialogSettings());
		data.setObserver(fPHPLocationGroup);
		fragment = (WizardFragment) Platform.getAdapterManager().loadAdapter(
				data, PHPProjectWizardFirstPage.class.getName());

		fVersionGroup = new VersionGroup(composite);
		fJavaScriptSupportGroup = new JavaScriptSupportGroup(composite, this);

		fDetectGroup = new DetectGroup(composite);

		// establish connections
		fNameGroup.addObserver(fPHPLocationGroup);
		
		fPHPLocationGroup.addObserver(fDetectGroup);
		// initialize all elements
		fNameGroup.notifyObservers();
		// create and connect validator
		fPdtValidator = new Validator();

		fNameGroup.addObserver(fPdtValidator);
		fPHPLocationGroup.addObserver(fPdtValidator);

		setControl(composite);
		Dialog.applyDialogFont(composite);

		// set the focus to the project name
		fNameGroup.postSetFocus();

		setHelpContext(composite);
	}
	
}
