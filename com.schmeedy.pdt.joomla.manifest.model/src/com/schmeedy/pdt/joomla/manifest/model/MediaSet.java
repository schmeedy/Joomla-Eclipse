/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Media Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MediaSet#getDestination <em>Destination</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MediaSet#getFiles <em>Files</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMediaSet()
 * @model
 * @generated
 */
public interface MediaSet extends AbstractResourceContainer {
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
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMediaSet_Destination()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getDestination();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MediaSet#getDestination <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' attribute.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(String value);

	/**
	 * Returns the value of the '<em><b>Files</b></em>' reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.manifest.model.FileResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' reference list.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMediaSet_Files()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	EList<FileResource> getFiles();

} // MediaSet
