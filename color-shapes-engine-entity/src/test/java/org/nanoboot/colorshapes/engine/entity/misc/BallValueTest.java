
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

package org.nanoboot.colorshapes.engine.entity.misc;

import org.nanoboot.colorshapes.engine.entity.misc.BallValue;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallValueTest {
    @Test
    public void cells() {
        //prepare
        //execute
        //assert
        assertEquals(-2, BallValue.MIN_VALUE);//NOSONAR
        assertEquals(2, BallValue.MAX_VALUE);//NOSONAR
        assertEquals(1, BallValue.DEFAULT_VALUE);//NOSONAR
    }

    @Test
    public void ofNumber() {
        for(int i= -2; i <= 2; i++) {
            assertEquals(i, BallValue.ofNumber(i).getNumber());
        }
    }
    @Test(expected = ColorShapesEngineException.class)
    public void ofNumberMinus3() {
        BallValue.ofNumber(-3);
    }
    @Test(expected = ColorShapesEngineException.class)
    public void ofNumberPlus3() {
        BallValue.ofNumber(3);
    }
}
