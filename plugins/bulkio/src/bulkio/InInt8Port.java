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
 * WARNING: This file is generated from DeprecatedInPort.java.template.
 *          Do not modify directly.
 */
package bulkio;

import org.apache.log4j.Logger;

@Deprecated
public class InInt8Port extends InCharPort {

    public InInt8Port(String portName) {
        super(portName);
    }

    public InInt8Port(String portName, bulkio.sri.Comparator compareSRI) {
        super(portName, compareSRI);
    }

    public InInt8Port(String portName, 
                        bulkio.sri.Comparator compareSRI, 
                        bulkio.SriListener sriCallback) {
        super(portName, compareSRI, sriCallback);
    }

    public InInt8Port(String portName, Logger logger) {
        super(portName, logger);
    }

    public InInt8Port(String portName, 
                        Logger logger,
                        bulkio.sri.Comparator compareSRI, 
                        bulkio.SriListener sriCallback) {
        super(portName, logger, compareSRI, sriCallback);
    }
}
