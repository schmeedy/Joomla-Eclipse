/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg.impl;

import com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationFactory;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;
import com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion;

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
public class JoomlaServerConfigurationPackageImpl extends EPackageImpl implements JoomlaServerConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass availableServersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localJoomlaServerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentRuntimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joomlaExtensionDeploymentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum majorJoomlaVersionEEnum = null;

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
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JoomlaServerConfigurationPackageImpl() {
		super(eNS_URI, JoomlaServerConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link JoomlaServerConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JoomlaServerConfigurationPackage init() {
		if (isInited) return (JoomlaServerConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(JoomlaServerConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		JoomlaServerConfigurationPackageImpl theJoomlaServerConfigurationPackage = (JoomlaServerConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JoomlaServerConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JoomlaServerConfigurationPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theJoomlaServerConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theJoomlaServerConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJoomlaServerConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JoomlaServerConfigurationPackage.eNS_URI, theJoomlaServerConfigurationPackage);
		return theJoomlaServerConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAvailableServers() {
		return availableServersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAvailableServers_Servers() {
		return (EReference)availableServersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalJoomlaServer() {
		return localJoomlaServerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalJoomlaServer_Id() {
		return (EAttribute)localJoomlaServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalJoomlaServer_Name() {
		return (EAttribute)localJoomlaServerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalJoomlaServer_MajorVersion() {
		return (EAttribute)localJoomlaServerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalJoomlaServer_ExactVersion() {
		return (EAttribute)localJoomlaServerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalJoomlaServer_InstallDir() {
		return (EAttribute)localJoomlaServerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalJoomlaServer_BaseUrl() {
		return (EAttribute)localJoomlaServerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeploymentDescriptor() {
		return deploymentDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeploymentDescriptor_Runtimes() {
		return (EReference)deploymentDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeploymentRuntime() {
		return deploymentRuntimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeploymentRuntime_Server() {
		return (EReference)deploymentRuntimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeploymentRuntime_DeployedExtensions() {
		return (EReference)deploymentRuntimeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoomlaExtensionDeployment() {
		return joomlaExtensionDeploymentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJoomlaExtensionDeployment_Runtime() {
		return (EReference)joomlaExtensionDeploymentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMajorJoomlaVersion() {
		return majorJoomlaVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaServerConfigurationFactory getJoomlaServerConfigurationFactory() {
		return (JoomlaServerConfigurationFactory)getEFactoryInstance();
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
		availableServersEClass = createEClass(AVAILABLE_SERVERS);
		createEReference(availableServersEClass, AVAILABLE_SERVERS__SERVERS);

		localJoomlaServerEClass = createEClass(LOCAL_JOOMLA_SERVER);
		createEAttribute(localJoomlaServerEClass, LOCAL_JOOMLA_SERVER__ID);
		createEAttribute(localJoomlaServerEClass, LOCAL_JOOMLA_SERVER__NAME);
		createEAttribute(localJoomlaServerEClass, LOCAL_JOOMLA_SERVER__MAJOR_VERSION);
		createEAttribute(localJoomlaServerEClass, LOCAL_JOOMLA_SERVER__EXACT_VERSION);
		createEAttribute(localJoomlaServerEClass, LOCAL_JOOMLA_SERVER__INSTALL_DIR);
		createEAttribute(localJoomlaServerEClass, LOCAL_JOOMLA_SERVER__BASE_URL);

		deploymentDescriptorEClass = createEClass(DEPLOYMENT_DESCRIPTOR);
		createEReference(deploymentDescriptorEClass, DEPLOYMENT_DESCRIPTOR__RUNTIMES);

		deploymentRuntimeEClass = createEClass(DEPLOYMENT_RUNTIME);
		createEReference(deploymentRuntimeEClass, DEPLOYMENT_RUNTIME__SERVER);
		createEReference(deploymentRuntimeEClass, DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS);

		joomlaExtensionDeploymentEClass = createEClass(JOOMLA_EXTENSION_DEPLOYMENT);
		createEReference(joomlaExtensionDeploymentEClass, JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME);

		// Create enums
		majorJoomlaVersionEEnum = createEEnum(MAJOR_JOOMLA_VERSION);
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
		initEClass(availableServersEClass, AvailableServers.class, "AvailableServers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAvailableServers_Servers(), this.getLocalJoomlaServer(), null, "servers", null, 0, -1, AvailableServers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localJoomlaServerEClass, LocalJoomlaServer.class, "LocalJoomlaServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalJoomlaServer_Id(), ecorePackage.getEString(), "id", null, 0, 1, LocalJoomlaServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalJoomlaServer_Name(), ecorePackage.getEString(), "name", null, 0, 1, LocalJoomlaServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalJoomlaServer_MajorVersion(), this.getMajorJoomlaVersion(), "majorVersion", null, 0, 1, LocalJoomlaServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalJoomlaServer_ExactVersion(), ecorePackage.getEString(), "exactVersion", null, 0, 1, LocalJoomlaServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalJoomlaServer_InstallDir(), ecorePackage.getEString(), "installDir", null, 0, 1, LocalJoomlaServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalJoomlaServer_BaseUrl(), ecorePackage.getEString(), "baseUrl", null, 0, 1, LocalJoomlaServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deploymentDescriptorEClass, DeploymentDescriptor.class, "DeploymentDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeploymentDescriptor_Runtimes(), this.getDeploymentRuntime(), null, "runtimes", null, 1, -1, DeploymentDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deploymentRuntimeEClass, DeploymentRuntime.class, "DeploymentRuntime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeploymentRuntime_Server(), this.getLocalJoomlaServer(), null, "server", null, 1, 1, DeploymentRuntime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeploymentRuntime_DeployedExtensions(), this.getJoomlaExtensionDeployment(), this.getJoomlaExtensionDeployment_Runtime(), "deployedExtensions", null, 0, -1, DeploymentRuntime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(joomlaExtensionDeploymentEClass, JoomlaExtensionDeployment.class, "JoomlaExtensionDeployment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJoomlaExtensionDeployment_Runtime(), this.getDeploymentRuntime(), this.getDeploymentRuntime_DeployedExtensions(), "runtime", null, 1, 1, JoomlaExtensionDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(majorJoomlaVersionEEnum, MajorJoomlaVersion.class, "MajorJoomlaVersion");
		addEEnumLiteral(majorJoomlaVersionEEnum, MajorJoomlaVersion.ONE_FIVE);
		addEEnumLiteral(majorJoomlaVersionEEnum, MajorJoomlaVersion.ONE_SIX);

		// Create resource
		createResource(eNS_URI);
	}

} //JoomlaServerConfigurationPackageImpl