package com.schmeedy.pdt.joomla.common.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class JoomlaCommonUiPlugin extends AbstractUIPlugin {

	public static final String BUNDLE_ID = "com.schmeedy.pdt.joomla.common.ui";
	
	public static final String IMG_OBJ_JOOMLA = BUNDLE_ID + ".obj16.joomla";

	private static JoomlaCommonUiPlugin INSTANCE;

	public static JoomlaCommonUiPlugin getInstance() {
		return INSTANCE;
	}

	public Image getImage(String symbolicName) {
		return getImageRegistry().get(IMG_OBJ_JOOMLA);
	}
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		reg.put(IMG_OBJ_JOOMLA, loadImage("/icons/obj16/joomla.png"));
	}
	
	private Image loadImage(String path) {
		return ImageDescriptor.createFromFile(JoomlaCommonUiPlugin.class, path).createImage();
	}
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		INSTANCE = this;
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		INSTANCE = null;
	}

}
