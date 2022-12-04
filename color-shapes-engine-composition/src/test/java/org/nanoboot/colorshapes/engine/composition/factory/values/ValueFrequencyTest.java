
///////////////////////////////////////////////////////////////////////////////////////////////
// color-shapes-engine: A logic game based on Color linez game.
// Copyright (C) 2016-2022 the original author or authors.
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; version 2
// of the License only.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
///////////////////////////////////////////////////////////////////////////////////////////////

package org.nanoboot.colorshapes.engine.composition.factory.values;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ValueFrequencyTest {

    @Test
    public void constructor_int_int() {
        //prepare
        ValueFrequency valueFrequency = new ValueFrequency(50,4);
        //execute
        //assert
        assertEquals(50, valueFrequency.getValue().intValue());
        assertEquals(4, valueFrequency.getValueNumber());
    }
    @Test
    public void constructor_empty() {
        //prepare
        ValueFrequency valueFrequency = new ValueFrequency();
        //execute
        //assert
        assertEquals(0, valueFrequency.getValue().intValue());
        assertEquals(1, valueFrequency.getValueNumber());
    }
    @Test
    public void constructor_jo() {
        //prepare
        ValueFrequency valueFrequency = new ValueFrequency();
        ValueFrequency valueFrequency2 = new ValueFrequency(valueFrequency.toJsonObject());
        //execute
        //assert
        assertEquals(valueFrequency.toJsonObject().toMinimalString(), valueFrequency2.toJsonObject().toMinimalString());
    }
    @Test
    public void toJsonObject() {
        //prepare
        ValueFrequency valueFrequency = new ValueFrequency();
        //execute
        valueFrequency.setValueNumber(2);
        //assert
        assertTrue(valueFrequency.toJsonObject().hasKey("valueNumber"));
    }

    @Test
    public void fromJsonObject() {
        //prepare
        ValueFrequency valueFrequency = new ValueFrequency();
        //execute
        valueFrequency.setValueNumber(2);
        valueFrequency.fromJsonObject(valueFrequency.toJsonObject());
        //assert
        assertTrue(valueFrequency.toJsonObject().hasKey("valueNumber"));
    }

    @Test
    public void getName() {
        //prepare
        ValueFrequency valueFrequency = new ValueFrequency();
        ////

        //execute
        valueFrequency.setValueNumber(-2);
        //assert
        assertEquals("valueMinus2Frequency", valueFrequency.getName());
        //execute
        valueFrequency.setValueNumber(-1);
        //assert
        assertEquals("valueMinus1Frequency", valueFrequency.getName());
        //execute
        valueFrequency.setValueNumber(0);
        //assert
        assertEquals("value0Frequency", valueFrequency.getName());
        //execute
        valueFrequency.setValueNumber(1);
        //assert
        assertEquals("valuePlus1Frequency", valueFrequency.getName());
        //execute
        valueFrequency.setValueNumber(2);
        //assert
        assertEquals("valuePlus2Frequency", valueFrequency.getName());
    }

    @Test
    public void returnThis() {
        //prepare
        ValueFrequency valueFrequency = new ValueFrequency(10, 5);
        //execute
        //assert
        assertEquals(valueFrequency, valueFrequency.returnThis());
    }
}
