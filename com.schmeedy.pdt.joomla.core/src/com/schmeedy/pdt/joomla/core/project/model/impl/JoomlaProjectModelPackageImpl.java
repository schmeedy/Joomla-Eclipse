/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionType;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelFactory;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage;
import com.schmeedy.pdt.joomla.core.project.model.ManifestVersion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JoomlaProjectModelPackageImpl extends EPackageImpl implements JoomlaProjectModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joomlaExtensionProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicExtensionModelEClass = null;

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
	private EEnum extensionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iPathEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iProjectEDataType = null;

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
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JoomlaProjectModelPackageImpl() {
		super(eNS_URI, JoomlaProjectModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link JoomlaProjectModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JoomlaProjectModelPackage init() {
		if (isInited) return (JoomlaProjectModelPackage)EPackage.Registry.INSTANCE.getEPackage(JoomlaProjectModelPackage.eNS_URI);

		// Obtain or create and register package
		JoomlaProjectModelPackageImpl theJoomlaProjectModelPackage = (JoomlaProjectModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JoomlaProjectModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JoomlaProjectModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theJoomlaProjectModelPackage.createPackageContents();

		// Initialize created meta-data
		theJoomlaProjectModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJoomlaProjectModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JoomlaProjectModelPackage.eNS_URI, theJoomlaProjectModelPackage);
		return theJoomlaProjectModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoomlaExtensionProject() {
		return joomlaExtensionProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionProject_Project() {
		return (EAttribute)joomlaExtensionProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJoomlaExtensionProject_Extensions() {
		return (EReference)joomlaExtensionProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicExtensionModel() {
		return basicExtensionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicExtensionModel_Name() {
		return (EAttribute)basicExtensionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicExtensionModel_Type() {
		return (EAttribute)basicExtensionModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicExtensionModel_ManifestVersion() {
		return (EAttribute)basicExtensionModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicExtensionModel_ManifestPath() {
		return (EAttribute)basicExtensionModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicExtensionModel_Project() {
		return (EReference)basicExtensionModelEClass.getEStructuralFeatures().get(4);
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
	public EEnum getExtensionType() {
		return extensionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIPath() {
		return iPathEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIProject() {
		return iProjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaProjectModelFactory getJoomlaProjectModelFactory() {
		return (JoomlaProjectModelFactory)getEFactoryInstance();
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
		joomlaExtensionProjectEClass = createEClass(JOOMLA_EXTENSION_PROJECT);
		createEAttribute(joomlaExtensionProjectEClass, JOOMLA_EXTENSION_PROJECT__PROJECT);
		createEReference(joomlaExtensionProjectEClass, JOOMLA_EXTENSION_PROJECT__EXTENSIONS);

		basicExtensionModelEClass = createEClass(BASIC_EXTENSION_MODEL);
		createEAttribute(basicExtensionModelEClass, BASIC_EXTENSION_MODEL__NAME);
		createEAttribute(basicExtensionModelEClass, BASIC_EXTENSION_MODEL__TYPE);
		createEAttribute(basicExtensionModelEClass, BASIC_EXTENSION_MODEL__MANIFEST_VERSION);
		createEAttribute(basicExtensionModelEClass, BASIC_EXTENSION_MODEL__MANIFEST_PATH);
		createEReference(basicExtensionModelEClass, BASIC_EXTENSION_MODEL__PROJECT);

		// Create enums
		manifestVersionEEnum = createEEnum(MANIFEST_VERSION);
		extensionTypeEEnum = createEEnum(EXTENSION_TYPE);

		// Create data types
		iPathEDataType = createEDataType(IPATH);
		iProjectEDataType = createEDataType(IPROJECT);
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
		initEClass(joomlaExtensionProjectEClass, JoomlaExtensionProject.class, "JoomlaExtensionProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJoomlaExtensionProject_Project(), this.getIProject(), "project", null, 0, 1, JoomlaExtensionProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJoomlaExtensionProject_Extensions(), this.getBasicExtensionModel(), this.getBasicExtensionModel_Project(), "extensions", null, 0, -1, JoomlaExtensionProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicExtensionModelEClass, BasicExtensionModel.class, "BasicExtensionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBasicExtensionModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, BasicExtensionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicExtensionModel_Type(), this.getExtensionType(), "type", null, 0, 1, BasicExtensionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicExtensionModel_ManifestVersion(), this.getManifestVersion(), "manifestVersion", null, 0, 1, BasicExtensionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicExtensionModel_ManifestPath(), this.getIPath(), "manifestPath", null, 0, 1, BasicExtensionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicExtensionModel_Project(), this.getJoomlaExtensionProject(), this.getJoomlaExtensionProject_Extensions(), "project", null, 0, 1, BasicExtensionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(manifestVersionEEnum, ManifestVersion.class, "ManifestVersion");
		addEEnumLiteral(manifestVersionEEnum, ManifestVersion.UNKNOWN);
		addEEnumLiteral(manifestVersionEEnum, ManifestVersion.ONE_FIVE);
		addEEnumLiteral(manifestVersionEEnum, ManifestVersion.ONE_SIX);

		initEEnum(extensionTypeEEnum, ExtensionType.class, "ExtensionType");
		addEEnumLiteral(extensionTypeEEnum, ExtensionType.UNKNOWN);
		addEEnumLiteral(extensionTypeEEnum, ExtensionType.COMPONENT);
		addEEnumLiteral(extensionTypeEEnum, ExtensionType.PLUGIN);
		addEEnumLiteral(extensionTypeEEnum, ExtensionType.MODULE);
		addEEnumLiteral(extensionTypeEEnum, ExtensionType.TEMPLATE);

		// Initialize data types
		initEDataType(iPathEDataType, IPath.class, "IPath", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iProjectEDataType, IProject.class, "IProject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //JoomlaProjectModelPackageImpl
