
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

import org.nanoboot.powerframework.json.JsonObject;
import org.junit.Test;

import static org.junit.Assert.*;
/*
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ShapeTest {

    static class ShapeImpl extends Shape {

        public ShapeImpl() {
            super();
        }
        public ShapeImpl(int i, int i1) {
            super(null, i, i1);
        }

        public ShapeImpl(JsonObject jsonObject) {
            super(jsonObject);
        }
    }
    @Test
    public void constructor() {
        ShapeImpl shape;
        //assert
        //execute
        //assert
        shape = new ShapeImpl();
        assertNotNull(shape.getHeight());
        assertNotNull(shape.getWidth());
        assertNotNull(shape.getHoles());
        //
        shape = new ShapeImpl(10, 12);
        assertEquals(10, shape.getHeight().getValue().intValue());
        assertEquals(12, shape.getWidth().getValue().intValue());
        assertNotNull(shape.getHoles());
        //
        shape = new ShapeImpl(new ShapeImpl(9, 10).toJsonObject());
        shape = new ShapeImpl(shape.toJsonObject());
        assertEquals(9, shape.getHeight().getValue().intValue());
        assertEquals(10, shape.getWidth().getValue().intValue());
        assertNotNull(shape.getHoles());
    }
    @Test
    public void deleteAllHoles() {
        //prepare
        Shape shape = new ShapeImpl(12, 12);
        //execute
        //assert
        assertTrue(shape.getHoles().getList().isEmpty());
        shape.addHole(1,1);
        shape.addHole(1,2);
        shape.addHole(3,3);
        assertEquals(3, shape.getHoles().getList().size());
        shape.deleteAllHoles();
        assertTrue(shape.getHoles().getList().isEmpty());
    }

    @Test
    public void addHole() {
        //prepare
        Shape shape = new ShapeImpl(12, 12);
        //execute
        //assert
        assertTrue(shape.getHoles().getList().isEmpty());
        shape.addHole(1,1);
        shape.addHole(1,2);
        shape.addHole(3,3);
        assertEquals(3, shape.getHoles().getList().size());
        assertEquals(1, shape.getHoles().getList().get(0).getRow().getValue().intValue());
        assertEquals(1, shape.getHoles().getList().get(0).getColumn().getValue().intValue());
        assertEquals(1, shape.getHoles().getList().get(1).getRow().getValue().intValue());
        assertEquals(2, shape.getHoles().getList().get(1).getColumn().getValue().intValue());
        assertEquals(3, shape.getHoles().getList().get(2).getRow().getValue().intValue());
        assertEquals(3, shape.getHoles().getList().get(2).getColumn().getValue().intValue());
    }
    @Test
    public void additionalValidate() {
        //prepare
        Shape shape;
        //execute
        //assert
        shape = new ShapeImpl(12, 12);
        shape.addHole(11,11);
        assertEquals(true, shape.validate());
        //
        shape = new ShapeImpl(12, 12);
        shape.addHole(11,12);
        assertEquals(true, shape.validate());
        //
        shape = new ShapeImpl(12, 12);
        shape.addHole(12,12);
        assertEquals(true, shape.validate());
        //
        shape = new ShapeImpl(12, 12);
        shape.addHole(12,13);
        assertEquals(false, shape.validate());
        //
        shape = new ShapeImpl(12, 12);
        shape.addHole(13,12);
        assertEquals(false, shape.validate());
        //
        shape = new ShapeImpl(12, 12);
        shape.addHole(13,13);
        assertEquals(false, shape.validate());
    }
    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        ShapeImpl shape = new ShapeImpl();
        //execute
        //assert
        assertNotNull(shape.describePossibleReasonsIfInvalid());
    }
}
