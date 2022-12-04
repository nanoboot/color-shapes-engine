
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

import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * Class holding an Integer value.
 * @param <C> class type
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class CompositionBooleanHolder<C extends Composition>
        extends BooleanHolder implements Composition<C> {
    /**
     * Constructor.
     * @param value boolean value
     */
    public CompositionBooleanHolder(final boolean value) {
        super(value);
    }
    /**
     * Constructor.
     */
    public CompositionBooleanHolder() {
        super();
    }

    /**
     * Constructor.
     * @param jo json object
     */
    public CompositionBooleanHolder(final JsonObject jo) {
        fromJsonObject(jo);
    }

    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "Invalid boolean";
    }
    @Override
    public final boolean validate() {
        return true;
    }
    @Override
    public final boolean setDefaultValues() {
        this.setValue(getDefaultValue());
        return true;
    }

    /**
     * @return default value
     */
    public Boolean getDefaultValue() {
        return false;
    }

    /**
     * @return json object
     */
    @Override
    public JsonObject toJsonObject() {
        JsonObject jo = getInitialJsonObject();
        jo.addBoolean("value", this.getValue());
        return jo;
    }

    /**
     * @param jsonObject json object
     */
    @Override
    public void fromJsonObject(final JsonObject jsonObject) {
        this.setValue(jsonObject.getBoolean("value"));
    }
}
