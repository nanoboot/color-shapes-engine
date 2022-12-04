
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

package org.nanoboot.colorshapes.engine.composition.other;

import org.nanoboot.powerframework.json.JsonObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class OtherCompositionTest {

    @Test
    public void validate() {
        //prepare
        //execute
        //validate
        for(OtherComposition oc : getAllPossibleCombinationOfOtherComposition()) {
            assertTrue(oc.validate());
        }
    }

    @Test
    public void setDefaultValues() {
        //prepare
        OtherComposition oc = new OtherComposition(false, true, true);
        //execute
        oc.setDefaultValues();
        //assert
        assertFalse(oc.isAllowedStepBack());
        assertFalse(oc.isFreeMode());
        assertFalse(oc.isTrainer());
    }

    @Test
    public void setRandomValues() {
        //prepare
        OtherComposition oc = new OtherComposition(false, true, true);
        //execute
        oc.setRandomValues();
        //assert
        assertFalse(oc.isAllowedStepBack());
        assertFalse(oc.isFreeMode());
        assertFalse(oc.isTrainer());
    }

    @Test
    public void createCopy() {
        //prepare
        //execute
        //validate
        for(OtherComposition oc : getAllPossibleCombinationOfOtherComposition()) {
            OtherComposition copy = oc.createCopy();
            assertEquals(oc.toJsonObject().toMinimalString(), copy.toJsonObject().toMinimalString());
        }
    }

    @Test
    public void toJsonObject() {
        //prepare
        String otherAsJson = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.other.OtherComposition\",\"id\":null,\"allowedStepBack\":false,\"freeMode\":false,\"trainer\":false}";
        OtherComposition oc = new OtherComposition(false, false, false);
        String returned;
        //execute
        returned = oc.toJsonObject().toMinimalString();
        //assert
        assertEquals("Expected " + otherAsJson + ", but was " + returned, otherAsJson, returned);
    }

    @Test
    public void fromJsonObject() {
        //prepare
        String otherAsJson = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.other.OtherComposition\",\"allowedStepBack\":false,\"freeMode\":false,\"trainer\":false}";
        //execute
        OtherComposition oc = new OtherComposition();
        oc.fromJsonObject(new JsonObject(otherAsJson));
        //assert
        assertEquals(false, oc.isAllowedStepBack());
        assertEquals(false, oc.isFreeMode());
        assertEquals(false, oc.isTrainer());
    }

    @Test
    public void constructor_json() {
        //prepare
        String otherAsJson = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.other.OtherComposition\",\"allowedStepBack\":false,\"freeMode\":false,\"trainer\":false}";
        //execute
        OtherComposition oc = new OtherComposition(new JsonObject(otherAsJson));
        //assert
        assertEquals(false, oc.isAllowedStepBack());
        assertEquals(false, oc.isFreeMode());
        assertEquals(false, oc.isTrainer());
    }

    @Test
    public void getAllPossibleCombinationOfOtherCompositionTest() {
        //prepare
        OtherComposition[] array = getAllPossibleCombinationOfOtherComposition();
        //execute
        //assert
        assertEquals(false, array[0].isAllowedStepBack());
        assertEquals(false, array[0].isFreeMode());
        assertEquals(false, array[0].isTrainer());
        //
        assertEquals(false, array[1].isAllowedStepBack());
        assertEquals(false, array[1].isFreeMode());
        assertEquals(true, array[1].isTrainer());
        //
        assertEquals(false, array[2].isAllowedStepBack());
        assertEquals(true, array[2].isFreeMode());
        assertEquals(false, array[2].isTrainer());
        //
        assertEquals(false, array[3].isAllowedStepBack());
        assertEquals(true, array[3].isFreeMode());
        assertEquals(true, array[3].isTrainer());
        //
        assertEquals(true, array[4].isAllowedStepBack());
        assertEquals(false, array[4].isFreeMode());
        assertEquals(false, array[4].isTrainer());
        //
        assertEquals(true, array[5].isAllowedStepBack());
        assertEquals(false, array[5].isFreeMode());
        assertEquals(true, array[5].isTrainer());
        //
        assertEquals(true, array[6].isAllowedStepBack());
        assertEquals(true, array[6].isFreeMode());
        assertEquals(false, array[6].isTrainer());
        //
        assertEquals(true, array[7].isAllowedStepBack());
        assertEquals(true, array[7].isFreeMode());
        assertEquals(true, array[7].isTrainer());
        //

    }
    public OtherComposition[] getAllPossibleCombinationOfOtherComposition() {
        OtherComposition[] array = new OtherComposition[8];
        int index = 0;
        array[index] = new OtherComposition(false, false, false);
        index++;
        array[index] = new OtherComposition(false, false, true);
        index++;
        array[index] = new OtherComposition(false, true, false);
        index++;
        array[index] = new OtherComposition(false, true, true);
        index++;
        array[index] = new OtherComposition(true, false, false);
        index++;
        array[index] = new OtherComposition(true, false, true);
        index++;
        array[index] = new OtherComposition(true, true, false);
        index++;
        array[index] = new OtherComposition(true, true, true);
        return array;
    }


    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        OtherComposition o = new OtherComposition();
        //execute
        //assert
        assertNotNull(o.describePossibleReasonsIfInvalid());
    }
}
