
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

package org.nanoboot.colorshapes.engine.game.utils;

import lombok.Getter;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum DirectionType {
    /**
     * Vertical.
     * .*.
     * .*.
     * .*.
     */
    VERTICAL(0),
    /**
     * Slant from right to left.
     * ..*
     * .*.
     * *..
     */
    SLANT_RIGHT_LEFT(1),
    /**
     * Horizontal.
     * ...
     * ***
     * ...
     */
    HORIZONTAL(2),
    /**
     * Slant from left to right.
     * *..
     * .*.
     * ..*
     */
    SLANT_LEFT_RIGHT(3);
    /**
     * Minimum number.
     */
    public static final int NUMBER_MIN = VERTICAL.getNumber();
    /**
     * Maximum number.
     */
    public static final int NUMBER_MAX = SLANT_LEFT_RIGHT.getNumber();
    /**
     * Number of direction types.
     */
    public static final int DIRECTION_TYPE_COUNT = values().length;

    /**
     * Half of the number of direction types.
     */
    public static final int DIRECTION_TYPE_COUNT_HALF =
            DIRECTION_TYPE_COUNT / 2;
    /**
     * Number for the direction.
     */
    @Getter
    private final int number;

    DirectionType(final int numberIn) {
        this.number = numberIn;
    }

    private static int normalizeNumber(final int number) {
        return Direction.NumberValidationResult.normalizeNumber(
                NUMBER_MIN,
                NUMBER_MAX,
                number,
                DIRECTION_TYPE_COUNT);
    }

    /**
     * Returns another direction using the parameters.
     *
     * @param numberCount count of positions
     * @return the computed direction
     */
    public DirectionType turn(final int numberCount) {
        return turn(
                Direction.RIGHT, numberCount);
    }

    /**
     * Returns another direction using the parameters.
     *
     * @param leftOrRight left or right move
     * @param numberCount count of positions
     * @return the computed direction
     */
    public DirectionType turn(
            final Direction leftOrRight,
            final int numberCount) {
        boolean isRightOrRight = leftOrRight.isOneOf(
                Direction.LEFT, Direction.RIGHT);
        if (!isRightOrRight) {
            String msg = "Direction must be left or right, but it is "
                    + leftOrRight;
            throw new ColorShapesEngineException(msg);
        }

        int numberToAdd = numberCount;
        if (leftOrRight.isLeft()) {
            numberToAdd = numberToAdd * (-1);
        }
        int currentNumber = this.getNumber();
        int newNumber = currentNumber + numberToAdd;
        int newNumberNormalized = normalizeNumber(newNumber);
        return ofNumber(newNumberNormalized);
    }

    /**
     * Get direction for the number.
     *
     * @param number number
     * @return direction
     */
    public static DirectionType ofNumber(final int number) {
        for (DirectionType dt : values()) {
            if (dt.getNumber() == number) {
                return dt;
            }
        }
        return null;
    }

    /**
     * Checks, if the direction number is valid.
     *
     * @param number number to check
     * @return result of the validation
     */
    public static Direction.NumberValidationResult validateNumber(
            final int number) {
        return Direction.NumberValidationResult.of(
                NUMBER_MIN, NUMBER_MAX, number);
    }

    /**
     * @return direction
     */
    public DirectionType overTurn() {
        return turn(Direction.RIGHT, DIRECTION_TYPE_COUNT_HALF);
    }

    /**
     * Checks the directionType, if it is one of the listed.
     *
     * @param directionType directionType
     * @return true, if the result was successful, otherwise false
     */
    public boolean isOneOf(final DirectionType... directionType) {
        for (DirectionType dt : directionType) {
            if (is(dt)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the directionType is not one of the listed.
     *
     * @param directionType directionType
     * @return true, if the result was successful, otherwise false
     */
    public boolean assureNotOneOf(final DirectionType... directionType) {
        for (DirectionType dt : directionType) {
            if (is(dt)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return true, if this directionType is slant, otherwise false
     */
    public boolean isSlant() {
        return this.getNumber() % 2 == 1;
    }

    /**
     * Checks, if this direction is vertical.
     *
     * @return result of this check.
     */
    public boolean isVertical() {
        return is(DirectionType.VERTICAL);
    }

    /**
     * Checks, if this direction is top horizontal.
     *
     * @return result of this check.
     */
    public boolean isHorizontal() {
        return is(DirectionType.HORIZONTAL);
    }

    /**
     * Checks, if this direction is slant right left.
     *
     * @return result of this check.
     */
    public boolean isSlantRightLeft() {
        return is(DirectionType.SLANT_RIGHT_LEFT);
    }

    /**
     * Checks, if this direction is slant left right.
     *
     * @return result of this check.
     */
    public boolean isSlantLeftRight() {
        return is(DirectionType.SLANT_LEFT_RIGHT);
    }

    /**
     * Checks the directionType.
     *
     * @param directionType directionType
     * @return result of this check.
     */
    public boolean is(final DirectionType directionType) {
        return this == directionType;
    }
}
