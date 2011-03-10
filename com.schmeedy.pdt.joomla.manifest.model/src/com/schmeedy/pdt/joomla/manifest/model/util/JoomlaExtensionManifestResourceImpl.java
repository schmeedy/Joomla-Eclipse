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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.xml.sax.helpers.DefaultHandler;

import com.schmeedy.pdt.joomla.manifest.model.InstallDb;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.ManifestType;
import com.schmeedy.pdt.joomla.manifest.model.util.JoomlaExtensionManifestResourceFactoryImpl.JoomlaResourceExtendedMetaData;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.manifest.model.util.JoomlaExtensionManifestResourceFactoryImpl
 * @generated
 */
public class JoomlaExtensionManifestResourceImpl extends XMLResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
		final JoomlaExtensionManifest jem = !contents.isEmpty() && contents.get(0) instanceof JoomlaExtensionManifest ? (JoomlaExtensionManifest) contents
				.get(0) : null;
		final JoomlaResourceExtendedMetaData extendedMeta = getCustomExtendedMetadata(options);

		if (jem != null) {
			{
				final String versionToken, extensionTypeToken = jem.getManifestType() == ManifestType.UNKNOWN ? null : jem
						.getManifestType().getLiteral();
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

	@Override
	protected XMLLoad createXMLLoad() {
		return new JoomlaXmlLoad(createXMLHelper());
	}

	private static interface SaveRunnable {
		void doSave() throws IOException;
	}

	private static class JoomlaXmlLoad extends XMLLoadImpl {

		public JoomlaXmlLoad(XMLHelper helper) {
			super(helper);
		}

		@Override
		protected DefaultHandler makeDefaultHandler() {
			return new JoomlaSaxHandler(resource, helper, options);
		}

	}

	private static class JoomlaSaxHandler extends SAXXMLHandler {

		public JoomlaSaxHandler(XMLResource xmiResource, XMLHelper helper, Map<?, ?> options) {
			super(xmiResource, helper, options);
		}

		@Override
		protected void handleObjectAttribs(EObject obj) {
			// element "install" has fixed value in DTDs while it's really present only in the top-level occurrence of the element
			if (!(obj instanceof InstallDb)) {
				super.handleObjectAttribs(obj);
			}
		}

	}

} // JoomlaExtensionManifestResourceImpl
