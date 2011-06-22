package com.schmeedy.pdt.joomla.core.project.impl;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import com.schmeedy.pdt.joomla.core.project.builder.JoomlaExtensionProjectBuilder;

public class JoomlaExtensionProjectNature implements IProjectNature {

	public static final String ID = "com.schmeedy.pdt.joomla.core.JoomlaExtensionNature";

	private IProject project;

	@Override
	public void configure() throws CoreException {
		addToFrontOfBuildSpec(JoomlaExtensionProjectBuilder.ID);
	}

	@Override
	public void deconfigure() throws CoreException {
		removeFromBuildSpec(JoomlaExtensionProjectBuilder.ID);
	}

	private ICommand addToFrontOfBuildSpec(String builderID) throws CoreException {
		ICommand command = null;
		final IProjectDescription description = project.getDescription();
		final ICommand[] commands = description.getBuildSpec();
		boolean found = false;
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(builderID)) {
				found = true;
				command = commands[i];
				break;
			}
		}
		if (!found) {
			command = description.newCommand();
			command.setBuilderName(builderID);
			final ICommand[] newCommands = new ICommand[commands.length + 1];
			System.arraycopy(commands, 0, newCommands, 1, commands.length);
			newCommands[0] = command;
			final IProjectDescription desc = getProject().getDescription();
			desc.setBuildSpec(newCommands);
			getProject().setDescription(desc, null);
		}
		return command;
	}

	private void removeFromBuildSpec(String builderID) throws org.eclipse.core.runtime.CoreException {
		final IProjectDescription description = project.getDescription();
		final ICommand[] commands = description.getBuildSpec();
		boolean found = false;
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(builderID)) {
				found = true;
				break;
			}
		}
		if (!found) {
			final ICommand command = description.newCommand();
			command.setBuilderName(builderID);
			final ICommand[] newCommands = new ICommand[commands.length + 1];
			System.arraycopy(commands, 0, newCommands, 1, commands.length);
			newCommands[0] = command;
			final IProjectDescription desc = getProject().getDescription();
			desc.setBuildSpec(newCommands);
			getProject().setDescription(desc, null);
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
