/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model.impl;

import com.schmeedy.pdt.joomla.core.project.model.*;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionResource;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionType;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelFactory;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage;
import com.schmeedy.pdt.joomla.core.project.model.ManifestVersion;
import com.schmeedy.pdt.joomla.core.project.model.MediaResource;
import com.schmeedy.pdt.joomla.core.project.model.ResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JoomlaProjectModelFactoryImpl extends EFactoryImpl implements JoomlaProjectModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JoomlaProjectModelFactory init() {
		try {
			JoomlaProjectModelFactory theJoomlaProjectModelFactory = (JoomlaProjectModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://schmeedy.com/pdt/joomla/project/model"); 
			if (theJoomlaProjectModelFactory != null) {
				return theJoomlaProjectModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JoomlaProjectModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaProjectModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JoomlaProjectModelPackage.JOOMLA_EXTENSION_PROJECT: return createJoomlaExtensionProject();
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL: return createBasicExtensionModel();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE: return createExtensionResource();
			case JoomlaProjectModelPackage.MEDIA_RESOURCE: return createMediaResource();
			case JoomlaProjectModelPackage.LANGUAGE_RESOURCE: return createLanguageResource();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JoomlaProjectModelPackage.MANIFEST_VERSION:
				return createManifestVersionFromString(eDataType, initialValue);
			case JoomlaProjectModelPackage.EXTENSION_TYPE:
				return createExtensionTypeFromString(eDataType, initialValue);
			case JoomlaProjectModelPackage.RESOURCE_TYPE:
				return createResourceTypeFromString(eDataType, initialValue);
			case JoomlaProjectModelPackage.IPATH:
				return createIPathFromString(eDataType, initialValue);
			case JoomlaProjectModelPackage.IPROJECT:
				return createIProjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JoomlaProjectModelPackage.MANIFEST_VERSION:
				return convertManifestVersionToString(eDataType, instanceValue);
			case JoomlaProjectModelPackage.EXTENSION_TYPE:
				return convertExtensionTypeToString(eDataType, instanceValue);
			case JoomlaProjectModelPackage.RESOURCE_TYPE:
				return convertResourceTypeToString(eDataType, instanceValue);
			case JoomlaProjectModelPackage.IPATH:
				return convertIPathToString(eDataType, instanceValue);
			case JoomlaProjectModelPackage.IPROJECT:
				return convertIProjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JoomlaExtensionProject createJoomlaExtensionProject() {
		JoomlaExtensionProjectImpl joomlaExtensionProject = new JoomlaExtensionProjectImpl();
		return joomlaExtensionProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicExtensionModel createBasicExtensionModel() {
		BasicExtensionModelImpl basicExtensionModel = new BasicExtensionModelImpl();
		return basicExtensionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionResource createExtensionResource() {
		ExtensionResourceImpl extensionResource = new ExtensionResourceImpl();
		return extensionResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaResource createMediaResource() {
		MediaResourceImpl mediaResource = new MediaResourceImpl();
		return mediaResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageResource createLanguageResource() {
		LanguageResourceImpl languageResource = new LanguageResourceImpl();
		return languageResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManifestVersion createManifestVersionFromString(EDataType eDataType, String initialValue) {
		ManifestVersion result = ManifestVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertManifestVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionType createExtensionTypeFromString(EDataType eDataType, String initialValue) {
		ExtensionType result = ExtensionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExtensionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType createResourceTypeFromString(EDataType eDataType, String initialValue) {
		ResourceType result = ResourceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IPath createIPathFromString(EDataType eDataType, String initialValue) {
		return new Path(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIPathToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProject createIProjectFromString(EDataType eDataType, String initialValue) {
		return (IProject)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIProjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JoomlaProjectModelPackage getJoomlaProjectModelPackage() {
		return (JoomlaProjectModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JoomlaProjectModelPackage getPackage() {
		return JoomlaProjectModelPackage.eINSTANCE;
	}

} //JoomlaProjectModelFactoryImpl
