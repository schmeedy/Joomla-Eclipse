package com.schmeedy.pdt.joomla.manifest.ui.editor;

import java.io.File;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResource;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.FileSet;
import com.schmeedy.pdt.joomla.manifest.model.FolderResource;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage.Literals;
import com.schmeedy.pdt.joomla.manifest.model.LanguageSet;
import com.schmeedy.pdt.joomla.manifest.model.MediaSet;
import com.schmeedy.pdt.joomla.manifest.ui.JoomlaExtensionManifestUiPlugin;

class MultiResourceContainerPage extends FormPage {

	public static final String ID_BASE = "com.schmeedy.pdt.joomla.manifest.ui.editor.OverviewPage.MultiResourceContainerPage.";
	
	private final ImageRegistry imageRegistry;
	
	private AbstractMultiResourceContainer currentInput;
	private DataBindingContext dataBindingContext;
	private EditingDomain editingDomain;
	private boolean uiInitialized = false;
	
	private TableViewer resourceSetViewer;
	private TableViewer resourceViewer;
	
	/**
	 * Create the form page.
	 * @param editor
	 * @wbp.parser.constructor
	 */
	public MultiResourceContainerPage(FormEditor editor, String id, String pageTitle, ImageRegistry imageRegistry) {
		super(editor, ID_BASE + id, pageTitle);
		this.imageRegistry = imageRegistry;
	}
	
	void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;		
	}
	
	void setInput(AbstractMultiResourceContainer input) {
		if (dataBindingContext != null) {
			dataBindingContext.dispose();
		}
		currentInput = input;
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
		form.setText("Resources");
		final Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new GridLayout(2, true));
		
		final Section sctnResourceSets = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TITLE_BAR);
		sctnResourceSets.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnResourceSets);
		sctnResourceSets.setText("Resource Sets");
		
		{
			final Composite sectionMasterComposite = toolkit.createComposite(sctnResourceSets, SWT.NONE);
			toolkit.paintBordersFor(sectionMasterComposite);
			sctnResourceSets.setClient(sectionMasterComposite);
			sectionMasterComposite.setLayout(new GridLayout(1, false));
			
			final Composite tableViewerComposite = toolkit.createComposite(sectionMasterComposite, SWT.NONE);
			final GridData viewerCompositeGD = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
			viewerCompositeGD.heightHint = 150;
			tableViewerComposite.setLayoutData(viewerCompositeGD);
					
			resourceSetViewer = new TableViewer(tableViewerComposite, SWT.BORDER | SWT.FULL_SELECTION);
			
			final TableColumn singleColumn = new TableColumn(resourceSetViewer.getTable(), SWT.NONE);
			final TableColumnLayout tableViewerCompositeLayout = new TableColumnLayout();
			tableViewerCompositeLayout.setColumnData(singleColumn, new ColumnWeightData(100));
			tableViewerComposite.setLayout(tableViewerCompositeLayout);
		}
		
		
		final Section sctnResources = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TITLE_BAR);
		sctnResources.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnResources);
		sctnResources.setText("Resources");
		
		{
			final Composite sectionMasterComposite = toolkit.createComposite(sctnResources, SWT.NONE);
			toolkit.paintBordersFor(sectionMasterComposite);
			sctnResources.setClient(sectionMasterComposite);
			sectionMasterComposite.setLayout(new GridLayout(1, false));
			
			final Composite tableViewerComposite = toolkit.createComposite(sectionMasterComposite, SWT.NONE);
			final GridData viewerCompositeGD = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
			tableViewerComposite.setLayoutData(viewerCompositeGD);
					
			resourceViewer = new TableViewer(tableViewerComposite, SWT.BORDER | SWT.FULL_SELECTION);
			
			final TableColumn singleColumn = new TableColumn(resourceViewer.getTable(), SWT.NONE);
			final TableColumnLayout tableViewerCompositeLayout = new TableColumnLayout();
			tableViewerCompositeLayout.setColumnData(singleColumn, new ColumnWeightData(100));
			tableViewerComposite.setLayout(tableViewerCompositeLayout);
		}
		
		if (currentInput != null) {
			dataBindingContext = initDataBindings();
		}
		
		uiInitialized = true;
	}
	
	protected DataBindingContext initDataBindings() {
		final DataBindingContext bindingContext = new DataBindingContext();
		
		{ // resource set list binding
			final ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			resourceSetViewer.setContentProvider(listContentProvider);
			
			final IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[]{ Literals.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER });
			resourceSetViewer.setLabelProvider(new AbstractResourceContainerLabelProvider(observeMaps));
			
			final IObservableList currentInputAllResourceSetsObserveList = EMFEditObservables.observeList(Realm.getDefault(), editingDomain, currentInput, Literals.ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS);
			resourceSetViewer.setInput(currentInputAllResourceSetsObserveList);
		}
		
		{ // resource list (from resource set selection) binding
			final ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
			resourceViewer.setContentProvider(listContentProvider);

			final IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(), new EStructuralFeature[] { Literals.ABSTRACT_RESOURCE__PATH });
			resourceViewer.setLabelProvider(new AbstractResourceLabelProvider(observeMaps));

			final IObservableValue selectedResourceSetObservable = ViewersObservables.observeSingleSelection(resourceSetViewer);
			final IObservableList resourceListObservable = EMFObservables.observeDetailList(Realm.getDefault(), selectedResourceSetObservable, Literals.ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES);
			
			resourceViewer.setInput(resourceListObservable);
		}
			
		return bindingContext;
	}
	
	private static class AbstractResourceContainerLabelProvider extends ObservableMapLabelProvider {
		
		private final Image fileSetIcon = JoomlaExtensionManifestUiPlugin.getInstance().getImage(JoomlaExtensionManifestUiPlugin.IMG_FILE_SET);
		private final Image mediaSetIcon = JoomlaExtensionManifestUiPlugin.getInstance().getImage(JoomlaExtensionManifestUiPlugin.IMG_MEDIA_SET);
		private final Image languageSetIcon = JoomlaExtensionManifestUiPlugin.getInstance().getImage(JoomlaExtensionManifestUiPlugin.IMG_LANGUAGE_SET);
		
		public AbstractResourceContainerLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}
		
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof FileSet) {
				return fileSetIcon;
			} else if (element instanceof MediaSet) {
				return mediaSetIcon;
			} else if (element instanceof LanguageSet) {
				return languageSetIcon;
			} else {
				return null;
			}
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element == null) {
				return super.getText(element);
			} else {
				final AbstractResourceContainer resourceContainer = (AbstractResourceContainer) element;
				return resourceContainer.getBaseFolder() == null ? "." : resourceContainer.getBaseFolder();
			}
		}
		
	}
	
	private class AbstractResourceLabelProvider extends ObservableMapLabelProvider {

		public AbstractResourceLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}
		
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (element == null) {
				return null;
			} else if (element instanceof FolderResource) {
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
			}
			final String path = ((AbstractResource) element).getPath().trim();
			if (path != null && !path.isEmpty()) {
				final String fileName = path.contains(File.separator) ? path.substring(path.indexOf(File.separator) + 1, path.length()) : path;
				final IContentType contentType = Platform.getContentTypeManager().findContentTypeFor(fileName);
				if (contentType != null) {
					if (imageRegistry.get(contentType.getId()) == null) {
						final ImageDescriptor imageDescriptor = PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor(fileName, contentType);
						imageRegistry.put(contentType.getId(), imageDescriptor.createImage());
					}
					return imageRegistry.get(contentType.getId());
				}
			}
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		}
		
		@Override
		public String getColumnText(Object element, int columnIndex) {
			return element == null ? null : ((AbstractResource) element).getPath();
		}
		
	}

}
