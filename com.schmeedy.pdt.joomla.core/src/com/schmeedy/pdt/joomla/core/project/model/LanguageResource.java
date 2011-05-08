/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.LanguageResource#getLanguageTag <em>Language Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getLanguageResource()
 * @model
 * @generated
 */
public interface LanguageResource extends ExtensionResource {
	/**
	 * Returns the value of the '<em><b>Language Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Tag</em>' attribute.
	 * @see #setLanguageTag(String)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getLanguageResource_LanguageTag()
	 * @model
	 * @generated
	 */
	String getLanguageTag();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.LanguageResource#getLanguageTag <em>Language Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Tag</em>' attribute.
	 * @see #getLanguageTag()
	 * @generated
	 */
	void setLanguageTag(String value);

} // LanguageResource
