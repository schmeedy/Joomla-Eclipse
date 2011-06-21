package com.schmeedy.pdt.joomla.core.project.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.content.IContentType;

import com.schmeedy.pdt.joomla.core.JoomlaCorePlugin;
import com.schmeedy.pdt.joomla.core.project.IExtensionModelChangeListener;
import com.schmeedy.pdt.joomla.core.project.IJoomlaProjectManager;
import com.schmeedy.pdt.joomla.core.project.impl.BasicExtensionModelParser.ParsingException;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelFactory;

public class JoomlaProjectManagerImpl implements IJoomlaProjectManager {

	private static final String JOOMLA_MANIFEST_CONTENT_TYPE_ID = "com.schmeedy.pdt.joomla.core.ExtensionManifest";
	
	private final BasicExtensionModelParser extensionModelParser = new BasicExtensionModelParser();
	
	private final Map<IProject, List<IFile>> extensionManifestFileCache = new ConcurrentHashMap<IProject, List<IFile>>();   
	
	private final Map<IFile, SoftReference<ExtensionModelWithModificationStamp>> extensionModelCache = new ConcurrentHashMap<IFile, SoftReference<ExtensionModelWithModificationStamp>>();

	private final ResourceChangeListener workspaceResourceListener = new ResourceChangeListener(); 
	
	private final List<IExtensionModelChangeListener> extensionModelChangeListeners = new CopyOnWriteArrayList<IExtensionModelChangeListener>();
	
	public void activate() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceResourceListener, IResourceChangeEvent.POST_CHANGE);
	}
	
	public void deactivate() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(workspaceResourceListener);
	}
	
	public void addExtensionModelChangeListener(IExtensionModelChangeListener listener) {
		extensionModelChangeListeners.add(listener);
	}
	
	public void removeExtensionModelChangeListener(IExtensionModelChangeListener listener) {
		extensionModelChangeListeners.remove(listener);
	}
	
	private void fireExtensionModelChanged(BasicExtensionModel extensionModel) {
		for (final IExtensionModelChangeListener listener : extensionModelChangeListeners) {
			listener.onExtensionModelChange(extensionModel);
		}
	}
	
	@Override
	public JoomlaExtensionProject getExtensionProjectModel(IProject project) {
		if (!project.isOpen()) {
			throw new IllegalArgumentException("Open project expected.");
		}
		try {
			final IProjectNature nature = project.getNature(JoomlaExtensionProjectNature.ID);
			if (nature == null) {
				return null;
			}
		} catch (final CoreException e) {
			throw new IllegalArgumentException("Invalid project handle.", e);
		}

		
		final JoomlaExtensionProject extensionProject = JoomlaProjectModelFactory.eINSTANCE.createJoomlaExtensionProject();
		extensionProject.setProject(project);
		
		final List<IFile> manifestFiles = getManifestFiles(project);
		
		for (final IFile manifestFile : manifestFiles) {
			final BasicExtensionModel extensionModel = getBasicExtensionModel(manifestFile);
			if (extensionModel != null) {
				extensionProject.getExtensions().add(extensionModel);
			}
		}
		
		return extensionProject;
	}

	private List<IFile> getManifestFiles(IProject project) {
		final List<IFile> cachedFiles = extensionManifestFileCache.get(project);
		if (cachedFiles != null) {
			return cachedFiles;
		}
		
		final List<IFile> manifestFiles = new LinkedList<IFile>();
		try {
			project.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						final IFile file = (IFile) resource;
						if (isJoomlaManifest(file)) {
							manifestFiles.add(file);
						}
						return false;
					} else {
						return true;
					}
				}
			}, IResource.DEPTH_INFINITE, IContainer.EXCLUDE_DERIVED);
		} catch (final CoreException e) {
			throw new RuntimeException("Failed to find Joomla! manifest files within " + project.getName(), e);
		}
		extensionManifestFileCache.put(project, new CopyOnWriteArrayList<IFile>(manifestFiles));
		return manifestFiles;
	}

	private boolean isJoomlaManifest(final IFile file) throws CoreException {
		if (file.isSynchronized(IResource.DEPTH_ZERO) && file.getContentDescription() != null && file.getContentDescription().getContentType() != null) {
			IContentType contentType = file.getContentDescription().getContentType();
			while (contentType != null) {
				if (JOOMLA_MANIFEST_CONTENT_TYPE_ID.equals(contentType.getId())) {
					return true;
				}
				contentType = contentType.getBaseType();
			}
		}
		return false;
	}
	
	@Override
	public BasicExtensionModel getBasicExtensionModel(IFile manifestFile) {
		final SoftReference<ExtensionModelWithModificationStamp> extensionModel = extensionModelCache.get(manifestFile);
		if (extensionModel != null) {
			final ExtensionModelWithModificationStamp modelWithStamp = extensionModel.get();
			if (modelWithStamp != null) {
				if (modelWithStamp.modificationStamp == manifestFile.getModificationStamp()) {
					return modelWithStamp.extensionModel;
				} else {
					extensionModelCache.remove(manifestFile);
				}
			}
		}
		
		if (!manifestFile.exists()) {
			return null;
		}
		
		try {
			final InputStream inputStream = manifestFile.getContents();
			try {
				final BasicExtensionModel parsedModel = extensionModelParser.parse(inputStream, manifestFile.getName());
				parsedModel.setManifestPath(manifestFile.getFullPath());
				if (parsedModel != null) {
					final ExtensionModelWithModificationStamp modelWithStamp = new ExtensionModelWithModificationStamp(parsedModel, manifestFile.getModificationStamp());
					extensionModelCache.put(manifestFile, new SoftReference<ExtensionModelWithModificationStamp>(modelWithStamp));
				}
				fireExtensionModelChanged(parsedModel);
				return parsedModel;
			} catch (final ParsingException e) {
				JoomlaCorePlugin.logError("Failed to parse extension model from " + manifestFile, e);
				return null;
			} finally {
				try {
					inputStream.close();
				} catch (final IOException ignore) {}
			}
		} catch (final CoreException e) {
			JoomlaCorePlugin.logError("Exception on attempt to read extension manifest file " + manifestFile, e);
			return null;
		}
	}
	
	@Override
	public List<JoomlaExtensionProject> getExtensionProjects() {
		final List<JoomlaExtensionProject> extensionProjects = new LinkedList<JoomlaExtensionProject>();
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (final IProject project : projects) {
			if (project.isOpen()) {
				final JoomlaExtensionProject extensionProject = getExtensionProjectModel(project);
				if (extensionProject != null) {
					extensionProjects.add(extensionProject);
				}
			}
		}
		return extensionProjects;
	}
	
	private static final class ExtensionModelWithModificationStamp {
		final BasicExtensionModel extensionModel;
		final long modificationStamp;
		
		public ExtensionModelWithModificationStamp(BasicExtensionModel extensionModel, long modificationStamp) {
			super();
			this.extensionModel = extensionModel;
			this.modificationStamp = modificationStamp;
		}		
	}
	
	private class ResourceChangeListener implements IResourceChangeListener, IResourceDeltaVisitor {
		@Override
		public void resourceChanged(IResourceChangeEvent resourceChangeEvent) {
			try {
				resourceChangeEvent.getDelta().accept(this);
			} catch (final CoreException e) {
				JoomlaCorePlugin.log(e.getStatus());
			}
		}
		
		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			final IResource resource = delta.getResource();
			switch (resource.getType()) {
				case IResource.PROJECT:
					final IProject project = (IProject) resource;
					return Arrays.asList(project.getDescription().getNatureIds()).contains(JoomlaExtensionProjectNature.ID);
				case IResource.FILE:
					final IFile file = (IFile) resource;
					if (isJoomlaManifest(file)) {
						processManifestDelta(file, delta.getKind());
					}
					return false;
				default:
					return true;
			}
		}

		private void processManifestDelta(IFile manifestFile, int deltaKind) {
			switch (deltaKind) {
				case IResourceDelta.ADDED:
					{
						final List<IFile> cachedFiles = extensionManifestFileCache.get(manifestFile.getProject());
						if (cachedFiles != null) {
							cachedFiles.add(manifestFile);
						}
					}
					// force to reload the model
					getBasicExtensionModel(manifestFile);
					break;
				case IResourceDelta.CHANGED:
					// force to reload the model
					getBasicExtensionModel(manifestFile);
					break;
				case IResourceDelta.REMOVED:
					{
						final List<IFile> cachedFiles = extensionManifestFileCache.get(manifestFile.getProject());
						if (cachedFiles != null) {
							cachedFiles.remove(manifestFile);
						}
					}
					extensionModelCache.remove(manifestFile);
					break;
			}
		}
	}
	
}