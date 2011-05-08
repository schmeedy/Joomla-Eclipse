package com.schmeedy.pdt.joomla.core.project.builder;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

import com.schmeedy.pdt.joomla.core.project.IJoomlaProjectManager;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionResource;
import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

public class JoomlaExtensionProjectBuilder extends IncrementalProjectBuilder {

	private static final IProject[] EMPTY_PROJECTS = new IProject[0];

	private final IJoomlaDeployer deployer = ServiceRegistry.getInstance().getService(IJoomlaDeployer.class);
	private final IJoomlaProjectManager projectManager = ServiceRegistry.getInstance().getService(IJoomlaProjectManager.class);
	
	private final ResourceSynchronizer resourceSynchronizer = new ResourceSynchronizer();
	
	@Override
	protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor) throws CoreException {
		final List<ExtensionWithTargetRuntime> extensions = getExtensionsToBuild();
		if (!extensions.isEmpty()) {
			build(kind, extensions, monitor);
		}
		return EMPTY_PROJECTS;
	}

	private void build(int kind, List<ExtensionWithTargetRuntime> extensions, IProgressMonitor monitor) throws CoreException {
		final Map<IPath, FileOrFolder> resourceMap = buildResourceMap(extensions);
		if (kind == AUTO_BUILD || kind == INCREMENTAL_BUILD) {
			getDelta(getProject()).accept(new IResourceDeltaVisitor() {
				@Override
				public boolean visit(IResourceDelta delta) throws CoreException {
					final IResource resource = delta.getResource();
					
					if (resourceMap.containsKey(resource.getFullPath())) {
						final FileOrFolder destination = resourceMap.get(resource.getFullPath());
						switch (delta.getKind()) {
							case IResourceDelta.ADDED:
							case IResourceDelta.CHANGED:
								resourceSynchronizer.copy(resource, destination);
								break;
							case IResourceDelta.REMOVED:
								resourceSynchronizer.remove(destination);
								break;
						}
					}
					
					for (final IPath path : resourceMap.keySet()) {
						if (resource.getFullPath().isPrefixOf(path)) {
							return true;
						}
					}
					return false;
				}
			});
		} else if (kind == FULL_BUILD || kind == CLEAN_BUILD) {
			for (final IPath fullResourcePath : resourceMap.keySet()) {
				IResource sourceResource;
				final IPath relativeResourcePath = fullResourcePath.makeRelativeTo(getProject().getFullPath());
				final FileOrFolder target = resourceMap.get(fullResourcePath);
				if (target.isFolder()) {
					sourceResource = getProject().getFolder(relativeResourcePath);
				} else {
					sourceResource = getProject().getFile(relativeResourcePath);
				}
				if (sourceResource.exists()) {
					resourceSynchronizer.copy(sourceResource, target);
				}
			}
		}
	}

	private Map<IPath, FileOrFolder> buildResourceMap(List<ExtensionWithTargetRuntime> extensions) {
		final Map<IPath, FileOrFolder> resourceMap = new HashMap<IPath, FileOrFolder>();
		for (final ExtensionWithTargetRuntime extensionAndRuntime : extensions) {
			for (final ExtensionResource resource : extensionAndRuntime.extension.getResources()) {
				final File targetFile = extensionAndRuntime.runtime.getDestination(resource);
				if (targetFile != null) {
					resourceMap.put(resource.getFullPath(), new FileOrFolder(targetFile, resource.isFolder()));
				}
			}
		}
		return resourceMap;
	}

	private List<ExtensionWithTargetRuntime> getExtensionsToBuild() {
		final List<ExtensionWithTargetRuntime> extensionsToBuild = new LinkedList<ExtensionWithTargetRuntime>();
		final IProject project = getProject();
		for (final DeploymentRuntime runtime : deployer.getDeploymentDescriptor().getRuntimes()) {
			for (final JoomlaExtensionDeployment deployment : runtime.getDeployedExtensions()) {
				final BasicExtensionModel extension = deployment.getExtension();
				if (project.getFullPath().isPrefixOf(extension.getManifestPath())) {
					final IFile manifestFile = ResourcesPlugin.getWorkspace().getRoot().getFile(extension.getManifestPath());
					final BasicExtensionModel currentModel = projectManager.getBasicExtensionModel(manifestFile);
					if (currentModel != null) {
						extensionsToBuild.add(new ExtensionWithTargetRuntime(currentModel, runtime));
					}
				}
			}
		}
		return extensionsToBuild;
	}
	
	private static class ExtensionWithTargetRuntime {
		final BasicExtensionModel extension;
		final DeploymentRuntime runtime;

		public ExtensionWithTargetRuntime(BasicExtensionModel extension, DeploymentRuntime runtime) {
			this.extension = extension;
			this.runtime = runtime;
		}
	}

}
