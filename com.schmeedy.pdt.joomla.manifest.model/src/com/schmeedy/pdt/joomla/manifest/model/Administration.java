/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Administration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.Administration#getMenu <em>Menu</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.Administration#getSubMenu <em>Sub Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAdministration()
 * @model
 * @generated
 */
public interface Administration extends AbstractMultiResourceContainer {
	/**
	 * Returns the value of the '<em><b>Menu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Menu</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Menu</em>' containment reference.
	 * @see #setMenu(MenuItem)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAdministration_Menu()
	 * @model containment="true"
	 * @generated
	 */
	MenuItem getMenu();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.Administration#getMenu <em>Menu</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Menu</em>' containment reference.
	 * @see #getMenu()
	 * @generated
	 */
	void setMenu(MenuItem value);

	/**
	 * Returns the value of the '<em><b>Sub Menu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Menu</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Menu</em>' containment reference.
	 * @see #setSubMenu(SubMenu)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAdministration_SubMenu()
	 * @model containment="true"
	 *        extendedMetaData="name='submenu'"
	 * @generated
	 */
	SubMenu getSubMenu();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.Administration#getSubMenu <em>Sub Menu</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Menu</em>' containment reference.
	 * @see #getSubMenu()
	 * @generated
	 */
	void setSubMenu(SubMenu value);

} // Administration
