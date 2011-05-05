/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Media Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.MediaResource#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getMediaResource()
 * @model
 * @generated
 */
public interface MediaResource extends ExtensionResource {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' attribute.
	 * @see #setDestination(String)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getMediaResource_Destination()
	 * @model
	 * @generated
	 */
	String getDestination();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.MediaResource#getDestination <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' attribute.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(String value);

} // MediaResource
