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
package bulkio.sri;

import org.ossie.properties.AnyUtils;
import CF.DataType;

import BULKIO.StreamSRI;

public class utils {

    public static StreamSRI create()
    {
	return create("defaultSRI", 1.0, (short)1, false );
    }

    public static StreamSRI create(String sid)
    {
        // Default sample rate is 1
        return create(sid, 1.0);
    }

    public static StreamSRI create(String sid, double srate)
    {
        // Default xunits is BULKIO::UNITS_TIME
        return create(sid, srate, BULKIO.UNITS_TIME.value);
    }

    public static StreamSRI create(String sid, double srate, short xunits)
    {
        // Default is non-blocking
        return create(sid, srate, xunits, false);
    }

    public static StreamSRI  create( String sid, 
				     double srate, 
				     short xunits,
				     boolean blocking ) {

	StreamSRI tsri = new StreamSRI();
	tsri.streamID = sid;
	tsri.hversion =1;
	tsri.xstart = 0.0;
	if ( srate <= 0.0 ) {
	    tsri.xdelta = 1.0;
	}
	else {
	    tsri.xdelta = 1.0/srate;
	}
	tsri.xunits = xunits;
	tsri.subsize = 0;
	tsri.ystart = 0.0;
	tsri.ydelta = 0.0;
	tsri.yunits = 0;
	tsri.mode = 0;
	tsri.blocking=blocking;
	tsri.keywords = new DataType[0];

	return tsri;
    }

    public static boolean compare(BULKIO.StreamSRI sriA, BULKIO.StreamSRI sriB)
    {
        if (sriA.hversion != sriB.hversion) {
            return false;
        } else if (sriA.xstart != sriB.xstart) {
            return false;
        } else if (sriA.xdelta != sriB.xdelta) {
            return false;
        } else if (sriA.xunits != sriB.xunits) {
            return false;
        } else if (sriA.subsize != sriB.subsize) {
            return false;
        } else if (sriA.ystart != sriB.ystart) {
            return false;
        } else if (sriA.ydelta != sriB.ydelta) {
            return false;
        } else if (sriA.yunits != sriB.yunits) {
            return false;
        } else if (sriA.mode != sriB.mode) {
            return false;
        } else if (sriA.streamID != sriB.streamID) {
            return false;
        } else if (sriA.blocking != sriB.blocking) {
            return false;
        } else if (!_compareKeywords(sriA.keywords, sriB.keywords)) {
            return false;
        }
        return true;
    }

    private static boolean _compareKeywords(CF.DataType[] keywordsA, CF.DataType[] keywordsB)
    {
        if (keywordsA == keywordsB) {
            return true;
        } else if ((keywordsA == null) || (keywordsB == null)) {
            return false;
        } else if (keywordsA.length != keywordsB.length) {
            return false;
        }
        for (int index = 0; index < keywordsA.length; index++) {
            if (!keywordsA[index].id.equals(keywordsB[index].id)) {
                return false;
            } else if (!AnyUtils.compareAnys(keywordsA[index].value, keywordsB[index].value, "eq")) {
                return false;
            }
        }
        return true;
    }
}
