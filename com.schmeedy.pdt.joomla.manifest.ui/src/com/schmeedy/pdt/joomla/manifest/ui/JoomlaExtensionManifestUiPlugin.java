package com.schmeedy.pdt.joomla.manifest.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class JoomlaExtensionManifestUiPlugin extends AbstractUIPlugin {
	
	public static final String BUNDLE_ID = "com.schmeedy.pdt.joomla.manifest.ui";
	
	public static final String IMG_FILE_SET = BUNDLE_ID + ".fileSet";
	public static final String IMG_MEDIA_SET = BUNDLE_ID + ".mediaSet";
	public static final String IMG_LANGUAGE_SET = BUNDLE_ID + ".languageSet";
	
	private static JoomlaExtensionManifestUiPlugin INSTANCE = new JoomlaExtensionManifestUiPlugin();
	
	public static JoomlaExtensionManifestUiPlugin getInstance() {
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
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		reg.put(IMG_FILE_SET, ImageDescriptor.createFromFile(JoomlaExtensionManifestUiPlugin.class, "/icons/documents.png").createImage());
		reg.put(IMG_MEDIA_SET, ImageDescriptor.createFromFile(JoomlaExtensionManifestUiPlugin.class, "/icons/image.png").createImage());
		reg.put(IMG_LANGUAGE_SET, ImageDescriptor.createFromFile(JoomlaExtensionManifestUiPlugin.class, "/icons/language.png").createImage());
	}
	
	public void logError(String message, Throwable throwable) {
		getLog().log(getErrorStatus(message, throwable));
	}

	public void logWarning(String message) {
		getLog().log(getWarningStatus(message, null));
	}

	public Status getErrorStatus(String message, Throwable throwable) {
		return new Status(IStatus.ERROR, BUNDLE_ID, trim(message), throwable);
	}

	public Status getWarningStatus(String message, Throwable throwable) {
		return new Status(IStatus.WARNING, BUNDLE_ID, trim(message), throwable);
	}

	private static String trim(String message) {
		return message == null ? "" : message.trim();
	}
	
}
