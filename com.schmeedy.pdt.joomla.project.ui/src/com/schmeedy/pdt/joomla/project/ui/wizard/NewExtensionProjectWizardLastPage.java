package com.schmeedy.pdt.joomla.project.ui.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestFactory;

public class NewExtensionProjectWizardLastPage extends WizardPage {
	
	private Combo extensionTypeCombo;
	private Text extensionNameText;
	private Text extensionVersionText;
	
	private final JoomlaExtensionManifest extensionManifest;
		
	public NewExtensionProjectWizardLastPage() {
		super("Joomla! Extension Settings");
		setTitle("Joomla! Extension Settings");
		setDescription("Configure Joomla! extension specific project settings.");
		extensionManifest = JoomlaExtensionManifestFactory.eINSTANCE.createJoomlaExtensionManifest();
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		final Group grpBasicExtensionProperties = new Group(container, SWT.NONE);
		grpBasicExtensionProperties.setLayout(new GridLayout(2, false));
		grpBasicExtensionProperties.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpBasicExtensionProperties.setText("Extension Properties");
		
		final Label lblNewLabel = new Label(grpBasicExtensionProperties, SWT.NONE);
		lblNewLabel.setText("Type:");
		
		extensionTypeCombo = new Combo(grpBasicExtensionProperties, SWT.NONE);
		extensionTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label lblName = new Label(grpBasicExtensionProperties, SWT.NONE);
		lblName.setText("Name:");
		
		extensionNameText = new Text(grpBasicExtensionProperties, SWT.BORDER);
		extensionNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label lblVersion = new Label(grpBasicExtensionProperties, SWT.NONE);
		lblVersion.setText("Version:");
		
		extensionVersionText = new Text(grpBasicExtensionProperties, SWT.BORDER);
		extensionVersionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

}
