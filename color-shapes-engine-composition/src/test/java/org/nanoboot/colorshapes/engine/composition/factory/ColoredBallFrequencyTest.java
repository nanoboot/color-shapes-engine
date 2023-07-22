
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

package org.nanoboot.colorshapes.engine.composition.factory;

import org.nanoboot.colorshapes.engine.composition.utils.Frequency;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ColoredBallFrequencyTest {
    @Test
    public void constructor_int() {
        //prepare
        ColoredBallFrequency colourfulBallFrequency = new ColoredBallFrequency(50);
        //execute
        //assert
        assertEquals(50, colourfulBallFrequency.getValue().intValue());
    }
    @Test
    public void constructor_empty() {
        //prepare
        ColoredBallFrequency colourfulBallFrequency = new ColoredBallFrequency();
        //execute
        //assert
        assertEquals(0, colourfulBallFrequency.getValue().intValue());
    }
    @Test
    public void constructor_jo() {
        //prepare
        ColoredBallFrequency colourfulBallFrequency = new ColoredBallFrequency();
        ColoredBallFrequency colourfulBallFrequency2 = new ColoredBallFrequency(colourfulBallFrequency.toJsonObject());
        //execute
        //assert
        assertEquals(colourfulBallFrequency.toJsonObject().toMinimalString(), colourfulBallFrequency2.toJsonObject().toMinimalString());
    }
    @Test
    public void returnThis() {
        //prepare
        ColoredBallFrequency colourfulBallFrequency = new ColoredBallFrequency(10);
        //execute
        //assert
        assertEquals(colourfulBallFrequency, colourfulBallFrequency.returnThis());
    }

    @Test
    public void setDefaultValues() {
        //prepare
        ColoredBallFrequency colourfulBallFrequency = new ColoredBallFrequency();
        colourfulBallFrequency.setDefaultValues();
        //execute
        //assert
        assertEquals(Frequency.MAX_VALUE, colourfulBallFrequency.getValue().intValue());
    }
}
