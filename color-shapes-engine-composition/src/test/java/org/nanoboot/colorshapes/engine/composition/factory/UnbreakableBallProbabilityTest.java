
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
public class UnbreakableBallProbabilityTest {

    @Test
    public void constructor_empty() {
        //prepare
        BreakableBallProbability breakableBallProbability = new BreakableBallProbability();
        //execute
        //assert
        assertEquals(0, breakableBallProbability.getValue().intValue());
    }
    @Test
    public void constructor_jo() {
        //prepare
        BreakableBallProbability breakableBallProbability = new BreakableBallProbability();
        BreakableBallProbability breakableBallProbability2 = new BreakableBallProbability(breakableBallProbability.toJsonObject());
        //execute
        //assert
        assertEquals(breakableBallProbability.toJsonObject().toMinimalString(), breakableBallProbability2.toJsonObject().toMinimalString());
    }
    @Test
    public void returnThis() {
        //prepare
        BreakableBallProbability breakableBallProbability = new BreakableBallProbability(10);
        //execute
        //assert
        assertEquals(breakableBallProbability, breakableBallProbability.returnThis());
    }

    @Test
    public void setDefaultValues() {
        //prepare
        BreakableBallProbability breakableBallProbability = new BreakableBallProbability();
        breakableBallProbability.setDefaultValues();
        //execute
        //assert
        assertEquals(Probability.MIN_VALUE, breakableBallProbability.getValue().intValue());
    }
}
