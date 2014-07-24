package bulkio;
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
import org.apache.log4j.Logger;

/**
 * 
 */
public class OutULongLongPort extends OutUInt64Port  {

    /**
     * @generated
     */
    public OutULongLongPort(String portName)
    {
        super(portName );
    }

    public OutULongLongPort(String portName, Logger logger)
    {
        super(portName, logger );
    }


    public OutULongLongPort(String portName, Logger logger, ConnectionEventListener eventCB )
    {
        super(portName, logger, eventCB );
    }

}

