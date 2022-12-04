
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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ShapeFinderCompositionTest {
    @Test
    public void validate() {
        //prepare
        //execute
        //assert
        assertEquals(false, new ShapeFinderComposition(null, 5, null).validate());
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.CUSTOM, 5, null).validate());
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.LINE, 5, new CustomExplodingShape()).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.CUSTOM, 0, new CustomExplodingShape()).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.LINE, 5, null).validate());
        ////
        //line
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.LINE, 1, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.LINE, 2, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.LINE, 4, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.LINE, 32, null).validate());
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.LINE, 33, null).validate());
        //block
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.BLOCK, 2, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.BLOCK, 3, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.BLOCK, 4, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.BLOCK, 32, null).validate());
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.BLOCK, 33, null).validate());
        //ring
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.RING, 3, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.RING, 4, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.RING, 5, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.RING, 16, null).validate());
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.RING, 17, null).validate());
        //square
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.SQUARE, 3, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.SQUARE, 4, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.SQUARE, 5, null).validate());
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.SQUARE, 16, null).validate());
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.SQUARE, 17, null).validate());
        //custom
        assertEquals(true, new ShapeFinderComposition(ExplodingShapeType.CUSTOM, 0, new CustomExplodingShape()).validate());
        assertEquals(false, new ShapeFinderComposition(ExplodingShapeType.CUSTOM, 1, new CustomExplodingShape()).validate());
    }
    @Test(expected = IllegalStateException.class)
    public void validate2() {
        //prepare
        //execute
        new ShapeFinderComposition(ExplodingShapeType.UNSUPPORTED_OPTION, 5, null).validate();
        //assert
    }

    @Test
    public void setDefaultValues() {
    }

    @Test
    public void setRandomValues() {
    }

    @Test
    public void createCopy() {
    }

    @Test
    public void toJsonObject() {
    }

    @Test
    public void fromJsonObject() {
    }

    @Test
    public void returnThis() {
    }

    @Test
    public void describePossibleReasonsIfInvalid() {
    }
}
