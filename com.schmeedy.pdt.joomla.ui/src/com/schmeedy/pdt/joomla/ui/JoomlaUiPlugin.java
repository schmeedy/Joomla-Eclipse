package com.schmeedy.pdt.joomla.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class JoomlaUiPlugin extends AbstractUIPlugin {

	public static final String BUNDLE_ID = "com.schmeedy.pdt.joomla.ui";
	
	private static JoomlaUiPlugin INSTANCE;
	
	public static JoomlaUiPlugin getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		INSTANCE = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
	}
	
	public Image getImage(String symbolicName) {
		return getImageRegistry().get(symbolicName);
	}
	
	public void logError(String message, Throwable throwable) {
		getLog().log(newErrorStatus(message, throwable));
	}

	public void logWarning(String message) {
		getLog().log(newWarningStatus(message, null));
	}

	public Status newErrorStatus(String message, Throwable throwable) {
		return new Status(IStatus.ERROR, BUNDLE_ID, trim(message), throwable);
	}

	public Status newWarningStatus(String message, Throwable throwable) {
		return new Status(IStatus.WARNING, BUNDLE_ID, trim(message), throwable);
	}

	public Status newOkStatus(String message) {
		return new Status(IStatus.OK, BUNDLE_ID, trim(message), null);
	}
	
	private static String trim(String message) {
		return message == null ? "" : message.trim();
	}
	
}
