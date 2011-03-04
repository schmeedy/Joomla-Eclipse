/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.impl;

import com.schmeedy.pdt.joomla.manifest.model.InstallDb;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestFactory;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;

import com.schmeedy.pdt.joomla.manifest.model.ManifestType;
import com.schmeedy.pdt.joomla.manifest.model.ManifestVersion;
import com.schmeedy.pdt.joomla.manifest.model.SqlFile;
import com.schmeedy.pdt.joomla.manifest.model.SqlFileSet;
import com.schmeedy.pdt.joomla.manifest.model.UninstallDb;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JoomlaExtensionManifestPackageImpl extends EPackageImpl implements JoomlaExtensionManifestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joomlaExtensionManifestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass installDbEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uninstallDbEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlFileSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum manifestVersionEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum manifestTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JoomlaExtensionManifestPackageImpl() {
		super(eNS_URI, JoomlaExtensionManifestFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JoomlaExtensionManifestPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JoomlaExtensionManifestPackage init() {
		if (isInited) return (JoomlaExtensionManifestPackage)EPackage.Registry.INSTANCE.getEPackage(JoomlaExtensionManifestPackage.eNS_URI);

		// Obtain or create and register package
		JoomlaExtensionManifestPackageImpl theJoomlaExtensionManifestPackage = (JoomlaExtensionManifestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JoomlaExtensionManifestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JoomlaExtensionManifestPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theJoomlaExtensionManifestPackage.createPackageContents();

		// Initialize created meta-data
		theJoomlaExtensionManifestPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJoomlaExtensionManifestPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JoomlaExtensionManifestPackage.eNS_URI, theJoomlaExtensionManifestPackage);
		return theJoomlaExtensionManifestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoomlaExtensionManifest() {
		return joomlaExtensionManifestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_ManifestVersion() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_ManifestType() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Name() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_CreationDate() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Author() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_AuthorEmail() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_AuthorUrl() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Copyright() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_License() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Version() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Description() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_InstallFile() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_UninstallFile() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJoomlaExtensionManifest_Install() {
		return (EReference)joomlaExtensionManifestEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJoomlaExtensionManifest_Uninstall() {
		return (EReference)joomlaExtensionManifestEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstallDb() {
		return installDbEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstallDb_Sql() {
		return (EReference)installDbEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUninstallDb() {
		return uninstallDbEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUninstallDb_Sql() {
		return (EReference)uninstallDbEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlFileSet() {
		return sqlFileSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSqlFileSet_Files() {
		return (EReference)sqlFileSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlFile() {
		return sqlFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlFile_FileName() {
		return (EAttribute)sqlFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlFile_Driver() {
		return (EAttribute)sqlFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlFile_Charset() {
		return (EAttribute)sqlFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getManifestVersion() {
		return manifestVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getManifestType() {
		return manifestTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionManifestFactory getJoomlaExtensionManifestFactory() {
		return (JoomlaExtensionManifestFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		joomlaExtensionManifestEClass = createEClass(JOOMLA_EXTENSION_MANIFEST);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__NAME);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__CREATION_DATE);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__AUTHOR);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__COPYRIGHT);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__LICENSE);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__VERSION);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__DESCRIPTION);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE);
		createEReference(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__INSTALL);
		createEReference(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__UNINSTALL);

		installDbEClass = createEClass(INSTALL_DB);
		createEReference(installDbEClass, INSTALL_DB__SQL);

		uninstallDbEClass = createEClass(UNINSTALL_DB);
		createEReference(uninstallDbEClass, UNINSTALL_DB__SQL);

		sqlFileSetEClass = createEClass(SQL_FILE_SET);
		createEReference(sqlFileSetEClass, SQL_FILE_SET__FILES);

		sqlFileEClass = createEClass(SQL_FILE);
		createEAttribute(sqlFileEClass, SQL_FILE__FILE_NAME);
		createEAttribute(sqlFileEClass, SQL_FILE__DRIVER);
		createEAttribute(sqlFileEClass, SQL_FILE__CHARSET);

		// Create enums
		manifestVersionEEnum = createEEnum(MANIFEST_VERSION);
		manifestTypeEEnum = createEEnum(MANIFEST_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(joomlaExtensionManifestEClass, JoomlaExtensionManifest.class, "JoomlaExtensionManifest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJoomlaExtensionManifest_ManifestType(), this.getManifestType(), "manifestType", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_ManifestVersion(), this.getManifestVersion(), "manifestVersion", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Name(), ecorePackage.getEString(), "name", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_CreationDate(), ecorePackage.getEString(), "creationDate", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Author(), ecorePackage.getEString(), "author", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_AuthorEmail(), ecorePackage.getEString(), "authorEmail", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_AuthorUrl(), ecorePackage.getEString(), "authorUrl", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Copyright(), ecorePackage.getEString(), "copyright", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_License(), ecorePackage.getEString(), "license", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Version(), ecorePackage.getEString(), "version", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Description(), ecorePackage.getEString(), "description", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_InstallFile(), ecorePackage.getEString(), "installFile", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_UninstallFile(), ecorePackage.getEString(), "uninstallFile", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJoomlaExtensionManifest_Install(), this.getInstallDb(), null, "install", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJoomlaExtensionManifest_Uninstall(), this.getUninstallDb(), null, "uninstall", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(installDbEClass, InstallDb.class, "InstallDb", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstallDb_Sql(), this.getSqlFileSet(), null, "sql", null, 0, 1, InstallDb.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uninstallDbEClass, UninstallDb.class, "UninstallDb", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUninstallDb_Sql(), this.getSqlFileSet(), null, "sql", null, 0, 1, UninstallDb.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlFileSetEClass, SqlFileSet.class, "SqlFileSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSqlFileSet_Files(), this.getSqlFile(), null, "files", null, 0, -1, SqlFileSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlFileEClass, SqlFile.class, "SqlFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSqlFile_FileName(), ecorePackage.getEString(), "fileName", null, 0, 1, SqlFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlFile_Driver(), ecorePackage.getEString(), "driver", null, 0, 1, SqlFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlFile_Charset(), ecorePackage.getEString(), "charset", null, 0, 1, SqlFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(manifestVersionEEnum, ManifestVersion.class, "ManifestVersion");
		addEEnumLiteral(manifestVersionEEnum, ManifestVersion.UNKNOWN);
		addEEnumLiteral(manifestVersionEEnum, ManifestVersion.ONE_FIVE);
		addEEnumLiteral(manifestVersionEEnum, ManifestVersion.ONE_SIX);

		initEEnum(manifestTypeEEnum, ManifestType.class, "ManifestType");
		addEEnumLiteral(manifestTypeEEnum, ManifestType.UNKNOWN);
		addEEnumLiteral(manifestTypeEEnum, ManifestType.COMPONENT);
		addEEnumLiteral(manifestTypeEEnum, ManifestType.PLUGIN);
		addEEnumLiteral(manifestTypeEEnum, ManifestType.MODULE);
		addEEnumLiteral(manifestTypeEEnum, ManifestType.TEMPLATE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (getJoomlaExtensionManifest_ManifestType(), 
		   source, 
		   new String[] {
			 "name", "type"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_ManifestVersion(), 
		   source, 
		   new String[] {
			 "name", "version"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Name(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_CreationDate(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Author(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_AuthorEmail(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_AuthorUrl(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Copyright(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_License(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Version(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Description(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_InstallFile(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "installfile"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_UninstallFile(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "uninstallfile"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Install(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Uninstall(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getSqlFileSet_Files(), 
		   source, 
		   new String[] {
			 "name", "file"
		   });		
		addAnnotation
		  (sqlFileEClass, 
		   source, 
		   new String[] {
			 "name", "file",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getSqlFile_FileName(), 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });
	}

} //JoomlaExtensionManifestPackageImpl
