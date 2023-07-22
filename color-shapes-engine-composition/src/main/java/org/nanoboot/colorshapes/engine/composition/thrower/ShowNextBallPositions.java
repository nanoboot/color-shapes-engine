
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

package org.nanoboot.colorshapes.engine.composition.thrower;

import org.nanoboot.colorshapes.engine.composition.common.CompositionBooleanHolder;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ShowNextBallPositions extends
        CompositionBooleanHolder<ShowNextBallPositions> {

    /**
     * Constructor.
     *
     * @param value    value to be hold
     */
    public ShowNextBallPositions(final boolean value) {
        super(value);
    }
    /**
     * Constructor.
     *
     */
    public ShowNextBallPositions() {
        super();
    }
    /**
     * Constructor.
     *
     * @param jo    json object
     */
    public ShowNextBallPositions(final JsonObject jo) {
        super(jo);
    }

    @Override
    public final ShowNextBallPositions returnThis() {
        return this;
    }
}
