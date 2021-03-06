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
package gov.redhawk.ui.port.nxmplot;

import gov.redhawk.ui.port.nxmplot.preferences.PlotPreferences;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * These setting are intended ONLY for the PLOT widget (not it's data source Port(s)).
 * @since 4.2
 */
public class PlotSettings {

	private Double minValue = null; // null to use default (i.e. AutoMin)
	private Double maxValue = null; // null to use default (i.e. AutoMax)
	private PlotType plotType = null; // null to not change plot type (line, raster, etc.)
	private PlotMode plotMode = null; // plot mode (i.e. complex mode (CM=)) (null to use default / no change)
	private Boolean enablePlotMenu = null; // null to use configured preference default - enable/disable middle-mouse-button (MMB) to bring up PLOT's configure menu
	private String launchArgs = null; // additional arguments when launching/running PLOT
	private String launchSwitches = null; // additional switches when launching/running PLOT

	/** plot data mode / complex mode (i.e. CM= arg or MPlot.setMode(..)).
	 * @since 4.4
	 */
	public static enum PlotMode {
		//  Instance			mode			Label
		AUTO("", "Auto"),
		MAGNITUDE("Mag", "Magnitude"),
		PHASE("Phase", "Phase"),
		REAL("Real", "Real"),
		IMAGINARY("Imag", "Imaginary"),
		REAL_AND_IMAGINARY("RnI", "Real and Imaginary"),
		REAL_VS_IMAGINARY("RvI", "Real vs Imaginary"),
		TEN_LOG("10Log", "10 Log"),
		TWENTY_LOG("20Log", "20 Log"),
		X("X", "X"),
		Y("Y", "Y"),
		Z("Z", "Z");

		private String modeString;
		private String label;

		private PlotMode(String modeString, String label) {
			this.modeString = modeString;
			this.label = label;
		}

		public String toModeString() {
			return this.modeString;
		}

		public String getLabel() {
			return this.label;
		}

		/** convert from plot's mode string (e.g. CM= arg) to this enum. */
		public static PlotMode of(String modeString) {
			for (PlotMode plotMode : PlotMode.values()) {
				if (plotMode.toModeString().equals(modeString)) {
					return plotMode; // found match
				}
			}
			throw new IllegalArgumentException("Invalid plot mode string: " + modeString);
		}

		public static List<PlotMode> getStandardModes() {
			return Arrays.asList(PlotMode.AUTO, PlotMode.IMAGINARY, PlotMode.MAGNITUDE, PlotMode.PHASE, PlotMode.REAL, PlotMode.REAL_AND_IMAGINARY,
				PlotMode.REAL_VS_IMAGINARY, PlotMode.TEN_LOG, PlotMode.TWENTY_LOG);
		}

	}

	public PlotSettings() {
		this(PlotActivator.getDefault().getPreferenceStore());
	}

	/**
	 * @since 4.4
	 */
	public PlotSettings(IPreferenceStore store) {
		this.enablePlotMenu = PlotPreferences.ENABLE_CONFIGURE_MENU_USING_MOUSE.getValue(store);
		//		this.launchArgs = PlotPreferences.LAUNCH_ARGS.getValue(store);
		//		this.launchSwitches = PlotPreferences.LAUNCH_SWITCHES.getValue(store);
		//		this.maxValue = PlotPreferences.MAX.getValue(store);
		//		this.minValue = PlotPreferences.MIN.getValue(store);
		String modeString = PlotPreferences.MODE.getValue(store);
		this.plotMode = PlotMode.valueOf(modeString);
		//		this.plotType = PlotType.valueOf(PlotPreferences.TYPE.getValue(store));
	}

	/** copy constructor */
	public PlotSettings(PlotSettings settings) {
		this();
		this.minValue = settings.minValue;
		this.maxValue = settings.maxValue;
		this.plotType = settings.plotType;
		this.plotMode = settings.plotMode;
		this.enablePlotMenu = settings.enablePlotMenu;
	}

	public PlotSettings(final PlotType plotType) {
		this();
		this.plotType = plotType;
	}

	/**
	 * @param plotType
	 * @param plotMode
	 * @since 4.4
	 */
	public PlotSettings(final PlotType plotType, PlotMode plotMode) {
		this(plotType, plotMode, null, null);
	}

	/**
	 * @param plotType
	 * @param launchArgs
	 * @since 4.4
	 * @param launchSwitches
	 */
	public PlotSettings(final PlotType plotType, PlotMode plotMode, String launchArgs, String launchSwitches) {
		this();
		this.plotType = plotType;
		this.plotMode = plotMode;
		this.launchArgs = launchArgs;
		this.launchSwitches = launchSwitches;
	}

	PlotSettings(final Double minValue, final Double maxValue, final PlotType plotType) {
		this();
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.plotType = plotType;
	}

	public Double getMinValue() {
		return this.minValue;
	}

	public void setMinValue(final Double minValue) {
		this.minValue = minValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public PlotType getPlotType() {
		return plotType;
	}

	public void setPlotType(PlotType plotType) {
		this.plotType = plotType;
	}

	/**
	 * @since 4.4
	 */
	public PlotMode getPlotMode() {
		return plotMode;
	}

	/**
	 * @since 4.4
	 */
	public void setPlotMode(PlotMode plotMode) {
		this.plotMode = plotMode;
	}

	/**
	 * @since 4.4
	 */
	public Boolean getEnablePlotMenu() {
		return enablePlotMenu;
	}

	/**
	 * @since 4.4
	 */
	public void setEnablePlotMenu(Boolean enablePlotMenu) {
		this.enablePlotMenu = enablePlotMenu;
	}

	/**
	 * @since 4.4
	 */
	public String getLaunchArgs() {
		return launchArgs;
	}

	/**
	 * @since 4.4
	 */
	public void setLaunchArgs(String launchArgs) {
		this.launchArgs = launchArgs;
	}

	/**
	 * @since 4.4
	 */
	public String getLaunchSwitches() {
		return launchSwitches;
	}

	/**
	 * @since 4.4
	 */
	public void setLaunchSwitches(String launchSwitches) {
		this.launchSwitches = launchSwitches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maxValue == null) ? 0 : maxValue.hashCode());
		result = prime * result + ((minValue == null) ? 0 : minValue.hashCode());
		result = prime * result + ((plotType == null) ? 0 : plotType.hashCode());
		result = prime * result + ((plotMode == null) ? 0 : plotMode.hashCode());
		result = prime * result + ((enablePlotMenu == null) ? 0 : enablePlotMenu.hashCode());
		result = prime * result + ((launchArgs == null) ? 0 : launchArgs.hashCode());
		result = prime * result + ((launchSwitches == null) ? 0 : launchSwitches.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PlotSettings)) {
			return false;
		}
		PlotSettings other = (PlotSettings) obj;
		if (maxValue == null) {
			if (other.maxValue != null) {
				return false;
			}
		} else if (!maxValue.equals(other.maxValue)) {
			return false;
		}
		if (minValue == null) {
			if (other.minValue != null) {
				return false;
			}
		} else if (!minValue.equals(other.minValue)) {
			return false;
		}
		if (plotType != other.plotType) {
			return false;
		}
		if (plotMode == null) {
			if (other.plotMode != null) {
				return false;
			}
		} else if (!plotMode.equals(other.plotMode)) {
			return false;
		}
		if (enablePlotMenu == null) {
			if (other.enablePlotMenu != null) {
				return false;
			}
		} else if (!enablePlotMenu.equals(other.enablePlotMenu)) {
			return false;
		}
		if (launchArgs == null) {
			if (other.launchArgs != null) {
				return false;
			}
		} else if (!launchArgs.equals(other.launchArgs)) {
			return false;
		}
		if (launchSwitches == null) {
			if (other.launchSwitches != null) {
				return false;
			}
		} else if (!launchSwitches.equals(other.launchSwitches)) {
			return false;
		}
		return true;
	}

}
