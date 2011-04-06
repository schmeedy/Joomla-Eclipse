/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;
import com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Joomla Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl#getMajorVersion <em>Major Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl#getExactVersion <em>Exact Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl#getInstallDir <em>Install Dir</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.LocalJoomlaServerImpl#getBaseUrl <em>Base Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalJoomlaServerImpl extends EObjectImpl implements LocalJoomlaServer {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated NOT
	 * @ordered
	 */
	protected String id = EcoreUtil.generateUUID();

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
	 * The default value of the '{@link #getMajorVersion() <em>Major Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMajorVersion()
	 * @generated NOT
	 * @ordered
	 */
	protected static final MajorJoomlaVersion MAJOR_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMajorVersion() <em>Major Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMajorVersion()
	 * @generated
	 * @ordered
	 */
	protected MajorJoomlaVersion majorVersion = MAJOR_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getExactVersion() <em>Exact Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExactVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String EXACT_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExactVersion() <em>Exact Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExactVersion()
	 * @generated
	 * @ordered
	 */
	protected String exactVersion = EXACT_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstallDir() <em>Install Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallDir()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_DIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallDir() <em>Install Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallDir()
	 * @generated
	 * @ordered
	 */
	protected String installDir = INSTALL_DIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseUrl() <em>Base Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseUrl() <em>Base Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUrl()
	 * @generated
	 * @ordered
	 */
	protected String baseUrl = BASE_URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalJoomlaServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaServerConfigurationPackage.Literals.LOCAL_JOOMLA_SERVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MajorJoomlaVersion getMajorVersion() {
		return majorVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMajorVersion(MajorJoomlaVersion newMajorVersion) {
		MajorJoomlaVersion oldMajorVersion = majorVersion;
		majorVersion = newMajorVersion == null ? MAJOR_VERSION_EDEFAULT : newMajorVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__MAJOR_VERSION, oldMajorVersion, majorVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExactVersion() {
		return exactVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExactVersion(String newExactVersion) {
		String oldExactVersion = exactVersion;
		exactVersion = newExactVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__EXACT_VERSION, oldExactVersion, exactVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInstallDir() {
		return installDir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstallDir(String newInstallDir) {
		String oldInstallDir = installDir;
		installDir = newInstallDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__INSTALL_DIR, oldInstallDir, installDir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseUrl(String newBaseUrl) {
		String oldBaseUrl = baseUrl;
		baseUrl = newBaseUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__BASE_URL, oldBaseUrl, baseUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__ID:
				return getId();
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__NAME:
				return getName();
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__MAJOR_VERSION:
				return getMajorVersion();
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__EXACT_VERSION:
				return getExactVersion();
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__INSTALL_DIR:
				return getInstallDir();
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__BASE_URL:
				return getBaseUrl();
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
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__ID:
				setId((String)newValue);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__NAME:
				setName((String)newValue);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__MAJOR_VERSION:
				setMajorVersion((MajorJoomlaVersion)newValue);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__EXACT_VERSION:
				setExactVersion((String)newValue);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__INSTALL_DIR:
				setInstallDir((String)newValue);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__BASE_URL:
				setBaseUrl((String)newValue);
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
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__ID:
				setId(ID_EDEFAULT);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__MAJOR_VERSION:
				setMajorVersion(MAJOR_VERSION_EDEFAULT);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__EXACT_VERSION:
				setExactVersion(EXACT_VERSION_EDEFAULT);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__INSTALL_DIR:
				setInstallDir(INSTALL_DIR_EDEFAULT);
				return;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__BASE_URL:
				setBaseUrl(BASE_URL_EDEFAULT);
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
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__MAJOR_VERSION:
				return majorVersion != MAJOR_VERSION_EDEFAULT;
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__EXACT_VERSION:
				return EXACT_VERSION_EDEFAULT == null ? exactVersion != null : !EXACT_VERSION_EDEFAULT.equals(exactVersion);
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__INSTALL_DIR:
				return INSTALL_DIR_EDEFAULT == null ? installDir != null : !INSTALL_DIR_EDEFAULT.equals(installDir);
			case JoomlaServerConfigurationPackage.LOCAL_JOOMLA_SERVER__BASE_URL:
				return BASE_URL_EDEFAULT == null ? baseUrl != null : !BASE_URL_EDEFAULT.equals(baseUrl);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", majorVersion: ");
		result.append(majorVersion);
		result.append(", exactVersion: ");
		result.append(exactVersion);
		result.append(", installDir: ");
		result.append(installDir);
		result.append(", baseUrl: ");
		result.append(baseUrl);
		result.append(')');
		return result.toString();
	}

} //LocalJoomlaServerImpl
