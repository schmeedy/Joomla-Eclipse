package com.schmeedy.pdt.joomla.core.project.impl;

import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IBuildpathEntry;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ModelException;

import com.schmeedy.pdt.joomla.core.project.buildpath.impl.JoomlaBuildpathContainer;

public class JoomlaExtensionProjectNature implements IProjectNature {

	public static final String ID = "com.schmeedy.pdt.joomla.core.JoomlaExtensionNature";
	
	private IProject project;
	
	@Override
	public void configure() throws CoreException {
		final IScriptProject scriptProject = DLTKCore.create(project);
		if (!scriptProject.isValid()) {
			return;
		}
		
//		addJoomlaBuildpathContainer(scriptProject);
	}

	@Override
	public void deconfigure() throws CoreException {
		final IScriptProject scriptProject = DLTKCore.create(project);
		if (!scriptProject.isValid()) {
			return;
		}
		
//		removeJoomlaBuildpathContainer(scriptProject);
	}
	
	private void addJoomlaBuildpathContainer(final IScriptProject scriptProject) throws ModelException {
		final IBuildpathEntry[] buildpath = scriptProject.getRawBuildpath();
		for (final IBuildpathEntry entry : buildpath) {
			if (JoomlaBuildpathContainer.ID.equals(entry.getPath().segment(0))) {
				return;
			}
		}
		final IBuildpathEntry[] extendedBuildpath = Arrays.copyOf(buildpath, buildpath.length + 1);
		extendedBuildpath[extendedBuildpath.length - 1] = DLTKCore.newContainerEntry(new Path(JoomlaBuildpathContainer.ID));
		scriptProject.setRawBuildpath(extendedBuildpath, null);
	}

	private void removeJoomlaBuildpathContainer(IScriptProject scriptProject) throws ModelException {
		final IBuildpathEntry[] buildpath = scriptProject.getRawBuildpath();
		int joomlaContainerIdx = -1;
		for (int i = 0; i < buildpath.length; i++) {
			final IBuildpathEntry entry = buildpath[i];
			if (JoomlaBuildpathContainer.ID.equals(entry.getPath().segment(0))) {
				joomlaContainerIdx = i;
				break;
			}
		}
		if (joomlaContainerIdx >= 0) {
			final IBuildpathEntry[] newBuildpath = new IBuildpathEntry[buildpath.length - 1];
			int idx = 0, newIdx = 0;
			for (; idx < buildpath.length; idx++) {
				if (idx != joomlaContainerIdx) {
					newBuildpath[newIdx++] = buildpath[idx];
				}
			}
			scriptProject.setRawBuildpath(newBuildpath, null);
		}
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

}
