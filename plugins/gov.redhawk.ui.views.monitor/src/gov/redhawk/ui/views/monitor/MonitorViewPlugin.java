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
package gov.redhawk.ui.views.monitor;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.FrameworkUtil;

public class MonitorViewPlugin {

	public static final String PLUGIN_ID = "gov.redhawk.ui.views.monitor";

	private MonitorViewPlugin() {
	}

	public static ILog getLog() {
		return Platform.getLog(FrameworkUtil.getBundle(MonitorViewPlugin.class));
	}
}
