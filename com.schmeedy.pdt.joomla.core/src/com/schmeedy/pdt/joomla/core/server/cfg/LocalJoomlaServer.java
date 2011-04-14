/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Joomla Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getId <em>Id</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getTeamId <em>Team Id</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getName <em>Name</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getMajorVersion <em>Major Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getExactVersion <em>Exact Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getInstallDir <em>Install Dir</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getBaseUrl <em>Base Url</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getLocalJoomlaServer()
 * @model
 * @generated
 */
public interface LocalJoomlaServer extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getLocalJoomlaServer_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Team Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team Id</em>' attribute.
	 * @see #setTeamId(String)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getLocalJoomlaServer_TeamId()
	 * @model
	 * @generated
	 */
	String getTeamId();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getTeamId <em>Team Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team Id</em>' attribute.
	 * @see #getTeamId()
	 * @generated
	 */
	void setTeamId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getLocalJoomlaServer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Major Version</b></em>' attribute.
	 * The literals are from the enumeration {@link com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Major Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Major Version</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion
	 * @see #setMajorVersion(MajorJoomlaVersion)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getLocalJoomlaServer_MajorVersion()
	 * @model
	 * @generated
	 */
	MajorJoomlaVersion getMajorVersion();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getMajorVersion <em>Major Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Major Version</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion
	 * @see #getMajorVersion()
	 * @generated
	 */
	void setMajorVersion(MajorJoomlaVersion value);

	/**
	 * Returns the value of the '<em><b>Exact Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exact Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exact Version</em>' attribute.
	 * @see #setExactVersion(String)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getLocalJoomlaServer_ExactVersion()
	 * @model
	 * @generated
	 */
	String getExactVersion();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getExactVersion <em>Exact Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exact Version</em>' attribute.
	 * @see #getExactVersion()
	 * @generated
	 */
	void setExactVersion(String value);

	/**
	 * Returns the value of the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Install Dir</em>' attribute.
	 * @see #setInstallDir(String)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getLocalJoomlaServer_InstallDir()
	 * @model
	 * @generated
	 */
	String getInstallDir();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getInstallDir <em>Install Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Dir</em>' attribute.
	 * @see #getInstallDir()
	 * @generated
	 */
	void setInstallDir(String value);

	/**
	 * Returns the value of the '<em><b>Base Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Url</em>' attribute.
	 * @see #setBaseUrl(String)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getLocalJoomlaServer_BaseUrl()
	 * @model
	 * @generated
	 */
	String getBaseUrl();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer#getBaseUrl <em>Base Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Url</em>' attribute.
	 * @see #getBaseUrl()
	 * @generated
	 */
	void setBaseUrl(String value);

} // LocalJoomlaServer
