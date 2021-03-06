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
package gov.redhawk.sca.internal.ui;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;

import gov.redhawk.model.sca.ScaFactory;
import gov.redhawk.model.sca.ScaNegotiatedConnection;
import gov.redhawk.model.sca.ScaPackage;
import gov.redhawk.model.sca.commands.ScaModelCommand;
import gov.redhawk.sca.internal.ui.dialogs.TransportDetailsDialog;
import gov.redhawk.sca.ui.RedhawkUiAdapterFactory;

public class ScaNegotiatedConnectionAdapterFactory extends RedhawkUiAdapterFactory {

	public static class ConnectionTransportDetailsPropertyDescriptor extends PropertyDescriptor {

		public ConnectionTransportDetailsPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
			super(object, itemPropertyDescriptor);
		}

		@Override
		public CellEditor createPropertyEditor(final Composite composite) {
			return new DialogCellEditor(composite) {

				@Override
				protected Object openDialogBox(Control cellEditorWindow) {
					// Clone the object so we don't have to worry about model changes
					ScaNegotiatedConnection connection = (ScaNegotiatedConnection) object;
					ScaNegotiatedConnection connectionCopy = ScaModelCommand.runExclusive(connection, () -> {
						ScaNegotiatedConnection copy = ScaFactory.eINSTANCE.createScaNegotiatedConnection();
						copy.setTransportType(connection.getTransportType());
						copy.getTransportInfo().addAll(EcoreUtil.copyAll(connection.getTransportInfo()));
						return copy;
					});
					new TransportDetailsDialog(cellEditorWindow.getShell(), connectionCopy).open();
					return null;
				}

				@Override
				protected void updateContents(Object value) {
					getDefaultLabel().setText(getEditLabelProvider().getText(value));
				}
			};
		}
	}

	public static class ScaNegotiatedConnectionPropertySource extends ScaPropertySource {

		public ScaNegotiatedConnectionPropertySource(final Object object, final IItemPropertySource itemPropertySource) {
			super(object, itemPropertySource);
		}

		@Override
		protected IPropertyDescriptor createPropertyDescriptor(final IItemPropertyDescriptor itemPropertyDescriptor) {
			if (itemPropertyDescriptor.getFeature(this.object) == ScaPackage.Literals.SCA_NEGOTIATED_CONNECTION__TRANSPORT_TYPE
				|| itemPropertyDescriptor.getFeature(this.object) == ScaPackage.Literals.SCA_NEGOTIATED_CONNECTION__TRANSPORT_INFO) {
				return new ConnectionTransportDetailsPropertyDescriptor(this.object, itemPropertyDescriptor);
			} else {
				return super.createPropertyDescriptor(itemPropertyDescriptor);
			}
		}

	}

	@Override
	protected IPropertySource2 createPropertySource(final Object adaptableObject, final IItemPropertySource itemPropertySource) {
		return new ScaNegotiatedConnectionPropertySource(adaptableObject, itemPropertySource);
	}
}
