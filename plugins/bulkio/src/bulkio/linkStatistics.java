
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
package bulkio;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.omg.CORBA.TCKind;
import org.ossie.properties.AnyUtils;
import CF.DataType;
import BULKIO.PortStatistics;
import bulkio.SizeOf;

/**
 * @generated
 */
public class linkStatistics  {

    class statPoint {
	public int elements;
        public float queueSize;
        public double secs;
        public double usecs;
    };

    /** @generated */
    protected int sizeof;
    /** @generated */
    protected boolean enabled;
    /** @generated */
    protected double bitSize;
    /** @generated */
    protected BULKIO.PortStatistics runningStats;
    /** @generated */
    protected statPoint[] receivedStatistics;
    /** @generated */
    protected List< String > activeStreamIDs;
    /** @generated */
    protected int historyWindow;
    /** @generated */
    protected int receivedStatistics_idx;
    /** @generated */
    protected double flushTime;
    /** @generated */
    protected String portName;
        
    /**
     * @generated
     */
    public linkStatistics(String portName, SizeOf<?> dataum ) {
	this.sizeof = dataum.sizeof();
	this.enabled = true;
	this.bitSize = this.sizeof * 8.0;
	this.historyWindow = 10;
	this.flushTime = 0.0;
	this.receivedStatistics_idx = 0;
	this.receivedStatistics = new statPoint[historyWindow];
	this.activeStreamIDs = new ArrayList<String>();
	this.portName = portName;
	this.runningStats = new PortStatistics();
	this.runningStats.portName = this.portName;
	this.runningStats.elementsPerSecond = -1.0f;
	this.runningStats.bitsPerSecond = -1.0f;
	this.runningStats.callsPerSecond = -1.0f;
	this.runningStats.averageQueueDepth = -1.0f;
	this.runningStats.streamIDs = new String[0];
	this.runningStats.timeSinceLastCall = -1.0f;
	this.runningStats.keywords = new DataType[0];
	for (int i = 0; i < historyWindow; ++i) {
	    this.receivedStatistics[i] = new statPoint();
	}
    }

    public List< String > getActiveStreamIDs() {
        return this.activeStreamIDs;
    }

    /**
     * @generated
     */
    public void setBitSize(double bitSize) {
	this.bitSize = bitSize;
    }

    /**
     * @generated
     */
    public void setEnabled(boolean enableStats) {
	this.enabled = enableStats;
    }

    /**
     * @generated
     */
    public void update(int elementsReceived, float queueSize, boolean EOS, String streamID, boolean flush) {
	if (!this.enabled) {
	    return;
	}
	double currTime = System.nanoTime() * 1.0e-9;
	this.receivedStatistics[this.receivedStatistics_idx].elements = elementsReceived;
	this.receivedStatistics[this.receivedStatistics_idx].queueSize = queueSize;
	this.receivedStatistics[this.receivedStatistics_idx++].secs = currTime;
	this.receivedStatistics_idx = this.receivedStatistics_idx % this.historyWindow;
	if (!EOS) {
	    if (!this.activeStreamIDs.contains(streamID)) {
		this.activeStreamIDs.add(streamID);
	    }
	} else {
	    this.activeStreamIDs.remove(streamID);
	}

	if (flush) {
	    this.flushTime = currTime;
	}
    }

    /**
     * @generated
     */
    public PortStatistics retrieve() {
	if (!this.enabled) {
	    return null;
	}
	double secs = System.nanoTime() * 1.0e-9;
	int idx = (this.receivedStatistics_idx == 0) ? (this.historyWindow - 1) : (this.receivedStatistics_idx - 1);
	double front_sec = this.receivedStatistics[idx].secs;
	double totalTime = secs - this.receivedStatistics[this.receivedStatistics_idx].secs;
	double totalData = 0;
	float queueSize = 0;
	int startIdx = (this.receivedStatistics_idx + 1) % this.historyWindow;
	for (int i = startIdx; i != this.receivedStatistics_idx; ) {
	    totalData += this.receivedStatistics[i].elements;
	    queueSize += this.receivedStatistics[i].queueSize;
	    i = (i + 1) % this.historyWindow;
	}
	int receivedSize = receivedStatistics.length;
	synchronized (this.runningStats) {
	    this.runningStats.timeSinceLastCall = (float)(secs - front_sec);
	    this.runningStats.bitsPerSecond = (float)((totalData * this.bitSize) / totalTime);
	    this.runningStats.elementsPerSecond = (float)(totalData / totalTime);
	    this.runningStats.averageQueueDepth = (float)(queueSize / receivedSize);
	    this.runningStats.callsPerSecond = (float)((receivedSize - 1) / totalTime);
	    this.runningStats.streamIDs = this.activeStreamIDs.toArray(new String[0]);
	    if (flushTime != 0.0) {
		double flushTotalTime = secs - this.flushTime;
		this.runningStats.keywords = new DataType[1];
		this.runningStats.keywords[0] = new DataType();
		this.runningStats.keywords[0].id = "timeSinceLastFlush";
		this.runningStats.keywords[0].value = AnyUtils.toAny(new Double(flushTotalTime), TCKind.tk_double);
	    }
	}
	return this.runningStats;
    }
}

