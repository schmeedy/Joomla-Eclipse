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
 * A representation of the model object '<em><b>Available Servers</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers#getServers <em>Servers</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getAvailableServers()
 * @model
 * @generated
 */
public interface AvailableServers extends EObject {
	/**
	 * Returns the value of the '<em><b>Servers</b></em>' containment reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Servers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Servers</em>' containment reference list.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage#getAvailableServers_Servers()
	 * @model containment="true"
	 * @generated
	 */
	EList<LocalJoomlaServer> getServers();

} // AvailableServers
