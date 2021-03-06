/**
 * This file is protected by Copyright.
 * Please refer to the COPYRIGHT file distributed with this source distribution.
 *
 * This file is part of REDHAWK IDE.
 *
 * All rights reserved.  This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
 */
// BEGIN GENERATED CODE
package gov.redhawk.ui.views.allocmgr.util;

import CF.AllocationManagerOperations;
import gov.redhawk.model.sca.CorbaObjWrapper;
import gov.redhawk.model.sca.DataProviderObject;
import gov.redhawk.model.sca.IDisposable;
import gov.redhawk.model.sca.IRefreshable;
import gov.redhawk.model.sca.IStatusProvider;
import gov.redhawk.ui.views.allocmgr.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gov.redhawk.ui.views.allocmgr.AllocMgrPackage
 * @generated
 */
public class AllocMgrAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AllocMgrPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocMgrAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AllocMgrPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance
	 * object of the model.
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
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocMgrSwitch<Adapter> modelSwitch = new AllocMgrSwitch<Adapter>() {
		@Override
		public Adapter caseScaAllocationManager(ScaAllocationManager object) {
			return createScaAllocationManagerAdapter();
		}

		@Override
		public Adapter caseAllocationStatus(AllocationStatus object) {
			return createAllocationStatusAdapter();
		}

		@Override
		public Adapter caseIStatusProvider(IStatusProvider object) {
			return createIStatusProviderAdapter();
		}

		@Override
		public Adapter caseIDisposable(IDisposable object) {
			return createIDisposableAdapter();
		}

		@Override
		public Adapter caseIRefreshable(IRefreshable object) {
			return createIRefreshableAdapter();
		}

		@Override
		public Adapter caseDataProviderObject(DataProviderObject object) {
			return createDataProviderObjectAdapter();
		}

		@Override
		public < T extends org.omg.CORBA.Object > Adapter caseCorbaObjWrapper(CorbaObjWrapper<T> object) {
			return createCorbaObjWrapperAdapter();
		}

		@Override
		public Adapter caseAllocationManagerOperations(AllocationManagerOperations object) {
			return createAllocationManagerOperationsAdapter();
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
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.redhawk.ui.views.allocmgr.ScaAllocationManager <em>Sca
	 * Allocation Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.redhawk.ui.views.allocmgr.ScaAllocationManager
	 * @generated
	 */
	public Adapter createScaAllocationManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.redhawk.ui.views.allocmgr.AllocationStatus
	 * <em>Allocation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.redhawk.ui.views.allocmgr.AllocationStatus
	 * @generated
	 */
	public Adapter createAllocationStatusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.redhawk.model.sca.IStatusProvider <em>IStatus
	 * Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.redhawk.model.sca.IStatusProvider
	 * @generated
	 */
	public Adapter createIStatusProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.redhawk.model.sca.IDisposable <em>IDisposable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.redhawk.model.sca.IDisposable
	 * @generated
	 */
	public Adapter createIDisposableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.redhawk.model.sca.IRefreshable <em>IRefreshable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.redhawk.model.sca.IRefreshable
	 * @generated
	 */
	public Adapter createIRefreshableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.redhawk.model.sca.DataProviderObject <em>Data Provider
	 * Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.redhawk.model.sca.DataProviderObject
	 * @generated
	 */
	public Adapter createDataProviderObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.redhawk.model.sca.CorbaObjWrapper <em>Corba Obj
	 * Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.redhawk.model.sca.CorbaObjWrapper
	 * @generated
	 */
	public Adapter createCorbaObjWrapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CF.AllocationManagerOperations <em>Allocation Manager
	 * Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CF.AllocationManagerOperations
	 * @generated
	 */
	public Adapter createAllocationManagerOperationsAdapter() {
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

} // AllocMgrAdapterFactory
