/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Joomla Extension Manifest</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getManifestType <em>Manifest Type</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getManifestVersion <em>Manifest Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getName <em>Name</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthorEmail <em>Author Email</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthorUrl <em>Author Url</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getLicense <em>License</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getVersion <em>Version</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getDescription <em>Description</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getInstallFile <em>Install File</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getUninstallFile <em>Uninstall File</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getInstall <em>Install</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getUninstall <em>Uninstall</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAdministration <em>Administration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest()
 * @model
 * @generated
 */
public interface JoomlaExtensionManifest extends AbstractMultiResourceContainer {
	/**
	 * Returns the value of the '<em><b>Manifest Version</b></em>' attribute.
	 * The literals are from the enumeration {@link com.schmeedy.pdt.joomla.manifest.model.ManifestVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manifest Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manifest Version</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestVersion
	 * @see #setManifestVersion(ManifestVersion)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_ManifestVersion()
	 * @model extendedMetaData="name='version' kind='attribute'"
	 * @generated
	 */
	ManifestVersion getManifestVersion();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getManifestVersion <em>Manifest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest Version</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestVersion
	 * @see #getManifestVersion()
	 * @generated
	 */
	void setManifestVersion(ManifestVersion value);

	/**
	 * Returns the value of the '<em><b>Manifest Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.schmeedy.pdt.joomla.manifest.model.ManifestType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manifest Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manifest Type</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestType
	 * @see #setManifestType(ManifestType)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_ManifestType()
	 * @model extendedMetaData="name='type' kind='attribute'"
	 * @generated
	 */
	ManifestType getManifestType();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getManifestType <em>Manifest Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest Type</em>' attribute.
	 * @see com.schmeedy.pdt.joomla.manifest.model.ManifestType
	 * @see #getManifestType()
	 * @generated
	 */
	void setManifestType(ManifestType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_Name()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_CreationDate()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getCreationDate();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_Author()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Author Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author Email</em>' attribute.
	 * @see #setAuthorEmail(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_AuthorEmail()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getAuthorEmail();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthorEmail <em>Author Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author Email</em>' attribute.
	 * @see #getAuthorEmail()
	 * @generated
	 */
	void setAuthorEmail(String value);

	/**
	 * Returns the value of the '<em><b>Author Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author Url</em>' attribute.
	 * @see #setAuthorUrl(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_AuthorUrl()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getAuthorUrl();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAuthorUrl <em>Author Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author Url</em>' attribute.
	 * @see #getAuthorUrl()
	 * @generated
	 */
	void setAuthorUrl(String value);

	/**
	 * Returns the value of the '<em><b>Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copyright</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copyright</em>' attribute.
	 * @see #setCopyright(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_Copyright()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getCopyright();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getCopyright <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copyright</em>' attribute.
	 * @see #getCopyright()
	 * @generated
	 */
	void setCopyright(String value);

	/**
	 * Returns the value of the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License</em>' attribute.
	 * @see #setLicense(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_License()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getLicense();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getLicense <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>License</em>' attribute.
	 * @see #getLicense()
	 * @generated
	 */
	void setLicense(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_Version()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_Description()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Install File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Install File</em>' attribute.
	 * @see #setInstallFile(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_InstallFile()
	 * @model extendedMetaData="kind='element' name='installfile'"
	 * @generated
	 */
	String getInstallFile();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getInstallFile <em>Install File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install File</em>' attribute.
	 * @see #getInstallFile()
	 * @generated
	 */
	void setInstallFile(String value);

	/**
	 * Returns the value of the '<em><b>Uninstall File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uninstall File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uninstall File</em>' attribute.
	 * @see #setUninstallFile(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_UninstallFile()
	 * @model extendedMetaData="kind='element' name='uninstallfile'"
	 * @generated
	 */
	String getUninstallFile();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getUninstallFile <em>Uninstall File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uninstall File</em>' attribute.
	 * @see #getUninstallFile()
	 * @generated
	 */
	void setUninstallFile(String value);

	/**
	 * Returns the value of the '<em><b>Install</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Install</em>' containment reference.
	 * @see #setInstall(InstallDb)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_Install()
	 * @model containment="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	InstallDb getInstall();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getInstall <em>Install</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install</em>' containment reference.
	 * @see #getInstall()
	 * @generated
	 */
	void setInstall(InstallDb value);

	/**
	 * Returns the value of the '<em><b>Uninstall</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uninstall</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uninstall</em>' containment reference.
	 * @see #setUninstall(UninstallDb)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_Uninstall()
	 * @model containment="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	UninstallDb getUninstall();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getUninstall <em>Uninstall</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uninstall</em>' containment reference.
	 * @see #getUninstall()
	 * @generated
	 */
	void setUninstall(UninstallDb value);

	/**
	 * Returns the value of the '<em><b>Administration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Administration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Administration</em>' containment reference.
	 * @see #setAdministration(Administration)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaExtensionManifest_Administration()
	 * @model containment="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	Administration getAdministration();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest#getAdministration <em>Administration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Administration</em>' containment reference.
	 * @see #getAdministration()
	 * @generated
	 */
	void setAdministration(Administration value);

} // JoomlaExtensionManifest
