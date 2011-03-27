package com.schmeedy.pdt.joomla.manifest.ui.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage.Literals;

class OverviewPage extends FormPage {

	public static final String ID = "com.schmeedy.pdt.joomla.manifest.ui.editor.OverviewPage";
	
	private Text nameText;
	private Text versionText;
	private Text descriptionText;
	
	private Text authorNameText;
	private Text authorEmailText;
	private Text authorUrlText;
	private Text copyrightText;
	private Text licenseText;
	
	private JoomlaExtensionManifest currentInput;
	private DataBindingContext dataBindingContext;
	private EditingDomain editingDomain;
	private boolean uiInitialized = false;
	
	/**
	 * Create the form page.
	 * @param editor
	 * @wbp.parser.constructor
	 */
	public OverviewPage(FormEditor editor) {
		super(editor, ID, "Overview");
	}
	
	void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;		
	}
	
	void setInput(JoomlaExtensionManifest manifest) {
		if (dataBindingContext != null) {
			dataBindingContext.dispose();
		}
		currentInput = manifest;
		if (uiInitialized && currentInput != null) {
			dataBindingContext = initDataBindings();
		}
	}
	
	@Override
	public void dispose() {
		if (dataBindingContext != null) {
			dataBindingContext.dispose();
		}
		uiInitialized = false;
	}
	
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		final FormToolkit toolkit = managedForm.getToolkit();
		final ScrolledForm form = managedForm.getForm();
		form.setText("Overview");
		final Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new GridLayout(2, true));
		
		final Section detailsSection = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TITLE_BAR);
		final GridData gd_detailsSection = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_detailsSection.heightHint = 116;
		detailsSection.setLayoutData(gd_detailsSection);
		managedForm.getToolkit().paintBordersFor(detailsSection);
		detailsSection.setText("Extension Details");
		
		final Composite detailsSectionContent = new Composite(detailsSection, SWT.NONE);
		managedForm.getToolkit().adapt(detailsSectionContent);
		managedForm.getToolkit().paintBordersFor(detailsSectionContent);
		detailsSection.setClient(detailsSectionContent);
		detailsSectionContent.setLayout(new GridLayout(2, false));
		
		managedForm.getToolkit().createLabel(detailsSectionContent, "Name:", SWT.NONE);
		
		nameText = managedForm.getToolkit().createText(detailsSectionContent, "New Text", SWT.NONE);
		nameText.setText("");
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		managedForm.getToolkit().createLabel(detailsSectionContent, "Version:", SWT.NONE);
		
		versionText = managedForm.getToolkit().createText(detailsSectionContent, "New Text", SWT.NONE);
		versionText.setText("");
		versionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label label = managedForm.getToolkit().createLabel(detailsSectionContent, "Description:", SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		
		descriptionText = managedForm.getToolkit().createText(detailsSectionContent, "New Text", SWT.WRAP | SWT.MULTI);
		descriptionText.setText("");
		final GridData gd_descriptionText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_descriptionText.heightHint = 83;
		descriptionText.setLayoutData(gd_descriptionText);
		
		final Section legalSection = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TITLE_BAR);
		legalSection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 2));
		managedForm.getToolkit().paintBordersFor(legalSection);
		legalSection.setText("Legal");
		
		final Composite composite = managedForm.getToolkit().createComposite(legalSection, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(composite);
		legalSection.setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		
		final Label copyrightLabel = managedForm.getToolkit().createLabel(composite, "Copyright:", SWT.NONE);
		copyrightLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		
		copyrightText = managedForm.getToolkit().createText(composite, "New Text", SWT.WRAP | SWT.MULTI);
		copyrightText.setText("");
		final GridData gd_copyrightText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_copyrightText.heightHint = 120;
		copyrightText.setLayoutData(gd_copyrightText);
		
		final Label lblLicense = managedForm.getToolkit().createLabel(composite, "License:", SWT.NONE);
		lblLicense.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		
		licenseText = managedForm.getToolkit().createText(composite, "New Text", SWT.WRAP | SWT.MULTI);
		licenseText.setText("");
		final GridData gd_licenseText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_licenseText.heightHint = 120;
		licenseText.setLayoutData(gd_licenseText);
		
		final Section authorSection = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TITLE_BAR);
		authorSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().paintBordersFor(authorSection);
		authorSection.setText("Author Details");
		
		final Composite authorSectionContent = managedForm.getToolkit().createComposite(authorSection, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(authorSectionContent);
		authorSection.setClient(authorSectionContent);
		authorSectionContent.setLayout(new GridLayout(2, false));
		
		final Label label_1 = managedForm.getToolkit().createLabel(authorSectionContent, "Name:", SWT.NONE);
		final GridData gd_label_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label_1.widthHint = 62;
		label_1.setLayoutData(gd_label_1);
		
		authorNameText = managedForm.getToolkit().createText(authorSectionContent, "New Text", SWT.NONE);
		authorNameText.setText("");
		authorNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		managedForm.getToolkit().createLabel(authorSectionContent, "E-mail:", SWT.NONE);
		
		authorEmailText = managedForm.getToolkit().createText(authorSectionContent, "New Text", SWT.NONE);
		authorEmailText.setText("");
		authorEmailText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		managedForm.getToolkit().createLabel(authorSectionContent, "URL:", SWT.NONE);
		
		authorUrlText = managedForm.getToolkit().createText(authorSectionContent, "New Text", SWT.NONE);
		authorUrlText.setText("");
		authorUrlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		new Label(managedForm.getForm().getBody(), SWT.NONE);
		
		if (currentInput != null) {
			dataBindingContext = initDataBindings();
		}
		
		uiInitialized = true;
	}
	protected DataBindingContext initDataBindings() {
		final DataBindingContext bindingContext = new DataBindingContext();
		//
		final IObservableValue nameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(nameText, SWT.Modify));
		final IObservableValue currentInputNameObserveValue = EMFEditObservables.observeValue(editingDomain, currentInput, Literals.JOOMLA_EXTENSION_MANIFEST__NAME);
		bindingContext.bindValue(nameTextObserveTextObserveWidget, currentInputNameObserveValue, null, new EMFUpdateValueStrategy());
		//
		final IObservableValue versionTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(versionText, SWT.Modify));
		final IObservableValue currentInputVersionObserveValue = EMFEditObservables.observeValue(editingDomain, currentInput, Literals.JOOMLA_EXTENSION_MANIFEST__VERSION);
		bindingContext.bindValue(versionTextObserveTextObserveWidget, currentInputVersionObserveValue, null, new EMFUpdateValueStrategy());
		//
		final IObservableValue descriptionTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(descriptionText, SWT.Modify));
		final IObservableValue currentInputDescriptionObserveValue = EMFEditObservables.observeValue(editingDomain, currentInput, Literals.JOOMLA_EXTENSION_MANIFEST__DESCRIPTION);
		bindingContext.bindValue(descriptionTextObserveTextObserveWidget, currentInputDescriptionObserveValue, null, new EMFUpdateValueStrategy());
		//
		final IObservableValue authorNameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(authorNameText, SWT.Modify));
		final IObservableValue currentInputAuthorObserveValue = EMFEditObservables.observeValue(editingDomain, currentInput, Literals.JOOMLA_EXTENSION_MANIFEST__AUTHOR);
		bindingContext.bindValue(authorNameTextObserveTextObserveWidget, currentInputAuthorObserveValue, null, new EMFUpdateValueStrategy());
		//
		final IObservableValue authorEmailTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(authorEmailText, SWT.Modify));
		final IObservableValue currentInputAuthorEmailObserveValue = EMFEditObservables.observeValue(editingDomain, currentInput, Literals.JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL);
		bindingContext.bindValue(authorEmailTextObserveTextObserveWidget, currentInputAuthorEmailObserveValue, null, new EMFUpdateValueStrategy());
		//
		final IObservableValue authorUrlTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(authorUrlText, SWT.Modify));
		final IObservableValue currentInputAuthorUrlObserveValue = EMFEditObservables.observeValue(editingDomain, currentInput, Literals.JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL);
		bindingContext.bindValue(authorUrlTextObserveTextObserveWidget, currentInputAuthorUrlObserveValue, null, new EMFUpdateValueStrategy());
		//
		final IObservableValue copyrightTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(copyrightText, SWT.Modify));
		final IObservableValue currentInputCopyrightObserveValue = EMFEditObservables.observeValue(editingDomain, currentInput, Literals.JOOMLA_EXTENSION_MANIFEST__COPYRIGHT);
		bindingContext.bindValue(copyrightTextObserveTextObserveWidget, currentInputCopyrightObserveValue, null, new EMFUpdateValueStrategy());
		//
		final IObservableValue licenseTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(licenseText, SWT.Modify));
		final IObservableValue currentInputLicenseObserveValue = EMFEditObservables.observeValue(editingDomain, currentInput, Literals.JOOMLA_EXTENSION_MANIFEST__LICENSE);
		bindingContext.bindValue(licenseTextObserveTextObserveWidget, currentInputLicenseObserveValue, null, new EMFUpdateValueStrategy());
		//
		return bindingContext;
	}
}
