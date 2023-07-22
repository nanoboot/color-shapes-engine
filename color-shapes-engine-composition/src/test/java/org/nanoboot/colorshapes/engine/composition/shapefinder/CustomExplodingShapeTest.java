
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

package org.nanoboot.colorshapes.engine.composition.shapefinder;

import org.nanoboot.colorshapes.engine.composition.board.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CustomExplodingShapeTest {
    @Test
    public void constructor_empty() {
        //prepare
        CustomExplodingShape shape = new CustomExplodingShape();
        //execute
        //assert
        assertNotNull(shape.getHeight());
        assertNotNull(shape.getWidth());
        assertNotNull(shape.getHoles());
    }
    @Test
    public void constructor_jo() {
        //prepare
        CustomExplodingShape customExplodingShape = new CustomExplodingShape();
        CustomExplodingShape customExplodingShape2 = new CustomExplodingShape(customExplodingShape.toJsonObject());
        //execute
        //assert
        Assert.assertEquals(customExplodingShape.toJsonObject().toMinimalString(), customExplodingShape2.toJsonObject().toMinimalString());
    }
    @Test
    public void additionalValidate() {
        //prepare
        Shape shape;
        //execute
        //assert
        shape = new CustomExplodingShape(2, 2);
        Assert.assertEquals(false, shape.validate());
        //
        shape = new CustomExplodingShape(2, 3);
        Assert.assertEquals(false, shape.validate());
        //
        shape = new CustomExplodingShape(3, 2);
        Assert.assertEquals(false, shape.validate());
        //
        shape = new CustomExplodingShape(3, 3);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(3, 4);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(4, 3);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(4, 4);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(31, 31);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(31, 32);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(32, 31);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(32, 32);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(32, 33);
        Assert.assertEquals(false, shape.validate());
        //
        shape = new CustomExplodingShape(33, 32);
        Assert.assertEquals(false, shape.validate());
        //
        shape = new CustomExplodingShape(33, 33);
        Assert.assertEquals(false, shape.validate());
        ////
        //prepare
        //execute
        //assert
        shape = new CustomExplodingShape(12, 12);
        shape.addHole(11,11);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(12, 12);
        shape.addHole(11,12);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(12, 12);
        shape.addHole(12,12);
        Assert.assertEquals(true, shape.validate());
        //
        shape = new CustomExplodingShape(12, 12);
        shape.addHole(12,13);
        Assert.assertEquals(false, shape.validate());
        //
        shape = new CustomExplodingShape(12, 12);
        shape.addHole(13,12);
        Assert.assertEquals(false, shape.validate());
        //
        shape = new CustomExplodingShape(12, 12);
        shape.addHole(13,13);
        Assert.assertEquals(false, shape.validate());
    }

    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        CustomExplodingShape shape = new CustomExplodingShape(3,3);
        //execute
        //assert
        assertNotNull(shape.describePossibleReasonsIfInvalid());
    }

    @Test
    public void setRandomValues() {
        //prepare
        CustomExplodingShape shape = new CustomExplodingShape(3,3);
        //execute
        shape.setRandomValues();
        //assert
        assertTrue(shape.getHoles().getList().size() > 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setDefaultValues() {
        //prepare
        CustomExplodingShape shape = new CustomExplodingShape(3,3);
        //execute
        shape.setDefaultValues();
        //assert
    }
}
