/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage
 * @generated
 */
public interface JoomlaExtensionManifestFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JoomlaExtensionManifestFactory eINSTANCE = com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Joomla Extension Manifest</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Joomla Extension Manifest</em>'.
	 * @generated
	 */
	JoomlaExtensionManifest createJoomlaExtensionManifest();

	/**
	 * Returns a new object of class '<em>Install Db</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Install Db</em>'.
	 * @generated
	 */
	InstallDb createInstallDb();

	/**
	 * Returns a new object of class '<em>Uninstall Db</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Uninstall Db</em>'.
	 * @generated
	 */
	UninstallDb createUninstallDb();

	/**
	 * Returns a new object of class '<em>Sql File Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sql File Set</em>'.
	 * @generated
	 */
	SqlFileSet createSqlFileSet();

	/**
	 * Returns a new object of class '<em>Sql File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sql File</em>'.
	 * @generated
	 */
	SqlFile createSqlFile();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JoomlaExtensionManifestPackage getJoomlaExtensionManifestPackage();

} //JoomlaExtensionManifestFactory
