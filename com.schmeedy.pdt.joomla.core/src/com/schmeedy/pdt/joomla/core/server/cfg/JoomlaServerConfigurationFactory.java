/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage
 * @generated
 */
public interface JoomlaServerConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JoomlaServerConfigurationFactory eINSTANCE = com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaServerConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Available Servers</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Available Servers</em>'.
	 * @generated
	 */
	AvailableServers createAvailableServers();

	/**
	 * Returns a new object of class '<em>Local Joomla Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Joomla Server</em>'.
	 * @generated
	 */
	LocalJoomlaServer createLocalJoomlaServer();

	/**
	 * Returns a new object of class '<em>User Credentials</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Credentials</em>'.
	 * @generated
	 */
	UserCredentials createUserCredentials();

	/**
	 * Returns a new object of class '<em>Deployment Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Descriptor</em>'.
	 * @generated
	 */
	DeploymentDescriptor createDeploymentDescriptor();

	/**
	 * Returns a new object of class '<em>Deployment Runtime</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Runtime</em>'.
	 * @generated
	 */
	DeploymentRuntime createDeploymentRuntime();

	/**
	 * Returns a new object of class '<em>Joomla Extension Deployment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Joomla Extension Deployment</em>'.
	 * @generated
	 */
	JoomlaExtensionDeployment createJoomlaExtensionDeployment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JoomlaServerConfigurationPackage getJoomlaServerConfigurationPackage();

} //JoomlaServerConfigurationFactory
