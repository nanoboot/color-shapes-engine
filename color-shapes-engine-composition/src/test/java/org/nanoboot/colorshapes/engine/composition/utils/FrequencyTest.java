
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

package org.nanoboot.colorshapes.engine.composition.utils;

import org.nanoboot.powerframework.json.JsonObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class FrequencyTest {
    @Test
    public void cells() {
        //prepare
        //execute
        //assert
        assertEquals(0, Frequency.MIN_VALUE);//NOSONAR
        assertEquals(100, Frequency.MAX_VALUE);//NOSONAR
    }
    @Test
    public void setNotNullRandomValue() {
        //prepare
        //execute
        for(int i = 1; i<= 1000; i++) {
            Frequency f = getDummyFrequency();
            f.setDefaultValues();
            f.setNotNullRandomValue();
            int value = f.getValue().intValue();
            assertTrue(value >= 50);
            assertTrue(value <= 100);
        }
    }

    class DummyFrequency extends Frequency {
        public DummyFrequency(JsonObject jo) {
            super(jo);
        }

        public DummyFrequency() {

        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public Frequency returnThis() {
            return this;
        }
    }
    @Test
    public void constructor_json() {
        //prepare
        Frequency f = getDummyFrequency();
        f.setDefaultValues();
        JsonObject jo = f.toJsonObject();

        //execute
        Frequency f2 = new DummyFrequency(jo);
        //assert
        assertEquals(jo.toMinimalString(), f2.toJsonObject().toMinimalString());
    }

    public Frequency getDummyFrequency() {
        return new DummyFrequency();
    }
}
