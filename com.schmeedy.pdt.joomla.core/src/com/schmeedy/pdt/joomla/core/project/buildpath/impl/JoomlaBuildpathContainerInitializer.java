package com.schmeedy.pdt.joomla.core.project.buildpath.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.core.BuildpathContainerInitializer;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IBuildpathContainer;
import org.eclipse.dltk.core.IScriptProject;

import com.schmeedy.pdt.joomla.core.project.IJoomlaProjectManager;
import com.schmeedy.pdt.joomla.core.project.buildpath.JoomlaBuildpathUtils;
import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

public class JoomlaBuildpathContainerInitializer extends BuildpathContainerInitializer {

	private final IJoomlaProjectManager projectManager = ServiceRegistry.getInstance().getService(IJoomlaProjectManager.class);
	private final IJoomlaServerManager serverManager = ServiceRegistry.getInstance().getService(IJoomlaServerManager.class);
	
	@Override
	public void initialize(IPath containerPath, IScriptProject project) throws CoreException {
		if (JoomlaBuildpathUtils.isJoomlaContainerPath(containerPath)) {
			final IScriptProject[] affectedProjects = new IScriptProject[1];
			affectedProjects[0] = project;
			final IBuildpathContainer[] containers = new IBuildpathContainer[1];
			containers[0] = new JoomlaBuildpathContainer(project.getProject(), projectManager, serverManager);
			DLTKCore.setBuildpathContainer(containerPath, affectedProjects, containers, null);
		}
	}

	@Override
	public String getDescription(IPath containerPath, IScriptProject project) {
		final JoomlaBuildpathContainer container = new JoomlaBuildpathContainer(project.getProject(), projectManager, serverManager);
		return container.getDescription();
	}
	
}
