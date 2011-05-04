/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getSourcePath <em>Source Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getDestinationPath <em>Destination Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource()
 * @model
 * @generated
 */
public interface ExtensionResource extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Path</em>' attribute.
	 * @see #setSourcePath(IPath)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_SourcePath()
	 * @model dataType="com.schmeedy.pdt.joomla.core.project.model.IPath"
	 * @generated
	 */
	IPath getSourcePath();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getSourcePath <em>Source Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Path</em>' attribute.
	 * @see #getSourcePath()
	 * @generated
	 */
	void setSourcePath(IPath value);

	/**
	 * Returns the value of the '<em><b>Destination Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Path</em>' attribute.
	 * @see #setDestinationPath(IPath)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_DestinationPath()
	 * @model dataType="com.schmeedy.pdt.joomla.core.project.model.IPath"
	 * @generated
	 */
	IPath getDestinationPath();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getDestinationPath <em>Destination Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Path</em>' attribute.
	 * @see #getDestinationPath()
	 * @generated
	 */
	void setDestinationPath(IPath value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.schmeedy.pdt.joomla.core.project.model.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ResourceType
	 * @see #setType(ResourceType)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_Type()
	 * @model
	 * @generated
	 */
	ResourceType getType();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ResourceType
	 * @see #getType()
	 * @generated
	 */
	void setType(ResourceType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="com.schmeedy.pdt.joomla.core.project.model.File" joomlaInstallationDirDataType="com.schmeedy.pdt.joomla.core.project.model.File"
	 * @generated
	 */
	File getDestinationAsFile(File joomlaInstallationDir);

} // ExtensionResource
