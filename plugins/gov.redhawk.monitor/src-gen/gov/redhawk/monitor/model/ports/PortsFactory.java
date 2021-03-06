/*******************************************************************************
 * This file is protected by Copyright. 
 * Please refer to the COPYRIGHT file distributed with this source distribution.
 *
 * This file is part of REDHAWK IDE.
 *
 * All rights reserved.  This program and the accompanying materials are made available under 
 * the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// BEGIN GENERATED CODE
package gov.redhawk.monitor.model.ports;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.redhawk.monitor.model.ports.PortsPackage
 * @generated
 */
public interface PortsFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PortsFactory eINSTANCE = gov.redhawk.monitor.model.ports.impl.PortsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Port Monitor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Monitor</em>'.
	 * @generated
	 */
	PortMonitor createPortMonitor();

	/**
	 * Returns a new object of class '<em>Port Connection Monitor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Connection Monitor</em>'.
	 * @generated
	 */
	PortConnectionMonitor createPortConnectionMonitor();

	/**
	 * Returns a new object of class '<em>Monitor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Monitor Registry</em>'.
	 * @generated
	 */
	MonitorRegistry createMonitorRegistry();

	/**
	 * Returns a new object of class '<em>Port Supplier Monitor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Supplier Monitor</em>'.
	 * @generated
	 */
	PortSupplierMonitor createPortSupplierMonitor();

	/**
	 * Returns a new object of class '<em>Port Statistics Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Statistics Provider</em>'.
	 * @generated
	 */
	PortStatisticsProvider createPortStatisticsProvider();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PortsPackage getPortsPackage();

} // PortsFactory
