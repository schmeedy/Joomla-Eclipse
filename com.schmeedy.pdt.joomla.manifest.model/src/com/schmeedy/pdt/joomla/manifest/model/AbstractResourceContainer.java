/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Resource Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer#getBaseFolder <em>Base Folder</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer#getAllResources <em>All Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractResourceContainer()
 * @model abstract="true"
 * @generated
 */
public interface AbstractResourceContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Folder</em>' attribute.
	 * @see #setBaseFolder(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractResourceContainer_BaseFolder()
	 * @model extendedMetaData="name='folder' kind='attribute'"
	 * @generated
	 */
	String getBaseFolder();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer#getBaseFolder <em>Base Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Folder</em>' attribute.
	 * @see #getBaseFolder()
	 * @generated
	 */
	void setBaseFolder(String value);

	/**
	 * Returns the value of the '<em><b>All Resources</b></em>' reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.manifest.model.AbstractResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Resources</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Resources</em>' reference list.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractResourceContainer_AllResources()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	EList<AbstractResource> getAllResources();

} // AbstractResourceContainer
