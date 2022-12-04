
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

package org.nanoboot.colorshapes.engine.game.tools;

import org.nanoboot.colorshapes.engine.core.misc.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.game.parts.Ball;

import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ResultCounter {

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    private ResultCounter() {
        //Not meant to be instantiated.
    }

    /**
     * Counts score
     *
     * @param balls
     * @param minBallCount
     * @return
     */
    public static int countScore(List<Ball> balls, int minBallCount) {
        int ballCount = 0;
        int multiplier = 1;
        for (Ball ball : balls) {
            if (!ball.getBallType().isABomb()) {
                //nothing to count
                return 0;
            }

            ++ballCount;
            if(ball.getValue() != 1) {
                multiplier = multiplier * ball.getValue();
            }
            if (multiplier == 0) {
                return 0;
            }
        }
        if (ballCount < minBallCount) {
            throw new ColorShapesEngineException("Fatal error. Balls were exploded, but their count (" + ballCount + ") was smaller than the minimum (" + minBallCount + ").");
        }
        int ballsOverMinimum = ballCount - minBallCount;
        switch (ballsOverMinimum) {
            case 0:
                return 10 * multiplier;
            case 1:
                return 12 * multiplier;
            case 2:
                return 18 * multiplier;
            case 3:
                return 28 * multiplier;
            case 4:
                return 42 * multiplier;
            default:
                return (42 + ((ballsOverMinimum - 4) * 5)) * multiplier;
        }
    }

}
