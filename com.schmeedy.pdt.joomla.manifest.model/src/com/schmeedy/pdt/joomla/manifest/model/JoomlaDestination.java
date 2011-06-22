/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Joomla Destination</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage#getJoomlaDestination()
 * @model
 * @generated
 */
public enum JoomlaDestination implements Enumerator {
	/**
	 * The '<em><b>SITE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SITE_VALUE
	 * @generated
	 * @ordered
	 */
	SITE(0, "SITE", "site"),

	/**
	 * The '<em><b>ADMINISTRATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADMINISTRATION_VALUE
	 * @generated
	 * @ordered
	 */
	ADMINISTRATION(1, "ADMINISTRATION", "administrator");

	/**
	 * The '<em><b>SITE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SITE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SITE
	 * @model literal="site"
	 * @generated
	 * @ordered
	 */
	public static final int SITE_VALUE = 0;

	/**
	 * The '<em><b>ADMINISTRATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADMINISTRATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADMINISTRATION
	 * @model literal="administrator"
	 * @generated
	 * @ordered
	 */
	public static final int ADMINISTRATION_VALUE = 1;

	/**
	 * An array of all the '<em><b>Joomla Destination</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final JoomlaDestination[] VALUES_ARRAY =
		new JoomlaDestination[] {
			SITE,
			ADMINISTRATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Joomla Destination</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<JoomlaDestination> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Joomla Destination</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JoomlaDestination get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JoomlaDestination result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Joomla Destination</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JoomlaDestination getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JoomlaDestination result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Joomla Destination</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JoomlaDestination get(int value) {
		switch (value) {
			case SITE_VALUE: return SITE;
			case ADMINISTRATION_VALUE: return ADMINISTRATION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private JoomlaDestination(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //JoomlaDestination
