package com.schmeedy.pdt.joomla.ui.project;

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
	
}
