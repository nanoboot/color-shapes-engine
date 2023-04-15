
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

package org.nanoboot.colorshapes.engine.game.parts;

import org.nanoboot.colorshapes.engine.composition.shapefinder.ShapeFinderComposition;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;
import org.nanoboot.colorshapes.engine.game.core.GameNode;
import org.nanoboot.colorshapes.engine.flow.event.impl.misc.UpdatePlayerScoreEvent;
import org.nanoboot.colorshapes.engine.game.tools.ResultCounter;

import java.util.List;

/**
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class TotalScore extends GameNode {

    private int score = 0;
    private final int minimumBallCount;
    /**
     * Constructor.
     *
     * @param eventConsumer eventConsumer
     * @param shapeFinderComposition shapeFinderComposition
     */
    public TotalScore(EventConsumer eventConsumer, ShapeFinderComposition shapeFinderComposition) {
        super(eventConsumer);
        this.minimumBallCount = shapeFinderComposition.getMinimumSize().getValue();
    }

    public int getCurrentTotalScore() {
        return this.score;
    }

    /**
     * @param ballsToCheck
     * @return sum of new added score
     */
    public int addExplodedBalls(List<Ball> ballsToCheck) {

        if (ballsToCheck == null) {
            return 0;
        }
        for(Ball b:ballsToCheck) {
            if(!b.isExploded()) {
                throw new ColorShapesEngineException("Cannot add ball, which is not exploded.");
            }
        }

        int scoreToAdd = ResultCounter.countScore(ballsToCheck, minimumBallCount);
        if (scoreToAdd != 0) {
            addNewScoreSum(scoreToAdd);
            produceEvent(new UpdatePlayerScoreEvent(this.getCurrentTotalScore()));
        }
        return scoreToAdd;
    }

    private void addNewScoreSum(int value) {
        this.score = score + value;
    }

}
