package com.schmeedy.pdt.joomla.ui.preferences;

import java.io.File;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
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

import com.schmeedy.pdt.joomla.core.server.JoomlaInstallationValidator;
import com.schmeedy.pdt.joomla.core.server.JoomlaInstallationValidator.ValidationStatusAndVersionInfo;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage.Literals;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;
import com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion;

public class EditLocalJoomlaServerDialog extends TitleAreaDialog {

	private final boolean edit;
	private final String initialMessage;
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
		this.initialMessage = edit ? "Change Joomla! server configuration properties." : "New Joomla! server configuration.";
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
		} else {
			setTitle("New Joomla! Server Configuration");
		}
		setMessage(initialMessage);
		
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

		final WritableValue statusObservable = new WritableValue();
		statusObservable.addChangeListener(new IChangeListener() {
			@Override
			public void handleChange(ChangeEvent event) {
				final IStatus status = AggregateValidationStatus.getStatusMaxSeverity(dataBindingContext.getBindings());
				if (status.isOK()) {
					setMessage(initialMessage);
				} else {
					setMessage(status.getMessage(), getMessageType(status));
				}
				final Button okButton = getButton(IDialogConstants.OK_ID);
				if (okButton != null) {
					// it's a little bit weird that IStatus.INFO disables OK button, but it's intentional 
					// (this status is returned from JoomlaInstallDirValidator when install directory is empty)
					final boolean okButtonEnabled = status.getSeverity() == IStatus.OK || status.getSeverity() == IStatus.WARNING;
					okButton.setEnabled(okButtonEnabled);
				}
			}
			
			private int getMessageType(IStatus status) {
				switch (status.getSeverity()) {
					case IStatus.INFO:
						return IMessageProvider.INFORMATION;
					case IStatus.WARNING:
						return IMessageProvider.WARNING;
					case IStatus.ERROR:
						return IMessageProvider.ERROR;
					default:
						return IMessageProvider.NONE;
				}
			}
		});
		dataBindingContext.bindValue(statusObservable, new AggregateValidationStatus(dataBindingContext, AggregateValidationStatus.MAX_SEVERITY));
		
		applyDialogFont(dialogComposite);
		return dialogComposite;
	}
	
	@Override
	protected Control createButtonBar(Composite parent) {
		final Control buttonBarControl = super.createButtonBar(parent);
		dataBindingContext.updateModels(); // trigger validation
		return buttonBarControl;
	}
	
	@Override
	public boolean close() {
		dataBindingContext.dispose();
		return super.close();
	}
	
	public class JoomlaInstallDirValidator implements IValidator {
		private final JoomlaInstallationValidator joomlaInstallationValidator = new JoomlaInstallationValidator();
		
		@Override
		public IStatus validate(Object value) {
			if (value == null || ((String) value).trim().length() == 0) {
				return ValidationStatus.info("Select location of Joomla! installation directory.");
			}
			final String stringValue = (String) value;
			final File file = new File(stringValue);
			if (!file.exists()) {
				clearVersionInfo();
				return ValidationStatus.error("Given Joomla! root directory does not exist.");
			}
			final ValidationStatusAndVersionInfo statusAndInfo = joomlaInstallationValidator.validate(file);
			if (statusAndInfo.getStatus().isOK()) {
				serverConfiguration.setMajorVersion(statusAndInfo.getMajorVersion());
				serverConfiguration.setExactVersion(statusAndInfo.getExactVersion());
			} else {
				clearVersionInfo();
			}
			return statusAndInfo.getStatus();
		}

		private void clearVersionInfo() {
			serverConfiguration.setMajorVersion(null);
			serverConfiguration.setExactVersion(null);
		}
	}
	
	public static class NonEmptyStringValidator implements IValidator {
		private final String errorMessage;
		
		public NonEmptyStringValidator(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		@Override
		public IStatus validate(Object value) {
			if (value == null) {
				return ValidationStatus.error(errorMessage);
			}
			final String stringVal = (String) value;
			return stringVal.trim().length() == 0 ? ValidationStatus.error(errorMessage) : Status.OK_STATUS;
		}
	}
	
	public static class VersionFamilyConverter extends Converter {
		public VersionFamilyConverter() {
			super(MajorJoomlaVersion.class, String.class);
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject == null) {
				return null;
			}
			final MajorJoomlaVersion majorJoomlaVersion = (MajorJoomlaVersion) fromObject;
			switch (majorJoomlaVersion) {
				case ONE_FIVE:
					return "Joomla! 1.5.x";
				case ONE_SIX:
					return "Joomla! 1.6.x";
				default:
					return "unknown";
			}
		}
	}
	protected DataBindingContext initDataBindings() {
		final DataBindingContext bindingContext = new DataBindingContext();
		//
		final IObservableValue installRootTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(installRootText, SWT.Modify));
		final IObservableValue serverConfigurationInstallDirObserveValue = EMFObservables.observeValue(serverConfiguration, Literals.LOCAL_JOOMLA_SERVER__INSTALL_DIR);
		final UpdateValueStrategy strategy_1 = new UpdateValueStrategy();
		strategy_1.setAfterConvertValidator(new JoomlaInstallDirValidator());
		bindingContext.bindValue(installRootTextObserveTextObserveWidget, serverConfigurationInstallDirObserveValue, strategy_1, null);
		//
		final IObservableValue nameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(nameText, SWT.Modify));
		final IObservableValue serverConfigurationNameObserveValue = EMFObservables.observeValue(serverConfiguration, Literals.LOCAL_JOOMLA_SERVER__NAME);
		final UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setAfterConvertValidator(new NonEmptyStringValidator("Server name cannot be empty."));
		bindingContext.bindValue(nameTextObserveTextObserveWidget, serverConfigurationNameObserveValue, strategy, null);
		//
		final IObservableValue baseUrlTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(baseUrlText, SWT.Modify));
		final IObservableValue serverConfigurationBaseUrlObserveValue = EMFObservables.observeValue(serverConfiguration, Literals.LOCAL_JOOMLA_SERVER__BASE_URL);
		final UpdateValueStrategy strategy_2 = new UpdateValueStrategy();
		strategy_2.setAfterConvertValidator(new NonEmptyStringValidator("Server base URL cannot be empty."));
		bindingContext.bindValue(baseUrlTextObserveTextObserveWidget, serverConfigurationBaseUrlObserveValue, strategy_2, null);
		//
		final IObservableValue versionFamilyTextObserveTextObserveWidget = SWTObservables.observeText(versionFamilyText, SWT.Modify);
		final IObservableValue serverConfigurationMajorVersionObserveValue = EMFObservables.observeValue(serverConfiguration, Literals.LOCAL_JOOMLA_SERVER__MAJOR_VERSION);
		final UpdateValueStrategy strategy_3 = new UpdateValueStrategy();
		strategy_3.setConverter(new VersionFamilyConverter());
		bindingContext.bindValue(versionFamilyTextObserveTextObserveWidget, serverConfigurationMajorVersionObserveValue, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), strategy_3);
		//
		final IObservableValue exactVersionTextObserveTextObserveWidget = SWTObservables.observeText(exactVersionText, SWT.Modify);
		final IObservableValue serverConfigurationExactVersionObserveValue = EMFObservables.observeValue(serverConfiguration, Literals.LOCAL_JOOMLA_SERVER__EXACT_VERSION);
		bindingContext.bindValue(exactVersionTextObserveTextObserveWidget, serverConfigurationExactVersionObserveValue, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		return bindingContext;
	}
}
