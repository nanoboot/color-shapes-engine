
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

import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.json.JsonObject;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class HolesTest {
    @Test
    public void getName() {
        //prepare
        Holes h = new Holes();
        //execute
        //assert
        assertEquals("holes", h.getName());
    }

    @Test
    public void toJsonObject() {
        //prepare
        Holes holes = new Holes();
        holes.getList().add(new CellCoordination(1, 1));
        holes.getList().add(new CellCoordination(1, 2));
        holes.getList().add(new CellCoordination(3, 3));
        String expected = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Holes\",\"id\":null,\"list\":[{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination\",\"id\":null,\"row\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Row\",\"id\":null,\"value\":1,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1},\"column\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Column\",\"id\":null,\"value\":1,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1}},{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination\",\"id\":null,\"row\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Row\",\"id\":null,\"value\":1,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1},\"column\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Column\",\"id\":null,\"value\":2,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1}},{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination\",\"id\":null,\"row\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Row\",\"id\":null,\"value\":3,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1},\"column\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Column\",\"id\":null,\"value\":3,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1}}]}";
        String returned;
        //execute
        returned = holes.toJsonObject().toMinimalString();
        //assert
        assertEquals(expected, returned);
    }

    @Test
    public void fromJsonObject() {
        //prepare
        String holeListAsJsonString = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Holes\",\"list\":[{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination\",\"row\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Row\",\"value\":1,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1},\"column\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Column\",\"value\":1,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1}},{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination\",\"row\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Row\",\"value\":1,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1},\"column\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Column\",\"value\":2,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1}},{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination\",\"row\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Row\",\"value\":3,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1},\"column\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Column\",\"value\":3,\"minValue\":1,\"maxValue\":32,\"defaultValue\":1}}]}";
        Holes holes;
        //execute
        holes = new Holes(new JsonObject(holeListAsJsonString));
        //assert
        assertEquals(3, holes.getList().size());
        assertEquals(1, holes.getList().get(0).getRow().getValue().intValue());
        assertEquals(1, holes.getList().get(0).getColumn().getValue().intValue());
        assertEquals(1, holes.getList().get(1).getRow().getValue().intValue());
        assertEquals(2, holes.getList().get(1).getColumn().getValue().intValue());
        assertEquals(3, holes.getList().get(2).getRow().getValue().intValue());
        assertEquals(3, holes.getList().get(2).getColumn().getValue().intValue());
    }

    @Test
    public void getList() {
        //prepare
        Holes holes = new Holes();
        //execute
        holes.add(1, 1);
        holes.add(1, 2);
        holes.add(3, 3);
        //assert
        assertNotNull(holes.getList());
        assertEquals(3, holes.getList().size());
    }

    @Test
    public void add() {
        //prepare
        Holes holes = new Holes();
        //execute
        holes.add(1, 1);
        holes.add(1, 2);
        holes.add(3, 3);
        //assert
        assertEquals(3, holes.getList().size());
        assertEquals(1, holes.getList().get(0).getRow().getValue().intValue());
        assertEquals(1, holes.getList().get(0).getColumn().getValue().intValue());
        assertEquals(1, holes.getList().get(1).getRow().getValue().intValue());
        assertEquals(2, holes.getList().get(1).getColumn().getValue().intValue());
        assertEquals(3, holes.getList().get(2).getRow().getValue().intValue());
        assertEquals(3, holes.getList().get(2).getColumn().getValue().intValue());
    }

    @Test
    public void returnThis() {
        //prepare
        Holes holes = new Holes();
        //execute
        holes.add(1, 1);
        holes.add(1, 2);
        holes.add(3, 3);
        holes = holes.returnThis();
        //assert
        assertEquals(3, holes.getList().size());
        assertEquals(1, holes.getList().get(0).getRow().getValue().intValue());
        assertEquals(1, holes.getList().get(0).getColumn().getValue().intValue());
        assertEquals(1, holes.getList().get(1).getRow().getValue().intValue());
        assertEquals(2, holes.getList().get(1).getColumn().getValue().intValue());
        assertEquals(3, holes.getList().get(2).getRow().getValue().intValue());
        assertEquals(3, holes.getList().get(2).getColumn().getValue().intValue());
    }

    @Test
    public void validate() {
        //prepare
        Holes holes = new Holes();
        CellCoordination hole1 = Mockito.spy(new CellCoordination(1,1));
        CellCoordination hole2 = Mockito.spy(new CellCoordination(1,2));
        CellCoordination hole3 = Mockito.spy(new CellCoordination(1,3));
        //
        //execute
        //assert
        when(hole1.validate()).thenReturn(false);
        when(hole2.validate()).thenReturn(false);
        when(hole3.validate()).thenReturn(false);
        holes.getList().addAll(new PowerList<>(hole1, hole2, hole3));
        assertEquals(false, holes.validate());
        //
        //execute
        //assert
        when(hole1.validate()).thenReturn(false);
        when(hole2.validate()).thenReturn(false);
        when(hole3.validate()).thenReturn(true);
        holes.getList().addAll(new PowerList<>(hole1, hole2, hole3));
        assertEquals(false, holes.validate());
        //
        //execute
        //assert
        when(hole1.validate()).thenReturn(true);
        when(hole2.validate()).thenReturn(true);
        when(hole3.validate()).thenReturn(false);
        holes.getList().addAll(new PowerList<>(hole1, hole2, hole3));
        assertEquals(false, holes.validate());
        //
        //execute
        //assert
        when(hole1.validate()).thenReturn(true);
        when(hole2.validate()).thenReturn(true);
        when(hole3.validate()).thenReturn(true);
        holes.getList().addAll(new PowerList<>(hole1, hole2, hole3));
        assertEquals(true, holes.validate());
    }

    @Test
    public void setRandomValues() {
        //prepare
        Holes holes = new Holes();
        CellCoordination hole1 = new CellCoordination(1,1);
        CellCoordination hole2 = new CellCoordination(1,2);
        CellCoordination hole3 = new CellCoordination(1,3);
        holes.getList().addAll(new PowerList<>(hole1, hole2, hole3));
        holes.setRandomValues();
        //
        //execute
        //assert
        assertEquals(true, holes.getList().isEmpty());
    }

    @Test
    public void setDefaultValues() {
        //prepare
        Holes holes = new Holes();
        CellCoordination hole1 = new CellCoordination(1,1);
        CellCoordination hole2 = new CellCoordination(1,2);
        CellCoordination hole3 = new CellCoordination(1,3);
        holes.getList().addAll(new PowerList<>(hole1, hole2, hole3));
        holes.setDefaultValues();
        //
        //execute
        //assert
        assertEquals(true, holes.getList().isEmpty());
    }

    @Test
    public void isDefault() {
        //prepare
        Holes holes = new Holes();
        CellCoordination hole1 = new CellCoordination(1,1);
        CellCoordination hole2 = new CellCoordination(1,2);
        CellCoordination hole3 = new CellCoordination(1,3);
        holes.getList().addAll(new PowerList<>(hole1, hole2, hole3));
        assertEquals(false, holes.isDefault());
        holes.setDefaultValues();
        assertEquals(true, holes.isDefault());
        //execute
        //assert
    }
    @Test
    public void isEmpty() {
        //prepare
        Holes holes = new Holes();
        //execute
        //assert
        assertTrue(holes.isEmpty());
        holes.add(3, 4);
        assertFalse(holes.isEmpty());
        holes.getList().clear();
        assertTrue(holes.isEmpty());
    }
    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        Holes holes = new Holes();
        //execute
        //assert
        assertNotNull(holes.describePossibleReasonsIfInvalid());
    }
    @Test
    public void describePossibleReasonsIfInvalid2() {
        //prepare
        Holes holes = new Holes();
        holes.add(0, 4);
        //execute
        //assert
        assertNotNull(holes.describePossibleReasonsIfInvalid());
    }
    @Test
    public void describePossibleReasonsIfInvalid3() {
        //prepare
        Holes holes = new Holes();
        holes.add(2, 4);
        //execute
        //assert
        assertNotNull(holes.describePossibleReasonsIfInvalid());
    }
}
