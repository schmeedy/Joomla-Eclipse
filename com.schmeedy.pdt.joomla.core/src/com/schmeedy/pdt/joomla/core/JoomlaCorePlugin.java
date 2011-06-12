package com.schmeedy.pdt.joomla.core;

import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.schmeedy.pdt.joomla.core.project.impl.JoomlaExtensionProjectNature;

@SuppressWarnings("restriction")
public class JoomlaCorePlugin implements BundleActivator {

	public static final String ID = "com.schmeedy.pdt.joomla.core";
	
	public static final String JOOMLA_EXTENSION_NATURE_ID = JoomlaExtensionProjectNature.ID;
	
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
		final InternalPlatform platform = InternalPlatform.getDefault();
		return platform == null ? null : platform.getLog(bundleContext.getBundle());
	}
	
	public static void log(IStatus status) {
		final ILog log = getLog();
		if (log != null) {
			log.log(status);
		}
	}
	
	public static void logError(String message) {
		log(newStatus(IStatus.ERROR, message, null));
	}
	
	public static void logError(String message, Throwable throwable) {
		log(newStatus(IStatus.ERROR, message, throwable));
	}

	public static void logWarning(String message) {
		log(newStatus(IStatus.WARNING, message, null));
	}
	
	public static IStatus newStatus(int severity, String message) {
		return new Status(severity, ID, message);
	}

	public static IStatus newStatus(int severity, String message, Throwable e) {
		return new Status(severity, ID, message, e);
	}
	
}
