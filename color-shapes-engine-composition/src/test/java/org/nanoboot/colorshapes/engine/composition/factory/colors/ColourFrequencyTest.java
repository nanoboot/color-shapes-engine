
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

package org.nanoboot.colorshapes.engine.composition.factory.colors;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ColourFrequencyTest {
    @Test
    public void constructor_int_int() {
        //prepare
        ColourFrequency colourFrequency = new ColourFrequency(50,4);
        //execute
        //assert
        assertEquals(50, colourFrequency.getValue().intValue());
        assertEquals(4, colourFrequency.getColourNumber());
    }
    @Test
    public void constructor_empty() {
        //prepare
        ColourFrequency colourFrequency = new ColourFrequency();
        //execute
        //assert
        assertEquals(0, colourFrequency.getValue().intValue());
        assertEquals(1, colourFrequency.getColourNumber());
    }
    @Test
    public void constructor_jo() {
        //prepare
        ColourFrequency colourFrequency = new ColourFrequency();
        ColourFrequency colourFrequency2 = new ColourFrequency(colourFrequency.toJsonObject());
        //execute
        //assert
        assertEquals(colourFrequency.toJsonObject().toMinimalString(), colourFrequency2.toJsonObject().toMinimalString());
    }
    @Test
    public void toJsonObject() {
        //prepare
        ColourFrequency colourFrequency = new ColourFrequency();
        //execute
        colourFrequency.setColourNumber(9);
        //assert
        assertTrue(colourFrequency.toJsonObject().hasKey("colourNumber"));
    }

    @Test
    public void fromJsonObject() {
        //prepare
        ColourFrequency colourFrequency = new ColourFrequency();
        //execute
        colourFrequency.setColourNumber(9);
        colourFrequency.fromJsonObject(colourFrequency.toJsonObject());
        //assert
        assertTrue(colourFrequency.toJsonObject().hasKey("colourNumber"));
    }

    @Test
    public void getName() {

        //prepare
        ColourFrequency colourFrequency = new ColourFrequency();
        //execute
        colourFrequency.setColourNumber(9);
        //assert
        assertEquals("colour9Frequency", colourFrequency.getName());
    }

    @Test
    public void returnThis() {
        //prepare
        ColourFrequency colourFrequency = new ColourFrequency(10, 5);
        //execute
        //assert
        assertEquals(colourFrequency, colourFrequency.returnThis());
    }
}
