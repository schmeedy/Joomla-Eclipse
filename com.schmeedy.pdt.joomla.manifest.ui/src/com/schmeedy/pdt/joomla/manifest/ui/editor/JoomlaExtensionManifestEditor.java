package com.schmeedy.pdt.joomla.manifest.ui.editor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.EventObject;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.wst.sse.ui.StructuredTextEditor;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.util.JoomlaExtensionManifestResourceFactoryImpl;
import com.schmeedy.pdt.joomla.manifest.ui.JoomlaExtensionManifestUiPlugin;

public class JoomlaExtensionManifestEditor extends FormEditor implements IEditingDomainProvider, IMenuListener {

	private final MarkerHelper markerHelper = new EditUIMarkerHelper();

	private OverviewPage overviewPage;
	private MultiResourceContainerPage resourcePage;
	private MultiResourceContainerPage adminResourcePage;
	private final StructuredTextEditor xmlSourceEditor = new StructuredTextEditor();

	private final TransactionalEditingDomain editingDomain;
	private final WorkspaceSynchronizer workspaceSynchronizer;
	private Resource inputResource;
	private Diagnostic inputResourceDiagnostic;
	
	private final AtomicBoolean savingModelState = new AtomicBoolean(false);

	public JoomlaExtensionManifestEditor() {
		final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		final TransactionalCommandStack commandStack = new TransactionalCommandStackImpl();
		commandStack.addCommandStackListener(new CommandStackListener() {
			@Override
			public void commandStackChanged(EventObject event) {
				firePropertyChange(IEditorPart.PROP_DIRTY);
			}
		});
		editingDomain = new TransactionalEditingDomainImpl(adapterFactory, commandStack);
		final ResourceSet resourceSet = editingDomain.getResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new JoomlaExtensionManifestResourceFactoryImpl());
		
		workspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			@Override
			public boolean handleResourceMoved(Resource resource, URI newURI) {
				return false;
			}
			
			@Override
			public boolean handleResourceDeleted(Resource resource) {
				return false;
			}
			
			@Override
			public boolean handleResourceChanged(Resource resource) {
				if (resource == inputResource) {
					if (!savingModelState.get()) {
						resource.unload();
						try { // TODO: request confirmation before reloading when the editor is dirty
							resource.load(resource.getResourceSet().getLoadOptions());
							getSite().getShell().getDisplay().asyncExec(new Runnable() {
								@Override
								public void run() {
									reloadStructuredPageInputFromInputResource();
								}
							});
						} catch (final IOException e) {
							JoomlaExtensionManifestUiPlugin.getInstance().logError("Failed to reload changed resource " + resource.getURI(), e);
						}
					}
					return true;
				} else {
					return false;
				}
			}
			
			@Override
			public void dispose() {
			}
		});
	}
	
	private int getXmlSourceEditorIndex() {
		return getPageCount() - 1;
	}

	@Override
	protected void addPages() {
		overviewPage = new OverviewPage(this);
		overviewPage.setEditingDomain(editingDomain);
		
		resourcePage = new MultiResourceContainerPage(this, "resources", "Resources");
		resourcePage.setEditingDomain(editingDomain);
		
		adminResourcePage = new MultiResourceContainerPage(this, "admin.resources", "Admin Resources");
		adminResourcePage.setEditingDomain(editingDomain);

		try {
			addPage(overviewPage);
			addPage(resourcePage);
			addPage(adminResourcePage);
			
			final int xmlSourcePageIdx = addPage(xmlSourceEditor, getEditorInput());
			setPageText(xmlSourcePageIdx, "XML");
		} catch (final PartInitException e) {
			JoomlaExtensionManifestUiPlugin.getInstance().logError("Failed to initialize Joomla! extension manifest editor.", e);
		}

		reloadModelInput();
	}
	
	@Override
	protected void setActivePage(int newPageIndex) {
		final int oldPageIndex = getActivePage();
		if (oldPageIndex == getXmlSourceEditorIndex() && newPageIndex != getXmlSourceEditorIndex() && xmlSourceEditor.isDirty()) {
			inputResource.unload();
			// TODO: reload model from changed XML source
		}
		super.setActivePage(newPageIndex);
	}

	private void reloadStructuredPageInputFromInputResource() {
		final JoomlaExtensionManifest manifest = (JoomlaExtensionManifest) inputResource.getEObject("/");
		if (manifest.getName() != null) {
			setPartName(manifest.getName());
		}
		overviewPage.setInput(manifest);
		resourcePage.setInput(manifest);
		if (manifest.getAdministration() != null) {
			adminResourcePage.setInput(manifest.getAdministration());
		}
	}

	private void reloadModelInput() {
		final IEditorInput input = getEditorInput();
		if (input instanceof IFileEditorInput) {
			final IFileEditorInput fileEditorInput = (IFileEditorInput) input;
			final IPath filePath = fileEditorInput.getFile().getFullPath();
			inputResource = editingDomain.getResourceSet().getResource(URI.createPlatformResourceURI(filePath.toString(), true), true);
			reloadStructuredPageInputFromInputResource();
		} else {
			throw new IllegalArgumentException("Unsupported editor input type: " + input.getClass());
		}
	}

	@Override
	public boolean isDirty() {
		return isModelDirty() || xmlSourceEditor.isDirty();
	}

	private boolean isModelDirty() {
		return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		if (getCurrentPage() == getXmlSourceEditorIndex()) {
			saveXmlSourceAndReloadResource(monitor);
		} else {
			saveResourceAndReloadXmlEditorInput(monitor);
		}
	}

	private void saveXmlSourceAndReloadResource(IProgressMonitor monitor) {
		xmlSourceEditor.doSave(monitor);
	}

	private void saveResourceAndReloadXmlEditorInput(IProgressMonitor monitor) {
		final WorkspaceModifyOperation saveOperation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				try {
					savingModelState.set(true);
					inputResource.save(Collections.emptyMap());
				} catch (final Exception e) {
					inputResourceDiagnostic = analyzeResourceProblems(inputResource, e);
				} finally {
					savingModelState.set(false);
				}
			}
		};

		try {
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, saveOperation);

			((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (final Exception e) {
			JoomlaExtensionManifestUiPlugin.getInstance().logError("Saving failed.", e);
		}
		updateProblemIndication();
	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	private void updateProblemIndication() {
		final BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, JoomlaExtensionManifestUiPlugin.BUNDLE_ID, 0, null,
				new Object[] { editingDomain.getResourceSet() });

		if (inputResourceDiagnostic != null) {
			diagnostic.add(inputResourceDiagnostic);
		}

		if (markerHelper.hasMarkers(editingDomain.getResourceSet())) {
			markerHelper.deleteMarkers(editingDomain.getResourceSet());
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				try {
					markerHelper.createMarkers(diagnostic);
				} catch (final CoreException exception) {
					JoomlaExtensionManifestUiPlugin.getInstance().logError("Failed to create problem markers.", exception);
				}
			}
		}
	}

	private Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
		final String message = "Problems in Joomla! extension manifest " + resource.getURI();
		if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
			final BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, JoomlaExtensionManifestUiPlugin.BUNDLE_ID, 0,
					message, new Object[] { exception == null ? (Object) resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		} else if (exception != null) {
			return new BasicDiagnostic(Diagnostic.ERROR, JoomlaExtensionManifestUiPlugin.BUNDLE_ID, 0, message, new Object[] { exception });
		} else {
			return Diagnostic.OK_INSTANCE;
		}
	}

	@Override
	public void menuAboutToShow(IMenuManager manager) {
		((IMenuListener) getEditorSite().getActionBarContributor()).menuAboutToShow(manager);
	}

	@Override
	public void dispose() {
		xmlSourceEditor.dispose();
		workspaceSynchronizer.dispose();
		editingDomain.dispose();
	}

}
