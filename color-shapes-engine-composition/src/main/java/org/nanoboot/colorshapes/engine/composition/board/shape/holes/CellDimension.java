
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

package org.nanoboot.colorshapes.engine.composition.board.shape.holes;

import org.nanoboot.colorshapes.engine.composition.common.MinMaxIntHolder;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * Cell dimension.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 * @param <C> Composition class
 */
public abstract class CellDimension<C extends Composition>
        extends MinMaxIntHolder<C> {
    /**
     * Min dimension value.
     *
     * @since 0.0.0
     */
    public static final int MIN_DIMENSION = 1;
    /**
     * Max dimension value.
     *
     * @since 0.0.0
     */
    public static final int MAX_DIMENSION = 32;
    /**
     * Default dimension value.
     *
     * @since 0.0.0
     */
    public static final int DEFAULT_DIMENSION = MIN_DIMENSION;
    /**
     * Constructor.
     *
     * @param value    value to be hold
     */
    public CellDimension(final int value) {
        super(value, MIN_DIMENSION, MAX_DIMENSION, DEFAULT_DIMENSION);
    }
    /**
     * Constructor.
     *
     */
    public CellDimension() {
        this(DEFAULT_DIMENSION);
    }
    /**
     * Constructor.
     *
     * @param jo    json object
     */
    public CellDimension(final JsonObject jo) {
        fromJsonObject(jo);
    }
}
