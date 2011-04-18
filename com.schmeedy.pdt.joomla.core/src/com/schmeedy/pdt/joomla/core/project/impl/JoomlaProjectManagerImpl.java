package com.schmeedy.pdt.joomla.core.project.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.content.IContentType;

import com.schmeedy.pdt.joomla.core.project.IJoomlaProjectManager;
import com.schmeedy.pdt.joomla.core.project.impl.BasicExtensionModelParser.ParsingException;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelFactory;

public class JoomlaProjectManagerImpl implements IJoomlaProjectManager {

	private static final String JOOMLA_MANIFEST_CONTENT_TYPE_ID = "com.schmeedy.pdt.joomla.core.ExtensionManifest";
	
	private final BasicExtensionModelParser extensionModelParser = new BasicExtensionModelParser();
	
	private final Map<ExtensionModelCacheKey, SoftReference<ExtensionModelWithModificationStamp>> extensionModelCache = new HashMap<JoomlaProjectManagerImpl.ExtensionModelCacheKey, SoftReference<ExtensionModelWithModificationStamp>>();
	
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
		
		final List<IPath> manifestFiles = new LinkedList<IPath>();
		try {
			project.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						final IFile file = (IFile) resource;
						if (file.getContentDescription() != null && file.getContentDescription().getContentType() != null) {
							IContentType contentType = file.getContentDescription().getContentType();
							while (contentType != null) {
								if (JOOMLA_MANIFEST_CONTENT_TYPE_ID.equals(contentType.getId())) {
									manifestFiles.add(resource.getProjectRelativePath());
								}
								contentType = contentType.getBaseType();
							}
						}
						return false;
					} else {
						return true;
					}
				}
			}, IResource.DEPTH_INFINITE, IContainer.EXCLUDE_DERIVED);
		} catch (final CoreException e) {
			throw new RuntimeException("Failed to find Joomla! manifest files within " + project.getName());
		}
		
		for (final IPath manifestFilePath : manifestFiles) {
			final BasicExtensionModel extensionModel = getBasicExtensionModel(project, manifestFilePath);
			if (extensionModel != null) {
				extensionProject.getExtensions().add(extensionModel);
			}
		}
		
		return extensionProject;
	}

	@Override
	public BasicExtensionModel getBasicExtensionModel(IProject project, IPath manifestPath) {
		final ExtensionModelCacheKey cacheKey = new ExtensionModelCacheKey(project, manifestPath);
		final SoftReference<ExtensionModelWithModificationStamp> extensionModel = extensionModelCache.get(cacheKey);
		if (extensionModel != null) {
			final ExtensionModelWithModificationStamp modelWithStamp = extensionModel.get();
			if (modelWithStamp != null) {
				if (modelWithStamp.modificationStamp == project.getFile(manifestPath).getModificationStamp()) {
					return modelWithStamp.extensionModel;
				} else {
					extensionModelCache.remove(cacheKey);
				}
			}
		}
		
		final IFile file = project.getFile(manifestPath);
		try {
			final InputStream inputStream = file.getContents();
			try {
				final BasicExtensionModel parsedModel = extensionModelParser.parse(inputStream);
				if (parsedModel != null) {
					final ExtensionModelWithModificationStamp modelWithStamp = new ExtensionModelWithModificationStamp(parsedModel, file.getModificationStamp());
					extensionModelCache.put(cacheKey, new SoftReference<ExtensionModelWithModificationStamp>(modelWithStamp));
				}
				return parsedModel;
			} catch (final ParsingException e) {
				return null; // TODO: log ... or something else?
			} finally {
				try {
					inputStream.close();
				} catch (final IOException ignore) {}
			}
		} catch (final CoreException e) {
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
	
	private static final class ExtensionModelCacheKey {
		private final IProject project;
		private final IPath manifestFilePath;
		
		public ExtensionModelCacheKey(IProject project, IPath manifestFilePath) {
			this.project = project;
			this.manifestFilePath = manifestFilePath;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((manifestFilePath == null) ? 0 : manifestFilePath.hashCode());
			result = prime * result + ((project == null) ? 0 : project.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final ExtensionModelCacheKey other = (ExtensionModelCacheKey) obj;
			if (manifestFilePath == null) {
				if (other.manifestFilePath != null)
					return false;
			} else if (!manifestFilePath.equals(other.manifestFilePath))
				return false;
			if (project == null) {
				if (other.project != null)
					return false;
			} else if (!project.equals(other.project))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return project.getFullPath().append(manifestFilePath).toString();
		}
	}

}