
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

import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import lombok.Getter;
import lombok.Setter;

import org.nanoboot.colorshapes.engine.composition.board.shape.BoardShape;
import org.nanoboot.colorshapes.engine.composition.board.shape.Shape;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.json.JsonValueType;
import org.nanoboot.powerframework.random.generators.RandomGenerator;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ShapeFinderComposition extends AbstractComposition
        implements Composition<ShapeFinderComposition> {
    /**
     * Default minimum exploding size for line.
     */
    public static final int DEFAULT_MINIMUM_EXPLODING_SIZE_FOR_LINE = 5;
    /**
     * minimum exploding size for line.
     */
    public static final int MIN_LINE_LENGTH = 2;
    /**
     * Maximum exploding size for line.
     */
    public static final int MAX_LINE_LENGTH = 32;
    /**
     * Minimum exploding size for block.
     */
    public static final int MIN_BLOCK_SIZE = 3;
    /**
     * Maximum exploding size for block.
     */
    public static final int MAX_BLOCK_SIZE = 32;
    /**
     * Minimum exploding size for ring or square.
     */
    public static final int MIN_RING_OR_SQUARE_SIZE = 4;
    /**
     * Maximum exploding size for ring or square.
     */
    public static final int MAX_RING_OR_SQUARE_SIZE = 16;
    /**
     * Internal constant.
     */
    private static final String CUSTOM_EXPLODING_SHAPE = "customExplodingShape";
    
    /**
     * Exploding shape type.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ExplodingShapeType explodingShapeType = ExplodingShapeType.LINE;
    /**
     * Minimum size of the shape.
     * Mandatory, if not custom shape, otherwise must be null.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private MinimumSize minimumSize = new MinimumSize();
    /**
     * Custom exploding shape.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private Shape customExplodingShape = null;

    /**
     * Constructor.
     * @param ballDetonatorCompositionJsonObject json object
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public ShapeFinderComposition(
            final JsonObject ballDetonatorCompositionJsonObject) {
        fromJsonObject(ballDetonatorCompositionJsonObject);
    }

    /**
     * Constructor.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public ShapeFinderComposition() {
        this.setDefaultValues();
    }

    
    /**
     * @param explodingShapeType exploding shape type
     * @param minimumSizeIn minimum size
     * @param customExplodingShapeIn custom exploding shape
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public ShapeFinderComposition(
            final ExplodingShapeType explodingShapeType,
            final int minimumSizeIn,
            final Shape customExplodingShapeIn
    ) {
        this(null, explodingShapeType, minimumSizeIn, customExplodingShapeIn);
    }
    
    /**
     * @param id
     * @param explodingShapeType exploding shape type
     * @param minimumSizeIn minimum size
     * @param customExplodingShapeIn custom exploding shape
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public ShapeFinderComposition(
            final String id,
            final ExplodingShapeType explodingShapeType,
            final int minimumSizeIn,
            final Shape customExplodingShapeIn
    ) {
        this.id = id;
        this.explodingShapeType = explodingShapeType;
        this.minimumSize = new MinimumSize(minimumSizeIn);
        this.customExplodingShape = customExplodingShapeIn;
    }

    @Override
    public final boolean validate() {
        if (this.explodingShapeType == null) {
            return false;
        }
        if (this.explodingShapeType == ExplodingShapeType.CUSTOM
                && this.customExplodingShape == null) {
            return false;
        }
        if (this.explodingShapeType != ExplodingShapeType.CUSTOM
                && this.customExplodingShape != null) {
            return false;
        }

        switch (explodingShapeType) {
            case LINE:
                return Composition.isInRange(
                        minimumSize.getValue().intValue(),
                        MIN_LINE_LENGTH, MAX_LINE_LENGTH);
            case BLOCK:
                return Composition.isInRange(
                        minimumSize.getValue().intValue(),
                        MIN_BLOCK_SIZE, MAX_BLOCK_SIZE);
            case CUSTOM:
                return minimumSize.isZero();
            case RING:
                return Composition.isInRange(
                        minimumSize.getValue(),
                        MIN_RING_OR_SQUARE_SIZE,
                        MAX_RING_OR_SQUARE_SIZE);
            case SQUARE:
                return Composition.isInRange(
                        minimumSize.getValue(),
                        MIN_RING_OR_SQUARE_SIZE,
                        MAX_RING_OR_SQUARE_SIZE);
            default:
                throw new IllegalStateException("Unknown exploding shape type "
                        + explodingShapeType);
        }
    }

    @Override
    public final boolean setDefaultValues() {
        this.explodingShapeType = ExplodingShapeType.LINE;
        this.minimumSize = new MinimumSize(
                DEFAULT_MINIMUM_EXPLODING_SIZE_FOR_LINE);
        this.customExplodingShape = null;
        return true;
    }

    @Override
    public final boolean setRandomValues() {
        this.customExplodingShape = null;
        int choiceFrom = ExplodingShapeType.LINE.getNumber();
        int choiceTo = ExplodingShapeType.SQUARE.getNumber();
        int choice = RandomGenerator.getDefaultImplStatic()
                .nextInt(choiceFrom, choiceTo);
        this.explodingShapeType = ExplodingShapeType.ofNumber(choice);
        switch (explodingShapeType) {
            case LINE:
                this.minimumSize.setValue(RandomGenerator
                        .getDefaultImplStatic()
                        .nextInt(MIN_LINE_LENGTH, MAX_LINE_LENGTH));
                break;
            case BLOCK:
                this.minimumSize.setValue(RandomGenerator
                        .getDefaultImplStatic()
                        .nextInt(MIN_BLOCK_SIZE, MAX_BLOCK_SIZE));
                break;
            case RING:
                this.minimumSize.setValue(RandomGenerator
                        .getDefaultImplStatic()
                        .nextInt(
                                MIN_RING_OR_SQUARE_SIZE,
                                MAX_BLOCK_SIZE * MAX_BLOCK_SIZE));
                break;
            case SQUARE:
                this.minimumSize.setValue(RandomGenerator
                        .getDefaultImplStatic()
                        .nextInt(
                                MIN_RING_OR_SQUARE_SIZE,
                                MAX_BLOCK_SIZE * MAX_BLOCK_SIZE));
                break;
            default:
                throw new IllegalStateException();
        }
        return true;
    }

    @Override
    public final ShapeFinderComposition createCopy() {
        Shape customExplodingShapeCopy;
        if (this.customExplodingShape == null) {
            customExplodingShapeCopy = null;
        } else {
            customExplodingShapeCopy = this.customExplodingShape.createCopy();
        }
        return new ShapeFinderComposition(
                this.id,
                this.explodingShapeType,
                this.minimumSize.getValue(),
                customExplodingShapeCopy);
    }
    @Override
    public final JsonObject toJsonObject() {
        JsonObject ballDetonatorCompositionJsonObject = getInitialJsonObject();

        ballDetonatorCompositionJsonObject
                .addString("explodingShapeType",
                        this.explodingShapeType.toString());
        ballDetonatorCompositionJsonObject
                .addInt("minimumSize", this.minimumSize.getValue());
        if (this.customExplodingShape == null) {
            ballDetonatorCompositionJsonObject
                    .addNull(CUSTOM_EXPLODING_SHAPE);
        } else {
            ballDetonatorCompositionJsonObject
                    .addObject(CUSTOM_EXPLODING_SHAPE,
                            this.customExplodingShape.toJsonObject());
        }

        return ballDetonatorCompositionJsonObject;
    }

    @Override
    public final void fromJsonObject(
            final JsonObject ballDetonatorCompositionJsonObject) {
        this.explodingShapeType = ExplodingShapeType.valueOf(
                ballDetonatorCompositionJsonObject
                        .getString("explodingShapeType"));
        this.minimumSize =
                new MinimumSize(
                        ballDetonatorCompositionJsonObject
                                .getInt("minimumSize"));
        if (ballDetonatorCompositionJsonObject.getJsonValueType(
                CUSTOM_EXPLODING_SHAPE) == JsonValueType.NULL) {
            this.customExplodingShape = null;
        } else {
            this.customExplodingShape =
                    new BoardShape(ballDetonatorCompositionJsonObject
                            .getObject(CUSTOM_EXPLODING_SHAPE));
        }
    }

    @Override
    public final ShapeFinderComposition returnThis() {
        return this;
    }


    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "One of children is not valid.";
    }
}
