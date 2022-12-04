
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

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ValueFrequenciesTest {

    @Test
    public void constructor_empty() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        //execute
        //assert
        assertNotNull(valueFrequencies.getValuePlus1Frequency());
        assertEquals(0, valueFrequencies.getValueFrequency(0).getValueNumber());
    }
    @Test
    public void constructor_jo() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        ValueFrequencies valueFrequencies2 = new ValueFrequencies(valueFrequencies.toJsonObject());
        //execute
        //assert
        assertEquals(valueFrequencies.toJsonObject().toMinimalString(), valueFrequencies2.toJsonObject().toMinimalString());
    }
    @Test
    public void getValueFrequency() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        ValueFrequency valueFrequency;
        //execute
        valueFrequency = valueFrequencies.getValueFrequency(0);
        //assert
        assertEquals(0, valueFrequency.getValueNumber());
    }
    @Test(expected = IllegalArgumentException.class)
    public void getValueFrequency2() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        ValueFrequency valueFrequency;
        //execute
        valueFrequency = valueFrequencies.getValueFrequency(-3);
        //assert
    }
    @Test(expected = IllegalArgumentException.class)
    public void getValueFrequency3() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        ValueFrequency valueFrequency;
        //execute
        valueFrequency = valueFrequencies.getValueFrequency(3);
        //assert
    }

    @Test
    public void setFrequency() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        //execute
        valueFrequencies.setFrequency(0, 40);
        //assert
        assertEquals(40, valueFrequencies.getValue0Frequency().getValue().intValue());
    }

    @Test
    public void getFrequency() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        //execute
        valueFrequencies.setFrequency(0, 40);
        //assert
        assertEquals(40, valueFrequencies.getFrequency(0));
    }

    @Test
    public void setDefaultValues() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        //execute
        valueFrequencies.setDefaultValues();
        //assert
        assertEquals(0, valueFrequencies.getFrequency(0));
        assertEquals(100, valueFrequencies.getFrequency(1));
    }
    @Test
    public void getChildren() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        //execute
        //assert
        assertEquals(5, valueFrequencies.getChildren().size());
    }

    @Test
    public void returnThis() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        //execute
        //assert
        assertEquals(valueFrequencies, valueFrequencies.returnThis());
    }
    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        ValueFrequencies valueFrequencies = new ValueFrequencies();
        //execute
        //assert
        Assert.assertNotNull(valueFrequencies.describePossibleReasonsIfInvalid());
    }
}
