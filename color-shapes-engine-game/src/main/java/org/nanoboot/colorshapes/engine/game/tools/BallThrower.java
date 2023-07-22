
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

package org.nanoboot.colorshapes.engine.game.tools;

import org.nanoboot.colorshapes.engine.parts.core.Board;
import org.nanoboot.colorshapes.engine.parts.core.PreviewBar;
import org.nanoboot.colorshapes.engine.parts.core.BallPositioner;
import org.nanoboot.colorshapes.engine.parts.core.TotalScore;
import org.nanoboot.colorshapes.engine.parts.core.BallPosition;
import org.nanoboot.colorshapes.engine.parts.core.Ball;
import org.nanoboot.colorshapes.engine.parts.core.Cell;
import org.nanoboot.colorshapes.engine.base.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;
import org.nanoboot.colorshapes.engine.flow.event.impl.misc.EndGameEvent;
import org.nanoboot.colorshapes.engine.parts.base.GameNode;
import org.nanoboot.colorshapes.engine.composition.thrower.BallThrowerComposition;

import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallThrower extends GameNode {

    private final BallThrowerComposition ballThrowerComposition;
    private final Board board;
    private final PreviewBar previewBar;
    private final BallPositionerGenerator ballPositionerGenerator;
    private final ShapeFinder shapeFinder;
    private final TotalScore totalScore;

    private boolean started = false;

    public BallThrower(final EventConsumer consumer,
                       BallThrowerComposition ballThrowerComposition,
                       Board board,
                       PreviewBar previewBar,
                       BallPositionerGenerator ballPositionerGenerator,
                       ShapeFinder shapeFinder,
                       TotalScore totalScore) {
        super(consumer);
        this.ballThrowerComposition = ballThrowerComposition;
        this.board = board;
        this.previewBar = previewBar;
        this.ballPositionerGenerator = ballPositionerGenerator;
        this.shapeFinder = shapeFinder;
        this.totalScore = totalScore;
    }

    /**
     * Throws ball at the beginning of the game.
     */
    public void throwAtTheStart() {
        if (started) {
            throw new ColorShapesEngineException("Game has already started.");
        }
        this.started = true;

        List<BallPositioner> ballPositioners = ballPositionerGenerator.generate(ballThrowerComposition.getStartBallCount().getValue());

        for (BallPositioner bp : ballPositioners) {
            insertBallIntoCell(bp);
        }

    }

    private void insertBallIntoCell(BallPositioner ballPositioner) {

        BallPosition ballPosition = ballPositioner.getBallPosition();
        int row = ballPosition.getRow();
        int column = ballPosition.getColumn();
        Cell cell = board.getCell(row, column);

        Ball ball = ballPositioner.getBall();
        cell.insertBall(ball);

        List<Ball> listOfExplodedBalls = shapeFinder.detonateIfNeeded(cell);

        if (ball.getBallType().isColored() || ball.getBallType().isJoker()) {
            int addedScore = totalScore.addExplodedBalls(listOfExplodedBalls);
        }

    }

    /**
     * Throw balls during the game
     */
    public void throwDuringGame() {
        if (!started) {
            throw new ColorShapesEngineException("Game has not yet started.");
        }
        List<BallPositioner> ballPositioners = previewBar.getAndRefill();
        for (BallPositioner bp : ballPositioners) {
            if (board.isFull()) {
                produceEvent(new EndGameEvent(totalScore.getCurrentTotalScore()));
                return;
            }
            this.insertBallIntoCell(bp);

        }
    }
}
