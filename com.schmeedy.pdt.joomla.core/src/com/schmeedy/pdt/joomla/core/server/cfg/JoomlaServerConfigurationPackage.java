/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg;

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
 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface JoomlaServerConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cfg";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://schmeedy.com/pdt/joomla/server";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jscfg";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JoomlaServerConfigurationPackage eINSTANCE = com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.AvailableServersImpl <em>Available Servers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.AvailableServersImpl
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getAvailableServers()
	 * @generated
	 */
	int AVAILABLE_SERVERS = 0;

	/**
	 * The feature id for the '<em><b>Servers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_SERVERS__SERVERS = 0;

	/**
	 * The number of structural features of the '<em>Available Servers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_SERVERS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl <em>Local Joomla Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getLocalJoomlaServer()
	 * @generated
	 */
	int LOCAL_JOOMLA_SERVER = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_JOOMLA_SERVER__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_JOOMLA_SERVER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Major Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_JOOMLA_SERVER__MAJOR_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Exact Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_JOOMLA_SERVER__EXACT_VERSION = 3;

	/**
	 * The feature id for the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_JOOMLA_SERVER__INSTALL_DIR = 4;

	/**
	 * The feature id for the '<em><b>Base Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_JOOMLA_SERVER__BASE_URL = 5;

	/**
	 * The number of structural features of the '<em>Local Joomla Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_JOOMLA_SERVER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentDescriptorImpl <em>Deployment Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentDescriptorImpl
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getDeploymentDescriptor()
	 * @generated
	 */
	int DEPLOYMENT_DESCRIPTOR = 2;

	/**
	 * The feature id for the '<em><b>Runtimes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_DESCRIPTOR__RUNTIMES = 0;

	/**
	 * The number of structural features of the '<em>Deployment Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_DESCRIPTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentRuntimeImpl <em>Deployment Runtime</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentRuntimeImpl
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getDeploymentRuntime()
	 * @generated
	 */
	int DEPLOYMENT_RUNTIME = 3;

	/**
	 * The feature id for the '<em><b>Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_RUNTIME__SERVER = 0;

	/**
	 * The feature id for the '<em><b>Deployed Extensions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS = 1;

	/**
	 * The number of structural features of the '<em>Deployment Runtime</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_RUNTIME_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaExtensionDeploymentImpl <em>Joomla Extension Deployment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaExtensionDeploymentImpl
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getJoomlaExtensionDeployment()
	 * @generated
	 */
	int JOOMLA_EXTENSION_DEPLOYMENT = 4;

	/**
	 * The feature id for the '<em><b>Runtime</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME = 0;

	/**
	 * The number of structural features of the '<em>Joomla Extension Deployment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOOMLA_EXTENSION_DEPLOYMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion <em>Major Joomla Version</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getMajorJoomlaVersion()
	 * @generated
	 */
	int MAJOR_JOOMLA_VERSION = 5;


	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers <em>Available Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Available Servers</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers
	 * @generated
	 */
	EClass getAvailableServers();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers#getServers <em>Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Servers</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers#getServers()
	 * @see #getAvailableServers()
	 * @generated
	 */
	EReference getAvailableServers_Servers();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer <em>Local Joomla Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Joomla Server</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer
	 * @generated
	 */
	EClass getLocalJoomlaServer();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getId()
	 * @see #getLocalJoomlaServer()
	 * @generated
	 */
	EAttribute getLocalJoomlaServer_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getName()
	 * @see #getLocalJoomlaServer()
	 * @generated
	 */
	EAttribute getLocalJoomlaServer_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getMajorVersion <em>Major Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Major Version</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getMajorVersion()
	 * @see #getLocalJoomlaServer()
	 * @generated
	 */
	EAttribute getLocalJoomlaServer_MajorVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getExactVersion <em>Exact Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exact Version</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getExactVersion()
	 * @see #getLocalJoomlaServer()
	 * @generated
	 */
	EAttribute getLocalJoomlaServer_ExactVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getInstallDir <em>Install Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Dir</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getInstallDir()
	 * @see #getLocalJoomlaServer()
	 * @generated
	 */
	EAttribute getLocalJoomlaServer_InstallDir();

	/**
	 * Returns the meta object for the attribute '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getBaseUrl <em>Base Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Url</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getBaseUrl()
	 * @see #getLocalJoomlaServer()
	 * @generated
	 */
	EAttribute getLocalJoomlaServer_BaseUrl();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor <em>Deployment Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Descriptor</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor
	 * @generated
	 */
	EClass getDeploymentDescriptor();

	/**
	 * Returns the meta object for the containment reference list '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor#getRuntimes <em>Runtimes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Runtimes</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor#getRuntimes()
	 * @see #getDeploymentDescriptor()
	 * @generated
	 */
	EReference getDeploymentDescriptor_Runtimes();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime <em>Deployment Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Runtime</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime
	 * @generated
	 */
	EClass getDeploymentRuntime();

	/**
	 * Returns the meta object for the containment reference '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getServer <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Server</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getServer()
	 * @see #getDeploymentRuntime()
	 * @generated
	 */
	EReference getDeploymentRuntime_Server();

	/**
	 * Returns the meta object for the reference list '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getDeployedExtensions <em>Deployed Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Deployed Extensions</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getDeployedExtensions()
	 * @see #getDeploymentRuntime()
	 * @generated
	 */
	EReference getDeploymentRuntime_DeployedExtensions();

	/**
	 * Returns the meta object for class '{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment <em>Joomla Extension Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Joomla Extension Deployment</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment
	 * @generated
	 */
	EClass getJoomlaExtensionDeployment();

	/**
	 * Returns the meta object for the reference '{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getRuntime <em>Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Runtime</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getRuntime()
	 * @see #getJoomlaExtensionDeployment()
	 * @generated
	 */
	EReference getJoomlaExtensionDeployment_Runtime();

	/**
	 * Returns the meta object for enum '{@link com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion <em>Major Joomla Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Major Joomla Version</em>'.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion
	 * @generated
	 */
	EEnum getMajorJoomlaVersion();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JoomlaServerConfigurationFactory getJoomlaServerConfigurationFactory();

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
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.AvailableServersImpl <em>Available Servers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.AvailableServersImpl
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getAvailableServers()
		 * @generated
		 */
		EClass AVAILABLE_SERVERS = eINSTANCE.getAvailableServers();

		/**
		 * The meta object literal for the '<em><b>Servers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AVAILABLE_SERVERS__SERVERS = eINSTANCE.getAvailableServers_Servers();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl <em>Local Joomla Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getLocalJoomlaServer()
		 * @generated
		 */
		EClass LOCAL_JOOMLA_SERVER = eINSTANCE.getLocalJoomlaServer();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_JOOMLA_SERVER__ID = eINSTANCE.getLocalJoomlaServer_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_JOOMLA_SERVER__NAME = eINSTANCE.getLocalJoomlaServer_Name();

		/**
		 * The meta object literal for the '<em><b>Major Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_JOOMLA_SERVER__MAJOR_VERSION = eINSTANCE.getLocalJoomlaServer_MajorVersion();

		/**
		 * The meta object literal for the '<em><b>Exact Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_JOOMLA_SERVER__EXACT_VERSION = eINSTANCE.getLocalJoomlaServer_ExactVersion();

		/**
		 * The meta object literal for the '<em><b>Install Dir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_JOOMLA_SERVER__INSTALL_DIR = eINSTANCE.getLocalJoomlaServer_InstallDir();

		/**
		 * The meta object literal for the '<em><b>Base Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_JOOMLA_SERVER__BASE_URL = eINSTANCE.getLocalJoomlaServer_BaseUrl();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentDescriptorImpl <em>Deployment Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentDescriptorImpl
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getDeploymentDescriptor()
		 * @generated
		 */
		EClass DEPLOYMENT_DESCRIPTOR = eINSTANCE.getDeploymentDescriptor();

		/**
		 * The meta object literal for the '<em><b>Runtimes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_DESCRIPTOR__RUNTIMES = eINSTANCE.getDeploymentDescriptor_Runtimes();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentRuntimeImpl <em>Deployment Runtime</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentRuntimeImpl
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getDeploymentRuntime()
		 * @generated
		 */
		EClass DEPLOYMENT_RUNTIME = eINSTANCE.getDeploymentRuntime();

		/**
		 * The meta object literal for the '<em><b>Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_RUNTIME__SERVER = eINSTANCE.getDeploymentRuntime_Server();

		/**
		 * The meta object literal for the '<em><b>Deployed Extensions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS = eINSTANCE.getDeploymentRuntime_DeployedExtensions();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaExtensionDeploymentImpl <em>Joomla Extension Deployment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaExtensionDeploymentImpl
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getJoomlaExtensionDeployment()
		 * @generated
		 */
		EClass JOOMLA_EXTENSION_DEPLOYMENT = eINSTANCE.getJoomlaExtensionDeployment();

		/**
		 * The meta object literal for the '<em><b>Runtime</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME = eINSTANCE.getJoomlaExtensionDeployment_Runtime();

		/**
		 * The meta object literal for the '{@link com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion <em>Major Joomla Version</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion
		 * @see com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationPackageImpl#getMajorJoomlaVersion()
		 * @generated
		 */
		EEnum MAJOR_JOOMLA_VERSION = eINSTANCE.getMajorJoomlaVersion();

	}

} //JoomlaServerConfigurationPackage
