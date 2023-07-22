
///////////////////////////////////////////////////////////////////////////////////////////////
// color-shapes-engine: A logic game based on Color linez game.
// Copyright (C) 2016-2023 the original author or authors.
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

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ColourFrequenciesTest {
    @Test
    public void cellsTest() {
        assertEquals(1, ColourFrequencies.COLOUR1);//NOSONAR
        assertEquals(2, ColourFrequencies.COLOUR2);//NOSONAR
        assertEquals(3, ColourFrequencies.COLOUR3);//NOSONAR
        assertEquals(4, ColourFrequencies.COLOUR4);//NOSONAR
        assertEquals(5, ColourFrequencies.COLOUR5);//NOSONAR
        assertEquals(6, ColourFrequencies.COLOUR6);//NOSONAR
        assertEquals(7, ColourFrequencies.COLOUR7);//NOSONAR
        assertEquals(8, ColourFrequencies.COLOUR8);//NOSONAR
        assertEquals(9, ColourFrequencies.COLOUR9);//NOSONAR
        assertEquals(10, ColourFrequencies.COLOUR10);//NOSONAR
        assertEquals(11, ColourFrequencies.COLOUR11);//NOSONAR
        assertEquals(12, ColourFrequencies.COLOUR12);//NOSONAR
        assertEquals(13, ColourFrequencies.COLOUR13);//NOSONAR
        assertEquals(14, ColourFrequencies.COLOUR14);//NOSONAR
        assertEquals(15, ColourFrequencies.COLOUR15);//NOSONAR
        assertEquals(16, ColourFrequencies.COLOUR16);//NOSONAR
        assertEquals(1, ColourFrequencies.MIN_COLOUR);//NOSONAR
        assertEquals(16, ColourFrequencies.MAX_COLOUR);//NOSONAR
    }

    @Test
    public void constructor_empty() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        //execute
        //assert
        assertNotNull(colourFrequencies.getColour3Frequency());
        assertEquals(3, colourFrequencies.getColour3Frequency().getColourNumber());
    }
    @Test
    public void constructor_jo() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        ColourFrequencies colourFrequencies2 = new ColourFrequencies(colourFrequencies.toJsonObject());
        //execute
        //assert
        assertEquals(colourFrequencies.toJsonObject().toMinimalString(), colourFrequencies2.toJsonObject().toMinimalString());
    }

    @Test
    public void getColourFrequency() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        ColourFrequency colourFrequency;
        //execute
        colourFrequency = colourFrequencies.getColourFrequency(6);
        //assert
        assertEquals(6, colourFrequency.getColourNumber());
    }
    @Test(expected = IllegalArgumentException.class)
    public void getColourFrequency2() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        ColourFrequency colourFrequency;
        //execute
        colourFrequency = colourFrequencies.getColourFrequency(0);
        //assert
    }
    @Test(expected = IllegalArgumentException.class)
    public void getColourFrequency3() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        ColourFrequency colourFrequency;
        //execute
        colourFrequency = colourFrequencies.getColourFrequency(17);
        //assert
    }

    @Test
    public void setFrequency() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        //execute
        colourFrequencies.setFrequency(6, 40);
        //assert
        assertEquals(40, colourFrequencies.getColour6Frequency().getValue().intValue());
    }

    @Test
    public void getFrequency() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        //execute
        colourFrequencies.setFrequency(6, 40);
        //assert
        assertEquals(40, colourFrequencies.getFrequency(6));
    }

    @Test
    public void setDefaultValues() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        //execute
        colourFrequencies.setDefaultValues();
        //assert
        assertEquals(100, colourFrequencies.getFrequency(7));
        assertEquals(0, colourFrequencies.getFrequency(8));
    }

    @Test
    public void getChildren() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        //execute
        //assert
        assertEquals(16, colourFrequencies.getChildren().size());
    }

    @Test
    public void returnThis() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        //execute
        //assert
        assertEquals(colourFrequencies, colourFrequencies.returnThis());
    }
    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        ColourFrequencies colourFrequencies = new ColourFrequencies();
        //execute
        //assert
        Assert.assertNotNull(colourFrequencies.describePossibleReasonsIfInvalid());
    }
}
