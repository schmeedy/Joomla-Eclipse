/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model.impl;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.schmeedy.pdt.joomla.core.project.model.ExtensionResource;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage;
import com.schmeedy.pdt.joomla.core.project.model.ResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#getSourcePath <em>Source Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#getDestinationPath <em>Destination Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionResourceImpl extends EObjectImpl implements ExtensionResource {
	/**
	 * The default value of the '{@link #getSourcePath() <em>Source Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePath()
	 * @generated
	 * @ordered
	 */
	protected static final IPath SOURCE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourcePath() <em>Source Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePath()
	 * @generated
	 * @ordered
	 */
	protected IPath sourcePath = SOURCE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDestinationPath() <em>Destination Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationPath()
	 * @generated
	 * @ordered
	 */
	protected static final IPath DESTINATION_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestinationPath() <em>Destination Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationPath()
	 * @generated
	 * @ordered
	 */
	protected IPath destinationPath = DESTINATION_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceType TYPE_EDEFAULT = ResourceType.FILE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ResourceType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaProjectModelPackage.Literals.EXTENSION_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPath getSourcePath() {
		return sourcePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePath(IPath newSourcePath) {
		IPath oldSourcePath = sourcePath;
		sourcePath = newSourcePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.EXTENSION_RESOURCE__SOURCE_PATH, oldSourcePath, sourcePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPath getDestinationPath() {
		return destinationPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestinationPath(IPath newDestinationPath) {
		IPath oldDestinationPath = destinationPath;
		destinationPath = newDestinationPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.EXTENSION_RESOURCE__DESTINATION_PATH, oldDestinationPath, destinationPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ResourceType newType) {
		ResourceType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.EXTENSION_RESOURCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File getDestinationAsFile(File joomlaInstallationDir) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__SOURCE_PATH:
				return getSourcePath();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__DESTINATION_PATH:
				return getDestinationPath();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__TYPE:
				return getType();
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
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__SOURCE_PATH:
				setSourcePath((IPath)newValue);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__DESTINATION_PATH:
				setDestinationPath((IPath)newValue);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__TYPE:
				setType((ResourceType)newValue);
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
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__SOURCE_PATH:
				setSourcePath(SOURCE_PATH_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__DESTINATION_PATH:
				setDestinationPath(DESTINATION_PATH_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__SOURCE_PATH:
				return SOURCE_PATH_EDEFAULT == null ? sourcePath != null : !SOURCE_PATH_EDEFAULT.equals(sourcePath);
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__DESTINATION_PATH:
				return DESTINATION_PATH_EDEFAULT == null ? destinationPath != null : !DESTINATION_PATH_EDEFAULT.equals(destinationPath);
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (sourcePath: ");
		result.append(sourcePath);
		result.append(", destinationPath: ");
		result.append(destinationPath);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ExtensionResourceImpl
