
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

package org.nanoboot.colorshapes.engine.composition;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

import org.nanoboot.colorshapes.engine.composition.board.BoardComposition;
import org.nanoboot.colorshapes.engine.composition.shapefinder.ShapeFinderComposition;
import org.nanoboot.colorshapes.engine.composition.factory.BallFactoryComposition;
import org.nanoboot.colorshapes.engine.composition.other.OtherComposition;
import org.nanoboot.colorshapes.engine.composition.thrower.BallThrowerComposition;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.json.JsonObject;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@AllArgsConstructor
public class GameComposition extends AbstractComposition
        implements Composition<GameComposition> {
    /**
     * Board composition of this game composition.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private BoardComposition boardComposition;
    /**
     * Ball factory composition of this game composition.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private BallFactoryComposition ballFactoryComposition;
    /**
     * Ball thrower composition of this game composition.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private BallThrowerComposition ballThrowerComposition;
    /**
     * Shape finder composition of this game composition.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ShapeFinderComposition shapeFinderComposition;
    /**
     * Other composition of this game composition.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private OtherComposition otherComposition;

    /**
     * @param gameCompositionJsonObject game composition as json object
     */
    public GameComposition(final JsonObject gameCompositionJsonObject) {
        fromJsonObject(gameCompositionJsonObject);
    }
    /**
     * Constructor.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public GameComposition() {
        this.boardComposition = new BoardComposition();
        this.ballFactoryComposition = new BallFactoryComposition();
        this.ballThrowerComposition = new BallThrowerComposition();
        this.shapeFinderComposition = new ShapeFinderComposition();
        this.otherComposition = new OtherComposition();
    }

    /**
     * @param id
     * @param boardCompositionIn boardComposition
     * @param ballFactoryCompositionIn ballFactoryComposition
     * @param ballThrowerCompositionIn ballThrowerComposition
     * @param shapeFinderCompositionIn ballDetonatorComposition
     * @param otherCompositionIn otherComposition
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public GameComposition(
            final String id, 
            final BoardComposition boardCompositionIn,
            final BallFactoryComposition ballFactoryCompositionIn,
            final BallThrowerComposition ballThrowerCompositionIn,
            final ShapeFinderComposition shapeFinderCompositionIn,
            final OtherComposition otherCompositionIn
    ) {
        this.id = id;
        this.boardComposition = boardCompositionIn;
        this.ballFactoryComposition = ballFactoryCompositionIn;
        this.ballThrowerComposition = ballThrowerCompositionIn;
        this.shapeFinderComposition = shapeFinderCompositionIn;
        this.otherComposition = otherCompositionIn;
    }

    @Override
    public final GameComposition returnThis() {
        return this;
    }
    @Override
    public final List<Composition> getChildren() {
        ArrayList<Composition> list = new ArrayList<>();
        list.add(this.boardComposition);
        list.add(this.ballFactoryComposition);
        list.add(this.ballThrowerComposition);
        list.add(this.shapeFinderComposition);
        list.add(this.otherComposition);
        return list;
    }
    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "One of children is not valid.";
    }
}
