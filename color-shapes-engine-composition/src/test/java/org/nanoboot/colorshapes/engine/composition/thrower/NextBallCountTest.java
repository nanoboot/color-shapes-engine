
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

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class NextBallCountTest {
    @Test
    public void constructor_int() {
        //prepare
        NextBallCount nextBallCount = new NextBallCount(5);
        //execute
        //assert
        Assert.assertEquals(5, nextBallCount.getValue().intValue());
    }
    @Test
    public void constructor_empty() {
        //prepare
        NextBallCount nextBallCount = new NextBallCount();
        //execute
        //assert
        Assert.assertEquals(3, nextBallCount.getValue().intValue());
    }
    @Test
    public void constructor_jo() {
        //prepare
        NextBallCount nextBallCount = new NextBallCount();
        NextBallCount nextBallCount2 = new NextBallCount(nextBallCount.toJsonObject());
        //execute
        //assert
        Assert.assertEquals(nextBallCount.toJsonObject().toMinimalString(), nextBallCount2.toJsonObject().toMinimalString());
    }

    @Test
    public void returnThis() {
        //prepare
        NextBallCount nextBallCount = new NextBallCount(5);
        //execute
        //assert
        assertEquals(nextBallCount, nextBallCount.returnThis());
    }
}
