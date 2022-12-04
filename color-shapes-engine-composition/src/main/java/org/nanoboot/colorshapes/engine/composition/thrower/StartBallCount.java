
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

package org.nanoboot.colorshapes.engine.composition.thrower;

import org.nanoboot.colorshapes.engine.composition.common.MinMaxIntHolder;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * A Frequency utility.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class StartBallCount extends MinMaxIntHolder<StartBallCount> {
    /**
     * Min start ball count constant.
     *
     * @since 0.0.0
     */
    public static final int MIN_START_BALL_COUNT = 1;
    /**
     * Max start ball count constant.
     *
     * @since 0.0.0
     */
    public static final int MAX_START_BALL_COUNT = 8;
    /**
     * Default start ball count.
     *
     * @since 0.0.0
     */
    public static final int DEFAULT_START_BALL_COUNT = 5;

    /**
     * Constructor.
     *
     * @param value    value to be hold
     */
    public StartBallCount(final int value) {
        super(value,
                MIN_START_BALL_COUNT,
                MAX_START_BALL_COUNT,
                DEFAULT_START_BALL_COUNT);
    }
    /**
     * Constructor.
     *
     */
    public StartBallCount() {
        this(DEFAULT_START_BALL_COUNT);
    }
    /**
     * Constructor.
     *
     * @param jo    json object
     */
    public StartBallCount(final JsonObject jo) {
        fromJsonObject(jo);
    }

    @Override
    public final StartBallCount returnThis() {
        return this;
    }
}
