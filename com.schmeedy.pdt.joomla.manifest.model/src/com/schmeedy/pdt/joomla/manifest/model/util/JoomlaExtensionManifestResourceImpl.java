/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.ManifestType;
import com.schmeedy.pdt.joomla.manifest.model.util.JoomlaExtensionManifestResourceFactoryImpl.JoomlaResourceExtendedMetaData;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.manifest.model.util.JoomlaExtensionManifestResourceFactoryImpl
 * @generated
 */
public class JoomlaExtensionManifestResourceImpl extends XMLResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public JoomlaExtensionManifestResourceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	public void doSave(final Writer writer, final Map<?, ?> options) throws IOException {
		doExtendedSave(new SaveRunnable() {
			@Override
			public void doSave() throws IOException {
				JoomlaExtensionManifestResourceImpl.super.doSave(writer, options);
			}
		}, options);
	}
	
	@Override
	public void doSave(final OutputStream outputStream, final Map<?, ?> options) throws IOException {
		doExtendedSave(new SaveRunnable() {
			@Override
			public void doSave() throws IOException {
				JoomlaExtensionManifestResourceImpl.super.doSave(outputStream, options);
			}
		}, options);
	}
	
	private void doExtendedSave(SaveRunnable runnable, Map<?, ?> options) throws IOException {
		final JoomlaExtensionManifest jem = !contents.isEmpty() && contents.get(0) instanceof JoomlaExtensionManifest ? (JoomlaExtensionManifest) contents.get(0) : null;
		final JoomlaResourceExtendedMetaData extendedMeta = getCustomExtendedMetadata(options);
			
		if (jem != null) {
			{
				final String versionToken, extensionTypeToken = jem.getManifestType() == ManifestType.UNKNOWN ? null : jem.getManifestType().getLiteral();
				switch (jem.getManifestVersion()) {
					case ONE_FIVE:
						versionToken = "1.5";
						break;
					case ONE_SIX:
						versionToken = "1.6";
						break;
					default:
						versionToken = null;
				}
				if (versionToken == null || extensionTypeToken == null) {
					setDoctypeInfo(null, null);
				} else {
					final String publicId = String.format("-//Joomla! %s//DTD %s 1.0//EN", versionToken, extensionTypeToken);
					final String systemId = String.format("http://dev.joomla.org/xml/%s/%s-install.dtd", versionToken, extensionTypeToken);
					setDoctypeInfo(publicId, systemId);
				}
			}
			if (extendedMeta != null) {
				extendedMeta.setVersionCompliance(jem.getManifestVersion());
			}
		}
		
		runnable.doSave();
	}

	private JoomlaResourceExtendedMetaData getCustomExtendedMetadata(Map<?, ?> options) {
		final Object extendedMetadata = options.get(OPTION_EXTENDED_META_DATA);
		return extendedMetadata instanceof JoomlaResourceExtendedMetaData ? (JoomlaResourceExtendedMetaData) extendedMetadata : null;
	}
	
	private static interface SaveRunnable {
		void doSave() throws IOException;
	}  

} //JoomlaExtensionManifestResourceImpl
