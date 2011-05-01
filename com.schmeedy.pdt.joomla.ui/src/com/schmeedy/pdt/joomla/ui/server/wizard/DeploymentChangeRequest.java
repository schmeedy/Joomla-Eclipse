package com.schmeedy.pdt.joomla.ui.server.wizard;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;

public class DeploymentChangeRequest {

	private final BasicExtensionModel extension;
	private final RequestType type;
	
	public DeploymentChangeRequest(BasicExtensionModel extension, RequestType type) {
		this.extension = extension;
		this.type = type;
	}
	
	public BasicExtensionModel getExtension() {
		return extension;
	}
	
	public RequestType getType() {
		return type;
	}

	public static enum RequestType {
		INSTALL, UNINSTALL
	}
	
	@Override
	public String toString() {
		return type + " " + extension.getName();
	}
	
}
