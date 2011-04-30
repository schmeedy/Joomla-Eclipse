/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Joomla Extension Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject#getProject <em>Project</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject#getExtensions <em>Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getJoomlaExtensionProject()
 * @model
 * @generated
 */
public interface JoomlaExtensionProject extends EObject {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' attribute.
	 * @see #setProject(IProject)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getJoomlaExtensionProject_Project()
	 * @model dataType="com.schmeedy.pdt.joomla.core.project.model.IProject"
	 * @generated
	 */
	IProject getProject();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject#getProject <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' attribute.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(IProject value);

	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel}.
	 * It is bidirectional and its opposite is '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' reference list.
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getJoomlaExtensionProject_Extensions()
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getProject
	 * @model opposite="project"
	 * @generated
	 */
	EList<BasicExtensionModel> getExtensions();

} // JoomlaExtensionProject
