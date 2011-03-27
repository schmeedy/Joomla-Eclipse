/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Multi Resource Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getFileSets <em>File Sets</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getLanguageSets <em>Language Sets</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getMediaSets <em>Media Sets</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer#getAllResourceSets <em>All Resource Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractMultiResourceContainer()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMultiResourceContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>File Sets</b></em>' containment reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.manifest.model.FileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Sets</em>' containment reference list.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractMultiResourceContainer_FileSets()
	 * @model containment="true"
	 *        extendedMetaData="name='files' kind='element'"
	 * @generated
	 */
	EList<FileSet> getFileSets();

	/**
	 * Returns the value of the '<em><b>Language Sets</b></em>' containment reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.manifest.model.LanguageSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Sets</em>' containment reference list.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractMultiResourceContainer_LanguageSets()
	 * @model containment="true"
	 *        extendedMetaData="name='languages' kind='element'"
	 * @generated
	 */
	EList<LanguageSet> getLanguageSets();

	/**
	 * Returns the value of the '<em><b>Media Sets</b></em>' containment reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.manifest.model.MediaSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Media Sets</em>' containment reference list.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractMultiResourceContainer_MediaSets()
	 * @model containment="true"
	 *        extendedMetaData="name='media' kind='element'"
	 * @generated
	 */
	EList<MediaSet> getMediaSets();

	/**
	 * Returns the value of the '<em><b>All Resource Sets</b></em>' reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Resource Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Resource Sets</em>' reference list.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getAbstractMultiResourceContainer_AllResourceSets()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	EList<AbstractResourceContainer> getAllResourceSets();

} // AbstractMultiResourceContainer
