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
 * A representation of the model object '<em><b>Joomla Extension Deployment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getRuntime <em>Runtime</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getJoomlaExtensionDeployment()
 * @model
 * @generated
 */
public interface JoomlaExtensionDeployment extends EObject {
	/**
	 * Returns the value of the '<em><b>Runtime</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getDeployedExtensions <em>Deployed Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtime</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime</em>' reference.
	 * @see #setRuntime(DeploymentRuntime)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getJoomlaExtensionDeployment_Runtime()
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getDeployedExtensions
	 * @model opposite="deployedExtensions" required="true"
	 * @generated
	 */
	DeploymentRuntime getRuntime();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getRuntime <em>Runtime</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime</em>' reference.
	 * @see #getRuntime()
	 * @generated
	 */
	void setRuntime(DeploymentRuntime value);

} // JoomlaExtensionDeployment
