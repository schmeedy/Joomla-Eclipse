/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.schmeedy.pdt.joomla.manifest.model.Administration;
import com.schmeedy.pdt.joomla.manifest.model.FileResource;
import com.schmeedy.pdt.joomla.manifest.model.FileSet;
import com.schmeedy.pdt.joomla.manifest.model.FolderResource;
import com.schmeedy.pdt.joomla.manifest.model.InstallDb;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaDestination;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestFactory;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.LanguageResource;
import com.schmeedy.pdt.joomla.manifest.model.LanguageSet;
import com.schmeedy.pdt.joomla.manifest.model.ManifestType;
import com.schmeedy.pdt.joomla.manifest.model.ManifestVersion;
import com.schmeedy.pdt.joomla.manifest.model.MediaSet;
import com.schmeedy.pdt.joomla.manifest.model.MenuItem;
import com.schmeedy.pdt.joomla.manifest.model.SqlFileSet;
import com.schmeedy.pdt.joomla.manifest.model.SqlResource;
import com.schmeedy.pdt.joomla.manifest.model.SubMenu;
import com.schmeedy.pdt.joomla.manifest.model.UninstallDb;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JoomlaExtensionManifestFactoryImpl extends EFactoryImpl implements JoomlaExtensionManifestFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JoomlaExtensionManifestFactory init() {
		try {
			JoomlaExtensionManifestFactory theJoomlaExtensionManifestFactory = (JoomlaExtensionManifestFactory)EPackage.Registry.INSTANCE.getEFactory("http://joomla.org/schema/extension-manifest"); 
			if (theJoomlaExtensionManifestFactory != null) {
				return theJoomlaExtensionManifestFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JoomlaExtensionManifestFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionManifestFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST: return createJoomlaExtensionManifest();
			case JoomlaExtensionManifestPackage.INSTALL_DB: return createInstallDb();
			case JoomlaExtensionManifestPackage.UNINSTALL_DB: return createUninstallDb();
			case JoomlaExtensionManifestPackage.SQL_FILE_SET: return createSqlFileSet();
			case JoomlaExtensionManifestPackage.SQL_RESOURCE: return createSqlResource();
			case JoomlaExtensionManifestPackage.FILE_SET: return createFileSet();
			case JoomlaExtensionManifestPackage.FILE_RESOURCE: return createFileResource();
			case JoomlaExtensionManifestPackage.FOLDER_RESOURCE: return createFolderResource();
			case JoomlaExtensionManifestPackage.LANGUAGE_SET: return createLanguageSet();
			case JoomlaExtensionManifestPackage.LANGUAGE_RESOURCE: return createLanguageResource();
			case JoomlaExtensionManifestPackage.MEDIA_SET: return createMediaSet();
			case JoomlaExtensionManifestPackage.ADMINISTRATION: return createAdministration();
			case JoomlaExtensionManifestPackage.MENU_ITEM: return createMenuItem();
			case JoomlaExtensionManifestPackage.SUB_MENU: return createSubMenu();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JoomlaExtensionManifestPackage.MANIFEST_VERSION:
				return createManifestVersionFromString(eDataType, initialValue);
			case JoomlaExtensionManifestPackage.MANIFEST_TYPE:
				return createManifestTypeFromString(eDataType, initialValue);
			case JoomlaExtensionManifestPackage.JOOMLA_DESTINATION:
				return createJoomlaDestinationFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JoomlaExtensionManifestPackage.MANIFEST_VERSION:
				return convertManifestVersionToString(eDataType, instanceValue);
			case JoomlaExtensionManifestPackage.MANIFEST_TYPE:
				return convertManifestTypeToString(eDataType, instanceValue);
			case JoomlaExtensionManifestPackage.JOOMLA_DESTINATION:
				return convertJoomlaDestinationToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionManifest createJoomlaExtensionManifest() {
		JoomlaExtensionManifestImpl joomlaExtensionManifest = new JoomlaExtensionManifestImpl();
		return joomlaExtensionManifest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstallDb createInstallDb() {
		InstallDbImpl installDb = new InstallDbImpl();
		return installDb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UninstallDb createUninstallDb() {
		UninstallDbImpl uninstallDb = new UninstallDbImpl();
		return uninstallDb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlFileSet createSqlFileSet() {
		SqlFileSetImpl sqlFileSet = new SqlFileSetImpl();
		return sqlFileSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlResource createSqlResource() {
		SqlResourceImpl sqlResource = new SqlResourceImpl();
		return sqlResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSet createFileSet() {
		FileSetImpl fileSet = new FileSetImpl();
		return fileSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileResource createFileResource() {
		FileResourceImpl fileResource = new FileResourceImpl();
		return fileResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FolderResource createFolderResource() {
		FolderResourceImpl folderResource = new FolderResourceImpl();
		return folderResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageSet createLanguageSet() {
		LanguageSetImpl languageSet = new LanguageSetImpl();
		return languageSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageResource createLanguageResource() {
		LanguageResourceImpl languageResource = new LanguageResourceImpl();
		return languageResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaSet createMediaSet() {
		MediaSetImpl mediaSet = new MediaSetImpl();
		return mediaSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Administration createAdministration() {
		AdministrationImpl administration = new AdministrationImpl();
		return administration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuItem createMenuItem() {
		MenuItemImpl menuItem = new MenuItemImpl();
		return menuItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubMenu createSubMenu() {
		SubMenuImpl subMenu = new SubMenuImpl();
		return subMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManifestVersion createManifestVersionFromString(EDataType eDataType, String initialValue) {
		ManifestVersion result = ManifestVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertManifestVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManifestType createManifestTypeFromString(EDataType eDataType, String initialValue) {
		ManifestType result = ManifestType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertManifestTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaDestination createJoomlaDestinationFromString(EDataType eDataType, String initialValue) {
		JoomlaDestination result = JoomlaDestination.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJoomlaDestinationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionManifestPackage getJoomlaExtensionManifestPackage() {
		return (JoomlaExtensionManifestPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JoomlaExtensionManifestPackage getPackage() {
		return JoomlaExtensionManifestPackage.eINSTANCE;
	}

} //JoomlaExtensionManifestFactoryImpl
