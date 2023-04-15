
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

package org.nanoboot.colorshapes.engine.composition.shapefinder;

import lombok.Getter;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum ExplodingShapeType {

    /**
     * line.
     *
     * @since 0.0.0
     */
    LINE(1),
    /**
     * block.
     *
     * @since 0.0.0
     */
    BLOCK(2),
    /**
     * ring.
     *
     * @since 0.0.0
     */
    RING(3),
    /**
     * square.
     *
     * @since 0.0.0
     */
    SQUARE(4),
    /**
     * custom.
     *
     * @since 0.0.0
     */
    CUSTOM(0),
    /**
     * Enum entry used only for testing purposes.
     * Please, do not use is it out of tests.
     *
     * @since 0.0.0
     */
    UNSUPPORTED_OPTION(999);

    /**
     * Number of the exploding shape type.
     */
    @Getter
    private final int number;

    /**
     * @param numberIn number of the exploding shape type
     */
    ExplodingShapeType(final int numberIn) {
        this.number = numberIn;
    }

    /**
     * @param number number of the exploding shape type
     * @return exploding shape type
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public static ExplodingShapeType ofNumber(final int number) {
        for (ExplodingShapeType e : ExplodingShapeType.values()) {
            if (e.getNumber() == number) {
                return e;
            }
        }

        String msg = "There is no such exploding shape type with number "
                + number;
        throw new ColorShapesEngineException(msg);
    }
}
