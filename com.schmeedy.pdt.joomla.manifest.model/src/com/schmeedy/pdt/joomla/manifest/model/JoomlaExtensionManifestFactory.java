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
	 * Returns a new object of class '<em>Sql Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sql Resource</em>'.
	 * @generated
	 */
	SqlResource createSqlResource();

	/**
	 * Returns a new object of class '<em>File Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Set</em>'.
	 * @generated
	 */
	FileSet createFileSet();

	/**
	 * Returns a new object of class '<em>File Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Resource</em>'.
	 * @generated
	 */
	FileResource createFileResource();

	/**
	 * Returns a new object of class '<em>Folder Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder Resource</em>'.
	 * @generated
	 */
	FolderResource createFolderResource();

	/**
	 * Returns a new object of class '<em>Language Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Language Set</em>'.
	 * @generated
	 */
	LanguageSet createLanguageSet();

	/**
	 * Returns a new object of class '<em>Language Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Language Resource</em>'.
	 * @generated
	 */
	LanguageResource createLanguageResource();

	/**
	 * Returns a new object of class '<em>Media Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Media Set</em>'.
	 * @generated
	 */
	MediaSet createMediaSet();

	/**
	 * Returns a new object of class '<em>Administration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Administration</em>'.
	 * @generated
	 */
	Administration createAdministration();

	/**
	 * Returns a new object of class '<em>Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Menu Item</em>'.
	 * @generated
	 */
	MenuItem createMenuItem();

	/**
	 * Returns a new object of class '<em>Sub Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Menu</em>'.
	 * @generated
	 */
	SubMenu createSubMenu();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JoomlaExtensionManifestPackage getJoomlaExtensionManifestPackage();

} //JoomlaExtensionManifestFactory
