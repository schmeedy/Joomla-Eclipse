package com.schmeedy.pdt.joomla.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class JoomlaCorePlugin {

	public static final String ID = "com.schmeedy.pdt.joomla.core";
	
	public static IStatus newStatus(int severity, String message) {
		return new Status(severity, ID, message);
	}

	public static IStatus newStatus(int severity, String message, Throwable e) {
		return new Status(severity, ID, message, e);
	}
	
}
