package com.schmeedy.pdt.joomla.manifest.ui;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

public class JoomlaExtensionManifestUiPlugin extends EMFPlugin {
	
	public static final JoomlaExtensionManifestUiPlugin INSTANCE = new JoomlaExtensionManifestUiPlugin();
	public static final String BUNDLE_ID = "com.schmeedy.pdt.joomla.manifest.ui";
	
	private static Implementation plugin;
	
	public JoomlaExtensionManifestUiPlugin() {
		super(new ResourceLocator [] {});
	}
	
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
	
	public static Implementation getPlugin() {
		return plugin;
	}
	
	public static class Implementation extends EclipseUIPlugin {
		public Implementation() {	
			super();
			plugin = this;
		}
	}

}
