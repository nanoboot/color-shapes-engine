
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

import org.nanoboot.colorshapes.engine.composition.board.shape.Shape;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.json.JsonObject;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CustomExplodingShape extends Shape {
    /**
     * Min height.
     *
     * @since 0.0.0
     */
    public static final int MIN_HEIGHT = 3;

    /**
     * Max height.
     *
     * @since 0.0.0
     */
    public static final int MAX_HEIGHT = 32;
    //
    /**
     * Min width.
     *
     * @since 0.0.0
     */
    public static final int MIN_WIDTH = 3;
    /**
     * Max width.
     *
     * @since 0.0.0
     */
    public static final int MAX_WIDTH = 32;
    //
    /**
     * Constructor.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public CustomExplodingShape() {
        super();
    }
    /**
     * Constructor.
     *
     * @param shapeJsonObject shape as json object
     * @author Robert Vokac
     * @since 0.0.0
     */
    public CustomExplodingShape(final JsonObject shapeJsonObject) {
        super(shapeJsonObject);
    }

    /**
     * @param id
     * @param heightIn height
     * @param widthIn  width
     * @author Robert Vokac
     * @since 0.0.0
     */
    public CustomExplodingShape(final String id, final int heightIn, final int widthIn) {
        super(id, heightIn, widthIn);
    }

     /**
     * @param heightIn height
     * @param widthIn  width
     * @author Robert Vokac
     * @since 0.0.0
     */
    public CustomExplodingShape(final int heightIn, final int widthIn) {
        this(null, heightIn, widthIn);
    }
    @Override
    public final boolean additionalValidate() {
        if (!super.additionalValidate()) {
            return false;
        }
        if (!Composition.isInRange(
                this.getHeight().getValue().intValue(),
                MIN_HEIGHT, MAX_HEIGHT)) {
            return false;
        }
        if (!Composition.isInRange(//NOSONAR
                this.getWidth().getValue().intValue(), MIN_WIDTH, MAX_WIDTH)) {
            return false;
        }
        return true;
    }
    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "The height or width is not "
        + "in the range (min and max value).";
    }
    @Override
    public final boolean setRandomValues() {
        getHoles().setRandomValues();
        for (int row = 1;
             row <= this.getHeight().getValue().intValue(); row++) {
            for (int column = 1;
                 column <= this.getWidth().getValue().intValue(); column++) {
                if (getRandom().nextBoolean()) {
                    this.addHole(row, column);
                }
            }
        }
        return true;
    }
    @Override
    public final boolean setDefaultValues() {
        throw new UnsupportedOperationException();
    }
}
