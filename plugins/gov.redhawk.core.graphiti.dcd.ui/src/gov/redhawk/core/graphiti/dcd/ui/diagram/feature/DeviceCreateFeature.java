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
package gov.redhawk.core.graphiti.dcd.ui.diagram.feature;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import gov.redhawk.core.graphiti.dcd.ui.diagram.providers.DeviceManagerImageProvider;
import gov.redhawk.core.graphiti.dcd.ui.ext.DeviceShape;
import gov.redhawk.core.graphiti.dcd.ui.utils.DCDUtils;
import gov.redhawk.core.graphiti.ui.diagram.features.AbstractCreateInstantiationFeature;
import gov.redhawk.core.graphiti.ui.util.DUtil;
import mil.jpeojtrs.sca.dcd.DcdComponentInstantiation;
import mil.jpeojtrs.sca.dcd.DeviceConfiguration;
import mil.jpeojtrs.sca.spd.SoftPkg;

public class DeviceCreateFeature extends AbstractCreateInstantiationFeature {

	public static final String SHAPE_TYPE = "deviceShape";
	public static final String OVERRIDE_USAGE_NAME = "OverrideUsageName";
	public static final String OVERRIDE_INSTANTIATION_ID = "OverrideInstantiationId";
	public static final String OVERRIDE_IMPLEMENTATION_ID = "OverrideImplementationId";

	@Override
	public String getDescription() {
		// Provides the context menu Undo/Redo description
		return "Add Device to Diagram";
	}

	public DeviceCreateFeature(IFeatureProvider fp, SoftPkg spd, String implId) {
		super(fp, spd, implId);
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (context.getTargetContainer() instanceof Diagram) {
			return true;
		}
		return false;
	}

	@Override
	public Object[] create(ICreateContext context) {
		if (getSoftPkg() == null) {
			// TODO: return some kind of error
			return null;
		}

		// collect overrides (currently used by GraphitiDcdModelMap)
		final String usageName = (String) context.getProperty(OVERRIDE_USAGE_NAME);
		final String instantiationId = (String) context.getProperty(OVERRIDE_INSTANTIATION_ID);
		final String implementationId = (String) context.getProperty(OVERRIDE_IMPLEMENTATION_ID);

		// editing domain for our transaction
		TransactionalEditingDomain editingDomain = getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getEditingDomain();

		// Get dcd from diagram
		final DeviceConfiguration dcd = DUtil.getDiagramDCD(getDiagram());

		// container for new component instantiation, necessary for reference after command execution
		final DcdComponentInstantiation[] componentInstantiations = new DcdComponentInstantiation[1];

		// Create Device related objects in DCD model
		TransactionalCommandStack stack = (TransactionalCommandStack) editingDomain.getCommandStack();
		stack.execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				componentInstantiations[0] = DCDUtils.createComponentInstantiation(getSoftPkg(), dcd, usageName, instantiationId, implementationId);
			}
		});

		// Call add feature
		context.putProperty("shapeType", SHAPE_TYPE);
		DeviceShape shape = (DeviceShape) addGraphicalRepresentation(context, componentInstantiations[0]);

		if (DUtil.isDiagramRuntime(getDiagram())) {
			shape.setEnabled(false);
		}

		return new Object[] { componentInstantiations[0] };
	}

	@Override
	public String getCreateImageId() {
		return DeviceManagerImageProvider.IMG_DEVICE;
	}
}
