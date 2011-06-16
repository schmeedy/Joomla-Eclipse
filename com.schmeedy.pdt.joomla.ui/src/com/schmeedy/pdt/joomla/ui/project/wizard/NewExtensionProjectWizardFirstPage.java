package com.schmeedy.pdt.joomla.ui.project.wizard;

import org.eclipse.dltk.ui.wizards.NewElementWizardPage;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionType;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelFactory;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.ManifestType;
import com.schmeedy.pdt.joomla.ui.project.ExtensionProjectFactory;

public class NewExtensionProjectWizardFirstPage extends NewElementWizardPage {

	private final JoomlaExtensionManifest manifest;
	private final Adapter extensionNameChangeAdapter;
	
	private final ExtensionProjectFactory projectFactory;
	
	private Text componentMenuText;
	
	private CommonExtensionMetadataBlock commonMetadata;
	private Control commonMetadataContainer;
	
	private Button btnFrontendModule;
	private Button btnBackendModule;

	private Group extensionSpecificSettingsGroup;

	private Composite componentComposite;
	private Composite moduleComposite;
	private Composite pluginComposite;
	
	private Label projectNameLabel;
	private Text projectNameText;

	public NewExtensionProjectWizardFirstPage(final JoomlaExtensionManifest manifest, final ExtensionProjectFactory projectFactory) {
		super("New Joomla! Extension Project");
		setTitle("New Joomla! Extension Project");
		setDescription("Create a new workspace project for Joomla! extension.");
		
		this.manifest = manifest;
		this.projectFactory = projectFactory;
		
		this.extensionNameChangeAdapter = new ExtensionNameChangeAdapter();
		this.manifest.eAdapters().add(extensionNameChangeAdapter);
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
					projectNameLabel.setVisible(true);
					projectNameText.setVisible(true);
					
					{ // refresh project name
						projectNameText.setText("");
						final String name = manifest.getName();
						manifest.eNotify(new ENotificationImpl((InternalEObject) manifest, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__NAME, name, name));
					}
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
		final GridData gd_extensionSpecificSettingsGroup = new GridData(SWT.FILL, SWT.TOP, false, false, 2, 1);
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
		
		projectNameLabel = new Label(container, SWT.NONE);
		projectNameLabel.setText("Project name:");
		projectNameLabel.setVisible(false);
		
		projectNameText = new Text(container, SWT.BORDER);
		projectNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		projectNameText.setVisible(false);
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
		manifest.eAdapters().remove(extensionNameChangeAdapter);
	}
	
	private final class ExtensionNameChangeAdapter extends AdapterImpl {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getEventType() == Notification.SET && msg.getFeature() == JoomlaExtensionManifestPackage.Literals.JOOMLA_EXTENSION_MANIFEST__NAME && msg.getNewStringValue() != null) {
				final BasicExtensionModel basicExtensionModel = toBasicExtensionModel(manifest);
				
				final BasicExtensionModel oldBasicExtensionModel = EcoreUtil.copy(basicExtensionModel);
				oldBasicExtensionModel.setName(msg.getOldStringValue());
				final String oldSuggestedName = projectFactory.suggestProjectName(oldBasicExtensionModel);
			
				if (isEmpty(projectNameText.getText()) || oldSuggestedName.equals(projectNameText.getText())) {
					final String newSuggestedName = projectFactory.suggestProjectName(basicExtensionModel);
					projectNameText.setText(newSuggestedName);
				}
			}
		}

		private BasicExtensionModel toBasicExtensionModel(JoomlaExtensionManifest manifest) {
			final BasicExtensionModel model = JoomlaProjectModelFactory.eINSTANCE.createBasicExtensionModel();
			model.setName(manifest.getName());
			switch (manifest.getManifestType()) {
				case COMPONENT:
					model.setType(ExtensionType.COMPONENT);
					break;
				case MODULE:
					model.setType(ExtensionType.MODULE);
					break;
				case PLUGIN:
					model.setType(ExtensionType.PLUGIN);
					break;
			}
			return model;
		}

		private boolean isEmpty(String string) {
			return string == null || "".equals(string);
		}
	}

}
