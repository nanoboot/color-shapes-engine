
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

package org.nanoboot.colorshapes.engine.composition.thrower;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ShowNextBallPositionsTest {
    @Test
    public void constructor_int() {
        //prepare
        ShowNextBallPositions showNextBallPositions = new ShowNextBallPositions(true);
        //execute
        //assert
        assertEquals(true, showNextBallPositions.getValue().booleanValue());
        ////
        //prepare
        showNextBallPositions = new ShowNextBallPositions(false);
        //execute
        //assert
        assertEquals(false, showNextBallPositions.getValue().booleanValue());
    }

    @Test
    public void constructor_empty() {
        //prepare
        ShowNextBallPositions showNextBallPositions = new ShowNextBallPositions();
        //execute
        //assert
        assertEquals(false, showNextBallPositions.getValue().booleanValue());
    }

    @Test
    public void constructor_jo() {
        //prepare
        ShowNextBallPositions showNextBallPositions = new ShowNextBallPositions();
        ShowNextBallPositions showNextBallPositions2 = new ShowNextBallPositions(showNextBallPositions.toJsonObject());
        //execute
        //assert
        assertEquals(showNextBallPositions.toJsonObject().toMinimalString(), showNextBallPositions2.toJsonObject().toMinimalString());
    }

    @Test
    public void returnThis() {
        //prepare
        ShowNextBallPositions showNextBallPositions = new ShowNextBallPositions(true);
        //execute
        //assert
        assertEquals(showNextBallPositions, showNextBallPositions.returnThis());
    }

}
