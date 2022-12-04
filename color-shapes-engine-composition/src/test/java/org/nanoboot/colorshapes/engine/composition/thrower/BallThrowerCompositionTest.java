
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

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallThrowerCompositionTest {
    @Test
    public void constructor_6args() {
        //prepare
        BallThrowerComposition ballThrowerComposition = new BallThrowerComposition(
                null,
                6,
                4,
                false
        );
        //execute
        //assert
        Assert.assertEquals(6, ballThrowerComposition.getStartBallCount().getValue().intValue());
        Assert.assertEquals(4, ballThrowerComposition.getNextBallCount().getValue().intValue());
        Assert.assertEquals(false, ballThrowerComposition.getShowNextBallPositions().getValue().booleanValue());
    }

    @Test
    public void constructor_empty() {
        //prepare
        BallThrowerComposition ballThrowerComposition = new BallThrowerComposition(
        );
        //execute
        //assert
        assertNotNull(ballThrowerComposition.getStartBallCount());
        assertNotNull(ballThrowerComposition.getNextBallCount());
        assertNotNull(ballThrowerComposition.getShowNextBallPositions());
    }

    @Test
    public void constructor_jo() {
        //prepare
        BallThrowerComposition ballThrowerComposition = new BallThrowerComposition();
        BallThrowerComposition ballThrowerComposition2 = new BallThrowerComposition(ballThrowerComposition.toJsonObject());
        //execute
        //assert
        Assert.assertEquals(ballThrowerComposition.toJsonObject().toMinimalString(), ballThrowerComposition2.toJsonObject().toMinimalString());
    }
    @Test
    public void returnThis() {
        //prepare
        BallThrowerComposition ballThrowerComposition = new BallThrowerComposition();
        //execute
        //assert
        assertEquals(ballThrowerComposition, ballThrowerComposition.returnThis());
    }

    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        BallThrowerComposition ballThrowerComposition = new BallThrowerComposition();
        //execute
        //assert
        assertNotNull(ballThrowerComposition.describePossibleReasonsIfInvalid());
    }
}
