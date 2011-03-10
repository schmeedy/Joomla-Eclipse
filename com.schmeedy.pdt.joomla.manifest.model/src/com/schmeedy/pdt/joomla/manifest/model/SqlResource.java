/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sql Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.SqlResource#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.SqlResource#getCharset <em>Charset</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getSqlResource()
 * @model extendedMetaData="kind='simple'"
 * @generated
 */
public interface SqlResource extends AbstractResource {
	/**
	 * Returns the value of the '<em><b>Driver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver</em>' attribute.
	 * @see #setDriver(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getSqlResource_Driver()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getDriver();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.SqlResource#getDriver <em>Driver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver</em>' attribute.
	 * @see #getDriver()
	 * @generated
	 */
	void setDriver(String value);

	/**
	 * Returns the value of the '<em><b>Charset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Charset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Charset</em>' attribute.
	 * @see #setCharset(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getSqlResource_Charset()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getCharset();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.SqlResource#getCharset <em>Charset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Charset</em>' attribute.
	 * @see #getCharset()
	 * @generated
	 */
	void setCharset(String value);

} // SqlResource
