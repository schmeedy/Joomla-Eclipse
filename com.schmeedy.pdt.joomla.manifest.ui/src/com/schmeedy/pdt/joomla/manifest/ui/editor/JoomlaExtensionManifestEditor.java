package com.schmeedy.pdt.joomla.manifest.ui.editor;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.util.JoomlaExtensionManifestResourceFactoryImpl;

public class JoomlaExtensionManifestEditor extends FormEditor {

	private OverviewPage overviewPage;

	private Resource inputResource;
	
	@Override
	protected void addPages() {
		overviewPage = new OverviewPage(this);

		try {
			addPage(overviewPage);
		} catch (final PartInitException e) {
			e.printStackTrace();
		}
		
		reloadInput();
	}
	
	private void changePageInput(JoomlaExtensionManifest manifest) {
		overviewPage.setInput(manifest);
	}
	
	private void reloadInput() {
		final IEditorInput input = getEditorInput();
		if (input instanceof IFileEditorInput) {
			final IFileEditorInput fileEditorInput = (IFileEditorInput) input;
			final IPath filePath = fileEditorInput.getFile().getFullPath();
			loadInput(URI.createPlatformResourceURI(filePath.toString(), true));
		} else if (input == null) {
			unloadCurrentInput();
		} else {
			throw new IllegalArgumentException("Unsupported editor input type: " + input.getClass());
		}
	}
	
	private void loadInput(URI uri) {
		unloadCurrentInput();
		
		try {
			final ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new JoomlaExtensionManifestResourceFactoryImpl());
			inputResource = resourceSet.createResource(uri);
			inputResource.load(Collections.emptyMap());
			final JoomlaExtensionManifest manifest = (JoomlaExtensionManifest) inputResource.getEObject("/");
			if (manifest.getName() != null) {
				setPartName(manifest.getName());
			}
			changePageInput(manifest);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	private void unloadCurrentInput() {
		if (inputResource != null) {
			inputResource.unload();
		}
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO
	}

	@Override
	public void doSaveAs() {
		
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	
	
}
