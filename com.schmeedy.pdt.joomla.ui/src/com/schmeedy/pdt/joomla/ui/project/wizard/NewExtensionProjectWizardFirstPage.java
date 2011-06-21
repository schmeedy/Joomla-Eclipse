package com.schmeedy.pdt.joomla.ui.project.wizard;

import org.eclipse.dltk.ui.wizards.NewElementWizardPage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestFactory;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.ManifestType;
import com.schmeedy.pdt.joomla.manifest.model.ManifestVersion;

public class NewExtensionProjectWizardFirstPage extends NewElementWizardPage implements IExtensionManifestProvider {

	private final JoomlaExtensionManifest manifest = JoomlaExtensionManifestFactory.eINSTANCE.createJoomlaExtensionManifest();
	
	private Text componentMenuText;
	
	private CommonExtensionMetadataBlock commonMetadata;
	private Control commonMetadataContainer;
	
	private Button btnFrontendModule;
	private Button btnBackendModule;

	private Group extensionSpecificSettingsGroup;

	private Composite componentComposite;
	private Composite moduleComposite;
	private Composite pluginComposite;

	private ComboViewer versionComboViewer;

	public NewExtensionProjectWizardFirstPage() {
		super("New Joomla! Extension Project");
		setTitle("New Joomla! Extension Project");
		setDescription("Enter basic extension metadata.");
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		final Label lblExtensionType = new Label(container, SWT.NONE);
		lblExtensionType.setText("Extension type:");
		
		final ComboViewer comboViewer = new ComboViewer(container, SWT.READ_ONLY);
		final Combo extensionTypeViewer = comboViewer.getCombo();
		extensionTypeViewer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setInput(new ManifestType[] { ManifestType.COMPONENT, ManifestType.MODULE, ManifestType.PLUGIN });
		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				final IStructuredSelection selection = (IStructuredSelection) comboViewer.getSelection();
				if (!selection.isEmpty()) {
					final ManifestType manifestType = (ManifestType) selection.getFirstElement();
					manifest.setManifestType(manifestType);
					switch (manifestType) {
						case COMPONENT:
							extensionSpecificSettingsGroup.setText("Component Specific Settings");
							revealExtensionSpecificSettings(componentComposite);
							break;
						case MODULE:
							extensionSpecificSettingsGroup.setText("Module Specific Settings");
							revealExtensionSpecificSettings(moduleComposite);
							break;
						case PLUGIN:
							extensionSpecificSettingsGroup.setText("Plugin Specific Settings");
							revealExtensionSpecificSettings(pluginComposite);
							break;
					}
					commonMetadataContainer.setVisible(true);
					extensionSpecificSettingsGroup.setVisible(true);
					
					{ // refresh project name
						final String name = manifest.getName();
						manifest.eNotify(new ENotificationImpl((InternalEObject) manifest, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__NAME, name, name));
					}
				}
			}
		});

		final Label lblTargetJoomlaVersion = new Label(container, SWT.NONE);
		lblTargetJoomlaVersion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTargetJoomlaVersion.setText("Joomla! version:");
		
		versionComboViewer = new ComboViewer(container, SWT.READ_ONLY);
		final Combo versionCombo = versionComboViewer.getCombo();
		versionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		versionComboViewer.setContentProvider(new ArrayContentProvider());
		versionComboViewer.setInput(new ManifestVersion[] { ManifestVersion.ONE_SIX, ManifestVersion.ONE_FIVE });
		versionComboViewer.setSelection(new StructuredSelection(ManifestVersion.ONE_SIX));
		
		commonMetadata = new CommonExtensionMetadataBlock(manifest);
		commonMetadataContainer = commonMetadata.createControl(container);
		commonMetadataContainer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));
		commonMetadataContainer.setVisible(false);
		
		extensionSpecificSettingsGroup = new Group(container, SWT.NONE);
		extensionSpecificSettingsGroup.setText("Type Specific Settings");
		extensionSpecificSettingsGroup.setLayout(new StackLayout());
		final GridData gd_extensionSpecificSettingsGroup = new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1);
		gd_extensionSpecificSettingsGroup.heightHint = 57;
		extensionSpecificSettingsGroup.setLayoutData(gd_extensionSpecificSettingsGroup);
		extensionSpecificSettingsGroup.setVisible(false);
		
		componentComposite = new Composite(extensionSpecificSettingsGroup, SWT.NONE);
		componentComposite.setLayout(new GridLayout(2, false));
		
		final Label lblAdministrationMenu = new Label(componentComposite, SWT.NONE);
		lblAdministrationMenu.setText("Administration Menu:");
		
		componentMenuText = new Text(componentComposite, SWT.BORDER);
		componentMenuText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		moduleComposite = new Composite(extensionSpecificSettingsGroup, SWT.NONE);
		moduleComposite.setLayout(new GridLayout(2, false));
		
		final Label lblModuleType = new Label(moduleComposite, SWT.NONE);
		lblModuleType.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblModuleType.setText("Module Type:");
		
		btnFrontendModule = new Button(moduleComposite, SWT.RADIO);
		btnFrontendModule.setSelection(true);
		btnFrontendModule.setText("Front-end module");
		new Label(moduleComposite, SWT.NONE);
		
		btnBackendModule = new Button(moduleComposite, SWT.RADIO);
		btnBackendModule.setText("Back-end module");
		
		pluginComposite = new Composite(extensionSpecificSettingsGroup, SWT.NONE);
	}
	
	@Override
	public JoomlaExtensionManifest getManifest() {
		final JoomlaExtensionManifest copy = EcoreUtil.copy(manifest);
		
		if (versionComboViewer != null) {
			final ManifestVersion version = (ManifestVersion) ((IStructuredSelection) versionComboViewer.getSelection()).getFirstElement();
			copy.setManifestVersion(version);
		}
		
		return copy;
	}
	
	private void revealExtensionSpecificSettings(Composite composite) {
		final StackLayout layout = (StackLayout) extensionSpecificSettingsGroup.getLayout();
		layout.topControl = composite;
		extensionSpecificSettingsGroup.layout();
	}
	
	@Override
	public void dispose() {
		if (commonMetadata != null) {
			commonMetadata.dispose();
		}
	}

}
