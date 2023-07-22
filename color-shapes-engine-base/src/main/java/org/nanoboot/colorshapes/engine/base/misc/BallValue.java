
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

package org.nanoboot.colorshapes.engine.base.misc;

import org.nanoboot.colorshapes.engine.base.exceptions.ColorShapesEngineException;
import lombok.Getter;

/**
 * Ball value (-2, -1, 0, 1 or 2).
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum BallValue {
    /**
     * -2.
     */
    MINUS_TWO(-2),
    /**
     * -1.
     */
    MINUS_ONE(-1),
    /**
     * 0.
     */
    ZERO(0),
    /**
     * 1.
     */
    PLUS_ONE(1),
    /**
     * 2.
     */
    PLUS_TWO(2);
    /**
     * Min value.
     */
    public static final int MIN_VALUE = MINUS_TWO.getNumber();
    /**
     * Max value.
     */
    public static final int MAX_VALUE = PLUS_TWO.getNumber();
    /**
     * Default value.
     */
    public static final int DEFAULT_VALUE = PLUS_ONE.getNumber();

    /**
     * Returns BallValue from number.
     * @param number colour number
     * @return BallValue instance
     * @throws  ColorShapesEngineException if the colour number is unknown
     */
    public static BallValue ofNumber(final int number) {
        for (BallValue bv : BallValue.values()) {
            if (bv.getNumber() == number) {
                return bv;
            }
        }
        throw new ColorShapesEngineException("Unknown ball value " + number);
    }
    /**
     * Number.
     */
    @Getter
    private final int number;

    /**
     * Constructor.
     * @param numberIn ball value
     */
    BallValue(final int numberIn) {
        this.number = numberIn;
    }
}
