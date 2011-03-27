/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResource#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractResource()
 * @model abstract="true"
 *        extendedMetaData="kind='simple'"
 * @generated NOT
 */
public interface AbstractResource extends EObject, Comparable<AbstractResource> {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractResource_Path()
	 * @model extendedMetaData="kind='simple'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResource#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // AbstractResource
