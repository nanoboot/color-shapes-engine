
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

package org.nanoboot.colorshapes.engine.composition.board.shape.holes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CellCoordinationTest {
    @Test
    public void getName() {
        //prepare
        CellCoordination fc = new CellCoordination(3, 4);
        //execute
        //assert
        assertEquals("cellCoordination", fc.getName());
    }

    @Test
    public void returnThis() {
        //prepare
        CellCoordination fc = new CellCoordination(3, 4);
        //execute
        //assert
        assertEquals(fc.hashCode(), fc.returnThis().hashCode());
    }
    @Test
    public void getChildren() {
        //prepare
        //execute
        CellCoordination fc = new CellCoordination(7, 8);
        //assert
        assertEquals(2, fc.getChildren().size());
    }

    @Test
    public void constructor_jo() {
        //prepare
        CellCoordination fc = new CellCoordination(2, 3);
        CellCoordination fc2 = new CellCoordination(fc.toJsonObject());
        //execute
        //assert
        assertEquals(fc.toJsonObject().toMinimalString(), fc2.toJsonObject().toMinimalString());
    }
    @Test
    public void constructor_empty() {
        //prepare
        CellCoordination fc = new CellCoordination();
        //execute
        //assert
        assertNull(fc.getRow());
        assertNull(fc.getColumn());
    }
    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        CellCoordination fc = new CellCoordination();
        //execute
        //assert
        assertNotNull(fc.describePossibleReasonsIfInvalid());
    }
}
