package com.schmeedy.pdt.joomla.common.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class JoomlaCommonUiPlugin extends AbstractUIPlugin {

	public static final String BUNDLE_ID = "com.schmeedy.pdt.joomla.common.ui";
	
	public static final String IMG_OBJ_JOOMLA = BUNDLE_ID + ".obj16.joomla";
	
	public static final String IMG_OBJ_EXT_COMPONENT = BUNDLE_ID + ".obj16.ext.com";
	public static final String IMG_OBJ_EXT_PLUGIN = BUNDLE_ID + ".obj16.ext.plugin";
	public static final String IMG_OBJ_EXT_MODULE = BUNDLE_ID + ".obj16.ext.mod";
	public static final String IMG_OBJ_EXT_LANGUAGE = BUNDLE_ID + ".obj16.ext.lang";

	public static final String OVR_SYNC_SITE = BUNDLE_ID + ".ovr16.sync.site";
	public static final String OVR_SYNC_ADMIN = BUNDLE_ID + ".ovr16.sync.admin";
	
	private static JoomlaCommonUiPlugin INSTANCE;

	public static JoomlaCommonUiPlugin getInstance() {
		return INSTANCE;
	}

	public Image getImage(String symbolicName) {
		return getImageRegistry().get(symbolicName);
	}
	
	public ImageDescriptor getImageDescriptor(String symbolicName) {
		if (OVR_SYNC_ADMIN.equals(symbolicName)) {
			return createImageDescriptor("/icons/ovr16/ovr_sync_admin.png");
		} else if (OVR_SYNC_SITE.equals(symbolicName)) {
			return createImageDescriptor("/icons/ovr16/ovr_sync_site.png");
		}
		return null;
	}
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		reg.put(IMG_OBJ_JOOMLA, loadImage("/icons/obj16/joomla.png"));
		reg.put(IMG_OBJ_EXT_COMPONENT, loadImage("/icons/obj16/ext_com.png"));
		reg.put(IMG_OBJ_EXT_PLUGIN, loadImage("/icons/obj16/ext_plugin.png"));
		reg.put(IMG_OBJ_EXT_MODULE, loadImage("/icons/obj16/ext_mod.png"));
		reg.put(IMG_OBJ_EXT_LANGUAGE, loadImage("/icons/obj16/ext_lang.png"));
	}
	
	private ImageDescriptor createImageDescriptor(String path) {
		return ImageDescriptor.createFromFile(JoomlaCommonUiPlugin.class, path);
	}
	
	private Image loadImage(String path) {
		return createImageDescriptor(path).createImage();
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
