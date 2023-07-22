
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

package org.nanoboot.colorshapes.engine.composition.thrower;

import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallThrowerComposition extends AbstractComposition
        implements Composition<BallThrowerComposition> {

    /**
     * Start ball count.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private StartBallCount startBallCount = new StartBallCount();
    /**
     * Next ball count.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private NextBallCount nextBallCount = new NextBallCount();
    /**
     * Show next ball positions.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private ShowNextBallPositions showNextBallPositions =
            new ShowNextBallPositions();

    /**
     * Constructor.
     *
     * @param ballThrowerCompositionJsonObject
     * BallThrowerComposition as json object
     * @author Robert Vokac
     * @since 0.0.0
     */
    public BallThrowerComposition(
            final JsonObject ballThrowerCompositionJsonObject) {
        fromJsonObject(ballThrowerCompositionJsonObject);
    }

    /**
     * Constructor.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public BallThrowerComposition() {
    }

    /**
     * Constructor.
     *
     * @param id
     * @param startBallCountIn         startBallCount
     * @param nextBallCountIn          nextBallCount
     * @param showNextBallsPositionsIn showNextBallPositions
     * @author Robert Vokac
     * @since 0.0.0
     */
    public BallThrowerComposition(
            final String id, 
            final int startBallCountIn,
            final int nextBallCountIn,
            final boolean showNextBallsPositionsIn
    ) {
        this.id = id;
        this.setStartBallCount(new StartBallCount(startBallCountIn));
        this.setNextBallCount(new NextBallCount(nextBallCountIn));
        this.setShowNextBallPositions(
                new ShowNextBallPositions(showNextBallsPositionsIn));
    }
    @Override
    public final BallThrowerComposition returnThis() {
        return this;
    }

    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "One of children is not valid.";
    }
    @Override
    public final List<Composition> getChildren() {
        List<Composition> list = new ArrayList<>();
        list.add(this.startBallCount);
        list.add(this.nextBallCount);
        list.add(this.showNextBallPositions);
        return list;
    }
}
