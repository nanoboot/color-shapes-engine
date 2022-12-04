
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

package org.nanoboot.colorshapes.engine.composition.board.shape;

import org.nanoboot.colorshapes.engine.composition.board.shape.holes.Holes;
import lombok.Getter;
import lombok.Setter;

import org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.json.JsonObject;

import java.util.List;
import org.nanoboot.colorshapes.engine.composition.AbstractComposition;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class Shape extends AbstractComposition
        implements Composition<Shape> {
    /**
     * Height of the shape.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private Height height = new Height();
    /**
     * Width of the shape.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private Width width = new Width();
    /**
     * List of holes.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private Holes holes = new Holes();
    /**
     * Constructor.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public Shape() {
    }
    /**
     * Constructor.
     *
     * @param shapeJsonObject shape as json object
     * @author Robert Vokac
     * @since 0.0.0
     */
    public Shape(final JsonObject shapeJsonObject) {
        fromJsonObject(shapeJsonObject);
    }

    /**
     * @param id
     * @param heightIn height
     * @param widthIn  width
     * @author Robert Vokac
     * @since 0.0.0
     */
    public Shape(final String id, final int heightIn, final int widthIn) {
        this.id = id;
        this.height = new Height(heightIn);
        this.width = new Width(widthIn);
    }

    /**
     * Deletes all holes.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public void deleteAllHoles() {
        this.holes.getList().clear();
    }

    /**
     * @param row    given row
     * @param column given column
     * @author Robert Vokac
     * @since 0.0.0
     */
    public void addHole(final int row, final int column) {
        this.holes.add(row, column);
    }
    @Override
    public final Shape returnThis() {
        return this;
    }

    /**
     * @return validates this composition
     * @author Robert Vokac
     * @since 0.0.0
     * @implNote This default implementation must be overridden in case,
     * the composition has no children, otherwise some exceptions
     * will be thrown.
     */
    @Override
    public boolean additionalValidate() {
        for (CellCoordination e : holes.getList()) {
            if (e.getRow().getValue() > height.getValue()) {
                return false;
            }
            if (e.getColumn().getValue() > width.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return reason
     * Can be overridden.
     */
    @Override
    public String describePossibleReasonsIfInvalid() {
        return "Height or width or holes is not valid.";
    }
    @Override
    public final List<Composition> getChildren() {
        return new PowerList<>(height, width, holes);
    }
}
