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
 * A representation of the model object '<em><b>Sql File Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.SqlFileSet#getFiles <em>Files</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getSqlFileSet()
 * @model
 * @generated
 */
public interface SqlFileSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Files</b></em>' containment reference list.
	 * The list contents are of type {@link com.schmeedy.pdt.joomla.manifest.model.SqlResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' containment reference list.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getSqlFileSet_Files()
	 * @model containment="true"
	 *        extendedMetaData="name='file' kind='element'"
	 * @generated
	 */
	EList<SqlResource> getFiles();

} // SqlFileSet
