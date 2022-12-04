
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

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
package org.nanoboot.colorshapes.engine.composition.utils;

import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.powerframework.json.JsonObject;

public class MinusComposition extends AbstractComposition implements Composition<MinusComposition> {
    public MinusComposition() {
    }

    public MinusComposition(JsonObject jo) {
        fromJsonObject(jo);
    }
    @Getter
    @Setter
    private int value;

    @Override
    public String getName() {
        return "minusComposition";
    }

    @Override
    public MinusComposition returnThis() {
        return this;
    }

    public boolean validate() {
        return this.value < 0;
    }

    @Override
    public boolean setRandomValues() {
        this.value = -1000;
        return true;
    }

    @Override
    public boolean setDefaultValues() {
        this.value = -10;
        return true;
    }
    @Override
    public JsonObject toJsonObject() {
        JsonObject jo = getInitialJsonObject();
        jo.addInt("value", value);
        return jo;
    }

    @Override
    public void fromJsonObject(final JsonObject jo) {
        this.setValue(jo.getInt("value"));
    }
    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "test";
    }
}
