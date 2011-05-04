package com.schmeedy.pdt.joomla.core.project;

import java.util.List;

import org.eclipse.core.resources.IProject;

import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;

public interface IJoomlaProjectManager {

	JoomlaExtensionProject getExtensionProjectModel(IProject project);
	
	List<JoomlaExtensionProject> getExtensionProjects();
	
}
