/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.FileResource#getModule <em>Module</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.FileResource#getPlugin <em>Plugin</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getFileResource()
 * @model extendedMetaData="kind='simple'"
 * @generated
 */
public interface FileResource extends AbstractResource {

	/**
	 * Returns the value of the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' attribute.
	 * @see #setModule(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getFileResource_Module()
	 * @model extendedMetaData="name='module' kind='attribute'"
	 * @generated
	 */
	String getModule();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.FileResource#getModule <em>Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' attribute.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(String value);

	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin</em>' attribute.
	 * @see #setPlugin(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getFileResource_Plugin()
	 * @model extendedMetaData="name='module' kind='plugin'"
	 * @generated
	 */
	String getPlugin();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.FileResource#getPlugin <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin</em>' attribute.
	 * @see #getPlugin()
	 * @generated
	 */
	void setPlugin(String value);

} // FileResource
