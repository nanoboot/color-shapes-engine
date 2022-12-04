
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

import org.nanoboot.colorshapes.engine.core.misc.ColorShapesEngineException;
import lombok.Getter;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum Direction {
    /**
     *
     */
    TOP(0),
    /**
     *
     */
    TOP_RIGHT(1),
    /**
     *
     */
    RIGHT(2),
    /**
     *
     */
    BOTTOM_RIGHT(3),
    /**
     *
     */
    BOTTOM(4),
    /**
     *
     */
    BOTTOM_LEFT(5),
    /**
     *
     */
    LEFT(6),
    /**
     *
     */
    TOP_LEFT(7);

    /**
     * Angle 45°.
     */
    public static final int ANGLE_45 = 45;
    /**
     * Minimum number.
     */
    public static final int NUMBER_MIN = TOP.getNumber();
    /**
     * Maximum number.
     */
    public static final int NUMBER_MAX = TOP_LEFT.getNumber();
    /**
     * Number of directions.
     */
    public static final int DIRECTION_COUNT = values().length;
    /**
     * Half of the number of directions.
     */
    public static final int DIRECTION_COUNT_HALF = DIRECTION_COUNT / 2;

    /**
     * Number for the direction.
     */
    @Getter
    private final int number;

    Direction(final int numberIn) {
        this.number = numberIn;
    }

    private static int normalizeNumber(final int number) {
        return Direction.NumberValidationResult.normalizeNumber(
                NUMBER_MIN,
                NUMBER_MAX,
                number,
                DIRECTION_COUNT);
    }

    /**
     * Get angle.
     *
     * @return angle
     */
    public int getAngle() {
        return this.getNumber() * ANGLE_45;
    }

    /**
     * Returns another direction using the parameters.
     *
     * @param numberCount count of positions
     * @return the computed direction
     */
    public Direction turn(final int numberCount) {
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
    public Direction turn(final Direction leftOrRight, final int numberCount) {
        return turnUsingAngles(leftOrRight, convertNumberToAngles(numberCount));
    }

    /**
     * Returns another direction using the parameters.
     *
     * @param leftOrRight left or right move
     * @param angles      angle count (must be true, that angles % 45 == 0)
     * @return the computed direction
     */
    public Direction turnUsingAngles(
            final Direction leftOrRight,
            final int angles) {
        boolean isRightOrRight = leftOrRight.isOneOf(
                Direction.LEFT, Direction.RIGHT);
        if (!isRightOrRight) {
            String msg = "Direction must be left or right, but it is "
                    + leftOrRight;
            throw new ColorShapesEngineException(msg);
        }

        int numberToAdd = convertAnglesToNumber(angles);
        if (leftOrRight.isLeft()) {
            numberToAdd = numberToAdd * (-1);
        }
        int currentNumber = this.getNumber();
        int newNumber = currentNumber + numberToAdd;
        int newNumberNormalized = normalizeNumber(newNumber);
        return ofNumber(newNumberNormalized);
    }

    /**
     * @param angles angle count (must be true, that angles % 45 == 0)
     * @return number using the angles
     */
    public static int convertAnglesToNumber(final int angles) {
        if (isAngleValid(angles)) {
            throw new ColorShapesEngineException("Invalid angles");
        }
        return angles / ANGLE_45;
    }

    /**
     * @param number number to convert
     * @return angles using the number
     */
    public static int convertNumberToAngles(final int number) {
        if (!validateNumber(number).isOk()) {
            throw new ColorShapesEngineException("Invalid number");
        }
        return number * ANGLE_45;
    }

    /**
     * Get direction for the angles.
     *
     * @param angles angles
     * @return direction
     */
    public static Direction ofAngles(final int angles) {
        int number = convertAnglesToNumber(angles);
        return ofNumber(number);
    }

    /**
     * Get direction for the number.
     *
     * @param number number
     * @return direction
     */
    public static Direction ofNumber(final int number) {
        for (Direction d : values()) {
            if (d.getNumber() == number) {
                return d;
            }
        }
        return null;
    }

    enum NumberValidationResult {
        /**
         * OK.
         */
        OK,
        /**
         * Too low.
         */
        TOO_LOW,
        /**
         * Too high.
         */
        TOO_HIGH;

        public boolean isOk() {
            return this == OK;
        }

        public boolean isTooLow() {
            return this == TOO_LOW;
        }

        public boolean isTooHigh() {
            return this == TOO_HIGH;
        }

        public static NumberValidationResult of(
                final int min,
                final int max,
                final int numberIn) {

            boolean numberTooLow = numberIn < min;
            boolean numberTooHigh = numberIn > max;
            if (numberTooLow) {
                return Direction.NumberValidationResult.TOO_LOW;
            }
            if (numberTooHigh) {
                return Direction.NumberValidationResult.TOO_HIGH;
            }
            return Direction.NumberValidationResult.OK;
        }

        public static int normalizeNumber(final int min,
                                          final int max,
                                          final int numberIn,
                                          final int countToNormalize) {
            Direction.NumberValidationResult numberValidationResult =
                    of(min, max, numberIn);
            if (!numberValidationResult.isOk()) {
                int numberToAdd = countToNormalize;
                int multiplier = 0;
                if (numberValidationResult.isTooHigh()) {
                    multiplier = -1;
                }
                if (numberValidationResult.isTooLow()) {
                    multiplier = 1;
                }
                if (multiplier == 0) {
                    String msg = "Internal error: multiplayer is 0.";
                    throw new ColorShapesEngineException(msg);
                }
                numberToAdd = numberToAdd * multiplier;
                return numberIn + numberToAdd;
            }

            return numberIn;
        }
    }

    /**
     * Checks, if the direction number is valid.
     *
     * @param number number to check
     * @return result of the validation
     */
    public static NumberValidationResult validateNumber(final int number) {
        return NumberValidationResult.of(
                NUMBER_MIN, NUMBER_MAX, number);
    }

    /**
     * Validates angles.
     *
     * @param angles angles to check
     * @return result of the check
     */
    public static boolean isAngleValid(final int angles) {
        return angles % ANGLE_45 != 0;
    }

    /**
     * @return direction
     */
    public Direction overTurn() {
        return turn(Direction.RIGHT, DIRECTION_COUNT_HALF);

    }

    /**
     * Checks the direction, if it is one of the listed.
     *
     * @param direction direction
     * @return true, if the result was successful, otherwise false
     */
    public boolean isOneOf(final Direction... direction) {
        for (Direction d : direction) {
            if (is(d)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the direction is not one of the listed.
     *
     * @param direction direction
     * @return true, if the result was successful, otherwise false
     */
    public boolean assureNotOneOf(final Direction... direction) {
        for (Direction d : direction) {
            if (is(d)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return true, if this direction is slant, otherwise false
     */
    public boolean isSlant() {
        return this.getNumber() % 2 == 1;
    }

    /**
     * Checks, if this direction is top.
     *
     * @return result of this check.
     */
    public boolean isTop() {
        return is(Direction.TOP);
    }

    /**
     * Checks, if this direction is top right.
     *
     * @return result of this check.
     */
    public boolean isTopRight() {
        return is(Direction.TOP_RIGHT);
    }

    /**
     * Checks, if this direction is right.
     *
     * @return result of this check.
     */
    public boolean isRight() {
        return is(Direction.RIGHT);
    }

    /**
     * Checks, if this direction is bottom right.
     *
     * @return result of this check.
     */
    public boolean isBottomRight() {
        return is(Direction.BOTTOM_RIGHT);
    }

    /**
     * Checks, if this direction is bottom.
     *
     * @return result of this check.
     */
    public boolean isBottom() {
        return is(Direction.BOTTOM);
    }

    /**
     * Checks, if this direction is bottom left.
     *
     * @return result of this check.
     */
    public boolean isBottomLeft() {
        return is(Direction.BOTTOM_LEFT);
    }

    /**
     * Checks, if this direction is left.
     *
     * @return result of this check.
     */
    public boolean isLeft() {
        return is(Direction.LEFT);
    }

    /**
     * Checks, if this direction is top left.
     *
     * @return result of this check.
     */
    public boolean isTopLeft() {
        return is(Direction.TOP_LEFT);
    }

    /**
     * Checks the direction.
     *
     * @param direction direction
     * @return result of this check.
     */
    public boolean is(final Direction direction) {
        return this == direction;
    }

    /**
     * Returns direction type.
     *
     * @return type of this direction
     */
    public DirectionType getType() {
        return DirectionType.ofNumber(
                this.getNumber() % DirectionType.DIRECTION_TYPE_COUNT);
    }

}
