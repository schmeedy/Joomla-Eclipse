/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Extension Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getName <em>Name</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getSymbolicName <em>Symbolic Name</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getType <em>Type</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getManifestVersion <em>Manifest Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getManifestPath <em>Manifest Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getGroup <em>Group</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getProject <em>Project</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getBasicExtensionModel()
 * @model
 * @generated
 */
public interface BasicExtensionModel extends EObject {
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
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getBasicExtensionModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Symbolic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbolic Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbolic Name</em>' attribute.
	 * @see #setSymbolicName(String)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getBasicExtensionModel_SymbolicName()
	 * @model
	 * @generated
	 */
	String getSymbolicName();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getSymbolicName <em>Symbolic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbolic Name</em>' attribute.
	 * @see #getSymbolicName()
	 * @generated
	 */
	void setSymbolicName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.schmeedy.pdt.joomla.core.project.model.ExtensionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionType
	 * @see #setType(ExtensionType)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getBasicExtensionModel_Type()
	 * @model
	 * @generated
	 */
	ExtensionType getType();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionType
	 * @see #getType()
	 * @generated
	 */
	void setType(ExtensionType value);

	/**
	 * Returns the value of the '<em><b>Manifest Version</b></em>' attribute.
	 * The literals are from the enumeration {@link com.schmeedy.pdt.joomla.core.project.model.ManifestVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manifest Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manifest Version</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ManifestVersion
	 * @see #setManifestVersion(ManifestVersion)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getBasicExtensionModel_ManifestVersion()
	 * @model
	 * @generated
	 */
	ManifestVersion getManifestVersion();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getManifestVersion <em>Manifest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest Version</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ManifestVersion
	 * @see #getManifestVersion()
	 * @generated
	 */
	void setManifestVersion(ManifestVersion value);

	/**
	 * Returns the value of the '<em><b>Manifest Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manifest Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manifest Path</em>' attribute.
	 * @see #setManifestPath(IPath)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getBasicExtensionModel_ManifestPath()
	 * @model dataType="com.schmeedy.pdt.joomla.core.project.model.IPath"
	 * @generated
	 */
	IPath getManifestPath();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getManifestPath <em>Manifest Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest Path</em>' attribute.
	 * @see #getManifestPath()
	 * @generated
	 */
	void setManifestPath(IPath value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute.
	 * @see #setGroup(String)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getBasicExtensionModel_Group()
	 * @model
	 * @generated
	 */
	String getGroup();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getGroup <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' attribute.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(String value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' container reference.
	 * @see #setProject(JoomlaExtensionProject)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getBasicExtensionModel_Project()
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject#getExtensions
	 * @model opposite="extensions" transient="false"
	 * @generated
	 */
	JoomlaExtensionProject getProject();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getProject <em>Project</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' container reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(JoomlaExtensionProject value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource}.
	 * It is bidirectional and its opposite is '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getExtensionModel <em>Extension Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getBasicExtensionModel_Resources()
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getExtensionModel
	 * @model opposite="extensionModel" containment="true" transient="true"
	 * @generated
	 */
	EList<ExtensionResource> getResources();

} // BasicExtensionModel
