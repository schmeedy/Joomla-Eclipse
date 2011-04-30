/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model.impl;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionType;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage;
import com.schmeedy.pdt.joomla.core.project.model.ManifestVersion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Extension Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.BasicExtensionModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.BasicExtensionModelImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.BasicExtensionModelImpl#getManifestVersion <em>Manifest Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.BasicExtensionModelImpl#getManifestPath <em>Manifest Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.BasicExtensionModelImpl#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicExtensionModelImpl extends EObjectImpl implements BasicExtensionModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ExtensionType TYPE_EDEFAULT = ExtensionType.UNKNOWN;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ExtensionType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getManifestVersion() <em>Manifest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestVersion()
	 * @generated
	 * @ordered
	 */
	protected static final ManifestVersion MANIFEST_VERSION_EDEFAULT = ManifestVersion.UNKNOWN;

	/**
	 * The cached value of the '{@link #getManifestVersion() <em>Manifest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestVersion()
	 * @generated
	 * @ordered
	 */
	protected ManifestVersion manifestVersion = MANIFEST_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getManifestPath() <em>Manifest Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestPath()
	 * @generated
	 * @ordered
	 */
	protected static final IPath MANIFEST_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManifestPath() <em>Manifest Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestPath()
	 * @generated
	 * @ordered
	 */
	protected IPath manifestPath = MANIFEST_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected JoomlaExtensionProject project;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicExtensionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaProjectModelPackage.Literals.BASIC_EXTENSION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ExtensionType newType) {
		ExtensionType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManifestVersion getManifestVersion() {
		return manifestVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManifestVersion(ManifestVersion newManifestVersion) {
		ManifestVersion oldManifestVersion = manifestVersion;
		manifestVersion = newManifestVersion == null ? MANIFEST_VERSION_EDEFAULT : newManifestVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_VERSION, oldManifestVersion, manifestVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPath getManifestPath() {
		return manifestPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManifestPath(IPath newManifestPath) {
		IPath oldManifestPath = manifestPath;
		manifestPath = newManifestPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_PATH, oldManifestPath, manifestPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionProject getProject() {
		if (project != null && project.eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (JoomlaExtensionProject)eResolveProxy(oldProject);
			if (project != oldProject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__PROJECT, oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionProject basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(JoomlaExtensionProject newProject, NotificationChain msgs) {
		JoomlaExtensionProject oldProject = project;
		project = newProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__PROJECT, oldProject, newProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(JoomlaExtensionProject newProject) {
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject)project).eInverseRemove(this, JoomlaProjectModelPackage.JOOMLA_EXTENSION_PROJECT__EXTENSIONS, JoomlaExtensionProject.class, msgs);
			if (newProject != null)
				msgs = ((InternalEObject)newProject).eInverseAdd(this, JoomlaProjectModelPackage.JOOMLA_EXTENSION_PROJECT__EXTENSIONS, JoomlaExtensionProject.class, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__PROJECT, newProject, newProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__PROJECT:
				if (project != null)
					msgs = ((InternalEObject)project).eInverseRemove(this, JoomlaProjectModelPackage.JOOMLA_EXTENSION_PROJECT__EXTENSIONS, JoomlaExtensionProject.class, msgs);
				return basicSetProject((JoomlaExtensionProject)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__PROJECT:
				return basicSetProject(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__NAME:
				return getName();
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__TYPE:
				return getType();
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_VERSION:
				return getManifestVersion();
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_PATH:
				return getManifestPath();
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
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
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__NAME:
				setName((String)newValue);
				return;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__TYPE:
				setType((ExtensionType)newValue);
				return;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_VERSION:
				setManifestVersion((ManifestVersion)newValue);
				return;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_PATH:
				setManifestPath((IPath)newValue);
				return;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__PROJECT:
				setProject((JoomlaExtensionProject)newValue);
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
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_VERSION:
				setManifestVersion(MANIFEST_VERSION_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_PATH:
				setManifestPath(MANIFEST_PATH_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__PROJECT:
				setProject((JoomlaExtensionProject)null);
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
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__TYPE:
				return type != TYPE_EDEFAULT;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_VERSION:
				return manifestVersion != MANIFEST_VERSION_EDEFAULT;
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__MANIFEST_PATH:
				return MANIFEST_PATH_EDEFAULT == null ? manifestPath != null : !MANIFEST_PATH_EDEFAULT.equals(manifestPath);
			case JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__PROJECT:
				return project != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", manifestVersion: ");
		result.append(manifestVersion);
		result.append(", manifestPath: ");
		result.append(manifestPath);
		result.append(')');
		return result.toString();
	}

} //BasicExtensionModelImpl
