/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg;

import org.eclipse.emf.ecore.EObject;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Joomla Extension Deployment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getRuntime <em>Runtime</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getJoomlaExtensionDeployment()
 * @model
 * @generated
 */
public interface JoomlaExtensionDeployment extends EObject {
	/**
	 * Returns the value of the '<em><b>Runtime</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getDeployedExtensions <em>Deployed Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtime</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime</em>' container reference.
	 * @see #setRuntime(DeploymentRuntime)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getJoomlaExtensionDeployment_Runtime()
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime#getDeployedExtensions
	 * @model opposite="deployedExtensions" required="true" transient="false"
	 * @generated
	 */
	DeploymentRuntime getRuntime();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getRuntime <em>Runtime</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime</em>' container reference.
	 * @see #getRuntime()
	 * @generated
	 */
	void setRuntime(DeploymentRuntime value);

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference.
	 * @see #setExtension(BasicExtensionModel)
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getJoomlaExtensionDeployment_Extension()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BasicExtensionModel getExtension();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment#getExtension <em>Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' containment reference.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(BasicExtensionModel value);

} // JoomlaExtensionDeployment
