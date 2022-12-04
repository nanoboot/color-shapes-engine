
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

package org.nanoboot.colorshapes.engine.composition.common;

import org.nanoboot.powerframework.json.JsonObject;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class MinMaxIntHolderTest {
    class MinMaxIntHolderImpl extends MinMaxIntHolder<MinMaxIntHolderImpl> {

        /**
         * Constructor.
         *
         * @param value value to be hold
         */
        public MinMaxIntHolderImpl(int value) {
            super(value, 0, 10, 5);
        }

        public MinMaxIntHolderImpl() {
            super();
        }

        public MinMaxIntHolderImpl(JsonObject jo) {
            super(jo);
        }

        @Override
        public String getName() {
            return "MinMaxIntHolderImpl";
        }

        @Override
        public MinMaxIntHolderImpl returnThis() {
            return this;
        }
    }

    @Test
    public void validate() {
        //prepare
        MinMaxIntHolderImpl minMaxIntHolderImpl = new MinMaxIntHolderImpl(0);
        //execute
        //assert
        for (int i = -1; i <= 11; i++) {
            boolean expected = i >= 0 && i <= 10;
            minMaxIntHolderImpl.setValue(i);
            assertEquals("i = "+ i, expected, minMaxIntHolderImpl.validate());
        }
    }
    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        MinMaxIntHolderImpl minMaxIntHolderImpl = new MinMaxIntHolderImpl(0);
        //execute
        //assert
        assertNotNull(minMaxIntHolderImpl.describePossibleReasonsIfInvalid());
    }
    @Test
    public void setRandomValues() {
        //prepare
        MinMaxIntHolderImpl minMaxIntHolderImpl = new MinMaxIntHolderImpl(0);
        //execute
        //assert
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            minMaxIntHolderImpl.setRandomValues();
            int value = minMaxIntHolderImpl.getValue();

            assertTrue("i = "+ i, value >= 0 && value <= 10);
            if (!set.contains(value)) {
                set.add(value);
            }
        }
        assertTrue("Set size is " + set.size(), set.size() > 1);
    }

    @Test
    public void setDefaultValues() {
        //prepare
        MinMaxIntHolderImpl minMaxIntHolderImpl = new MinMaxIntHolderImpl(0);
        //execute
        //assert
        for (int i = 0; i < 10; i++) {
            minMaxIntHolderImpl.setDefaultValues();
            int value = minMaxIntHolderImpl.getValue();

            assertEquals("i = "+ i, 5, value);
        }
    }

    @Test
    public void isDefault() {
        //prepare
        MinMaxIntHolderImpl minMaxIntHolderImpl = new MinMaxIntHolderImpl(0);
        //execute
        //assert
        for (int i = -1; i <= 11; i++) {
            boolean expected = i == 5;
            minMaxIntHolderImpl.setValue(i);
            assertEquals("i = "+ i, expected, minMaxIntHolderImpl.isDefault());
        }
    }

    @Test
    public void toJsonObject() {
        //prepare
        String jos = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.common.MinMaxIntHolderTest$MinMaxIntHolderImpl\",\"id\":null,\"value\":3,\"minValue\":2,\"maxValue\":8,\"defaultValue\":5}";
        MinMaxIntHolderImpl minMaxIntHolderImpl = new MinMaxIntHolderImpl(0);
        //execute
        minMaxIntHolderImpl.setValue(3);
        minMaxIntHolderImpl.setMinValue(2);
        minMaxIntHolderImpl.setMaxValue(8);
        //assert
        String returned = minMaxIntHolderImpl.toJsonObject().toMinimalString();
        assertEquals("Expected " + jos + ", but was found " +returned, jos, returned);
    }

    @Test
    public void fromJsonObject() {
        //prepare
        String jos = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.common.MinMaxIntHolderTest$MinMaxIntHolderImpl\",\"value\":3,\"minValue\":2,\"maxValue\":8,\"defaultValue\":5}";
        //execute
        MinMaxIntHolderImpl minMaxIntHolderImpl = new MinMaxIntHolderImpl();
        minMaxIntHolderImpl.fromJsonObject(new JsonObject(jos));
        //assert
        assertEquals(3, minMaxIntHolderImpl.getValue().intValue());
        assertEquals(2, minMaxIntHolderImpl.getMinValue());
        assertEquals(8, minMaxIntHolderImpl.getMaxValue());
    }
    @Test
    public void constructor_json() {
        //prepare
        String jos = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.common.MinMaxIntHolderTest$MinMaxIntHolderImpl\",\"value\":3,\"minValue\":2,\"maxValue\":8,\"defaultValue\":5}";
        //execute
        MinMaxIntHolderImpl minMaxIntHolderImpl = new MinMaxIntHolderImpl(new JsonObject(jos));
        //assert
        assertEquals(3, minMaxIntHolderImpl.getValue().intValue());
        assertEquals(2, minMaxIntHolderImpl.getMinValue());
        assertEquals(8, minMaxIntHolderImpl.getMaxValue());
    }
    @Test
    public void constructor_4args() {
        //prepare
        //execute
        MinMaxIntHolderImpl minMaxIntHolderImpl = new MinMaxIntHolderImpl(7);
        //assert
        assertEquals(7, minMaxIntHolderImpl.getValue().intValue());
    }
    @Test
    public void isZero() {
        assertEquals(false, new MinMaxIntHolderImpl(-1).isZero());
        assertEquals(true, new MinMaxIntHolderImpl(0).isZero());
        assertEquals(false, new MinMaxIntHolderImpl(1).isZero());
    }
    @Test
    public void isNotZero() {
        assertEquals(true, new MinMaxIntHolderImpl(-1).isNotZero());
        assertEquals(false, new MinMaxIntHolderImpl(0).isNotZero());
        assertEquals(true, new MinMaxIntHolderImpl(1).isNotZero());
    }

}
