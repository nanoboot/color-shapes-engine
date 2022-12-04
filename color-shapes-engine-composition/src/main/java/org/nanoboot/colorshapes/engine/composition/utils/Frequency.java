
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

import org.nanoboot.colorshapes.engine.composition.common.MinMaxIntHolder;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * A Frequency utility.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class Frequency extends MinMaxIntHolder<Frequency> {
    /**
     * Min possible value for frequency.
     *
     * @since 0.0.0
     */
    public static final int MIN_VALUE = 0;
    /**
     * Max possible value for frequency.
     *
     * @since 0.0.0
     */
    public static final int MAX_VALUE = 100;
    /**
     * Default value for frequency.
     *
     * @since 0.0.0
     */
    public static final int DEFAULT_VALUE = 50;

    /**
     * Half of max possible value for frequency.
     *
     * @since 0.0.0
     */
    public static final int HALF_MAX_VALUE = MAX_VALUE / 2;

    /**
     * Constructor.
     *
     * @param value    value to be hold
     */
    public Frequency(final int value) {
        super(value, MIN_VALUE, MAX_VALUE, DEFAULT_VALUE);
    }
    /**
     * Constructor.
     *
     */
    public Frequency() {
        this(0);
    }
    /**
     * Constructor.
     *
     * @param jo    json object
     */
    public Frequency(final JsonObject jo) {
        fromJsonObject(jo);
    }

    /**
     * Sets the value to a not null (50 - 100).
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public void setNotNullRandomValue() {
        int randomNotNull = RANDOM.nextInt(getMaxValue() / 2, getMaxValue());
        setValue(randomNotNull);
    }
}
