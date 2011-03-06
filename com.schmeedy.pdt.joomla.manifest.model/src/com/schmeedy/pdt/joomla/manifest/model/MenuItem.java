/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLabel <em>Label</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getAct <em>Act</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getTask <em>Task</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getController <em>Controller</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getView <em>View</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLayout <em>Layout</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getSub <em>Sub</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getImg <em>Img</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem()
 * @model extendedMetaData="kind='simple'"
 * @generated
 */
public interface MenuItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem_Label()
	 * @model extendedMetaData="kind='simple'"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Act</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Act</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Act</em>' attribute.
	 * @see #setAct(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem_Act()
	 * @model
	 * @generated
	 */
	String getAct();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getAct <em>Act</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Act</em>' attribute.
	 * @see #getAct()
	 * @generated
	 */
	void setAct(String value);

	/**
	 * Returns the value of the '<em><b>Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' attribute.
	 * @see #setTask(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem_Task()
	 * @model
	 * @generated
	 */
	String getTask();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getTask <em>Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' attribute.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(String value);

	/**
	 * Returns the value of the '<em><b>Controller</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controller</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controller</em>' attribute.
	 * @see #setController(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem_Controller()
	 * @model
	 * @generated
	 */
	String getController();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getController <em>Controller</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controller</em>' attribute.
	 * @see #getController()
	 * @generated
	 */
	void setController(String value);

	/**
	 * Returns the value of the '<em><b>View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View</em>' attribute.
	 * @see #setView(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem_View()
	 * @model
	 * @generated
	 */
	String getView();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getView <em>View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View</em>' attribute.
	 * @see #getView()
	 * @generated
	 */
	void setView(String value);

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' attribute.
	 * @see #setLayout(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem_Layout()
	 * @model
	 * @generated
	 */
	String getLayout();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLayout <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' attribute.
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(String value);

	/**
	 * Returns the value of the '<em><b>Sub</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub</em>' attribute.
	 * @see #setSub(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem_Sub()
	 * @model
	 * @generated
	 */
	String getSub();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getSub <em>Sub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub</em>' attribute.
	 * @see #getSub()
	 * @generated
	 */
	void setSub(String value);

	/**
	 * Returns the value of the '<em><b>Img</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Img</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Img</em>' attribute.
	 * @see #setImg(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem_Img()
	 * @model
	 * @generated
	 */
	String getImg();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getImg <em>Img</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Img</em>' attribute.
	 * @see #getImg()
	 * @generated
	 */
	void setImg(String value);

	/**
	 * Returns the value of the '<em><b>Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' attribute.
	 * @see #setLink(String)
	 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getMenuItem_Link()
	 * @model
	 * @generated
	 */
	String getLink();

	/**
	 * Sets the value of the '{@link com.schmeedy.pdt.joomla.manifest.model.MenuItem#getLink <em>Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' attribute.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(String value);

} // MenuItem
