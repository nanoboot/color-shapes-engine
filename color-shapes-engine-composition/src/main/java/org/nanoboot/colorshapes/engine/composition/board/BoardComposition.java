
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

package org.nanoboot.colorshapes.engine.composition.board;

import org.nanoboot.colorshapes.engine.composition.board.shape.BoardShape;
import lombok.Getter;
import lombok.Setter;

import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.json.JsonObject;

import java.util.List;
import org.nanoboot.colorshapes.engine.composition.AbstractComposition;

/**
 * Composition for board.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BoardComposition extends AbstractComposition
        implements Composition<BoardComposition> {

    /**
     * Grid probability.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private GridProbability gridProbability = new GridProbability();
    /**
     * Grid count.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private GridCount gridCount = new GridCount();
    /**
     * Wall probability.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private WallProbability wallProbability = new WallProbability();
    /**
     * Wall count.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private WallCount wallCount = new WallCount();

    /**
     * Shape.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private BoardShape boardShape = new BoardShape();

    /**
     * @param boardCompositionJsonObject textToDescribe
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public BoardComposition(final JsonObject boardCompositionJsonObject) {
        fromJsonObject(boardCompositionJsonObject);
    }

    /**
     * Constructor.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public BoardComposition() {
        this.setDefaultValues();
    }

    /**
     * @param id
     * @param shapeIn given shape
     * @param gridProbabilityIn given grid probability
     * @param gridCountIn  given grid count
     * @param wallProbabilityIn given wall probability
     * @param wallCountIn given wall count
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public BoardComposition(final String id, 
                            final BoardShape shapeIn,
                            final int gridProbabilityIn,
                            final int gridCountIn,
                            final int wallProbabilityIn,
                            final int wallCountIn) {
        this.id = id;
        this.boardShape = shapeIn;
        this.gridProbability = new GridProbability(gridProbabilityIn);
        this.gridCount = new GridCount(gridCountIn);
        this.wallProbability = new WallProbability(wallProbabilityIn);
        this.wallCount = new WallCount(wallCountIn);
    }
    @Override
    public final boolean additionalValidate() {
        boolean probabilityOk = gridProbability.isZero() && gridCount.isZero()
                || gridProbability.isNotZero() && gridCount.isNotZero();
        if (!probabilityOk) {
            return false;
        }
        boolean wallOk = wallProbability.isZero() && wallCount.isZero()
                || wallProbability.isNotZero() && wallCount.isNotZero();
        if (!wallOk) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public final BoardComposition returnThis() {
        return this;
    }

    @Override
    public final List<Composition> getChildren() {
        return new PowerList<>(
                boardShape,
                gridProbability,
                gridCount,
                wallProbability,
                wallCount);
    }
    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "One of children is not valid.";
    }
}
