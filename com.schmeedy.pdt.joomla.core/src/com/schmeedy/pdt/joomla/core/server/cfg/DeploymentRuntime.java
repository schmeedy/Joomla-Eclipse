/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.schmeedy.pdt.joomla.core.server.IJoomlaHttpSession;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Runtime</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getServer <em>Server</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getDeployedExtensions <em>Deployed Extensions</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getHttpSession <em>Http Session</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getDeploymentRuntime()
 * @model
 * @generated
 */
public interface DeploymentRuntime extends EObject {
	/**
	 * Returns the value of the '<em><b>Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server</em>' containment reference.
	 * @see #setServer(LocalJoomlaServer)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getDeploymentRuntime_Server()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LocalJoomlaServer getServer();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getServer <em>Server</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server</em>' containment reference.
	 * @see #getServer()
	 * @generated
	 */
	void setServer(LocalJoomlaServer value);

	/**
	 * Returns the value of the '<em><b>Deployed Extensions</b></em>' reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment}.
	 * It is bidirectional and its opposite is '{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getRuntime <em>Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployed Extensions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployed Extensions</em>' reference list.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getDeploymentRuntime_DeployedExtensions()
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getRuntime
	 * @model opposite="runtime"
	 * @generated
	 */
	EList<JoomlaExtensionDeployment> getDeployedExtensions();

	/**
	 * Returns the value of the '<em><b>Http Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Http Session</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Http Session</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getDeploymentRuntime_HttpSession()
	 * @model dataType="com.schmeedy.pdt.joomla.core.server.cfg.IJoomlaHttpSession" required="true" transient="true" changeable="false"
	 * @generated
	 */
	IJoomlaHttpSession getHttpSession();

} // DeploymentRuntime
