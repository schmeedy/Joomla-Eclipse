package com.schmeedy.pdt.joomla.manifest.ui.editor;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;

class OverviewPage extends FormPage {

	public OverviewPage(FormEditor editor) {
		super(OverviewPage.class.getName(), "Overview");
		initialize(editor);
	}
	
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		form.setText("Overview");

		final Composite body = managedForm.getForm().getBody();
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(true).margins(8, 8).applyTo(body);

		final FormToolkit toolkit = managedForm.getToolkit();
		toolkit.decorateFormHeading(form.getForm());
	}

	void setInput(JoomlaExtensionManifest manifest) {
		
	}
	
}
