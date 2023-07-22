
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

package org.nanoboot.colorshapes.engine.composition.factory;

import org.nanoboot.colorshapes.engine.composition.utils.Probability;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class MovableBallProbabilityTest {

    @Test
    public void constructor_empty() {
        //prepare
        MovableBallProbability movableBallProbability = new MovableBallProbability();
        //execute
        //assert
        assertEquals(0, movableBallProbability.getValue().intValue());
    }
    @Test
    public void constructor_jo() {
        //prepare
        MovableBallProbability movableBallProbability = new MovableBallProbability();
        MovableBallProbability movableBallProbability2 = new MovableBallProbability(movableBallProbability.toJsonObject());
        //execute
        //assert
        assertEquals(movableBallProbability.toJsonObject().toMinimalString(), movableBallProbability2.toJsonObject().toMinimalString());
    }
    @Test
    public void returnThis() {
        //prepare
        MovableBallProbability movableBallProbability = new MovableBallProbability(10);
        //execute
        //assert
        assertEquals(movableBallProbability, movableBallProbability.returnThis());
    }

    @Test
    public void setDefaultValues() {
        //prepare
        MovableBallProbability movableBallProbability = new MovableBallProbability();
        movableBallProbability.setDefaultValues();
        //execute
        //assert
        assertEquals(Probability.MIN_VALUE, movableBallProbability.getValue().intValue());
    }
}
