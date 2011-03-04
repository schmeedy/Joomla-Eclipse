/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.ManifestVersion;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.manifest.model.util.JoomlaExtensionManifestResourceImpl
 * @generated
 */
public class JoomlaExtensionManifestResourceFactoryImpl extends ResourceFactoryImpl {

	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionManifestResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Resource createResource(URI uri) {
		final ExtendedMetaData extendedMetadata = new JoomlaResourceExtendedMetaData();
		
		final XMLResource result = new JoomlaExtensionManifestResourceImpl(uri);
		result.getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetadata);
		result.getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetadata);
		
		result.getDefaultLoadOptions().put(XMLResource.OPTION_ENCODING, "UTF-8");
		result.getDefaultSaveOptions().put(XMLResource.OPTION_ENCODING, "UTF-8");

		result.getDefaultSaveOptions().put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.FALSE);
		result.getDefaultSaveOptions().put(XMLResource.OPTION_SAVE_DOCTYPE, Boolean.TRUE);

		result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		result.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);

		result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);
		return result;
	}
	
	final class JoomlaResourceExtendedMetaData extends BasicExtendedMetaData {
		private ManifestVersion versionCompliance = ManifestVersion.ONE_FIVE;
		
		public void setVersionCompliance(ManifestVersion versionCompliance) {
			this.versionCompliance = versionCompliance;
		}
		
		private JoomlaResourceExtendedMetaData() {
			super(new EPackageRegistryImpl(EPackage.Registry.INSTANCE));
		}

		@Override
		public String getNamespace(EPackage ePackage) {
			return JoomlaExtensionManifestPackage.eNS_URI.equals(ePackage.getNsURI()) ? null : super.getNamespace(ePackage);
		}

		@Override
		public String getName(org.eclipse.emf.ecore.EClassifier eClassifier) {
			if (JoomlaExtensionManifestPackage.eNS_URI.equals(eClassifier.getEPackage().getNsURI())) {
				if (JoomlaExtensionManifestPackage.eINSTANCE.getJoomlaExtensionManifest().getName().equals(eClassifier.getName())) {
					return versionCompliance == ManifestVersion.ONE_FIVE ? "install" : "extension";
				}
			}
			return super.getName(eClassifier);
		}
	}

} //JoomlaExtensionManifestResourceFactoryImpl
