/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.util;

import com.schmeedy.pdt.joomla.manifest.model.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResource;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.FileResource;
import com.schmeedy.pdt.joomla.manifest.model.FileSet;
import com.schmeedy.pdt.joomla.manifest.model.FolderResource;
import com.schmeedy.pdt.joomla.manifest.model.InstallDb;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.LanguageResource;
import com.schmeedy.pdt.joomla.manifest.model.LanguageSet;
import com.schmeedy.pdt.joomla.manifest.model.MediaSet;
import com.schmeedy.pdt.joomla.manifest.model.SqlFileSet;
import com.schmeedy.pdt.joomla.manifest.model.SqlResource;
import com.schmeedy.pdt.joomla.manifest.model.UninstallDb;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage
 * @generated
 */
public class JoomlaExtensionManifestAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JoomlaExtensionManifestPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaExtensionManifestAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = JoomlaExtensionManifestPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoomlaExtensionManifestSwitch<Adapter> modelSwitch =
		new JoomlaExtensionManifestSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractMultiResourceContainer(AbstractMultiResourceContainer object) {
				return createAbstractMultiResourceContainerAdapter();
			}
			@Override
			public Adapter caseJoomlaExtensionManifest(JoomlaExtensionManifest object) {
				return createJoomlaExtensionManifestAdapter();
			}
			@Override
			public Adapter caseInstallDb(InstallDb object) {
				return createInstallDbAdapter();
			}
			@Override
			public Adapter caseUninstallDb(UninstallDb object) {
				return createUninstallDbAdapter();
			}
			@Override
			public Adapter caseAbstractResource(AbstractResource object) {
				return createAbstractResourceAdapter();
			}
			@Override
			public Adapter caseAbstractResourceContainer(AbstractResourceContainer object) {
				return createAbstractResourceContainerAdapter();
			}
			@Override
			public Adapter caseSqlFileSet(SqlFileSet object) {
				return createSqlFileSetAdapter();
			}
			@Override
			public Adapter caseSqlResource(SqlResource object) {
				return createSqlResourceAdapter();
			}
			@Override
			public Adapter caseFileSet(FileSet object) {
				return createFileSetAdapter();
			}
			@Override
			public Adapter caseFileResource(FileResource object) {
				return createFileResourceAdapter();
			}
			@Override
			public Adapter caseFolderResource(FolderResource object) {
				return createFolderResourceAdapter();
			}
			@Override
			public Adapter caseLanguageSet(LanguageSet object) {
				return createLanguageSetAdapter();
			}
			@Override
			public Adapter caseLanguageResource(LanguageResource object) {
				return createLanguageResourceAdapter();
			}
			@Override
			public Adapter caseMediaSet(MediaSet object) {
				return createMediaSetAdapter();
			}
			@Override
			public Adapter caseAdministration(Administration object) {
				return createAdministrationAdapter();
			}
			@Override
			public Adapter caseMenuItem(MenuItem object) {
				return createMenuItemAdapter();
			}
			@Override
			public Adapter caseSubMenu(SubMenu object) {
				return createSubMenuAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer <em>Abstract Multi Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer
	 * @generated
	 */
	public Adapter createAbstractMultiResourceContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest <em>Joomla Extension Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest
	 * @generated
	 */
	public Adapter createJoomlaExtensionManifestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.InstallDb <em>Install Db</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.InstallDb
	 * @generated
	 */
	public Adapter createInstallDbAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.UninstallDb <em>Uninstall Db</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.UninstallDb
	 * @generated
	 */
	public Adapter createUninstallDbAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResource <em>Abstract Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractResource
	 * @generated
	 */
	public Adapter createAbstractResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer <em>Abstract Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer
	 * @generated
	 */
	public Adapter createAbstractResourceContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.SqlFileSet <em>Sql File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlFileSet
	 * @generated
	 */
	public Adapter createSqlFileSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.SqlResource <em>Sql Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SqlResource
	 * @generated
	 */
	public Adapter createSqlResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.FileSet <em>File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.FileSet
	 * @generated
	 */
	public Adapter createFileSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.FileResource
	 * @generated
	 */
	public Adapter createFileResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.FolderResource <em>Folder Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.FolderResource
	 * @generated
	 */
	public Adapter createFolderResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.LanguageSet <em>Language Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.LanguageSet
	 * @generated
	 */
	public Adapter createLanguageSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.LanguageResource <em>Language Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.LanguageResource
	 * @generated
	 */
	public Adapter createLanguageResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.MediaSet <em>Media Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MediaSet
	 * @generated
	 */
	public Adapter createMediaSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.Administration <em>Administration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.Administration
	 * @generated
	 */
	public Adapter createAdministrationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem <em>Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.MenuItem
	 * @generated
	 */
	public Adapter createMenuItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.manifest.model.SubMenu <em>Sub Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.manifest.model.SubMenu
	 * @generated
	 */
	public Adapter createSubMenuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //JoomlaExtensionManifestAdapterFactory
