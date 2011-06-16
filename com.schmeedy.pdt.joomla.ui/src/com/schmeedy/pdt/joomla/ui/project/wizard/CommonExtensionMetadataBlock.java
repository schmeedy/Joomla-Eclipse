package com.schmeedy.pdt.joomla.ui.project.wizard;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;

public class CommonExtensionMetadataBlock {
	
	private final JoomlaExtensionManifest manifest;
	
	private Text extensionNameText;
	private Text extensionVersionText;
	private Text authorNameText;
	private Text authorEmailText;
	private Text authorWebsiteText;

	private DataBindingContext bindingContext;

	public CommonExtensionMetadataBlock(JoomlaExtensionManifest manifest) {
		this.manifest = manifest;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public Control createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		final GridLayout gl_container = new GridLayout(2, false);
		gl_container.marginWidth = 0;
		gl_container.marginHeight = 0;
		container.setLayout(gl_container);
		
		final Group grpExtensionMetadata = new Group(container, SWT.NONE);
		grpExtensionMetadata.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		grpExtensionMetadata.setText("Extension");
		grpExtensionMetadata.setLayout(new GridLayout(2, false));
		
		final Label lblName = new Label(grpExtensionMetadata, SWT.NONE);
		lblName.setText("Name:");
		
		extensionNameText = new Text(grpExtensionMetadata, SWT.BORDER);
		extensionNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label lblVersion = new Label(grpExtensionMetadata, SWT.NONE);
		lblVersion.setText("Version:");
		
		extensionVersionText = new Text(grpExtensionMetadata, SWT.BORDER);
		extensionVersionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		
		final Group grpAuthor = new Group(container, SWT.NONE);
		grpAuthor.setLayout(new GridLayout(2, false));
		grpAuthor.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		grpAuthor.setText("Author");
		
		final Label lblAuthorName = new Label(grpAuthor, SWT.NONE);
		lblAuthorName.setText("Name:");
		
		authorNameText = new Text(grpAuthor, SWT.BORDER);
		authorNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label lblEmail = new Label(grpAuthor, SWT.NONE);
		lblEmail.setText("E-mail:");
		
		authorEmailText = new Text(grpAuthor, SWT.BORDER);
		authorEmailText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		final Label lblWebsite = new Label(grpAuthor, SWT.NONE);
		lblWebsite.setText("Website:");
		
		authorWebsiteText = new Text(grpAuthor, SWT.BORDER);
		authorWebsiteText.setText("");
		authorWebsiteText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
	
		bindingContext = initDataBindings();
		return container;
	}
	
	protected DataBindingContext initDataBindings() {
		final DataBindingContext bindingContext = new DataBindingContext();
		//
		final IObservableValue extensionNameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(extensionNameText, SWT.Modify));
		final IObservableValue manifestNameObserveValue = PojoObservables.observeValue(manifest, "name");
		bindingContext.bindValue(extensionNameTextObserveTextObserveWidget, manifestNameObserveValue, null, null);
		//
		final IObservableValue extensionVersionTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(extensionVersionText, SWT.Modify));
		final IObservableValue manifestVersionObserveValue = PojoObservables.observeValue(manifest, "version");
		bindingContext.bindValue(extensionVersionTextObserveTextObserveWidget, manifestVersionObserveValue, null, null);
		//
		final IObservableValue authorNameTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(authorNameText, SWT.Modify));
		final IObservableValue manifestAuthorObserveValue = PojoObservables.observeValue(manifest, "author");
		bindingContext.bindValue(authorNameTextObserveTextObserveWidget, manifestAuthorObserveValue, null, null);
		//
		final IObservableValue authorEmailTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(authorEmailText, SWT.Modify));
		final IObservableValue manifestAuthorEmailObserveValue = PojoObservables.observeValue(manifest, "authorEmail");
		bindingContext.bindValue(authorEmailTextObserveTextObserveWidget, manifestAuthorEmailObserveValue, null, null);
		//
		final IObservableValue authorWebsiteTextObserveTextObserveWidget = SWTObservables.observeDelayedValue(300, SWTObservables.observeText(authorWebsiteText, SWT.Modify));
		final IObservableValue manifestAuthorUrlObserveValue = PojoObservables.observeValue(manifest, "authorUrl");
		bindingContext.bindValue(authorWebsiteTextObserveTextObserveWidget, manifestAuthorUrlObserveValue, null, null);
		//
		return bindingContext;
	}
	
	public void dispose() {
		bindingContext.dispose();
	}
	
}
