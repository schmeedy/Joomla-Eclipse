package com.schmeedy.pdt.joomla.ui.preferences;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage.Literals;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;

public class EditLocalJoomlaServerDialog extends TitleAreaDialog {

	private final boolean edit;
	private final LocalJoomlaServer serverConfiguration;
	
	private Text installRootText;
	private Text nameText;
	private Text baseUrlText;
	private Text versionFamilyText;
	private Text exactVersionText;
	
	private DataBindingContext dataBindingContext;

	public EditLocalJoomlaServerDialog(Shell parent, LocalJoomlaServer serverConfiguration, boolean edit) {
		super(parent);
		this.edit = edit;
		this.serverConfiguration = serverConfiguration;
		setShellStyle(getShellStyle() | SWT.RESIZE);
		setHelpAvailable(false);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite dialogComposite = (Composite) super.createDialogArea(parent);
		final GridLayout gl_dialogComposite = new GridLayout(1, false);
		gl_dialogComposite.verticalSpacing = 0;
		gl_dialogComposite.marginWidth = 0;
		gl_dialogComposite.marginHeight = 0;
		dialogComposite.setLayout(gl_dialogComposite);
		
		if (edit) {
			setTitle("Edit Joomla! Server Configuration");
			setMessage("Change Joomla! server configuration properties.");
		} else {
			setTitle("New Joomla! Server Configuration");
			setMessage("Select location of Joomla! files on your filesystem.");
		}
		
		final Composite installDirSelectionComposite = new Composite(dialogComposite, SWT.NONE);
		final GridLayout gl_installDirSelectionComposite = new GridLayout(3, false);
		installDirSelectionComposite.setLayout(gl_installDirSelectionComposite);
		installDirSelectionComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		
		final Label lblJoomlaRoot = new Label(installDirSelectionComposite, SWT.NONE);
		lblJoomlaRoot.setText("Joomla! Root:");
		
		installRootText = new Text(installDirSelectionComposite, SWT.BORDER);
		installRootText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Button browseButton = new Button(installDirSelectionComposite, SWT.NONE);
		final GridData gd_browseButton = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_browseButton.widthHint = 90;
		browseButton.setLayoutData(gd_browseButton);
		browseButton.setText("Browse...");
		browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final DirectoryDialog dirDialog = new DirectoryDialog(getShell());
				final String directory = dirDialog.open();
				if (directory != null) {
					installRootText.setText(directory);
				}
			}
		});
		
		final Composite serverPropertiesGroupComposite = new Composite(dialogComposite, SWT.NONE);
		serverPropertiesGroupComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		final GridLayout gl_serverPropertiesGroupComposite = new GridLayout(1, false);
		gl_serverPropertiesGroupComposite.marginHeight = 0;
		serverPropertiesGroupComposite.setLayout(gl_serverPropertiesGroupComposite);
		
		final Group serverPropertiesGroup = new Group(serverPropertiesGroupComposite, SWT.NONE);
		serverPropertiesGroup.setText("Properties");
		final GridLayout gl_serverPropertiesGroup = new GridLayout(2, false);
		serverPropertiesGroup.setLayout(gl_serverPropertiesGroup);
		serverPropertiesGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		final Label lblName = new Label(serverPropertiesGroup, SWT.NONE);
		lblName.setText("Name:");
		
		nameText = new Text(serverPropertiesGroup, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label lblBaseUrl = new Label(serverPropertiesGroup, SWT.NONE);
		lblBaseUrl.setText("Base URL:");
		
		baseUrlText = new Text(serverPropertiesGroup, SWT.BORDER);
		baseUrlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label lblVersionFamily = new Label(serverPropertiesGroup, SWT.NONE);
		lblVersionFamily.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVersionFamily.setText("Version Family:");
		
		versionFamilyText = new Text(serverPropertiesGroup, SWT.BORDER);
		versionFamilyText.setEnabled(false);
		versionFamilyText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label lblExactVersion = new Label(serverPropertiesGroup, SWT.NONE);
		lblExactVersion.setText("Exact Version:");
		
		exactVersionText = new Text(serverPropertiesGroup, SWT.BORDER);
		exactVersionText.setEnabled(false);
		exactVersionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		dataBindingContext = initDataBindings();

		applyDialogFont(dialogComposite);
		return dialogComposite;
	}
	
	@Override
	public boolean close() {
		dataBindingContext.dispose();
		return super.close();
	}
	protected DataBindingContext initDataBindings() {
		final DataBindingContext bindingContext = new DataBindingContext();
		//
		final IObservableValue nameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(nameText, SWT.Modify));
		final IObservableValue serverConfigurationNameObserveValue = EMFObservables.observeValue(serverConfiguration, Literals.LOCAL_JOOMLA_SERVER__NAME);
		bindingContext.bindValue(nameTextObserveTextObserveWidget, serverConfigurationNameObserveValue, null, null);
		//
		final IObservableValue baseUrlTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(baseUrlText, SWT.Modify));
		final IObservableValue serverConfigurationBaseUrlObserveValue = EMFObservables.observeValue(serverConfiguration, Literals.LOCAL_JOOMLA_SERVER__BASE_URL);
		bindingContext.bindValue(baseUrlTextObserveTextObserveWidget, serverConfigurationBaseUrlObserveValue, null, null);
		//
		final IObservableValue installRootTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(installRootText, SWT.Modify));
		final IObservableValue serverConfigurationInstallDirObserveValue = EMFObservables.observeValue(serverConfiguration, Literals.LOCAL_JOOMLA_SERVER__INSTALL_DIR);
		bindingContext.bindValue(installRootTextObserveTextObserveWidget, serverConfigurationInstallDirObserveValue, null, null);
		//
		return bindingContext;
	}
}
