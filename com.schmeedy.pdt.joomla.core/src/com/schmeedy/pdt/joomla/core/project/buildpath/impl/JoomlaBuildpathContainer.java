package com.schmeedy.pdt.joomla.core.project.buildpath.impl;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IBuildpathContainer;
import org.eclipse.dltk.core.IBuildpathEntry;
import org.eclipse.dltk.core.environment.FileAsFileHandle;
import org.eclipse.emf.common.util.EList;

import com.schmeedy.pdt.joomla.core.project.IJoomlaProjectManager;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;

public class JoomlaBuildpathContainer implements IBuildpathContainer {

	public static final String ID = "com.schmeedy.pdt.JoomlaAPI"; 
	
	private static final IBuildpathEntry[] EMPTY_BUILDPATH = new IBuildpathEntry[0];
	
	private final IProject project;
	private final IJoomlaProjectManager projectManager;
	private final IJoomlaServerManager serverManager;
	
	private final String preferredServerTeamId;
	
	public JoomlaBuildpathContainer(IProject project, IJoomlaProjectManager projectManager, IJoomlaServerManager serverManager, String preferredServerTeamId) {
		this.project = project;
		this.projectManager = projectManager;
		this.serverManager = serverManager;
		this.preferredServerTeamId = preferredServerTeamId;
	}

	private LocalJoomlaServer getProjectApiServer() {
		final JoomlaExtensionProject projectModel = projectManager.getExtensionProjectModel(project);
		if (projectModel == null) {
			return null;
		}
		
		if (preferredServerTeamId != null) {
			final EList<LocalJoomlaServer> servers = serverManager.getAvailableServers().getServers();
			for (final LocalJoomlaServer server : servers) {
				if (preferredServerTeamId.equals(server.getTeamId())) {
					return server;
				}
			}
		}
			
		return serverManager.getDefaultServer(projectModel);
	}
	
	@Override
	public IBuildpathEntry[] getBuildpathEntries() {
		final LocalJoomlaServer apiServer = getProjectApiServer();		
		if (apiServer == null) {
			return EMPTY_BUILDPATH;
		}
		
		final File installDir = new File(apiServer.getInstallDir());
		final IBuildpathEntry entry = DLTKCore.newLibraryEntry(new FileAsFileHandle(installDir).getFullPath().append("libraries"), false, true);
		final IBuildpathEntry[] buildpath = new IBuildpathEntry[1];
		buildpath[0] = entry;
		return buildpath;
	}

	@Override
	public String getDescription() {
		final String label = "Joomla! API";
		final LocalJoomlaServer server = getProjectApiServer();
		if (server == null) {
			return label;
		} else {
			return label + " [" + server.getInstallDir() + File.separator + "libraries]";
		}
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
