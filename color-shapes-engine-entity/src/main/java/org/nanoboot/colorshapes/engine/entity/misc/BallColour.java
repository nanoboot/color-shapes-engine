
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

package org.nanoboot.colorshapes.engine.entity.misc;

import lombok.Getter;
import org.nanoboot.powerframework.utils.NamingConvention;
import org.nanoboot.powerframework.utils.NamingConventionConvertor;

/**
 * Ball colour enumeration.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum BallColour {
     /**
     * <p>
     * No colour is selected.</p>
     * <p>
     * For example, this is used for rainbow balls. </p>
     * <p>
     * Rainbow ball has no colour.</p>
     */
    NO_COLOUR(0),
    /**
     * Light Green.
     */
    LIGHT_GREEN(1),
    /**
     * Red.
     */
    RED(2),
    /**
     * Dark Blue.
     */
    DARK_BLUE(3),
    /**
     * Yellow.
     */
    YELLOW(4),
    /**
     * Light Blue.
     */
    LIGHT_BLUE(5),
    /**
     * Purple.
     */
    PURPLE(6),
    /**
     * Brown.
     */
    BROWN(7),
    /**
     * Pink.
     */
    PINK(8),
    /**
     * Green.
     */
    GREEN(9),
    /**
     * Gold.
     */
    GOLD(10),
    /**
     * Orange.
     */
    ORANGE(11),
    /**
     * White.
     */
    WHITE(12),
    /**
     * Grey.
     */
    GREY(13),
    /**
     * Black.
     */
    BLACK(14),
    /**
     * Blue.
     */
    BLUE(15),
    /**
     * OliveGreen.
     */
    OLIVE_GREEN(16);
    /**
     * Min value.
     */
    public static final int MIN_VALUE = LIGHT_GREEN.getNumber();
    /**
     * Max value.
     */
    public static final int MAX_VALUE = OLIVE_GREEN.getNumber();
    /**
     * Max value for default.
     */
    public static final int MAX_VALUE_FOR_DEFAULT = BROWN.getNumber();
    /**
     * Number.
     */
    @Getter
    private final int number;

    /**
     * Constructor.
     * @param numberIn colour number
     */
    BallColour(final int numberIn) {
        this.number = numberIn;
    }

    /**
     * @param number colour number
     * @return ball colour with the given number
     */
    public static BallColour ofNumber(final int number) {
        for (BallColour e : values()) {
            if (e.getNumber() == number) {
                return e;
            }
        }
        return null;
    }

    /**
     * Returns this colour as a human representation.
     * @return human representation of a ball colour
     * Example: LIGHT_GREEN is converted to "light green"
     */
    public final String asHumanName() {
        return NamingConventionConvertor.convert(
                this.name(), NamingConvention.DATABASE, NamingConvention.HUMAN);
    }
}
