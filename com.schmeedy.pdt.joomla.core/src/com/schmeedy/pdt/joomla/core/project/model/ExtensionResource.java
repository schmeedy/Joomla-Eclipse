/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model;

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
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getFullPath <em>Full Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getManifestRelativePath <em>Manifest Relative Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getInstallPackagePathSegments <em>Install Package Path Segments</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#isFolder <em>Folder</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#isInAdministration <em>In Administration</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getExtensionModel <em>Extension Model</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#isSpecialResource <em>Special Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource()
 * @model
 * @generated
 */
public interface ExtensionResource extends EObject {
	/**
	 * Returns the value of the '<em><b>Full Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Path</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_FullPath()
	 * @model dataType="com.schmeedy.pdt.joomla.core.project.model.IPath" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	IPath getFullPath();

	/**
	 * Returns the value of the '<em><b>Manifest Relative Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manifest Relative Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manifest Relative Path</em>' attribute.
	 * @see #setManifestRelativePath(IPath)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_ManifestRelativePath()
	 * @model dataType="com.schmeedy.pdt.joomla.core.project.model.IPath"
	 * @generated
	 */
	IPath getManifestRelativePath();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getManifestRelativePath <em>Manifest Relative Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest Relative Path</em>' attribute.
	 * @see #getManifestRelativePath()
	 * @generated
	 */
	void setManifestRelativePath(IPath value);

	/**
	 * Returns the value of the '<em><b>Install Package Path Segments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install Package Path Segments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Install Package Path Segments</em>' attribute.
	 * @see #setInstallPackagePathSegments(int)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_InstallPackagePathSegments()
	 * @model
	 * @generated
	 */
	int getInstallPackagePathSegments();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getInstallPackagePathSegments <em>Install Package Path Segments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Package Path Segments</em>' attribute.
	 * @see #getInstallPackagePathSegments()
	 * @generated
	 */
	void setInstallPackagePathSegments(int value);

	/**
	 * Returns the value of the '<em><b>Resource Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.schmeedy.pdt.joomla.core.project.model.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Type</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ResourceType
	 * @see #setResourceType(ResourceType)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_ResourceType()
	 * @model
	 * @generated
	 */
	ResourceType getResourceType();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getResourceType <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ResourceType
	 * @see #getResourceType()
	 * @generated
	 */
	void setResourceType(ResourceType value);

	/**
	 * Returns the value of the '<em><b>Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folder</em>' attribute.
	 * @see #setFolder(boolean)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_Folder()
	 * @model
	 * @generated
	 */
	boolean isFolder();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#isFolder <em>Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Folder</em>' attribute.
	 * @see #isFolder()
	 * @generated
	 */
	void setFolder(boolean value);

	/**
	 * Returns the value of the '<em><b>In Administration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Administration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Administration</em>' attribute.
	 * @see #setInAdministration(boolean)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_InAdministration()
	 * @model
	 * @generated
	 */
	boolean isInAdministration();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#isInAdministration <em>In Administration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Administration</em>' attribute.
	 * @see #isInAdministration()
	 * @generated
	 */
	void setInAdministration(boolean value);

	/**
	 * Returns the value of the '<em><b>Extension Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Model</em>' container reference.
	 * @see #setExtensionModel(BasicExtensionModel)
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_ExtensionModel()
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel#getResources
	 * @model opposite="resources"
	 * @generated
	 */
	BasicExtensionModel getExtensionModel();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource#getExtensionModel <em>Extension Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Model</em>' container reference.
	 * @see #getExtensionModel()
	 * @generated
	 */
	void setExtensionModel(BasicExtensionModel value);

	/**
	 * Returns the value of the '<em><b>Special Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Special Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special Resource</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getExtensionResource_SpecialResource()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isSpecialResource();

} // ExtensionResource
