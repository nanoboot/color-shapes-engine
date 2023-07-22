
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

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BoardShapeTest {
    @Test
    public void constructor() {
        BoardShape shape;
        //assert
        //execute
        //assert
        shape = new BoardShape();
        assertNotNull(shape.getHeight());
        assertNotNull(shape.getWidth());
        assertNotNull(shape.getHoles());
        //
        shape = new BoardShape(null, 10, 12);
        assertEquals(10, shape.getHeight().getValue().intValue());
        assertEquals(12, shape.getWidth().getValue().intValue());
        assertNotNull(shape.getHoles());
        //
        shape = new BoardShape(new BoardShape(null, 9, 10).toJsonObject());
        shape = new BoardShape(shape.toJsonObject());
        assertEquals(9, shape.getHeight().getValue().intValue());
        assertEquals(10, shape.getWidth().getValue().intValue());
        assertNotNull(shape.getHoles());
    }

    @Test
    public void additionalValidate() {
        //prepare
        Shape shape;
        //execute
        //assert
        shape = new BoardShape(null, 2, 2);
        assertEquals(false, shape.validate());
        //
        shape = new BoardShape(null, 2, 3);
        assertEquals(false, shape.validate());
        //
        shape = new BoardShape(null, 3, 2);
        assertEquals(false, shape.validate());
        //
        shape = new BoardShape(null, 3, 3);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 3, 4);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 4, 3);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 4, 4);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 31, 31);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 31, 32);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 32, 31);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 32, 32);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 32, 33);
        assertEquals(false, shape.validate());
        //
        shape = new BoardShape(null, 33, 32);
        assertEquals(false, shape.validate());
        //
        shape = new BoardShape(null, 33, 33);
        assertEquals(false, shape.validate());
        ////
        //prepare
        //execute
        //assert
        shape = new BoardShape(null, 12, 12);
        shape.addHole(11,11);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 12, 12);
        shape.addHole(11,12);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 12, 12);
        shape.addHole(12,12);
        assertEquals(true, shape.validate());
        //
        shape = new BoardShape(null, 12, 12);
        shape.addHole(12,13);
        assertEquals(false, shape.validate());
        //
        shape = new BoardShape(null, 12, 12);
        shape.addHole(13,12);
        assertEquals(false, shape.validate());
        //
        shape = new BoardShape(null, 12, 12);
        shape.addHole(13,13);
        assertEquals(false, shape.validate());
    }

    @Test
    public void setRandomValues() {
        //prepare
        BoardShape shape;
        shape = new BoardShape();
        //execute
        shape.setRandomValues();
        //assert
        assertTrue(shape.getHeight().getValue() >= 3);
        assertTrue(shape.getWidth().getValue() >= 3);
    }

    @Test
    public void setDefaultValues() {
        //prepare
        BoardShape shape;
        shape = new BoardShape();
        //execute
        shape.setDefaultValues();
        //assert
        assertEquals(9, shape.getHeight().getValue().intValue());
        assertEquals(9, shape.getWidth().getValue().intValue());
        assertTrue(shape.getHoles().getList().isEmpty());
    }
    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        BoardShape shape = new BoardShape(null, 3,3);
        //execute
        //assert
        assertNotNull(shape.describePossibleReasonsIfInvalid());
    }
}
