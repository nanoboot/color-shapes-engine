
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

package org.nanoboot.colorshapes.engine.composition.board;

import org.nanoboot.colorshapes.engine.composition.common.MinMaxIntHolder;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * A Probability utility. 
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class GridCount extends MinMaxIntHolder<GridCount> {

    /**
     * Min possible value for probability.
     *
     * @since 0.0.0
     */
    public static final int MIN_VALUE = 0;
    /**
     * Max possible value for probability.
     *
     * @since 0.0.0
     */
    public static final int MAX_VALUE = 16;
    /**
     * Default value for probability.
     *
     * @since 0.0.0
     */
    public static final int DEFAULT_VALUE = 0;

    /**
     * Constructor.
     *
     * @param value    value to be hold
     */
    public GridCount(final int value) {
        super(value, MIN_VALUE, MAX_VALUE, DEFAULT_VALUE);
    }
    /**
     * Constructor.
     *
     */
    public GridCount() {
        this(0);
    }
    /**
     * Constructor.
     *
     * @param jo    json object
     */
    public GridCount(final JsonObject jo) {
        fromJsonObject(jo);
    }

    @Override
    public final GridCount returnThis() {
        return this;
    }
}
