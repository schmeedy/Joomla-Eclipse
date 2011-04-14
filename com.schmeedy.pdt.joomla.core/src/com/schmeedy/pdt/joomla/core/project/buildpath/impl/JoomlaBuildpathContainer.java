package com.schmeedy.pdt.joomla.core.project.buildpath.impl;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IAccessRule;
import org.eclipse.dltk.core.IBuildpathAttribute;
import org.eclipse.dltk.core.IBuildpathContainer;
import org.eclipse.dltk.core.IBuildpathEntry;
import org.eclipse.dltk.core.environment.FileAsFileHandle;
import org.eclipse.dltk.internal.core.BuildpathAttribute;

import com.schmeedy.pdt.joomla.core.project.IJoomlaProjectManager;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;

@SuppressWarnings("restriction")
public class JoomlaBuildpathContainer implements IBuildpathContainer {


	public static final String ID = "com.schmeedy.pdt.JoomlaContainer"; 
	
	private static final IAccessRule[] EMPTY_ACCESS_RULES = new IAccessRule[0];
	private static final IBuildpathEntry[] EMPTY_BUILDPATH = new IBuildpathEntry[0];
	private static final IBuildpathAttribute[] JOOMLA_CONTAINER_BUILDPATH_ATTRIBUTES;
	
	static {
		JOOMLA_CONTAINER_BUILDPATH_ATTRIBUTES = new IBuildpathAttribute[1];
		JOOMLA_CONTAINER_BUILDPATH_ATTRIBUTES[0] = new BuildpathAttribute("resolved-joomla-installation", "true");
	}
	
	private final IProject project;
	private final IJoomlaProjectManager projectManager;
	private final IJoomlaServerManager serverManager;
	
	public JoomlaBuildpathContainer(IProject project, IJoomlaProjectManager projectManager, IJoomlaServerManager serverManager) {
		this.project = project;
		this.projectManager = projectManager;
		this.serverManager = serverManager;
	}

	@Override
	public IBuildpathEntry[] getBuildpathEntries() {
		final JoomlaExtensionProject projectModel = projectManager.getExtensionProjectModel(project);
		if (projectModel == null) {
			return EMPTY_BUILDPATH;
		}
		
		final LocalJoomlaServer defaultServer = serverManager.getDefaultServer(projectModel);
		if (defaultServer == null) {
			return EMPTY_BUILDPATH;
		}
		final File installDir = new File(defaultServer.getInstallDir());
		final IBuildpathEntry entry = DLTKCore.newLibraryEntry(new FileAsFileHandle(installDir).getFullPath().append("libraries"), EMPTY_ACCESS_RULES, JOOMLA_CONTAINER_BUILDPATH_ATTRIBUTES, false, true);
		final IBuildpathEntry[] buildpath = new IBuildpathEntry[1];
		buildpath[0] = entry;
		return buildpath;
	}

	@Override
	public String getDescription() {
		return "Joomla!";
	}

	@Override
	public IPath getPath() {
		return new Path(ID);
	}

	@Override
	public int getKind() {
		return IBuildpathContainer.K_SYSTEM;
	}

}
