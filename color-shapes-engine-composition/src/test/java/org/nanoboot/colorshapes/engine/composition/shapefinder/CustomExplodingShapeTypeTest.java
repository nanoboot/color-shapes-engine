
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

package org.nanoboot.colorshapes.engine.composition.shapefinder;

import org.nanoboot.colorshapes.engine.core.misc.ColorShapesEngineException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CustomExplodingShapeTypeTest {

    @Test
    public void ofNumber() {
        //prepare
        //execute
        //assert
        assertEquals(ExplodingShapeType.LINE, ExplodingShapeType.ofNumber(1));
        assertEquals(ExplodingShapeType.BLOCK, ExplodingShapeType.ofNumber(2));
        assertEquals(ExplodingShapeType.RING, ExplodingShapeType.ofNumber(3));
        assertEquals(ExplodingShapeType.SQUARE, ExplodingShapeType.ofNumber(4));
        assertEquals(ExplodingShapeType.CUSTOM, ExplodingShapeType.ofNumber(0));
    }
    @Test(expected = ColorShapesEngineException.class)
    public void ofNumber2() {
        //prepare
        //execute
        ExplodingShapeType.ofNumber(-1);
        //assert
    }
    @Test(expected = ColorShapesEngineException.class)
    public void ofNumber3() {
        //prepare
        //execute
        ExplodingShapeType.ofNumber(5);
        //assert
    }

    @Test
    public void getNumber() {

        //prepare
        //execute
        //assert
        assertEquals(1, ExplodingShapeType.LINE.getNumber());
        assertEquals(2, ExplodingShapeType.BLOCK.getNumber());
        assertEquals(3, ExplodingShapeType.RING.getNumber());
        assertEquals(4, ExplodingShapeType.SQUARE.getNumber());
        assertEquals(0, ExplodingShapeType.CUSTOM.getNumber());
    }
}
