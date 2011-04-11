package com.schmeedy.pdt.joomla.core.server;

import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;

public interface IJoomlaServerManager {

	AvailableServers getAvailableServers();
	
	void updateAvailableServers(AvailableServers availableServers);
	
	LocalJoomlaServer getDefaultServer(JoomlaExtensionProject projectModel);
	
}
