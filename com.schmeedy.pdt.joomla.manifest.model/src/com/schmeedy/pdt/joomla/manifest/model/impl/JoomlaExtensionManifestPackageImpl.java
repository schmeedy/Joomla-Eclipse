/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResource;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.Administration;
import com.schmeedy.pdt.joomla.manifest.model.FileResource;
import com.schmeedy.pdt.joomla.manifest.model.FileSet;
import com.schmeedy.pdt.joomla.manifest.model.FolderResource;
import com.schmeedy.pdt.joomla.manifest.model.InstallDb;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JoomlaExtensionManifestPackageImpl extends EPackageImpl implements JoomlaExtensionManifestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMultiResourceContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joomlaExtensionManifestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass installDbEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uninstallDbEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractResourceContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlFileSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass languageSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass languageResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediaSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass administrationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass menuItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subMenuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum manifestVersionEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum manifestTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JoomlaExtensionManifestPackageImpl() {
		super(eNS_URI, JoomlaExtensionManifestFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JoomlaExtensionManifestPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JoomlaExtensionManifestPackage init() {
		if (isInited) return (JoomlaExtensionManifestPackage)EPackage.Registry.INSTANCE.getEPackage(JoomlaExtensionManifestPackage.eNS_URI);

		// Obtain or create and register package
		JoomlaExtensionManifestPackageImpl theJoomlaExtensionManifestPackage = (JoomlaExtensionManifestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JoomlaExtensionManifestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JoomlaExtensionManifestPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theJoomlaExtensionManifestPackage.createPackageContents();

		// Initialize created meta-data
		theJoomlaExtensionManifestPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJoomlaExtensionManifestPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JoomlaExtensionManifestPackage.eNS_URI, theJoomlaExtensionManifestPackage);
		return theJoomlaExtensionManifestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMultiResourceContainer() {
		return abstractMultiResourceContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMultiResourceContainer_FileSets() {
		return (EReference)abstractMultiResourceContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMultiResourceContainer_LanguageSets() {
		return (EReference)abstractMultiResourceContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMultiResourceContainer_MediaSets() {
		return (EReference)abstractMultiResourceContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoomlaExtensionManifest() {
		return joomlaExtensionManifestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_ManifestVersion() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_ManifestType() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Name() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_CreationDate() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Author() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_AuthorEmail() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_AuthorUrl() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Copyright() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_License() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Version() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_Description() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_InstallFile() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoomlaExtensionManifest_UninstallFile() {
		return (EAttribute)joomlaExtensionManifestEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJoomlaExtensionManifest_Install() {
		return (EReference)joomlaExtensionManifestEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJoomlaExtensionManifest_Uninstall() {
		return (EReference)joomlaExtensionManifestEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJoomlaExtensionManifest_Administration() {
		return (EReference)joomlaExtensionManifestEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstallDb() {
		return installDbEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstallDb_Sql() {
		return (EReference)installDbEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUninstallDb() {
		return uninstallDbEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUninstallDb_Sql() {
		return (EReference)uninstallDbEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractResource() {
		return abstractResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractResource_Path() {
		return (EAttribute)abstractResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractResourceContainer() {
		return abstractResourceContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractResourceContainer_BaseFolder() {
		return (EAttribute)abstractResourceContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlFileSet() {
		return sqlFileSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSqlFileSet_Files() {
		return (EReference)sqlFileSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlResource() {
		return sqlResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlResource_Driver() {
		return (EAttribute)sqlResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlResource_Charset() {
		return (EAttribute)sqlResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileSet() {
		return fileSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFileSet_Files() {
		return (EReference)fileSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFileSet_Folders() {
		return (EReference)fileSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileResource() {
		return fileResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolderResource() {
		return folderResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLanguageSet() {
		return languageSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageSet_Resources() {
		return (EReference)languageSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLanguageResource() {
		return languageResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLanguageResource_Tag() {
		return (EAttribute)languageResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediaSet() {
		return mediaSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaSet_Destination() {
		return (EAttribute)mediaSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediaSet_Files() {
		return (EReference)mediaSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdministration() {
		return administrationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdministration_Menu() {
		return (EReference)administrationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdministration_SubMenu() {
		return (EReference)administrationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMenuItem() {
		return menuItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Label() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Act() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Task() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Controller() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_View() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Layout() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Sub() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Img() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMenuItem_Link() {
		return (EAttribute)menuItemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubMenu() {
		return subMenuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubMenu_MenuItems() {
		return (EReference)subMenuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getManifestVersion() {
		return manifestVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getManifestType() {
		return manifestTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionManifestFactory getJoomlaExtensionManifestFactory() {
		return (JoomlaExtensionManifestFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractMultiResourceContainerEClass = createEClass(ABSTRACT_MULTI_RESOURCE_CONTAINER);
		createEReference(abstractMultiResourceContainerEClass, ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS);
		createEReference(abstractMultiResourceContainerEClass, ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS);
		createEReference(abstractMultiResourceContainerEClass, ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS);

		joomlaExtensionManifestEClass = createEClass(JOOMLA_EXTENSION_MANIFEST);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__MANIFEST_TYPE);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__MANIFEST_VERSION);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__NAME);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__CREATION_DATE);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__AUTHOR);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__AUTHOR_EMAIL);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__AUTHOR_URL);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__COPYRIGHT);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__LICENSE);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__VERSION);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__DESCRIPTION);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__INSTALL_FILE);
		createEAttribute(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__UNINSTALL_FILE);
		createEReference(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__INSTALL);
		createEReference(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__UNINSTALL);
		createEReference(joomlaExtensionManifestEClass, JOOMLA_EXTENSION_MANIFEST__ADMINISTRATION);

		installDbEClass = createEClass(INSTALL_DB);
		createEReference(installDbEClass, INSTALL_DB__SQL);

		uninstallDbEClass = createEClass(UNINSTALL_DB);
		createEReference(uninstallDbEClass, UNINSTALL_DB__SQL);

		abstractResourceEClass = createEClass(ABSTRACT_RESOURCE);
		createEAttribute(abstractResourceEClass, ABSTRACT_RESOURCE__PATH);

		abstractResourceContainerEClass = createEClass(ABSTRACT_RESOURCE_CONTAINER);
		createEAttribute(abstractResourceContainerEClass, ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER);

		sqlFileSetEClass = createEClass(SQL_FILE_SET);
		createEReference(sqlFileSetEClass, SQL_FILE_SET__FILES);

		sqlResourceEClass = createEClass(SQL_RESOURCE);
		createEAttribute(sqlResourceEClass, SQL_RESOURCE__DRIVER);
		createEAttribute(sqlResourceEClass, SQL_RESOURCE__CHARSET);

		fileSetEClass = createEClass(FILE_SET);
		createEReference(fileSetEClass, FILE_SET__FILES);
		createEReference(fileSetEClass, FILE_SET__FOLDERS);

		fileResourceEClass = createEClass(FILE_RESOURCE);

		folderResourceEClass = createEClass(FOLDER_RESOURCE);

		languageSetEClass = createEClass(LANGUAGE_SET);
		createEReference(languageSetEClass, LANGUAGE_SET__RESOURCES);

		languageResourceEClass = createEClass(LANGUAGE_RESOURCE);
		createEAttribute(languageResourceEClass, LANGUAGE_RESOURCE__TAG);

		mediaSetEClass = createEClass(MEDIA_SET);
		createEAttribute(mediaSetEClass, MEDIA_SET__DESTINATION);
		createEReference(mediaSetEClass, MEDIA_SET__FILES);

		administrationEClass = createEClass(ADMINISTRATION);
		createEReference(administrationEClass, ADMINISTRATION__MENU);
		createEReference(administrationEClass, ADMINISTRATION__SUB_MENU);

		menuItemEClass = createEClass(MENU_ITEM);
		createEAttribute(menuItemEClass, MENU_ITEM__LABEL);
		createEAttribute(menuItemEClass, MENU_ITEM__ACT);
		createEAttribute(menuItemEClass, MENU_ITEM__TASK);
		createEAttribute(menuItemEClass, MENU_ITEM__CONTROLLER);
		createEAttribute(menuItemEClass, MENU_ITEM__VIEW);
		createEAttribute(menuItemEClass, MENU_ITEM__LAYOUT);
		createEAttribute(menuItemEClass, MENU_ITEM__SUB);
		createEAttribute(menuItemEClass, MENU_ITEM__IMG);
		createEAttribute(menuItemEClass, MENU_ITEM__LINK);

		subMenuEClass = createEClass(SUB_MENU);
		createEReference(subMenuEClass, SUB_MENU__MENU_ITEMS);

		// Create enums
		manifestVersionEEnum = createEEnum(MANIFEST_VERSION);
		manifestTypeEEnum = createEEnum(MANIFEST_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		joomlaExtensionManifestEClass.getESuperTypes().add(this.getAbstractMultiResourceContainer());
		sqlResourceEClass.getESuperTypes().add(this.getAbstractResource());
		fileSetEClass.getESuperTypes().add(this.getAbstractResourceContainer());
		fileResourceEClass.getESuperTypes().add(this.getAbstractResource());
		folderResourceEClass.getESuperTypes().add(this.getAbstractResource());
		languageSetEClass.getESuperTypes().add(this.getAbstractResourceContainer());
		languageResourceEClass.getESuperTypes().add(this.getAbstractResource());
		mediaSetEClass.getESuperTypes().add(this.getAbstractResourceContainer());
		administrationEClass.getESuperTypes().add(this.getAbstractMultiResourceContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractMultiResourceContainerEClass, AbstractMultiResourceContainer.class, "AbstractMultiResourceContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMultiResourceContainer_FileSets(), this.getFileSet(), null, "fileSets", null, 0, -1, AbstractMultiResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractMultiResourceContainer_LanguageSets(), this.getLanguageSet(), null, "languageSets", null, 0, -1, AbstractMultiResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractMultiResourceContainer_MediaSets(), this.getMediaSet(), null, "mediaSets", null, 0, -1, AbstractMultiResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(joomlaExtensionManifestEClass, JoomlaExtensionManifest.class, "JoomlaExtensionManifest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJoomlaExtensionManifest_ManifestType(), this.getManifestType(), "manifestType", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_ManifestVersion(), this.getManifestVersion(), "manifestVersion", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Name(), ecorePackage.getEString(), "name", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_CreationDate(), ecorePackage.getEString(), "creationDate", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Author(), ecorePackage.getEString(), "author", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_AuthorEmail(), ecorePackage.getEString(), "authorEmail", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_AuthorUrl(), ecorePackage.getEString(), "authorUrl", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Copyright(), ecorePackage.getEString(), "copyright", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_License(), ecorePackage.getEString(), "license", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Version(), ecorePackage.getEString(), "version", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_Description(), ecorePackage.getEString(), "description", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_InstallFile(), ecorePackage.getEString(), "installFile", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoomlaExtensionManifest_UninstallFile(), ecorePackage.getEString(), "uninstallFile", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJoomlaExtensionManifest_Install(), this.getInstallDb(), null, "install", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJoomlaExtensionManifest_Uninstall(), this.getUninstallDb(), null, "uninstall", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJoomlaExtensionManifest_Administration(), this.getAdministration(), null, "administration", null, 0, 1, JoomlaExtensionManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(installDbEClass, InstallDb.class, "InstallDb", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstallDb_Sql(), this.getSqlFileSet(), null, "sql", null, 0, 1, InstallDb.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uninstallDbEClass, UninstallDb.class, "UninstallDb", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUninstallDb_Sql(), this.getSqlFileSet(), null, "sql", null, 0, 1, UninstallDb.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractResourceEClass, AbstractResource.class, "AbstractResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractResource_Path(), ecorePackage.getEString(), "path", null, 0, 1, AbstractResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractResourceContainerEClass, AbstractResourceContainer.class, "AbstractResourceContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractResourceContainer_BaseFolder(), ecorePackage.getEString(), "baseFolder", null, 0, 1, AbstractResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlFileSetEClass, SqlFileSet.class, "SqlFileSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSqlFileSet_Files(), this.getSqlResource(), null, "files", null, 0, -1, SqlFileSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlResourceEClass, SqlResource.class, "SqlResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSqlResource_Driver(), ecorePackage.getEString(), "driver", null, 0, 1, SqlResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlResource_Charset(), ecorePackage.getEString(), "charset", null, 0, 1, SqlResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileSetEClass, FileSet.class, "FileSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFileSet_Files(), this.getFileResource(), null, "files", null, 0, -1, FileSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFileSet_Folders(), this.getFolderResource(), null, "folders", null, 0, -1, FileSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileResourceEClass, FileResource.class, "FileResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(folderResourceEClass, FolderResource.class, "FolderResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(languageSetEClass, LanguageSet.class, "LanguageSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLanguageSet_Resources(), this.getLanguageResource(), null, "resources", null, 1, -1, LanguageSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(languageResourceEClass, LanguageResource.class, "LanguageResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLanguageResource_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, LanguageResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediaSetEClass, MediaSet.class, "MediaSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMediaSet_Destination(), ecorePackage.getEString(), "destination", null, 0, 1, MediaSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMediaSet_Files(), this.getFileResource(), null, "files", null, 0, -1, MediaSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(administrationEClass, Administration.class, "Administration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdministration_Menu(), this.getMenuItem(), null, "menu", null, 0, 1, Administration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdministration_SubMenu(), this.getSubMenu(), null, "subMenu", null, 0, 1, Administration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(menuItemEClass, MenuItem.class, "MenuItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMenuItem_Label(), ecorePackage.getEString(), "label", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuItem_Act(), ecorePackage.getEString(), "act", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuItem_Task(), ecorePackage.getEString(), "task", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuItem_Controller(), ecorePackage.getEString(), "controller", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuItem_View(), ecorePackage.getEString(), "view", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuItem_Layout(), ecorePackage.getEString(), "layout", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuItem_Sub(), ecorePackage.getEString(), "sub", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuItem_Img(), ecorePackage.getEString(), "img", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMenuItem_Link(), ecorePackage.getEString(), "link", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subMenuEClass, SubMenu.class, "SubMenu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubMenu_MenuItems(), this.getMenuItem(), null, "menuItems", null, 1, -1, SubMenu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(manifestVersionEEnum, ManifestVersion.class, "ManifestVersion");
		addEEnumLiteral(manifestVersionEEnum, ManifestVersion.UNKNOWN);
		addEEnumLiteral(manifestVersionEEnum, ManifestVersion.ONE_FIVE);
		addEEnumLiteral(manifestVersionEEnum, ManifestVersion.ONE_SIX);

		initEEnum(manifestTypeEEnum, ManifestType.class, "ManifestType");
		addEEnumLiteral(manifestTypeEEnum, ManifestType.UNKNOWN);
		addEEnumLiteral(manifestTypeEEnum, ManifestType.COMPONENT);
		addEEnumLiteral(manifestTypeEEnum, ManifestType.PLUGIN);
		addEEnumLiteral(manifestTypeEEnum, ManifestType.MODULE);
		addEEnumLiteral(manifestTypeEEnum, ManifestType.TEMPLATE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (getAbstractMultiResourceContainer_FileSets(), 
		   source, 
		   new String[] {
			 "name", "files",
			 "kind", "element"
		   });		
		addAnnotation
		  (getAbstractMultiResourceContainer_LanguageSets(), 
		   source, 
		   new String[] {
			 "name", "languages",
			 "kind", "element"
		   });		
		addAnnotation
		  (getAbstractMultiResourceContainer_MediaSets(), 
		   source, 
		   new String[] {
			 "name", "media",
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_ManifestType(), 
		   source, 
		   new String[] {
			 "name", "type",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_ManifestVersion(), 
		   source, 
		   new String[] {
			 "name", "version",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Name(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_CreationDate(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Author(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_AuthorEmail(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_AuthorUrl(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Copyright(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_License(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Version(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Description(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_InstallFile(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "installfile"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_UninstallFile(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "uninstallfile"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Install(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Uninstall(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getJoomlaExtensionManifest_Administration(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getInstallDb_Sql(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getUninstallDb_Sql(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (abstractResourceEClass, 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (getAbstractResource_Path(), 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (getAbstractResourceContainer_BaseFolder(), 
		   source, 
		   new String[] {
			 "name", "folder",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getSqlFileSet_Files(), 
		   source, 
		   new String[] {
			 "name", "file",
			 "kind", "element"
		   });		
		addAnnotation
		  (sqlResourceEClass, 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (getSqlResource_Driver(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getSqlResource_Charset(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getFileSet_Files(), 
		   source, 
		   new String[] {
			 "name", "filename",
			 "kind", "element"
		   });		
		addAnnotation
		  (getFileSet_Folders(), 
		   source, 
		   new String[] {
			 "name", "folder",
			 "kind", "element"
		   });		
		addAnnotation
		  (fileResourceEClass, 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (folderResourceEClass, 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (getLanguageSet_Resources(), 
		   source, 
		   new String[] {
			 "name", "language",
			 "kind", "element"
		   });		
		addAnnotation
		  (languageResourceEClass, 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (getLanguageResource_Tag(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMediaSet_Destination(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMediaSet_Files(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getAdministration_Menu(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getAdministration_SubMenu(), 
		   source, 
		   new String[] {
			 "name", "submenu",
			 "kind", "element"
		   });		
		addAnnotation
		  (menuItemEClass, 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (getMenuItem_Label(), 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (getMenuItem_Act(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMenuItem_Task(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMenuItem_Controller(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMenuItem_View(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMenuItem_Layout(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMenuItem_Sub(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMenuItem_Img(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMenuItem_Link(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getSubMenu_MenuItems(), 
		   source, 
		   new String[] {
			 "name", "menu",
			 "kind", "element"
		   });
	}

} //JoomlaExtensionManifestPackageImpl
