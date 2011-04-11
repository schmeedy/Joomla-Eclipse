/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor#getRuntimes <em>Runtimes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getDeploymentDescriptor()
 * @model
 * @generated
 */
public interface DeploymentDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Runtimes</b></em>' containment reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtimes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtimes</em>' containment reference list.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getDeploymentDescriptor_Runtimes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DeploymentRuntime> getRuntimes();

} // DeploymentDescriptor
