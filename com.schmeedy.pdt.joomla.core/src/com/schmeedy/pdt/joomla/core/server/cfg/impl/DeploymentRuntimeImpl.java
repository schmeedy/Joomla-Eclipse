/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg.impl;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionResource;
import com.schmeedy.pdt.joomla.core.project.model.LanguageResource;
import com.schmeedy.pdt.joomla.core.project.model.ManifestVersion;
import com.schmeedy.pdt.joomla.core.project.model.MediaResource;
import com.schmeedy.pdt.joomla.core.project.model.ResourceType;
import com.schmeedy.pdt.joomla.core.server.IJoomlaHttpSession;
import com.schmeedy.pdt.joomla.core.server.ServerUtils;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;
import com.schmeedy.pdt.joomla.core.server.impl.JoomlaHttpSessionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Runtime</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentRuntimeImpl#getServer <em>Server</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentRuntimeImpl#getDeployedExtensions <em>Deployed Extensions</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentRuntimeImpl#getHttpSession <em>Http Session</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeploymentRuntimeImpl extends EObjectImpl implements DeploymentRuntime {
	/**
	 * The cached value of the '{@link #getServer() <em>Server</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServer()
	 * @generated
	 * @ordered
	 */
	protected LocalJoomlaServer server;

	/**
	 * The cached value of the '{@link #getDeployedExtensions() <em>Deployed Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeployedExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<JoomlaExtensionDeployment> deployedExtensions;

	/**
	 * The default value of the '{@link #getHttpSession() <em>Http Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttpSession()
	 * @generated
	 * @ordered
	 */
	protected static final IJoomlaHttpSession HTTP_SESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHttpSession() <em>Http Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttpSession()
	 * @generated NOT
	 * @ordered
	 */
	protected IJoomlaHttpSession httpSession = new JoomlaHttpSessionImpl(this);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentRuntimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaServerConfigurationPackage.Literals.DEPLOYMENT_RUNTIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalJoomlaServer getServer() {
		return server;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServer(LocalJoomlaServer newServer, NotificationChain msgs) {
		final LocalJoomlaServer oldServer = server;
		server = newServer;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER, oldServer, newServer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServer(LocalJoomlaServer newServer) {
		if (newServer != server) {
			NotificationChain msgs = null;
			if (server != null)
				msgs = ((InternalEObject)server).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER, null, msgs);
			if (newServer != null)
				msgs = ((InternalEObject)newServer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER, null, msgs);
			msgs = basicSetServer(newServer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER, newServer, newServer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JoomlaExtensionDeployment> getDeployedExtensions() {
		if (deployedExtensions == null) {
			deployedExtensions = new EObjectContainmentWithInverseEList<JoomlaExtensionDeployment>(JoomlaExtensionDeployment.class, this, JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS, JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME);
		}
		return deployedExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IJoomlaHttpSession getHttpSession() {
		return httpSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public File getDestination(ExtensionResource resource) {
		File baseDir = new File(getServer().getInstallDir());
		
		if (resource.getResourceType() == ResourceType.MEDIA) {
			final String destination = ((MediaResource) resource).getDestination();
			if (destination == null) {
				// cannot determine destination folder
				return null;
			}
			return new File(baseDir, "media" + File.separator + destination + File.separator + resource.getManifestRelativePath().lastSegment());
		}
		
		if (resource.isInAdministration()) {
			baseDir = new File(baseDir, "administrator");
		}
		
		if (resource.getResourceType() == ResourceType.LANGUAGE) {
			final LanguageResource languageResource = (LanguageResource) resource;
			if (languageResource.getLanguageTag() == null) {
				// cannot determine destination folder
				return null;
			}
			return new File(baseDir, "language" + File.separator + languageResource.getLanguageTag() + File.separator + languageResource.getManifestRelativePath().lastSegment());
		}
		
		final BasicExtensionModel extension = resource.getExtensionModel();
		switch (extension.getType()) {
			case COMPONENT:
				baseDir = new File(baseDir, "components");
				break;
			case MODULE:
				baseDir = new File(baseDir, "modules");
				break;
			case PLUGIN:
				final String group = extension.getGroup();
				if (group == null) {
					return null; // group is mandatory for plug-ins - cannot determine target path
				}
				baseDir = new File(new File(baseDir, "plugins"), group);
				break;
			case TEMPLATE:
				baseDir = new File(baseDir, "templates");
				break;
			case UNKNOWN:
				return null; // cannot reliably determine target path
		}
		final String extensionDirName = getExtensionDirName(extension);
		if (extensionDirName == null) {
			return null; // failed to determine extension directory name
		}
		baseDir = new File(baseDir, extensionDirName);
		
		final int prefixSegments = resource.getInstallPackagePathSegments();
		final IPath targetFilePath = prefixSegments == 0 ? resource.getManifestRelativePath() : resource.getManifestRelativePath().removeFirstSegments(prefixSegments);
		return new File(baseDir, targetFilePath.toString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean supports(BasicExtensionModel extension) {
		switch (getServer().getMajorVersion()) {
			case ONE_FIVE:
				return extension.getManifestVersion() == ManifestVersion.ONE_FIVE;
			case ONE_SIX:
				return extension.getManifestVersion() == ManifestVersion.ONE_SIX || extension.getManifestVersion() == ManifestVersion.ONE_FIVE;
			default:
				return true;
		}
	}

	/**
	 * @generated NOT
	 */
	private String getExtensionDirName(BasicExtensionModel extension) {
		switch (extension.getType()) {
			case COMPONENT:
				if (extension.getName() == null) {
					return null;
				}
				final String cleanedName = ServerUtils.jfilterInputCleanCommand(extension.getName().toLowerCase());
				return cleanedName.startsWith("com_") ? cleanedName : "com_" + cleanedName;
			case PLUGIN:
			case MODULE:
				return extension.getSymbolicName();
			case TEMPLATE:
				if (extension.getName() == null) {
					return null;
				}
				return ServerUtils.jfilterInputCleanCommand(extension.getName()).toLowerCase();
			default:
				return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeployedExtensions()).basicAdd(otherEnd, msgs);
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
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				return basicSetServer(null, msgs);
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				return ((InternalEList<?>)getDeployedExtensions()).basicRemove(otherEnd, msgs);
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
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				return getServer();
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				return getDeployedExtensions();
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__HTTP_SESSION:
				return getHttpSession();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				setServer((LocalJoomlaServer)newValue);
				return;
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				getDeployedExtensions().clear();
				getDeployedExtensions().addAll((Collection<? extends JoomlaExtensionDeployment>)newValue);
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
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				setServer((LocalJoomlaServer)null);
				return;
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				getDeployedExtensions().clear();
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
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				return server != null;
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				return deployedExtensions != null && !deployedExtensions.isEmpty();
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__HTTP_SESSION:
				return HTTP_SESSION_EDEFAULT == null ? httpSession != null : !HTTP_SESSION_EDEFAULT.equals(httpSession);
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
		result.append(" (httpSession: ");
		result.append(httpSession);
		result.append(')');
		return result.toString();
	}

} //DeploymentRuntimeImpl
