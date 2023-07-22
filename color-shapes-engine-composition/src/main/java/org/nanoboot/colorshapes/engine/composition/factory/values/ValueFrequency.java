
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

package org.nanoboot.colorshapes.engine.composition.factory.values;

import lombok.Getter;
import lombok.Setter;
import org.nanoboot.colorshapes.engine.base.misc.BallValue;
import org.nanoboot.colorshapes.engine.composition.utils.Frequency;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * Value frequency.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ValueFrequency extends Frequency {
    /**
     * Value.
     */
    @Getter
    @Setter
    private int valueNumber;

    /**
     * Constructor.
     *
     * @param value    value to be hold
     * @param valueNumberIn value frequency number
     */
    public ValueFrequency(final int value, final int valueNumberIn) {
        super(value);
        this.valueNumber = valueNumberIn;
    }
    /**
     * Constructor.
     *
     */
    public ValueFrequency() {
        super();
        this.valueNumber = BallValue.DEFAULT_VALUE;
    }

    /**
     * Constructor.
     *
     * @param jo    json object
     */
    public ValueFrequency(final JsonObject jo) {
        super(jo);
    }
    /**
     * @return
     */
    @Override
    public JsonObject toJsonObject() {
        JsonObject jo = super.toJsonObject();
        jo.addInt("valueNumber", this.valueNumber);
        return jo;
    }
    /**
     *
     * @param jo
     */
    @Override
    public void fromJsonObject(final JsonObject jo) {
        super.fromJsonObject(jo);
        this.valueNumber = jo.getInt("valueNumber");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getName() {
        return generateKey(valueNumber);
    }

    /**
     * Generates key for getName().
     * @param value from -2 to 2
     * @return the key
     */
    private static String generateKey(final int value) {
        StringBuilder sb = new StringBuilder();
        sb.append("value");
        if (value <= -1) {
            sb.append("Minus");
        }
        if (value >= 1) {
            sb.append("Plus");
        }
        sb.append(value >= 0 ? value : value * (-1));
        sb.append("Frequency");
        return sb.toString();
    }

    @Override
    public final ValueFrequency returnThis() {
        return this;
    }
}
