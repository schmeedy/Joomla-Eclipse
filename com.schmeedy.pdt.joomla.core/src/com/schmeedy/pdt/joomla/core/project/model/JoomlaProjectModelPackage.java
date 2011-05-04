/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelFactory
 * @model kind="package"
 * @generated
 */
public interface JoomlaProjectModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://schmeedy.com/pdt/joomla/project/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jpm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JoomlaProjectModelPackage eINSTANCE = com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaExtensionProjectImpl <em>Joomla Extension Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaExtensionProjectImpl
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getJoomlaExtensionProject()
	 * @generated
	 */
	int JOOMLA_EXTENSION_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_PROJECT__PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_PROJECT__EXTENSIONS = 1;

	/**
	 * The number of structural features of the '<em>Joomla Extension Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_PROJECT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.project.model.impl.BasicExtensionModelImpl <em>Basic Extension Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.BasicExtensionModelImpl
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getBasicExtensionModel()
	 * @generated
	 */
	int BASIC_EXTENSION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EXTENSION_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EXTENSION_MODEL__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Manifest Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EXTENSION_MODEL__MANIFEST_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Manifest Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EXTENSION_MODEL__MANIFEST_PATH = 3;

	/**
	 * The feature id for the '<em><b>Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EXTENSION_MODEL__PROJECT = 4;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EXTENSION_MODEL__RESOURCES = 5;

	/**
	 * The number of structural features of the '<em>Basic Extension Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_EXTENSION_MODEL_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl <em>Extension Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getExtensionResource()
	 * @generated
	 */
	int EXTENSION_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Source Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_RESOURCE__SOURCE_PATH = 0;

	/**
	 * The feature id for the '<em><b>Destination Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_RESOURCE__DESTINATION_PATH = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_RESOURCE__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Extension Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_RESOURCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.project.model.ManifestVersion <em>Manifest Version</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.project.model.ManifestVersion
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getManifestVersion()
	 * @generated
	 */
	int MANIFEST_VERSION = 3;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionType <em>Extension Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionType
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 4;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.project.model.ResourceType <em>Resource Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.project.model.ResourceType
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 5;

	/**
	 * The meta object id for the '<em>IPath</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IPath
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getIPath()
	 * @generated
	 */
	int IPATH = 6;

	/**
	 * The meta object id for the '<em>IProject</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IProject
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getIProject()
	 * @generated
	 */
	int IPROJECT = 7;


	/**
	 * The meta object id for the '<em>File</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.File
	 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 8;


	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject <em>Joomla Extension Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Joomla Extension Project</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject
	 * @generated
	 */
	EClass getJoomlaExtensionProject();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject#getProject()
	 * @see #getJoomlaExtensionProject()
	 * @generated
	 */
	EAttribute getJoomlaExtensionProject_Project();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extensions</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject#getExtensions()
	 * @see #getJoomlaExtensionProject()
	 * @generated
	 */
	EReference getJoomlaExtensionProject_Extensions();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel <em>Basic Extension Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Extension Model</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel
	 * @generated
	 */
	EClass getBasicExtensionModel();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getName()
	 * @see #getBasicExtensionModel()
	 * @generated
	 */
	EAttribute getBasicExtensionModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getType()
	 * @see #getBasicExtensionModel()
	 * @generated
	 */
	EAttribute getBasicExtensionModel_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getManifestVersion <em>Manifest Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manifest Version</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getManifestVersion()
	 * @see #getBasicExtensionModel()
	 * @generated
	 */
	EAttribute getBasicExtensionModel_ManifestVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getManifestPath <em>Manifest Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manifest Path</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getManifestPath()
	 * @see #getBasicExtensionModel()
	 * @generated
	 */
	EAttribute getBasicExtensionModel_ManifestPath();

	/**
	 * Returns the meta object for the container reference '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Project</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getProject()
	 * @see #getBasicExtensionModel()
	 * @generated
	 */
	EReference getBasicExtensionModel_Project();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getResources()
	 * @see #getBasicExtensionModel()
	 * @generated
	 */
	EReference getBasicExtensionModel_Resources();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource <em>Extension Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Resource</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionResource
	 * @generated
	 */
	EClass getExtensionResource();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getSourcePath <em>Source Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Path</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getSourcePath()
	 * @see #getExtensionResource()
	 * @generated
	 */
	EAttribute getExtensionResource_SourcePath();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getDestinationPath <em>Destination Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination Path</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getDestinationPath()
	 * @see #getExtensionResource()
	 * @generated
	 */
	EAttribute getExtensionResource_DestinationPath();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getType()
	 * @see #getExtensionResource()
	 * @generated
	 */
	EAttribute getExtensionResource_Type();

	/**
	 * Returns the meta object for enum '{@link com.schmeedy.pdt.joomla.core.project.model.ManifestVersion <em>Manifest Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Manifest Version</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ManifestVersion
	 * @generated
	 */
	EEnum getManifestVersion();

	/**
	 * Returns the meta object for enum '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Extension Type</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionType
	 * @generated
	 */
	EEnum getExtensionType();

	/**
	 * Returns the meta object for enum '{@link com.schmeedy.pdt.joomla.core.project.model.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resource Type</em>'.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ResourceType
	 * @generated
	 */
	EEnum getResourceType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IPath <em>IPath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IPath</em>'.
	 * @see org.eclipse.core.runtime.IPath
	 * @model instanceClass="org.eclipse.core.runtime.IPath"
	 * @generated
	 */
	EDataType getIPath();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IProject <em>IProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IProject</em>'.
	 * @see org.eclipse.core.resources.IProject
	 * @model instanceClass="org.eclipse.core.resources.IProject"
	 * @generated
	 */
	EDataType getIProject();

	/**
	 * Returns the meta object for data type '{@link java.io.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>File</em>'.
	 * @see java.io.File
	 * @model instanceClass="java.io.File"
	 * @generated
	 */
	EDataType getFile();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JoomlaProjectModelFactory getJoomlaProjectModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaExtensionProjectImpl <em>Joomla Extension Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaExtensionProjectImpl
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getJoomlaExtensionProject()
		 * @generated
		 */
		EClass JOOMLA_EXTENSION_PROJECT = eINSTANCE.getJoomlaExtensionProject();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_PROJECT__PROJECT = eINSTANCE.getJoomlaExtensionProject_Project();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOOMLA_EXTENSION_PROJECT__EXTENSIONS = eINSTANCE.getJoomlaExtensionProject_Extensions();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.project.model.impl.BasicExtensionModelImpl <em>Basic Extension Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.BasicExtensionModelImpl
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getBasicExtensionModel()
		 * @generated
		 */
		EClass BASIC_EXTENSION_MODEL = eINSTANCE.getBasicExtensionModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_EXTENSION_MODEL__NAME = eINSTANCE.getBasicExtensionModel_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_EXTENSION_MODEL__TYPE = eINSTANCE.getBasicExtensionModel_Type();

		/**
		 * The meta object literal for the '<em><b>Manifest Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_EXTENSION_MODEL__MANIFEST_VERSION = eINSTANCE.getBasicExtensionModel_ManifestVersion();

		/**
		 * The meta object literal for the '<em><b>Manifest Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_EXTENSION_MODEL__MANIFEST_PATH = eINSTANCE.getBasicExtensionModel_ManifestPath();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_EXTENSION_MODEL__PROJECT = eINSTANCE.getBasicExtensionModel_Project();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_EXTENSION_MODEL__RESOURCES = eINSTANCE.getBasicExtensionModel_Resources();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl <em>Extension Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getExtensionResource()
		 * @generated
		 */
		EClass EXTENSION_RESOURCE = eINSTANCE.getExtensionResource();

		/**
		 * The meta object literal for the '<em><b>Source Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_RESOURCE__SOURCE_PATH = eINSTANCE.getExtensionResource_SourcePath();

		/**
		 * The meta object literal for the '<em><b>Destination Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_RESOURCE__DESTINATION_PATH = eINSTANCE.getExtensionResource_DestinationPath();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_RESOURCE__TYPE = eINSTANCE.getExtensionResource_Type();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.project.model.ManifestVersion <em>Manifest Version</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.project.model.ManifestVersion
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getManifestVersion()
		 * @generated
		 */
		EEnum MANIFEST_VERSION = eINSTANCE.getManifestVersion();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionType <em>Extension Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionType
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getExtensionType()
		 * @generated
		 */
		EEnum EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.project.model.ResourceType <em>Resource Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.project.model.ResourceType
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getResourceType()
		 * @generated
		 */
		EEnum RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '<em>IPath</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IPath
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getIPath()
		 * @generated
		 */
		EDataType IPATH = eINSTANCE.getIPath();

		/**
		 * The meta object literal for the '<em>IProject</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IProject
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getIProject()
		 * @generated
		 */
		EDataType IPROJECT = eINSTANCE.getIProject();

		/**
		 * The meta object literal for the '<em>File</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.File
		 * @see com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelPackageImpl#getFile()
		 * @generated
		 */
		EDataType FILE = eINSTANCE.getFile();

	}

} //JoomlaProjectModelPackage
