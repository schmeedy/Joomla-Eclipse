package com.schmeedy.pdt.joomla.ui.project.wizard;

import org.eclipse.dltk.ui.wizards.NewElementWizardPage;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.schmeedy.pdt.joomla.manifest.model.Administration;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaDestination;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestFactory;
import com.schmeedy.pdt.joomla.manifest.model.ManifestType;
import com.schmeedy.pdt.joomla.manifest.model.ManifestVersion;
import com.schmeedy.pdt.joomla.manifest.model.MenuItem;

public class NewExtensionProjectWizardFirstPage extends NewElementWizardPage implements IExtensionManifestProvider {

	private final JoomlaExtensionManifest manifest = JoomlaExtensionManifestFactory.eINSTANCE.createJoomlaExtensionManifest();
	private final Adapter manifestChangeAdapter;
	
	{
		manifestChangeAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (!msg.isTouch()) {
					validate();
				}
			}
		};
		manifest.eAdapters().add(manifestChangeAdapter);
	}
	
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
	private ComboViewer pluginGroupViewer;

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
		
		final Label lblTargetJoomlaVersion = new Label(container, SWT.NONE);
		lblTargetJoomlaVersion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTargetJoomlaVersion.setText("Joomla! version:");
		
		versionComboViewer = new ComboViewer(container, SWT.READ_ONLY);
		final Combo versionCombo = versionComboViewer.getCombo();
		versionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		versionComboViewer.setContentProvider(new ArrayContentProvider());
		versionComboViewer.setInput(new ManifestVersion[] { ManifestVersion.ONE_SIX, ManifestVersion.ONE_FIVE });
		versionComboViewer.setSelection(new StructuredSelection(ManifestVersion.ONE_SIX));
		
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
				}
			}
		});
		
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
		componentMenuText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validate();
			}
		});
		
		moduleComposite = new Composite(extensionSpecificSettingsGroup, SWT.NONE);
		moduleComposite.setLayout(new GridLayout(1, false));
		
		btnFrontendModule = new Button(moduleComposite, SWT.RADIO);
		btnFrontendModule.setSelection(true);
		btnFrontendModule.setText("Front-end module");
		
		btnBackendModule = new Button(moduleComposite, SWT.RADIO);
		btnBackendModule.setText("Back-end module");
		
		pluginComposite = new Composite(extensionSpecificSettingsGroup, SWT.NONE);
		pluginComposite.setLayout(new GridLayout(2, false));
		
		final Label lblGroup = new Label(pluginComposite, SWT.NONE);
		lblGroup.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGroup.setText("Group:");
		
		pluginGroupViewer = new ComboViewer(pluginComposite, SWT.NONE);
		final Combo pluginGroupCombo = pluginGroupViewer.getCombo();
		pluginGroupCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		pluginGroupViewer.setContentProvider(new ArrayContentProvider());
		pluginGroupViewer.setInput(new String[] { "authentication", "content", "editors", "editors-xtd", "search", "system", "user", "xmlrpc" });
		pluginGroupViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				validate();
			}
		});
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			validate();
		}
	}
	
	private void validate() {
		if (manifest.getManifestType() == null || manifest.getManifestType() == ManifestType.UNKNOWN) {
			setMessage("Select extension type.", IMessageProvider.INFORMATION);
			setPageComplete(false);
			return;
		}
		
		if (manifest.getName() == null || manifest.getName().trim().length() == 0) {
			setMessage("Enter extension name.", IMessageProvider.INFORMATION);
			setPageComplete(false);
			return;
		}
		
		if (manifest.getManifestType() == ManifestType.COMPONENT) {
			if (componentMenuText.getText() == null || componentMenuText.getText().trim().length() == 0) {
				setMessage("Enter label for component's top-level administration menu entry.", IMessageProvider.INFORMATION);
				setPageComplete(false);
				return;
			}
		}
		
		if (manifest.getManifestType() == ManifestType.PLUGIN) {
			final String group = pluginGroupViewer.getSelection().isEmpty() ? null : (String) ((IStructuredSelection) pluginGroupViewer.getSelection()).getFirstElement();
			if (group == null || group.trim().isEmpty()) {
				setMessage("Enter plugin group name.", IMessageProvider.INFORMATION);
				setPageComplete(false);
				return;
			}
		}
		
		setMessage(null);
		setPageComplete(true);
	}
	
	@Override
	public JoomlaExtensionManifest getManifest() {
		final JoomlaExtensionManifest manifestCopy = EcoreUtil.copy(manifest);
		
		if (versionComboViewer != null) {
			final ManifestVersion version = (ManifestVersion) ((IStructuredSelection) versionComboViewer.getSelection()).getFirstElement();
			manifestCopy.setManifestVersion(version);
		}
		
		if (manifestCopy.getManifestType() == ManifestType.COMPONENT && componentMenuText.getText() != null) {
			final Administration administration = JoomlaExtensionManifestFactory.eINSTANCE.createAdministration();
			final MenuItem menuItem = JoomlaExtensionManifestFactory.eINSTANCE.createMenuItem();
			menuItem.setLabel(componentMenuText.getText().trim());
			administration.setMenu(menuItem);
			manifestCopy.setAdministration(administration);
		} else if (manifestCopy.getManifestType() == ManifestType.MODULE) {
			if (btnBackendModule.getSelection()) {
				manifestCopy.setDestination(JoomlaDestination.ADMINISTRATION);
			} else {
				manifestCopy.setDestination(JoomlaDestination.SITE);
			}
		} else if (manifestCopy.getManifestType() == ManifestType.PLUGIN) {
			final IStructuredSelection groupSelection = (IStructuredSelection) pluginGroupViewer.getSelection();
			if (!groupSelection.isEmpty() && ((String) groupSelection.getFirstElement()).trim().length() > 0) {
				manifestCopy.setPluginGroup(((String) groupSelection.getFirstElement()).trim());
			}
		}
		
		return manifestCopy;
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
		manifest.eAdapters().remove(manifestChangeAdapter);
	}
}
