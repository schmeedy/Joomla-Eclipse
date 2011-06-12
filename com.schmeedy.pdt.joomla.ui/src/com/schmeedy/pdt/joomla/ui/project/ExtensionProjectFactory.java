package com.schmeedy.pdt.joomla.ui.project;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IBuildpathEntry;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.php.internal.core.includepath.IncludePath;
import org.eclipse.php.internal.core.includepath.IncludePathManager;
import org.eclipse.php.internal.core.language.LanguageModelInitializer;
import org.eclipse.php.internal.core.project.PHPNature;
import org.eclipse.wst.jsdt.web.core.internal.project.JsWebNature;

import com.schmeedy.pdt.joomla.core.JoomlaCorePlugin;
import com.schmeedy.pdt.joomla.core.project.buildpath.JoomlaBuildpathUtils;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionType;
import com.schmeedy.pdt.joomla.core.server.ServerUtils;

public class ExtensionProjectFactory {

	public String suggestProjectName(BasicExtensionModel extension) {
		if ((extension.getType() == null || extension.getType() == ExtensionType.UNKNOWN)) {
			if (extension.getName() == null) {
				return "unknown_extension";
			} else {
				return ServerUtils.jfilterInputCleanCommand(extension.getName()).toLowerCase();
			}
		}
		switch (extension.getType()) {
			case COMPONENT:
				if (extension.getName() == null) {
					return "unknown_component";
				} else {
					final String cleanedName = ServerUtils.jfilterInputCleanCommand(extension.getName().toLowerCase());
					return cleanedName.startsWith("com_") ? cleanedName : "com_" + cleanedName;
				}
			case MODULE:
				if (extension.getSymbolicName() == null) {
					return "unknown_module";
				} else {
					final String cleanedName = ServerUtils.jfilterInputCleanCommand(extension.getSymbolicName().toLowerCase());
					return cleanedName.startsWith("mod_") ? cleanedName : "mod_" + cleanedName;
				}
			case PLUGIN:
				if (extension.getSymbolicName() == null) {
					return "unknown_plugin";
				} else {
					final String cleanedName = ServerUtils.jfilterInputCleanCommand(extension.getSymbolicName().toLowerCase());
					return cleanedName.startsWith("plg_") ? cleanedName : "plg_" + cleanedName;
				}
			case TEMPLATE:
				if (extension.getName() == null) {
					return "unknown_template";
				} else {
					final String cleanedName = ServerUtils.jfilterInputCleanCommand(extension.getName().toLowerCase());
					return cleanedName.startsWith("tpl_") ? cleanedName : "tpl" + cleanedName;
				}
			default:
				if (extension.getName() == null) {
					return "unknown_extension";
				} else {
					return ServerUtils.jfilterInputCleanCommand(extension.getName().toLowerCase());
				}
		}
	}
	
	public IScriptProject createJoomlaExtensionProject(String projectName, BasicExtensionModel extension, IProgressMonitor monitor) throws CoreException {
		final boolean jsSupport = extension.getType() != null && extension.getType() != ExtensionType.PLUGIN;
		return createJoomlaExtensionProject(projectName, JoomlaBuildpathUtils.newDefaultJoomlaContainerEntry(), jsSupport, monitor);
	}
	
	public IScriptProject createJoomlaExtensionProject(final String projectName, final IBuildpathEntry joomlaApiEntry, final boolean jsSupport, IProgressMonitor monitor) throws CoreException {
		try {
			monitor.beginTask("Create Joomla! extension project '" + projectName + "' in the workspace.", 4000);
			
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			createProject(project, new SubProgressMonitor(monitor, 1000));
			
			{
				final IProjectDescription projectDescription = project.getDescription();
				projectDescription.setNatureIds(new String[] { JoomlaCorePlugin.JOOMLA_EXTENSION_NATURE_ID, PHPNature.ID });
				project.setDescription(projectDescription, new SubProgressMonitor(monitor, 1000));
			}

			if (jsSupport) {
				final JsWebNature jsWebNature = new JsWebNature(project, new SubProgressMonitor(monitor, 1000));
				jsWebNature.configure();
			}
			
			final IScriptProject scriptProject = DLTKCore.create(project);
			
			final List<IBuildpathEntry> cpEntries = new ArrayList<IBuildpathEntry>();
			cpEntries.add(DLTKCore.newSourceEntry(project.getFullPath()));
			final List<IncludePath> ipEntries = new ArrayList<IncludePath>();
			ipEntries.add(new IncludePath(project, project));
			
			if (joomlaApiEntry != null) {
				cpEntries.add(joomlaApiEntry);
				ipEntries.add(new IncludePath(joomlaApiEntry, project));
			}

			final IBuildpathEntry[] buildpathEntries = cpEntries.toArray(new IBuildpathEntry[cpEntries.size()]);
			final IncludePath[] includePathEntries = ipEntries.toArray(new IncludePath[ipEntries.size()]);
			
			scriptProject.setRawBuildpath(buildpathEntries, new SubProgressMonitor(monitor, 1000));
			LanguageModelInitializer.enableLanguageModelFor(scriptProject);
			IncludePathManager.getInstance().setIncludePath(project, includePathEntries);
			
			return scriptProject;
		} finally {
			monitor.done();
		}
	}
			

	private void createProject(IProject project, IProgressMonitor monitor) throws CoreException {
		try {
			monitor.beginTask("Create project " + project.getName(), 1000);
			if (!project.exists()) {
				project.create(new SubProgressMonitor(monitor, 500));
			} else {
				monitor.worked(500);
			}
			if (!project.isOpen()) {
				project.open(new SubProgressMonitor(monitor, 500));
			} else {
				monitor.worked(500);
			}
		} finally {
			monitor.done();
		}
	}

}
