/*
 * This file is protected by Copyright. Please refer to the COPYRIGHT file
 * distributed with this source distribution.
 *
 * This file is part of REDHAWK bulkioInterfaces.
 *
 * REDHAWK bulkioInterfaces is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * REDHAWK bulkioInterfaces is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
/*
 * WARNING: This file is generated from InPort.java.template.
 *          Do not modify directly.
 */
package bulkio;

import org.apache.log4j.Logger;

import org.ossie.component.RHLogger;

import BULKIO.PortStatistics;
import BULKIO.PortUsageType;
import BULKIO.PrecisionUTCTime;
import BULKIO.StreamSRI;

/**
 * 
 */
public class InDoublePort extends BULKIO.jni.dataDoublePOA implements InDataPort<BULKIO.dataDoubleOperations,double[]> {

    /**
     * A class to hold packet data.
     * 
     */
    public class Packet extends DataTransfer < double[] > {

        public Packet(double[] data, PrecisionUTCTime time, boolean endOfStream, String streamID, StreamSRI H, boolean sriChanged, boolean inputQueueFlushed ) {
            super(data,time,endOfStream,streamID,H,sriChanged,inputQueueFlushed);
        };
    };

    private InPortImpl<double[]> impl;

    /**
     * 
     */
    public InDoublePort( String portName ) {
        this( portName, null, new bulkio.sri.DefaultComparator(), null );
    }

    public InDoublePort( String portName,
                       bulkio.sri.Comparator compareSRI ){
        this( portName, null, compareSRI, null );
    }

    public InDoublePort( String portName,
                        bulkio.sri.Comparator compareSRI,
                        bulkio.SriListener sriCallback
                       ) {
        this( portName, null, compareSRI, sriCallback );
    }

    public InDoublePort( String portName, Logger logger ) {
        this( portName, logger, new bulkio.sri.DefaultComparator(), null );
    }

    public InDoublePort( String portName,
                       Logger logger,
                       bulkio.sri.Comparator compareSRI,
                       bulkio.SriListener sriCallback ) {
        impl = new InPortImpl<double[]>(portName, logger, compareSRI, sriCallback, new DoubleDataHelper());
    }

    public Logger getLogger() {
        return impl.getLogger();
    }

    public void setLogger(Logger logger){
        impl.setLogger(logger);
    }

    public void setLogger(RHLogger logger)
    {
        impl.setLogger(logger);
    }

    /**
     * 
     */
    public void setSriListener(bulkio.SriListener sriCallback) {
        impl.setSriListener(sriCallback);
    }

    /**
     * 
     */
    public String getName() {
        return impl.getName();
    }

    /**
     * 
     */
    public void enableStats(boolean enable) {
        impl.enableStats(enable);
    }

    /**
     * 
     */
    public PortStatistics statistics() {
        return impl.statistics();
    }

    /**
     * 
     */
    public PortUsageType state() {
        return impl.state();
    }

    /**
     * 
     */
    public StreamSRI[] activeSRIs() {
        return impl.activeSRIs();
    }

    /**
     * 
     */
    public int getCurrentQueueDepth() {
        return impl.getCurrentQueueDepth();
    }

    /**
     * 
     */
    public int getMaxQueueDepth() {
        return impl.getMaxQueueDepth();
    }

    /**
     * 
     */
    public void setMaxQueueDepth(int newDepth) {
        impl.setMaxQueueDepth(newDepth);
    }

    /**
     * 
     */
    public void pushSRI(StreamSRI header) {
        impl.pushSRI(header);
    }

    /**
     * 
     */
    public void pushPacket(double[] data, PrecisionUTCTime time, boolean eos, String streamID)
    {
        impl.pushPacket(data, time, eos, streamID);
    }

    /**
     * 
     */
    public Packet getPacket(long wait)
    {
        DataTransfer<double[]> p = impl.getPacket(wait);
        if (p == null) {
            return null;
        } else {
            return new Packet(p.getData(), p.getTime(), p.getEndOfStream(), p.getStreamID(), p.getSRI(), p.sriChanged(), p.inputQueueFlushed());
        }
    }

    public String getRepid()
    {
        return BULKIO.dataDoubleHelper.id();
    }

    public String getDirection()
    {
        return CF.PortSet.DIRECTION_PROVIDES;
    }

}
