
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

package org.nanoboot.colorshapes.engine.composition.board.shape.holes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ColumnTest {

    @Test
    public void getName() {
        //prepare
        Column fcd = new Column(3);
        //execute
        //assert
        assertEquals("column", fcd.getName());
    }

    @Test
    public void returnThis() {
        //prepare
        Column fcd = new Column(3);
        //execute
        //assert
        assertEquals(fcd.hashCode(), fcd.returnThis().hashCode());
    }

    @Test
    public void constructor_int() {
        //prepare
        Column cellDimensionImpl = new Column(1);
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
        Column cellDimensionImpl = new Column();
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
        Column cellDimensionImpl = new Column();
        Column cellDimensionImpl2 = new Column(cellDimensionImpl.toJsonObject());
        //execute
        //assert
        assertEquals(1, cellDimensionImpl2.getValue().intValue());
        assertEquals(1, cellDimensionImpl2.getMinValue());
        assertEquals(32, cellDimensionImpl2.getMaxValue());
        assertEquals(1, cellDimensionImpl2.getDefaultValue());
    }
}
