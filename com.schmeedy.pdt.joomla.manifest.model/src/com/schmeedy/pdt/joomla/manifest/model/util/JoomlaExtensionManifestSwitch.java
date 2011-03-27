/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResource;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.Administration;
import com.schmeedy.pdt.joomla.manifest.model.FileResource;
import com.schmeedy.pdt.joomla.manifest.model.FileSet;
import com.schmeedy.pdt.joomla.manifest.model.FolderResource;
import com.schmeedy.pdt.joomla.manifest.model.InstallDb;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.LanguageResource;
import com.schmeedy.pdt.joomla.manifest.model.LanguageSet;
import com.schmeedy.pdt.joomla.manifest.model.MediaSet;
import com.schmeedy.pdt.joomla.manifest.model.MenuItem;
import com.schmeedy.pdt.joomla.manifest.model.SqlFileSet;
import com.schmeedy.pdt.joomla.manifest.model.SqlResource;
import com.schmeedy.pdt.joomla.manifest.model.SubMenu;
import com.schmeedy.pdt.joomla.manifest.model.UninstallDb;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage
 * @generated
 */
public class JoomlaExtensionManifestSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JoomlaExtensionManifestPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionManifestSwitch() {
		if (modelPackage == null) {
			modelPackage = JoomlaExtensionManifestPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER: {
				AbstractMultiResourceContainer abstractMultiResourceContainer = (AbstractMultiResourceContainer)theEObject;
				T result = caseAbstractMultiResourceContainer(abstractMultiResourceContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.JOOMLA_EXTENSION_MANIFEST: {
				JoomlaExtensionManifest joomlaExtensionManifest = (JoomlaExtensionManifest)theEObject;
				T result = caseJoomlaExtensionManifest(joomlaExtensionManifest);
				if (result == null) result = caseAbstractMultiResourceContainer(joomlaExtensionManifest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.INSTALL_DB: {
				InstallDb installDb = (InstallDb)theEObject;
				T result = caseInstallDb(installDb);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.UNINSTALL_DB: {
				UninstallDb uninstallDb = (UninstallDb)theEObject;
				T result = caseUninstallDb(uninstallDb);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE: {
				AbstractResource abstractResource = (AbstractResource)theEObject;
				T result = caseAbstractResource(abstractResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER: {
				AbstractResourceContainer abstractResourceContainer = (AbstractResourceContainer)theEObject;
				T result = caseAbstractResourceContainer(abstractResourceContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.SQL_FILE_SET: {
				SqlFileSet sqlFileSet = (SqlFileSet)theEObject;
				T result = caseSqlFileSet(sqlFileSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.SQL_RESOURCE: {
				SqlResource sqlResource = (SqlResource)theEObject;
				T result = caseSqlResource(sqlResource);
				if (result == null) result = caseAbstractResource(sqlResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.FILE_SET: {
				FileSet fileSet = (FileSet)theEObject;
				T result = caseFileSet(fileSet);
				if (result == null) result = caseAbstractResourceContainer(fileSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.FILE_RESOURCE: {
				FileResource fileResource = (FileResource)theEObject;
				T result = caseFileResource(fileResource);
				if (result == null) result = caseAbstractResource(fileResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.FOLDER_RESOURCE: {
				FolderResource folderResource = (FolderResource)theEObject;
				T result = caseFolderResource(folderResource);
				if (result == null) result = caseAbstractResource(folderResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.LANGUAGE_SET: {
				LanguageSet languageSet = (LanguageSet)theEObject;
				T result = caseLanguageSet(languageSet);
				if (result == null) result = caseAbstractResourceContainer(languageSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.LANGUAGE_RESOURCE: {
				LanguageResource languageResource = (LanguageResource)theEObject;
				T result = caseLanguageResource(languageResource);
				if (result == null) result = caseAbstractResource(languageResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.MEDIA_SET: {
				MediaSet mediaSet = (MediaSet)theEObject;
				T result = caseMediaSet(mediaSet);
				if (result == null) result = caseAbstractResourceContainer(mediaSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.ADMINISTRATION: {
				Administration administration = (Administration)theEObject;
				T result = caseAdministration(administration);
				if (result == null) result = caseAbstractMultiResourceContainer(administration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.MENU_ITEM: {
				MenuItem menuItem = (MenuItem)theEObject;
				T result = caseMenuItem(menuItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JoomlaExtensionManifestPackage.SUB_MENU: {
				SubMenu subMenu = (SubMenu)theEObject;
				T result = caseSubMenu(subMenu);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Multi Resource Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Multi Resource Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractMultiResourceContainer(AbstractMultiResourceContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Joomla Extension Manifest</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Joomla Extension Manifest</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoomlaExtensionManifest(JoomlaExtensionManifest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Install Db</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Install Db</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstallDb(InstallDb object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uninstall Db</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uninstall Db</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUninstallDb(UninstallDb object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractResource(AbstractResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Resource Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Resource Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractResourceContainer(AbstractResourceContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sql File Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sql File Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSqlFileSet(SqlFileSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sql Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sql Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSqlResource(SqlResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileSet(FileSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileResource(FileResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolderResource(FolderResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguageSet(LanguageSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguageResource(LanguageResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Media Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Media Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediaSet(MediaSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Administration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Administration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdministration(Administration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuItem(MenuItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Menu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Menu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubMenu(SubMenu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //JoomlaExtensionManifestSwitch
