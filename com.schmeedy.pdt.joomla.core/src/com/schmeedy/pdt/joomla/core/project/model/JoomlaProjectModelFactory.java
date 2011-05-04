/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage
 * @generated
 */
public interface JoomlaProjectModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JoomlaProjectModelFactory eINSTANCE = com.schmeedy.pdt.joomla.core.project.model.impl.JoomlaProjectModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Joomla Extension Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Joomla Extension Project</em>'.
	 * @generated
	 */
	JoomlaExtensionProject createJoomlaExtensionProject();

	/**
	 * Returns a new object of class '<em>Basic Extension Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Extension Model</em>'.
	 * @generated
	 */
	BasicExtensionModel createBasicExtensionModel();

	/**
	 * Returns a new object of class '<em>Extension Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Resource</em>'.
	 * @generated
	 */
	ExtensionResource createExtensionResource();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JoomlaProjectModelPackage getJoomlaProjectModelPackage();

} //JoomlaProjectModelFactory
