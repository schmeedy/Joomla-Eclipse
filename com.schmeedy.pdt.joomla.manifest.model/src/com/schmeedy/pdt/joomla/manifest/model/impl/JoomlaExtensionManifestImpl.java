/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.impl;

import com.schmeedy.pdt.joomla.manifest.model.Administration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.schmeedy.pdt.joomla.manifest.model.InstallDb;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.ManifestType;
import com.schmeedy.pdt.joomla.manifest.model.ManifestVersion;
import com.schmeedy.pdt.joomla.manifest.model.UninstallDb;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Joomla Extension Manifest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getManifestType <em>Manifest Type</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getManifestVersion <em>Manifest Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getAuthorEmail <em>Author Email</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getAuthorUrl <em>Author Url</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getLicense <em>License</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getInstallFile <em>Install File</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getUninstallFile <em>Uninstall File</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getInstall <em>Install</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getUninstall <em>Uninstall</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.JoomlaExtensionManifestImpl#getAdministration <em>Administration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JoomlaExtensionManifestImpl extends AbstractMultiResourceContainerImpl implements JoomlaExtensionManifest {
	/**
	 * The default value of the '{@link #getManifestType() <em>Manifest Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestType()
	 * @generated
	 * @ordered
	 */
	protected static final ManifestType MANIFEST_TYPE_EDEFAULT = ManifestType.UNKNOWN;

	/**
	 * The cached value of the '{@link #getManifestType() <em>Manifest Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestType()
	 * @generated
	 * @ordered
	 */
	protected ManifestType manifestType = MANIFEST_TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected String creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthorEmail() <em>Author Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthorEmail() <em>Author Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorEmail()
	 * @generated
	 * @ordered
	 */
	protected String authorEmail = AUTHOR_EMAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthorUrl() <em>Author Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthorUrl() <em>Author Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorUrl()
	 * @generated
	 * @ordered
	 */
	protected String authorUrl = AUTHOR_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected static final String COPYRIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected String copyright = COPYRIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected String license = LICENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstallFile() <em>Install File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallFile()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallFile() <em>Install File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallFile()
	 * @generated
	 * @ordered
	 */
	protected String installFile = INSTALL_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUninstallFile() <em>Uninstall File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUninstallFile()
	 * @generated
	 * @ordered
	 */
	protected static final String UNINSTALL_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUninstallFile() <em>Uninstall File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUninstallFile()
	 * @generated
	 * @ordered
	 */
	protected String uninstallFile = UNINSTALL_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstall() <em>Install</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstall()
	 * @generated
	 * @ordered
	 */
	protected InstallDb install;

	/**
	 * The cached value of the '{@link #getUninstall() <em>Uninstall</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUninstall()
	 * @generated
	 * @ordered
	 */
	protected UninstallDb uninstall;

	/**
	 * The cached value of the '{@link #getAdministration() <em>Administration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdministration()
	 * @generated
	 * @ordered
	 */
	protected Administration administration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoomlaExtensionManifestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaExtensionManifestPackage.Literals.JOOMLA_EXTENSION_MANIFEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ManifestVersion getManifestVersion() {
		return manifestVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setManifestVersion(ManifestVersion newManifestVersion) {
		ManifestVersion oldManifestVersion = manifestVersion;
		manifestVersion = newManifestVersion == null ? MANIFEST_VERSION_EDEFAULT : newManifestVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION, oldManifestVersion, manifestVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ManifestType getManifestType() {
		return manifestType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setManifestType(ManifestType newManifestType) {
		ManifestType oldManifestType = manifestType;
		manifestType = newManifestType == null ? MANIFEST_TYPE_EDEFAULT : newManifestType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE, oldManifestType, manifestType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationDate(String newCreationDate) {
		String oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthorEmail() {
		return authorEmail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthorEmail(String newAuthorEmail) {
		String oldAuthorEmail = authorEmail;
		authorEmail = newAuthorEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL, oldAuthorEmail, authorEmail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthorUrl() {
		return authorUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthorUrl(String newAuthorUrl) {
		String oldAuthorUrl = authorUrl;
		authorUrl = newAuthorUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL, oldAuthorUrl, authorUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCopyright() {
		return copyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCopyright(String newCopyright) {
		String oldCopyright = copyright;
		copyright = newCopyright;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__COPYRIGHT, oldCopyright, copyright));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLicense(String newLicense) {
		String oldLicense = license;
		license = newLicense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__LICENSE, oldLicense, license));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInstallFile() {
		return installFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstallFile(String newInstallFile) {
		String oldInstallFile = installFile;
		installFile = newInstallFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE, oldInstallFile, installFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUninstallFile() {
		return uninstallFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUninstallFile(String newUninstallFile) {
		String oldUninstallFile = uninstallFile;
		uninstallFile = newUninstallFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE, oldUninstallFile, uninstallFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstallDb getInstall() {
		return install;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstall(InstallDb newInstall, NotificationChain msgs) {
		InstallDb oldInstall = install;
		install = newInstall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL, oldInstall, newInstall);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstall(InstallDb newInstall) {
		if (newInstall != install) {
			NotificationChain msgs = null;
			if (install != null)
				msgs = ((InternalEObject)install).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL, null, msgs);
			if (newInstall != null)
				msgs = ((InternalEObject)newInstall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL, null, msgs);
			msgs = basicSetInstall(newInstall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL, newInstall, newInstall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UninstallDb getUninstall() {
		return uninstall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUninstall(UninstallDb newUninstall, NotificationChain msgs) {
		UninstallDb oldUninstall = uninstall;
		uninstall = newUninstall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL, oldUninstall, newUninstall);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUninstall(UninstallDb newUninstall) {
		if (newUninstall != uninstall) {
			NotificationChain msgs = null;
			if (uninstall != null)
				msgs = ((InternalEObject)uninstall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL, null, msgs);
			if (newUninstall != null)
				msgs = ((InternalEObject)newUninstall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL, null, msgs);
			msgs = basicSetUninstall(newUninstall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL, newUninstall, newUninstall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Administration getAdministration() {
		return administration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdministration(Administration newAdministration, NotificationChain msgs) {
		Administration oldAdministration = administration;
		administration = newAdministration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION, oldAdministration, newAdministration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdministration(Administration newAdministration) {
		if (newAdministration != administration) {
			NotificationChain msgs = null;
			if (administration != null)
				msgs = ((InternalEObject)administration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION, null, msgs);
			if (newAdministration != null)
				msgs = ((InternalEObject)newAdministration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION, null, msgs);
			msgs = basicSetAdministration(newAdministration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION, newAdministration, newAdministration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL:
				return basicSetInstall(null, msgs);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL:
				return basicSetUninstall(null, msgs);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION:
				return basicSetAdministration(null, msgs);
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
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE:
				return getManifestType();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION:
				return getManifestVersion();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__NAME:
				return getName();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__CREATION_DATE:
				return getCreationDate();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR:
				return getAuthor();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL:
				return getAuthorEmail();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL:
				return getAuthorUrl();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__COPYRIGHT:
				return getCopyright();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__LICENSE:
				return getLicense();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__VERSION:
				return getVersion();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__DESCRIPTION:
				return getDescription();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE:
				return getInstallFile();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE:
				return getUninstallFile();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL:
				return getInstall();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL:
				return getUninstall();
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION:
				return getAdministration();
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
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE:
				setManifestType((ManifestType)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION:
				setManifestVersion((ManifestVersion)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__NAME:
				setName((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__CREATION_DATE:
				setCreationDate((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR:
				setAuthor((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL:
				setAuthorEmail((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL:
				setAuthorUrl((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__COPYRIGHT:
				setCopyright((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__LICENSE:
				setLicense((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__VERSION:
				setVersion((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE:
				setInstallFile((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE:
				setUninstallFile((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL:
				setInstall((InstallDb)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL:
				setUninstall((UninstallDb)newValue);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION:
				setAdministration((Administration)newValue);
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
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE:
				setManifestType(MANIFEST_TYPE_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION:
				setManifestVersion(MANIFEST_VERSION_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL:
				setAuthorEmail(AUTHOR_EMAIL_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL:
				setAuthorUrl(AUTHOR_URL_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__COPYRIGHT:
				setCopyright(COPYRIGHT_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__LICENSE:
				setLicense(LICENSE_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE:
				setInstallFile(INSTALL_FILE_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE:
				setUninstallFile(UNINSTALL_FILE_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL:
				setInstall((InstallDb)null);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL:
				setUninstall((UninstallDb)null);
				return;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION:
				setAdministration((Administration)null);
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
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE:
				return manifestType != MANIFEST_TYPE_EDEFAULT;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION:
				return manifestVersion != MANIFEST_VERSION_EDEFAULT;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL:
				return AUTHOR_EMAIL_EDEFAULT == null ? authorEmail != null : !AUTHOR_EMAIL_EDEFAULT.equals(authorEmail);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL:
				return AUTHOR_URL_EDEFAULT == null ? authorUrl != null : !AUTHOR_URL_EDEFAULT.equals(authorUrl);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__COPYRIGHT:
				return COPYRIGHT_EDEFAULT == null ? copyright != null : !COPYRIGHT_EDEFAULT.equals(copyright);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__LICENSE:
				return LICENSE_EDEFAULT == null ? license != null : !LICENSE_EDEFAULT.equals(license);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE:
				return INSTALL_FILE_EDEFAULT == null ? installFile != null : !INSTALL_FILE_EDEFAULT.equals(installFile);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE:
				return UNINSTALL_FILE_EDEFAULT == null ? uninstallFile != null : !UNINSTALL_FILE_EDEFAULT.equals(uninstallFile);
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__INSTALL:
				return install != null;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__UNINSTALL:
				return uninstall != null;
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION:
				return administration != null;
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
		result.append(" (manifestType: ");
		result.append(manifestType);
		result.append(", manifestVersion: ");
		result.append(manifestVersion);
		result.append(", name: ");
		result.append(name);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(", author: ");
		result.append(author);
		result.append(", authorEmail: ");
		result.append(authorEmail);
		result.append(", authorUrl: ");
		result.append(authorUrl);
		result.append(", copyright: ");
		result.append(copyright);
		result.append(", license: ");
		result.append(license);
		result.append(", version: ");
		result.append(version);
		result.append(", description: ");
		result.append(description);
		result.append(", installFile: ");
		result.append(installFile);
		result.append(", uninstallFile: ");
		result.append(uninstallFile);
		result.append(')');
		return result.toString();
	}

} //JoomlaExtensionManifestImpl
