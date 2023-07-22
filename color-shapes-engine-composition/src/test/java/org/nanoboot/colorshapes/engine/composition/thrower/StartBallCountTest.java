
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

package org.nanoboot.colorshapes.engine.composition.thrower;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class StartBallCountTest {
    @Test
    public void constructor_int() {
        //prepare
        StartBallCount startBallCount = new StartBallCount(5);
        //execute
        //assert
        Assert.assertEquals(5, startBallCount.getValue().intValue());
    }
    @Test
    public void constructor_empty() {
        //prepare
        StartBallCount startBallCount = new StartBallCount();
        //execute
        //assert
        Assert.assertEquals(5, startBallCount.getValue().intValue());
    }
    @Test
    public void constructor_jo() {
        //prepare
        StartBallCount startBallCount = new StartBallCount();
        StartBallCount startBallCount2 = new StartBallCount(startBallCount.toJsonObject());
        //execute
        //assert
        Assert.assertEquals(startBallCount.toJsonObject().toMinimalString(), startBallCount2.toJsonObject().toMinimalString());
    }

    @Test
    public void returnThis() {
        //prepare
        StartBallCount startBallCount = new StartBallCount(4);
        //execute
        //assert
        assertEquals(startBallCount, startBallCount.returnThis());
    }
}
