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
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
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
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#getFullPath <em>Full Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#getManifestRelativePath <em>Manifest Relative Path</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#getInstallPackagePathSegments <em>Install Package Path Segments</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#isFolder <em>Folder</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#isInAdministration <em>In Administration</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#getExtensionModel <em>Extension Model</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.ExtensionResourceImpl#isSpecialResource <em>Special Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionResourceImpl extends EObjectImpl implements ExtensionResource {
	/**
	 * The default value of the '{@link #getFullPath() <em>Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullPath()
	 * @generated
	 * @ordered
	 */
	protected static final IPath FULL_PATH_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getManifestRelativePath() <em>Manifest Relative Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestRelativePath()
	 * @generated
	 * @ordered
	 */
	protected static final IPath MANIFEST_RELATIVE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManifestRelativePath() <em>Manifest Relative Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestRelativePath()
	 * @generated
	 * @ordered
	 */
	protected IPath manifestRelativePath = MANIFEST_RELATIVE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstallPackagePathSegments() <em>Install Package Path Segments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallPackagePathSegments()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTALL_PACKAGE_PATH_SEGMENTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInstallPackagePathSegments() <em>Install Package Path Segments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallPackagePathSegments()
	 * @generated
	 * @ordered
	 */
	protected int installPackagePathSegments = INSTALL_PACKAGE_PATH_SEGMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceType RESOURCE_TYPE_EDEFAULT = ResourceType.GENERIC_FILE;

	/**
	 * The cached value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected ResourceType resourceType = RESOURCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isFolder() <em>Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFolder()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOLDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFolder() <em>Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFolder()
	 * @generated
	 * @ordered
	 */
	protected boolean folder = FOLDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isInAdministration() <em>In Administration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInAdministration()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_ADMINISTRATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInAdministration() <em>In Administration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInAdministration()
	 * @generated
	 * @ordered
	 */
	protected boolean inAdministration = IN_ADMINISTRATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isSpecialResource() <em>Special Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpecialResource()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SPECIAL_RESOURCE_EDEFAULT = false;

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
	 * @generated NOT
	 */
	@Override
	public IPath getFullPath() {
		final BasicExtensionModel extensionModel = getExtensionModel();
		if (extensionModel == null) {
			throw new IllegalArgumentException("Resource is not contained in an extension model.");
		}
		final IPath manifestPath = extensionModel.getManifestPath();
		return manifestPath.removeLastSegments(1).append(getManifestRelativePath());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IPath getManifestRelativePath() {
		return manifestRelativePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setManifestRelativePath(IPath newManifestRelativePath) {
		final IPath oldManifestRelativePath = manifestRelativePath;
		manifestRelativePath = newManifestRelativePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.EXTENSION_RESOURCE__MANIFEST_RELATIVE_PATH, oldManifestRelativePath, manifestRelativePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInstallPackagePathSegments() {
		return installPackagePathSegments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstallPackagePathSegments(int newInstallPackagePathSegments) {
		final int oldInstallPackagePathSegments = installPackagePathSegments;
		installPackagePathSegments = newInstallPackagePathSegments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.EXTENSION_RESOURCE__INSTALL_PACKAGE_PATH_SEGMENTS, oldInstallPackagePathSegments, installPackagePathSegments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceType(ResourceType newResourceType) {
		final ResourceType oldResourceType = resourceType;
		resourceType = newResourceType == null ? RESOURCE_TYPE_EDEFAULT : newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.EXTENSION_RESOURCE__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFolder() {
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFolder(boolean newFolder) {
		final boolean oldFolder = folder;
		folder = newFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.EXTENSION_RESOURCE__FOLDER, oldFolder, folder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInAdministration() {
		return inAdministration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInAdministration(boolean newInAdministration) {
		final boolean oldInAdministration = inAdministration;
		inAdministration = newInAdministration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.EXTENSION_RESOURCE__IN_ADMINISTRATION, oldInAdministration, inAdministration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicExtensionModel getExtensionModel() {
		if (eContainerFeatureID() != JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL) return null;
		return (BasicExtensionModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionModel(BasicExtensionModel newExtensionModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExtensionModel, JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtensionModel(BasicExtensionModel newExtensionModel) {
		if (newExtensionModel != eInternalContainer() || (eContainerFeatureID() != JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL && newExtensionModel != null)) {
			if (EcoreUtil.isAncestor(this, newExtensionModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExtensionModel != null)
				msgs = ((InternalEObject)newExtensionModel).eInverseAdd(this, JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__RESOURCES, BasicExtensionModel.class, msgs);
			msgs = basicSetExtensionModel(newExtensionModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL, newExtensionModel, newExtensionModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isSpecialResource() {
		return resourceType != null && (
					resourceType == ResourceType.SPECIAL_INSTALL_SQL ||
					resourceType == ResourceType.SPECIAL_UNINSTALL_SQL ||
					resourceType == ResourceType.SPECIAL_INSTALL_SCRIPT ||
					resourceType == ResourceType.SPECIAL_UNINSTALL_SCRIPT
				);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExtensionModel((BasicExtensionModel)otherEnd, msgs);
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
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL:
				return basicSetExtensionModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL:
				return eInternalContainer().eInverseRemove(this, JoomlaProjectModelPackage.BASIC_EXTENSION_MODEL__RESOURCES, BasicExtensionModel.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__FULL_PATH:
				return getFullPath();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__MANIFEST_RELATIVE_PATH:
				return getManifestRelativePath();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__INSTALL_PACKAGE_PATH_SEGMENTS:
				return getInstallPackagePathSegments();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__RESOURCE_TYPE:
				return getResourceType();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__FOLDER:
				return isFolder();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__IN_ADMINISTRATION:
				return isInAdministration();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL:
				return getExtensionModel();
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__SPECIAL_RESOURCE:
				return isSpecialResource();
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
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__MANIFEST_RELATIVE_PATH:
				setManifestRelativePath((IPath)newValue);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__INSTALL_PACKAGE_PATH_SEGMENTS:
				setInstallPackagePathSegments((Integer)newValue);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__FOLDER:
				setFolder((Boolean)newValue);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__IN_ADMINISTRATION:
				setInAdministration((Boolean)newValue);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL:
				setExtensionModel((BasicExtensionModel)newValue);
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
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__MANIFEST_RELATIVE_PATH:
				setManifestRelativePath(MANIFEST_RELATIVE_PATH_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__INSTALL_PACKAGE_PATH_SEGMENTS:
				setInstallPackagePathSegments(INSTALL_PACKAGE_PATH_SEGMENTS_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__FOLDER:
				setFolder(FOLDER_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__IN_ADMINISTRATION:
				setInAdministration(IN_ADMINISTRATION_EDEFAULT);
				return;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL:
				setExtensionModel((BasicExtensionModel)null);
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
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__FULL_PATH:
				return FULL_PATH_EDEFAULT == null ? getFullPath() != null : !FULL_PATH_EDEFAULT.equals(getFullPath());
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__MANIFEST_RELATIVE_PATH:
				return MANIFEST_RELATIVE_PATH_EDEFAULT == null ? manifestRelativePath != null : !MANIFEST_RELATIVE_PATH_EDEFAULT.equals(manifestRelativePath);
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__INSTALL_PACKAGE_PATH_SEGMENTS:
				return installPackagePathSegments != INSTALL_PACKAGE_PATH_SEGMENTS_EDEFAULT;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__FOLDER:
				return folder != FOLDER_EDEFAULT;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__IN_ADMINISTRATION:
				return inAdministration != IN_ADMINISTRATION_EDEFAULT;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__EXTENSION_MODEL:
				return getExtensionModel() != null;
			case JoomlaProjectModelPackage.EXTENSION_RESOURCE__SPECIAL_RESOURCE:
				return isSpecialResource() != SPECIAL_RESOURCE_EDEFAULT;
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

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (manifestRelativePath: ");
		result.append(manifestRelativePath);
		result.append(", installPackagePathSegments: ");
		result.append(installPackagePathSegments);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", folder: ");
		result.append(folder);
		result.append(", inAdministration: ");
		result.append(inAdministration);
		result.append(')');
		return result.toString();
	}

} //ExtensionResourceImpl
