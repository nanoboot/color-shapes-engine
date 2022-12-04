
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
import org.nanoboot.powerframework.json.JsonValueType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CompositionBooleanHolderTest {
    @Test
    public void constructor_empty() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl();
        //execute
        //assert
        assertEquals(true, compositionBooleanHolder.isDefault());
    }

    @Test
    public void constructor_jo() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl();
        CompositionBooleanHolderImpl compositionBooleanHolder2 = new CompositionBooleanHolderImpl(compositionBooleanHolder.toJsonObject());
        //execute
        //assert
        assertEquals(compositionBooleanHolder.toJsonObject().toMinimalString(), compositionBooleanHolder2.toJsonObject().toMinimalString());
    }

    @Test
    public void constructor_1arg() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl(true);
        //execute
        //assert
        assertEquals(true, compositionBooleanHolder.getValue());
    }

    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl();
        //execute
        //assert
        Assert.assertNotNull(compositionBooleanHolder.describePossibleReasonsIfInvalid());
    }

    @Test
    public void validate() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl(true);
        //execute
        //assert
        Assert.assertEquals(true, compositionBooleanHolder.validate());
    }
    @Test
    public void validate2() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl(false);
        //execute
        //assert
        Assert.assertEquals(true, compositionBooleanHolder.validate());
    }

    @Test
    public void setDefaultValues() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl(true);
        //execute
        compositionBooleanHolder.setDefaultValues();
        //assert
        assertEquals(false, compositionBooleanHolder.getValue());
    }

    @Test
    public void getDefaultValue() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl(true);
        //execute
        //assert
        Assert.assertEquals(false, compositionBooleanHolder.getDefaultValue());
    }

    @Test
    public void toJsonObject() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl(true);
        //execute
        //assert
        JsonObject jo = compositionBooleanHolder.toJsonObject();
        Assert.assertTrue(jo.hasKey("value"));
        Assert.assertTrue(jo.getJsonValueType("value") == JsonValueType.BOOLEAN);
    }

    @Test
    public void fromJsonObject() {
        //prepare
        CompositionBooleanHolderImpl compositionBooleanHolder = new CompositionBooleanHolderImpl(true);
        CompositionBooleanHolderImpl compositionBooleanHolder2 = new CompositionBooleanHolderImpl(compositionBooleanHolder.toJsonObject());
        //execute
        //assert
        Assert.assertEquals(compositionBooleanHolder.toJsonObject().toMinimalString(), compositionBooleanHolder2.toJsonObject().toMinimalString());
    }
}
