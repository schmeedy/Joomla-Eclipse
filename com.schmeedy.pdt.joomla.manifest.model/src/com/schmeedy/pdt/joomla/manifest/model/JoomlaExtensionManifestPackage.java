/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestFactory
 * @model kind="package"
 * @generated
 */
public interface JoomlaExtensionManifestPackage extends EPackage {
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
	String eNS_URI = "http://joomla.org/schema/extension-manifest";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jem";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "com.schmeedy.pdt.joomla.manifest.model.ExtensionManifest";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JoomlaExtensionManifestPackage eINSTANCE = com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractMultiResourceContainerImpl <em>Abstract Multi Resource Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.AbstractMultiResourceContainerImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getAbstractMultiResourceContainer()
	 * @generated
	 */
	int ABSTRACT_MULTI_RESOURCE_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>File Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS = 0;

	/**
	 * The feature id for the '<em><b>Language Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS = 1;

	/**
	 * The feature id for the '<em><b>Media Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS = 2;

	/**
	 * The feature id for the '<em><b>All Resource Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS = 3;

	/**
	 * The number of structural features of the '<em>Abstract Multi Resource Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl <em>Joomla Extension Manifest</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getJoomlaExtensionManifest()
	 * @generated
	 */
	int JOOMLA_EXTENSION_MANIFEST = 1;

	/**
	 * The feature id for the '<em><b>File Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__FILE_SETS = ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS;

	/**
	 * The feature id for the '<em><b>Language Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__LANGUAGE_SETS = ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS;

	/**
	 * The feature id for the '<em><b>Media Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__MEDIA_SETS = ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS;

	/**
	 * The feature id for the '<em><b>All Resource Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__ALL_RESOURCE_SETS = ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS;

	/**
	 * The feature id for the '<em><b>Manifest Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Manifest Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__NAME = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__CREATION_DATE = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__AUTHOR = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Author Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Author Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__COPYRIGHT = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__LICENSE = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__VERSION = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__DESCRIPTION = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Install File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Uninstall File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Install</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__INSTALL = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Uninstall</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__UNINSTALL = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Administration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>Joomla Extension Manifest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST_FEATURE_COUNT = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 16;


	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.InstallDbImpl <em>Install Db</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.InstallDbImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getInstallDb()
	 * @generated
	 */
	int INSTALL_DB = 2;

	/**
	 * The feature id for the '<em><b>Sql</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALL_DB__SQL = 0;

	/**
	 * The number of structural features of the '<em>Install Db</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALL_DB_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.UninstallDbImpl <em>Uninstall Db</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.UninstallDbImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getUninstallDb()
	 * @generated
	 */
	int UNINSTALL_DB = 3;

	/**
	 * The feature id for the '<em><b>Sql</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINSTALL_DB__SQL = 0;

	/**
	 * The number of structural features of the '<em>Uninstall Db</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINSTALL_DB_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceImpl <em>Abstract Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getAbstractResource()
	 * @generated
	 */
	int ABSTRACT_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE__PATH = 0;

	/**
	 * The number of structural features of the '<em>Abstract Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceContainerImpl <em>Abstract Resource Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceContainerImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getAbstractResourceContainer()
	 * @generated
	 */
	int ABSTRACT_RESOURCE_CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>Base Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER = 0;

	/**
	 * The feature id for the '<em><b>All Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES = 1;

	/**
	 * The number of structural features of the '<em>Abstract Resource Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileSetImpl <em>Sql File Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileSetImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getSqlFileSet()
	 * @generated
	 */
	int SQL_FILE_SET = 6;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_FILE_SET__FILES = 0;

	/**
	 * The number of structural features of the '<em>Sql File Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_FILE_SET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.SqlResourceImpl <em>Sql Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.SqlResourceImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getSqlResource()
	 * @generated
	 */
	int SQL_RESOURCE = 7;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESOURCE__PATH = ABSTRACT_RESOURCE__PATH;

	/**
	 * The feature id for the '<em><b>Driver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESOURCE__DRIVER = ABSTRACT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Charset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESOURCE__CHARSET = ABSTRACT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sql Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESOURCE_FEATURE_COUNT = ABSTRACT_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.FileSetImpl <em>File Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.FileSetImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getFileSet()
	 * @generated
	 */
	int FILE_SET = 8;

	/**
	 * The feature id for the '<em><b>Base Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SET__BASE_FOLDER = ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER;

	/**
	 * The feature id for the '<em><b>All Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SET__ALL_RESOURCES = ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SET__FILES = ABSTRACT_RESOURCE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SET__FOLDERS = ABSTRACT_RESOURCE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>File Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SET_FEATURE_COUNT = ABSTRACT_RESOURCE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.FileResourceImpl <em>File Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.FileResourceImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getFileResource()
	 * @generated
	 */
	int FILE_RESOURCE = 9;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE__PATH = ABSTRACT_RESOURCE__PATH;

	/**
	 * The number of structural features of the '<em>File Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE_FEATURE_COUNT = ABSTRACT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.FolderResourceImpl <em>Folder Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.FolderResourceImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getFolderResource()
	 * @generated
	 */
	int FOLDER_RESOURCE = 10;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_RESOURCE__PATH = ABSTRACT_RESOURCE__PATH;

	/**
	 * The number of structural features of the '<em>Folder Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_RESOURCE_FEATURE_COUNT = ABSTRACT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.LanguageSetImpl <em>Language Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.LanguageSetImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getLanguageSet()
	 * @generated
	 */
	int LANGUAGE_SET = 11;

	/**
	 * The feature id for the '<em><b>Base Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SET__BASE_FOLDER = ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER;

	/**
	 * The feature id for the '<em><b>All Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SET__ALL_RESOURCES = ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SET__RESOURCES = ABSTRACT_RESOURCE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Language Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SET_FEATURE_COUNT = ABSTRACT_RESOURCE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.LanguageResourceImpl <em>Language Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.LanguageResourceImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getLanguageResource()
	 * @generated
	 */
	int LANGUAGE_RESOURCE = 12;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_RESOURCE__PATH = ABSTRACT_RESOURCE__PATH;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_RESOURCE__TAG = ABSTRACT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Language Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_RESOURCE_FEATURE_COUNT = ABSTRACT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.MediaSetImpl <em>Media Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.MediaSetImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getMediaSet()
	 * @generated
	 */
	int MEDIA_SET = 13;

	/**
	 * The feature id for the '<em><b>Base Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_SET__BASE_FOLDER = ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER;

	/**
	 * The feature id for the '<em><b>All Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_SET__ALL_RESOURCES = ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_SET__DESTINATION = ABSTRACT_RESOURCE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_SET__FILES = ABSTRACT_RESOURCE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Media Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_SET_FEATURE_COUNT = ABSTRACT_RESOURCE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.AdministrationImpl <em>Administration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.AdministrationImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getAdministration()
	 * @generated
	 */
	int ADMINISTRATION = 14;

	/**
	 * The feature id for the '<em><b>File Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION__FILE_SETS = ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS;

	/**
	 * The feature id for the '<em><b>Language Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION__LANGUAGE_SETS = ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS;

	/**
	 * The feature id for the '<em><b>Media Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION__MEDIA_SETS = ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS;

	/**
	 * The feature id for the '<em><b>All Resource Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION__ALL_RESOURCE_SETS = ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS;

	/**
	 * The feature id for the '<em><b>Menu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION__MENU = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Menu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION__SUB_MENU = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Administration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FEATURE_COUNT = ABSTRACT_MULTI_RESOURCE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl <em>Menu Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getMenuItem()
	 * @generated
	 */
	int MENU_ITEM = 15;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Act</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__ACT = 1;

	/**
	 * The feature id for the '<em><b>Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__TASK = 2;

	/**
	 * The feature id for the '<em><b>Controller</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__CONTROLLER = 3;

	/**
	 * The feature id for the '<em><b>View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__VIEW = 4;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__LAYOUT = 5;

	/**
	 * The feature id for the '<em><b>Sub</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__SUB = 6;

	/**
	 * The feature id for the '<em><b>Img</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__IMG = 7;

	/**
	 * The feature id for the '<em><b>Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__LINK = 8;

	/**
	 * The number of structural features of the '<em>Menu Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.SubMenuImpl <em>Sub Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.SubMenuImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getSubMenu()
	 * @generated
	 */
	int SUB_MENU = 16;

	/**
	 * The feature id for the '<em><b>Menu Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MENU__MENU_ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Sub Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_MENU_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.ManifestVersion <em>Manifest Version</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestVersion
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getManifestVersion()
	 * @generated
	 */
	int MANIFEST_VERSION = 17;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.ManifestType <em>Manifest Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestType
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getManifestType()
	 * @generated
	 */
	int MANIFEST_TYPE = 18;


	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer <em>Abstract Multi Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Multi Resource Container</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer
	 * @generated
	 */
	EClass getAbstractMultiResourceContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getFileSets <em>File Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>File Sets</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getFileSets()
	 * @see #getAbstractMultiResourceContainer()
	 * @generated
	 */
	EReference getAbstractMultiResourceContainer_FileSets();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getLanguageSets <em>Language Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Language Sets</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getLanguageSets()
	 * @see #getAbstractMultiResourceContainer()
	 * @generated
	 */
	EReference getAbstractMultiResourceContainer_LanguageSets();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getMediaSets <em>Media Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Media Sets</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getMediaSets()
	 * @see #getAbstractMultiResourceContainer()
	 * @generated
	 */
	EReference getAbstractMultiResourceContainer_MediaSets();

	/**
	 * Returns the meta object for the reference list '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getAllResourceSets <em>All Resource Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Resource Sets</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getAllResourceSets()
	 * @see #getAbstractMultiResourceContainer()
	 * @generated
	 */
	EReference getAbstractMultiResourceContainer_AllResourceSets();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest <em>Joomla Extension Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Joomla Extension Manifest</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest
	 * @generated
	 */
	EClass getJoomlaExtensionManifest();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getManifestVersion <em>Manifest Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manifest Version</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getManifestVersion()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_ManifestVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getManifestType <em>Manifest Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manifest Type</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getManifestType()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_ManifestType();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getName()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getCreationDate()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_CreationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthor()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_Author();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthorEmail <em>Author Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author Email</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthorEmail()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_AuthorEmail();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthorUrl <em>Author Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author Url</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthorUrl()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_AuthorUrl();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getCopyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Copyright</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getCopyright()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_Copyright();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getLicense <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getLicense()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_License();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getVersion()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getDescription()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getInstallFile <em>Install File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install File</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getInstallFile()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_InstallFile();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getUninstallFile <em>Uninstall File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uninstall File</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getUninstallFile()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EAttribute getJoomlaExtensionManifest_UninstallFile();

	/**
	 * Returns the meta object for the containment reference '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getInstall <em>Install</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Install</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getInstall()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EReference getJoomlaExtensionManifest_Install();

	/**
	 * Returns the meta object for the containment reference '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getUninstall <em>Uninstall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Uninstall</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getUninstall()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EReference getJoomlaExtensionManifest_Uninstall();

	/**
	 * Returns the meta object for the containment reference '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAdministration <em>Administration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Administration</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAdministration()
	 * @see #getJoomlaExtensionManifest()
	 * @generated
	 */
	EReference getJoomlaExtensionManifest_Administration();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.InstallDb <em>Install Db</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Install Db</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.InstallDb
	 * @generated
	 */
	EClass getInstallDb();

	/**
	 * Returns the meta object for the containment reference '{@link com.schmeedy.pdt.joomla.manifest.model.InstallDb#getSql <em>Sql</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sql</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.InstallDb#getSql()
	 * @see #getInstallDb()
	 * @generated
	 */
	EReference getInstallDb_Sql();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.UninstallDb <em>Uninstall Db</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uninstall Db</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.UninstallDb
	 * @generated
	 */
	EClass getUninstallDb();

	/**
	 * Returns the meta object for the containment reference '{@link com.schmeedy.pdt.joomla.manifest.model.UninstallDb#getSql <em>Sql</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sql</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.UninstallDb#getSql()
	 * @see #getUninstallDb()
	 * @generated
	 */
	EReference getUninstallDb_Sql();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResource <em>Abstract Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Resource</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractResource
	 * @generated
	 */
	EClass getAbstractResource();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResource#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractResource#getPath()
	 * @see #getAbstractResource()
	 * @generated
	 */
	EAttribute getAbstractResource_Path();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer <em>Abstract Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Resource Container</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer
	 * @generated
	 */
	EClass getAbstractResourceContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer#getBaseFolder <em>Base Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Folder</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer#getBaseFolder()
	 * @see #getAbstractResourceContainer()
	 * @generated
	 */
	EAttribute getAbstractResourceContainer_BaseFolder();

	/**
	 * Returns the meta object for the reference list '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer#getAllResources <em>All Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Resources</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer#getAllResources()
	 * @see #getAbstractResourceContainer()
	 * @generated
	 */
	EReference getAbstractResourceContainer_AllResources();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.SqlFileSet <em>Sql File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sql File Set</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlFileSet
	 * @generated
	 */
	EClass getSqlFileSet();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.manifest.model.SqlFileSet#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlFileSet#getFiles()
	 * @see #getSqlFileSet()
	 * @generated
	 */
	EReference getSqlFileSet_Files();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.SqlResource <em>Sql Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sql Resource</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlResource
	 * @generated
	 */
	EClass getSqlResource();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.SqlResource#getDriver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlResource#getDriver()
	 * @see #getSqlResource()
	 * @generated
	 */
	EAttribute getSqlResource_Driver();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.SqlResource#getCharset <em>Charset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Charset</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlResource#getCharset()
	 * @see #getSqlResource()
	 * @generated
	 */
	EAttribute getSqlResource_Charset();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.FileSet <em>File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Set</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.FileSet
	 * @generated
	 */
	EClass getFileSet();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.manifest.model.FileSet#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.FileSet#getFiles()
	 * @see #getFileSet()
	 * @generated
	 */
	EReference getFileSet_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.manifest.model.FileSet#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.FileSet#getFolders()
	 * @see #getFileSet()
	 * @generated
	 */
	EReference getFileSet_Folders();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Resource</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.FileResource
	 * @generated
	 */
	EClass getFileResource();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.FolderResource <em>Folder Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder Resource</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.FolderResource
	 * @generated
	 */
	EClass getFolderResource();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.LanguageSet <em>Language Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Set</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.LanguageSet
	 * @generated
	 */
	EClass getLanguageSet();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.manifest.model.LanguageSet#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.LanguageSet#getResources()
	 * @see #getLanguageSet()
	 * @generated
	 */
	EReference getLanguageSet_Resources();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.LanguageResource <em>Language Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Resource</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.LanguageResource
	 * @generated
	 */
	EClass getLanguageResource();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.LanguageResource#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.LanguageResource#getTag()
	 * @see #getLanguageResource()
	 * @generated
	 */
	EAttribute getLanguageResource_Tag();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.MediaSet <em>Media Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Media Set</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MediaSet
	 * @generated
	 */
	EClass getMediaSet();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MediaSet#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MediaSet#getDestination()
	 * @see #getMediaSet()
	 * @generated
	 */
	EAttribute getMediaSet_Destination();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.manifest.model.MediaSet#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MediaSet#getFiles()
	 * @see #getMediaSet()
	 * @generated
	 */
	EReference getMediaSet_Files();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.Administration <em>Administration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Administration</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.Administration
	 * @generated
	 */
	EClass getAdministration();

	/**
	 * Returns the meta object for the containment reference '{@link com.schmeedy.pdt.joomla.manifest.model.Administration#getMenu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Menu</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.Administration#getMenu()
	 * @see #getAdministration()
	 * @generated
	 */
	EReference getAdministration_Menu();

	/**
	 * Returns the meta object for the containment reference '{@link com.schmeedy.pdt.joomla.manifest.model.Administration#getSubMenu <em>Sub Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Menu</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.Administration#getSubMenu()
	 * @see #getAdministration()
	 * @generated
	 */
	EReference getAdministration_SubMenu();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem <em>Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Item</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem
	 * @generated
	 */
	EClass getMenuItem();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLabel()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Label();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getAct <em>Act</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Act</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem#getAct()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Act();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem#getTask()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Task();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getController <em>Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Controller</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem#getController()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Controller();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem#getView()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_View();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLayout()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Layout();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getSub <em>Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem#getSub()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Sub();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getImg <em>Img</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Img</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem#getImg()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Img();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLink()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Link();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.SubMenu <em>Sub Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Menu</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SubMenu
	 * @generated
	 */
	EClass getSubMenu();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.manifest.model.SubMenu#getMenuItems <em>Menu Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Menu Items</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SubMenu#getMenuItems()
	 * @see #getSubMenu()
	 * @generated
	 */
	EReference getSubMenu_MenuItems();

	/**
	 * Returns the meta object for enum '{@link com.schmeedy.pdt.joomla.manifest.model.ManifestVersion <em>Manifest Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Manifest Version</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestVersion
	 * @generated
	 */
	EEnum getManifestVersion();

	/**
	 * Returns the meta object for enum '{@link com.schmeedy.pdt.joomla.manifest.model.ManifestType <em>Manifest Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Manifest Type</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestType
	 * @generated
	 */
	EEnum getManifestType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JoomlaExtensionManifestFactory getJoomlaExtensionManifestFactory();

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
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractMultiResourceContainerImpl <em>Abstract Multi Resource Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.AbstractMultiResourceContainerImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getAbstractMultiResourceContainer()
		 * @generated
		 */
		EClass ABSTRACT_MULTI_RESOURCE_CONTAINER = eINSTANCE.getAbstractMultiResourceContainer();

		/**
		 * The meta object literal for the '<em><b>File Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS = eINSTANCE.getAbstractMultiResourceContainer_FileSets();

		/**
		 * The meta object literal for the '<em><b>Language Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS = eINSTANCE.getAbstractMultiResourceContainer_LanguageSets();

		/**
		 * The meta object literal for the '<em><b>Media Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS = eINSTANCE.getAbstractMultiResourceContainer_MediaSets();

		/**
		 * The meta object literal for the '<em><b>All Resource Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS = eINSTANCE.getAbstractMultiResourceContainer_AllResourceSets();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl <em>Joomla Extension Manifest</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getJoomlaExtensionManifest()
		 * @generated
		 */
		EClass JOOMLA_EXTENSION_MANIFEST = eINSTANCE.getJoomlaExtensionManifest();

		/**
		 * The meta object literal for the '<em><b>Manifest Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION = eINSTANCE.getJoomlaExtensionManifest_ManifestVersion();

		/**
		 * The meta object literal for the '<em><b>Manifest Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE = eINSTANCE.getJoomlaExtensionManifest_ManifestType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__NAME = eINSTANCE.getJoomlaExtensionManifest_Name();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__CREATION_DATE = eINSTANCE.getJoomlaExtensionManifest_CreationDate();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__AUTHOR = eINSTANCE.getJoomlaExtensionManifest_Author();

		/**
		 * The meta object literal for the '<em><b>Author Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL = eINSTANCE.getJoomlaExtensionManifest_AuthorEmail();

		/**
		 * The meta object literal for the '<em><b>Author Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL = eINSTANCE.getJoomlaExtensionManifest_AuthorUrl();

		/**
		 * The meta object literal for the '<em><b>Copyright</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__COPYRIGHT = eINSTANCE.getJoomlaExtensionManifest_Copyright();

		/**
		 * The meta object literal for the '<em><b>License</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__LICENSE = eINSTANCE.getJoomlaExtensionManifest_License();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__VERSION = eINSTANCE.getJoomlaExtensionManifest_Version();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__DESCRIPTION = eINSTANCE.getJoomlaExtensionManifest_Description();

		/**
		 * The meta object literal for the '<em><b>Install File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE = eINSTANCE.getJoomlaExtensionManifest_InstallFile();

		/**
		 * The meta object literal for the '<em><b>Uninstall File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE = eINSTANCE.getJoomlaExtensionManifest_UninstallFile();

		/**
		 * The meta object literal for the '<em><b>Install</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOOMLA_EXTENSION_MANIFEST__INSTALL = eINSTANCE.getJoomlaExtensionManifest_Install();

		/**
		 * The meta object literal for the '<em><b>Uninstall</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOOMLA_EXTENSION_MANIFEST__UNINSTALL = eINSTANCE.getJoomlaExtensionManifest_Uninstall();

		/**
		 * The meta object literal for the '<em><b>Administration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION = eINSTANCE.getJoomlaExtensionManifest_Administration();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.InstallDbImpl <em>Install Db</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.InstallDbImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getInstallDb()
		 * @generated
		 */
		EClass INSTALL_DB = eINSTANCE.getInstallDb();

		/**
		 * The meta object literal for the '<em><b>Sql</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTALL_DB__SQL = eINSTANCE.getInstallDb_Sql();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.UninstallDbImpl <em>Uninstall Db</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.UninstallDbImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getUninstallDb()
		 * @generated
		 */
		EClass UNINSTALL_DB = eINSTANCE.getUninstallDb();

		/**
		 * The meta object literal for the '<em><b>Sql</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNINSTALL_DB__SQL = eINSTANCE.getUninstallDb_Sql();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceImpl <em>Abstract Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getAbstractResource()
		 * @generated
		 */
		EClass ABSTRACT_RESOURCE = eINSTANCE.getAbstractResource();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_RESOURCE__PATH = eINSTANCE.getAbstractResource_Path();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceContainerImpl <em>Abstract Resource Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceContainerImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getAbstractResourceContainer()
		 * @generated
		 */
		EClass ABSTRACT_RESOURCE_CONTAINER = eINSTANCE.getAbstractResourceContainer();

		/**
		 * The meta object literal for the '<em><b>Base Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER = eINSTANCE.getAbstractResourceContainer_BaseFolder();

		/**
		 * The meta object literal for the '<em><b>All Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES = eINSTANCE.getAbstractResourceContainer_AllResources();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileSetImpl <em>Sql File Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileSetImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getSqlFileSet()
		 * @generated
		 */
		EClass SQL_FILE_SET = eINSTANCE.getSqlFileSet();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SQL_FILE_SET__FILES = eINSTANCE.getSqlFileSet_Files();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.SqlResourceImpl <em>Sql Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.SqlResourceImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getSqlResource()
		 * @generated
		 */
		EClass SQL_RESOURCE = eINSTANCE.getSqlResource();

		/**
		 * The meta object literal for the '<em><b>Driver</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_RESOURCE__DRIVER = eINSTANCE.getSqlResource_Driver();

		/**
		 * The meta object literal for the '<em><b>Charset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_RESOURCE__CHARSET = eINSTANCE.getSqlResource_Charset();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.FileSetImpl <em>File Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.FileSetImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getFileSet()
		 * @generated
		 */
		EClass FILE_SET = eINSTANCE.getFileSet();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_SET__FILES = eINSTANCE.getFileSet_Files();

		/**
		 * The meta object literal for the '<em><b>Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_SET__FOLDERS = eINSTANCE.getFileSet_Folders();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.FileResourceImpl <em>File Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.FileResourceImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getFileResource()
		 * @generated
		 */
		EClass FILE_RESOURCE = eINSTANCE.getFileResource();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.FolderResourceImpl <em>Folder Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.FolderResourceImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getFolderResource()
		 * @generated
		 */
		EClass FOLDER_RESOURCE = eINSTANCE.getFolderResource();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.LanguageSetImpl <em>Language Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.LanguageSetImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getLanguageSet()
		 * @generated
		 */
		EClass LANGUAGE_SET = eINSTANCE.getLanguageSet();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_SET__RESOURCES = eINSTANCE.getLanguageSet_Resources();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.LanguageResourceImpl <em>Language Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.LanguageResourceImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getLanguageResource()
		 * @generated
		 */
		EClass LANGUAGE_RESOURCE = eINSTANCE.getLanguageResource();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_RESOURCE__TAG = eINSTANCE.getLanguageResource_Tag();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.MediaSetImpl <em>Media Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.MediaSetImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getMediaSet()
		 * @generated
		 */
		EClass MEDIA_SET = eINSTANCE.getMediaSet();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_SET__DESTINATION = eINSTANCE.getMediaSet_Destination();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEDIA_SET__FILES = eINSTANCE.getMediaSet_Files();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.AdministrationImpl <em>Administration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.AdministrationImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getAdministration()
		 * @generated
		 */
		EClass ADMINISTRATION = eINSTANCE.getAdministration();

		/**
		 * The meta object literal for the '<em><b>Menu</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADMINISTRATION__MENU = eINSTANCE.getAdministration_Menu();

		/**
		 * The meta object literal for the '<em><b>Sub Menu</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADMINISTRATION__SUB_MENU = eINSTANCE.getAdministration_SubMenu();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl <em>Menu Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getMenuItem()
		 * @generated
		 */
		EClass MENU_ITEM = eINSTANCE.getMenuItem();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__LABEL = eINSTANCE.getMenuItem_Label();

		/**
		 * The meta object literal for the '<em><b>Act</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__ACT = eINSTANCE.getMenuItem_Act();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__TASK = eINSTANCE.getMenuItem_Task();

		/**
		 * The meta object literal for the '<em><b>Controller</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__CONTROLLER = eINSTANCE.getMenuItem_Controller();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__VIEW = eINSTANCE.getMenuItem_View();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__LAYOUT = eINSTANCE.getMenuItem_Layout();

		/**
		 * The meta object literal for the '<em><b>Sub</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__SUB = eINSTANCE.getMenuItem_Sub();

		/**
		 * The meta object literal for the '<em><b>Img</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__IMG = eINSTANCE.getMenuItem_Img();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__LINK = eINSTANCE.getMenuItem_Link();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.SubMenuImpl <em>Sub Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.SubMenuImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getSubMenu()
		 * @generated
		 */
		EClass SUB_MENU = eINSTANCE.getSubMenu();

		/**
		 * The meta object literal for the '<em><b>Menu Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_MENU__MENU_ITEMS = eINSTANCE.getSubMenu_MenuItems();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.ManifestVersion <em>Manifest Version</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestVersion
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getManifestVersion()
		 * @generated
		 */
		EEnum MANIFEST_VERSION = eINSTANCE.getManifestVersion();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.ManifestType <em>Manifest Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestType
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getManifestType()
		 * @generated
		 */
		EEnum MANIFEST_TYPE = eINSTANCE.getManifestType();

	}

} //JoomlaExtensionManifestPackage
