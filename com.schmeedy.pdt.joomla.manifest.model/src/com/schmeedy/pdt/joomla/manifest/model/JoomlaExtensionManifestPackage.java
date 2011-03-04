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
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl <em>Joomla Extension Manifest</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getJoomlaExtensionManifest()
	 * @generated
	 */
	int JOOMLA_EXTENSION_MANIFEST = 0;

	/**
	 * The feature id for the '<em><b>Manifest Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Manifest Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__NAME = 2;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__CREATION_DATE = 3;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__AUTHOR = 4;

	/**
	 * The feature id for the '<em><b>Author Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL = 5;

	/**
	 * The feature id for the '<em><b>Author Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL = 6;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__COPYRIGHT = 7;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__LICENSE = 8;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__VERSION = 9;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__DESCRIPTION = 10;

	/**
	 * The feature id for the '<em><b>Install File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE = 11;

	/**
	 * The feature id for the '<em><b>Uninstall File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE = 12;

	/**
	 * The feature id for the '<em><b>Install</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__INSTALL = 13;

	/**
	 * The feature id for the '<em><b>Uninstall</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST__UNINSTALL = 14;

	/**
	 * The number of structural features of the '<em>Joomla Extension Manifest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_MANIFEST_FEATURE_COUNT = 15;


	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.InstallDbImpl <em>Install Db</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.InstallDbImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getInstallDb()
	 * @generated
	 */
	int INSTALL_DB = 1;

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
	int UNINSTALL_DB = 2;

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
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileSetImpl <em>Sql File Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileSetImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getSqlFileSet()
	 * @generated
	 */
	int SQL_FILE_SET = 3;

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
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileImpl <em>Sql File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileImpl
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getSqlFile()
	 * @generated
	 */
	int SQL_FILE = 4;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_FILE__FILE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Driver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_FILE__DRIVER = 1;

	/**
	 * The feature id for the '<em><b>Charset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_FILE__CHARSET = 2;

	/**
	 * The number of structural features of the '<em>Sql File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_FILE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.ManifestVersion <em>Manifest Version</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestVersion
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getManifestVersion()
	 * @generated
	 */
	int MANIFEST_VERSION = 5;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.manifest.model.ManifestType <em>Manifest Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestType
	 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getManifestType()
	 * @generated
	 */
	int MANIFEST_TYPE = 6;


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
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.manifest.model.SqlFile <em>Sql File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sql File</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlFile
	 * @generated
	 */
	EClass getSqlFile();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.SqlFile#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlFile#getFileName()
	 * @see #getSqlFile()
	 * @generated
	 */
	EAttribute getSqlFile_FileName();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.SqlFile#getDriver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlFile#getDriver()
	 * @see #getSqlFile()
	 * @generated
	 */
	EAttribute getSqlFile_Driver();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.manifest.model.SqlFile#getCharset <em>Charset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Charset</em>'.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlFile#getCharset()
	 * @see #getSqlFile()
	 * @generated
	 */
	EAttribute getSqlFile_Charset();

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
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileImpl <em>Sql File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.SqlFileImpl
		 * @see com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestPackageImpl#getSqlFile()
		 * @generated
		 */
		EClass SQL_FILE = eINSTANCE.getSqlFile();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_FILE__FILE_NAME = eINSTANCE.getSqlFile_FileName();

		/**
		 * The meta object literal for the '<em><b>Driver</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_FILE__DRIVER = eINSTANCE.getSqlFile_Driver();

		/**
		 * The meta object literal for the '<em><b>Charset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_FILE__CHARSET = eINSTANCE.getSqlFile_Charset();

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
