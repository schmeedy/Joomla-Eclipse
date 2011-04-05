package com.schmeedy.pdt.joomla.core.server;

import com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers;

public interface IJoomlaServerManager {

	AvailableServers getAvailableServers();
	
	void updateAvailableServers(AvailableServers availableServers);
	
}
