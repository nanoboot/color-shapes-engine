
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

package org.nanoboot.colorshapes.engine.composition.utils;

import org.nanoboot.powerframework.json.JsonObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ProbabilityTest {

    @Test
    public void cells() {
        //prepare
        //execute
        //assert
        assertEquals(0, Probability.MIN_VALUE);//NOSONAR
        assertEquals(100, Probability.MAX_VALUE);//NOSONAR
    }

    class DummyProbability extends Probability {
        public DummyProbability(JsonObject jo) {
            super(jo);
        }

        public DummyProbability() {

        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public DummyProbability returnThis() {
            return this;
        }
    }
    @Test
    public void constructor_json() {
        //prepare
        Probability p = getDummyProbability();
        p.setDefaultValues();
        JsonObject jo = p.toJsonObject();

        //execute
        Probability f2 = new DummyProbability(jo);
        //assert
        assertEquals(jo.toMinimalString(), f2.toJsonObject().toMinimalString());
    }

    public Probability getDummyProbability() {
        return new DummyProbability();
    }
}
