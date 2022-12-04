
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

import org.nanoboot.colorshapes.engine.composition.thrower.BallThrowerComposition;
import org.nanoboot.colorshapes.engine.core.misc.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.core.random.CSRandomGenerator;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;
import org.nanoboot.colorshapes.engine.flow.event.impl.add.AddNextAutomaticBombEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.add.AddNextBallEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.add.AddNextManualBombEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.add.AddNextPaintBombEvent;
import org.nanoboot.colorshapes.engine.game.core.GameNode;
import org.nanoboot.colorshapes.engine.game.tools.BallPositionerGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Line extends GameNode {
    @Getter
    private final int size;
    private final BallPositionerGenerator ballPositionerGenerator;
    private List<BallPositioner> nextBalls;

    public Line(EventConsumer eventConsumer, CSRandomGenerator random, BallThrowerComposition ballThrowerComposition, BallPositionerGenerator ballPositionerGenerator) {
        super(eventConsumer);
        this.size = ballThrowerComposition.getNextBallCount().getValue();
        this.ballPositionerGenerator = ballPositionerGenerator;
        nextBalls = new ArrayList<>();
        //first filling
        getAndRefill();
    }

    /**
     * Returns content of lines and clear all and refill this line
     *
     * @return
     */
    public List<BallPositioner> getAndRefill() {
        List<BallPositioner> result = this.nextBalls;
        this.nextBalls = null;
        this.nextBalls = ballPositionerGenerator.generate(size);

        int column = 0;
        for (BallPositioner bp : result) {
            column++;
            Ball ball = bp.getBall();
            switch (ball.getBallType()) {
                case COLORED:
                    produceEvent(new AddNextBallEvent(column, ball.getColour(), ball.getValue(), ball.isMovable(), ball.isBreakable()));
                    break;
                case JOKER:
                    produceEvent(new AddNextBallEvent(column, ball.getColour(), ball.getValue(), ball.isMovable(), ball.isBreakable()));
                    break;
                case AUTOMATIC_BOMB:
                    produceEvent(new AddNextAutomaticBombEvent(column));
                    break;
                case MANUAL_BOMB:
                    produceEvent(new AddNextManualBombEvent(column));
                    break;
                case PAINT_BOMB:
                    produceEvent(new AddNextPaintBombEvent(column));
                    break;
                default:
                    throw new ColorShapesEngineException("Unknown ball type " + ball.getBallType());
            }
        }
        return result;
    }

    public void replaceBallPosition(int index) {
        BallPosition ballPosition = ballPositionerGenerator.getBallPositionGenerator().generate();
        nextBalls.get(index).setBallPosition(ballPosition);
    }
}
