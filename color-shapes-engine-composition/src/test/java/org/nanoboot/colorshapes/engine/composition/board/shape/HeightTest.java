
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

package org.nanoboot.colorshapes.engine.composition.board.shape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class HeightTest {

    @Test
    public void getName() {
        //prepare
        Height frd = new Height(3);
        //execute
        //assert
        assertEquals("height", frd.getName());
    }

    @Test
    public void returnThis() {
        //prepare
        Height frd = new Height(3);
        //execute
        //assert
        assertEquals(frd.hashCode(), frd.returnThis().hashCode());
    }
    @Test
    public void constructor_int() {
        //prepare
        Height cellDimensionImpl = new Height(1);
        //execute
        //assert
        assertEquals(1, cellDimensionImpl.getValue().intValue());
        assertEquals(1, cellDimensionImpl.getMinValue());
        assertEquals(32, cellDimensionImpl.getMaxValue());
        assertEquals(1, cellDimensionImpl.getDefaultValue());
    }
    @Test
    public void constructor_empty() {
        //prepare
        Height cellDimensionImpl = new Height();
        //execute
        //assert
        assertEquals(1, cellDimensionImpl.getValue().intValue());
        assertEquals(1, cellDimensionImpl.getMinValue());
        assertEquals(32, cellDimensionImpl.getMaxValue());
        assertEquals(1, cellDimensionImpl.getDefaultValue());
    }
    @Test
    public void constructor_jo() {
        //prepare
        Height cellDimensionImpl = new Height();
        Height cellDimensionImpl2 = new Height(cellDimensionImpl.toJsonObject());
        //execute
        //assert
        assertEquals(1, cellDimensionImpl2.getValue().intValue());
        assertEquals(1, cellDimensionImpl2.getMinValue());
        assertEquals(32, cellDimensionImpl2.getMaxValue());
        assertEquals(1, cellDimensionImpl2.getDefaultValue());
    }
}
