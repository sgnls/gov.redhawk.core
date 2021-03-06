/**
 * This file is protected by Copyright. 
 * Please refer to the COPYRIGHT file distributed with this source distribution.
 * 
 * This file is part of REDHAWK IDE.
 * 
 * All rights reserved.  This program and the accompanying materials are made available under 
 * the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
 *
 */
package gov.redhawk.prf.ui.wizard;

import mil.jpeojtrs.sca.prf.Enumeration;

import org.eclipse.jface.wizard.Wizard;

/**
 * @since 4.0
 */
public class EnumerationWizard extends Wizard {

	private final EnumerationWizardPage page;

	public EnumerationWizard() {
		this.page = new EnumerationWizardPage();
		this.setWindowTitle("Enumeration Wizard");
	}

	@Override
	public void addPages() {
		this.addPage(this.page);
	}

	@Override
	public boolean performFinish() {
		return true;
	}

	public Enumeration getEnumeration() {
		return this.page.getEnumeration();
	}

	public void setEnumeration(final Enumeration enumeration) {
		this.page.setEnumeration(enumeration);
	}

}
