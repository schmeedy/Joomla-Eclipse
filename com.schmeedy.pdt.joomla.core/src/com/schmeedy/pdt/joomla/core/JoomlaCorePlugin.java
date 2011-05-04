package com.schmeedy.pdt.joomla.core;

import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

@SuppressWarnings("restriction")
public class JoomlaCorePlugin implements BundleActivator {

	public static final String ID = "com.schmeedy.pdt.joomla.core";
	
	private static BundleContext bundleContext;
	
	@Override
	public void start(BundleContext context) throws Exception {
		bundleContext = context;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		bundleContext = null;
	}
	
	private static ILog getLog() {
		return InternalPlatform.getDefault().getLog(bundleContext.getBundle());
	}
	
	public static void log(IStatus status) {
		getLog().log(status);
	}
	
	public static void logError(String message, Throwable throwable) {
		getLog().log(newStatus(IStatus.ERROR, message, throwable));
	}

	public static void logWarning(String message) {
		getLog().log(newStatus(IStatus.WARNING, message, null));
	}
	
	public static IStatus newStatus(int severity, String message) {
		return new Status(severity, ID, message);
	}

	public static IStatus newStatus(int severity, String message, Throwable e) {
		return new Status(severity, ID, message, e);
	}
	
}
