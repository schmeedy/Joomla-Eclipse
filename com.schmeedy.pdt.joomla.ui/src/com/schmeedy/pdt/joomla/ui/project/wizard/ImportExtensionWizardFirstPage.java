package com.schmeedy.pdt.joomla.ui.project.wizard;

import java.io.File;

import org.eclipse.dltk.ui.wizards.NewElementWizardPage;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ImportExtensionWizardFirstPage extends NewElementWizardPage implements IExtensionPackageFileProvider {
	
	private Text installationPackageText;
	private Button browseButton;
	
	public ImportExtensionWizardFirstPage() {
		super("Import Joomla! Extension");
		setTitle("Import Joomla! Extension");
		setDescription("Import Joomla! extension or multiple extensions from installation package.");
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		final Label lblExtensionPackage = new Label(container, SWT.NONE);
		lblExtensionPackage.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblExtensionPackage.setText("Installation Package:");
		
		installationPackageText = new Text(container, SWT.BORDER);
		installationPackageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		installationPackageText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				final String text = installationPackageText.getText();
				if (text == null) {
					setPageComplete(false);
					return;
				}
				
				final File archiveFile = new File(text);
				if (!archiveFile.exists()) {
					setMessage("Given installation package does not exist.", IMessageProvider.ERROR);
					setPageComplete(false);
				} else if (!archiveFile.canRead()) {
					setMessage("Given installation package is not readable (check permissions).", IMessageProvider.ERROR);
					setPageComplete(false);
				} else if (!archiveFile.getName().endsWith(".zip") && !archiveFile.getName().endsWith(".phar")) {
					setMessage("Only ZIP installation archives are supported.", IMessageProvider.ERROR);
					setPageComplete(false);
				} else {
					setMessage(null);
					setPageComplete(true);
				}
			}
		});
		
		browseButton = new Button(container, SWT.NONE);
		final GridData gd_btnBrowse = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnBrowse.widthHint = 80;
		browseButton.setLayoutData(gd_btnBrowse);
		browseButton.setText("Browse...");
		browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final FileDialog fileDialog = new FileDialog(getShell());
				fileDialog.setFilterExtensions(new String[] {"*.zip"});
				final String file = fileDialog.open();
				if (file != null) {
					installationPackageText.setText(file);
				}
			}
		});
	}
	
	@Override
	public File getExtensionPackageFile() {
		return new File(installationPackageText.getText());
	}
	
}
