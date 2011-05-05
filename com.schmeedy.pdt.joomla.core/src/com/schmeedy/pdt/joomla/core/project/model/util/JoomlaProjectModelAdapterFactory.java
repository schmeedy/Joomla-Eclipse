/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionResource;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage;
import com.schmeedy.pdt.joomla.core.project.model.MediaResource;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage
 * @generated
 */
public class JoomlaProjectModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JoomlaProjectModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaProjectModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = JoomlaProjectModelPackage.eINSTANCE;
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
	protected JoomlaProjectModelSwitch<Adapter> modelSwitch =
		new JoomlaProjectModelSwitch<Adapter>() {
			@Override
			public Adapter caseJoomlaExtensionProject(JoomlaExtensionProject object) {
				return createJoomlaExtensionProjectAdapter();
			}
			@Override
			public Adapter caseBasicExtensionModel(BasicExtensionModel object) {
				return createBasicExtensionModelAdapter();
			}
			@Override
			public Adapter caseExtensionResource(ExtensionResource object) {
				return createExtensionResourceAdapter();
			}
			@Override
			public Adapter caseMediaResource(MediaResource object) {
				return createMediaResourceAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject <em>Joomla Extension Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject
	 * @generated
	 */
	public Adapter createJoomlaExtensionProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel <em>Basic Extension Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel
	 * @generated
	 */
	public Adapter createBasicExtensionModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.core.project.model.ExtensionResource <em>Extension Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.core.project.model.ExtensionResource
	 * @generated
	 */
	public Adapter createExtensionResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.core.project.model.MediaResource <em>Media Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.core.project.model.MediaResource
	 * @generated
	 */
	public Adapter createMediaResourceAdapter() {
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

} //JoomlaProjectModelAdapterFactory
