/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Resource Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceContainerImpl#getBaseFolder <em>Base Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractResourceContainerImpl extends EObjectImpl implements AbstractResourceContainer {
	/**
	 * The default value of the '{@link #getBaseFolder() <em>Base Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseFolder() <em>Base Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseFolder()
	 * @generated
	 * @ordered
	 */
	protected String baseFolder = BASE_FOLDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractResourceContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaExtensionManifestPackage.Literals.ABSTRACT_RESOURCE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseFolder() {
		return baseFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseFolder(String newBaseFolder) {
		String oldBaseFolder = baseFolder;
		baseFolder = newBaseFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER, oldBaseFolder, baseFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER:
				return getBaseFolder();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER:
				setBaseFolder((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER:
				setBaseFolder(BASE_FOLDER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER:
				return BASE_FOLDER_EDEFAULT == null ? baseFolder != null : !BASE_FOLDER_EDEFAULT.equals(baseFolder);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (baseFolder: ");
		result.append(baseFolder);
		result.append(')');
		return result.toString();
	}

} //AbstractResourceContainerImpl
