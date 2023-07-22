
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

import org.nanoboot.colorshapes.engine.parts.core.BallPositionerGeneratorI;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;
import org.nanoboot.colorshapes.engine.parts.base.GameNode;
import org.nanoboot.colorshapes.engine.parts.core.Ball;
import org.nanoboot.colorshapes.engine.parts.core.BallPosition;
import org.nanoboot.colorshapes.engine.parts.core.BallPositioner;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallPositionerGenerator extends GameNode implements BallPositionerGeneratorI {
    private final BallFactory ballFactory;
    @Getter
    private final BallPositionGenerator ballPositionGenerator;

    public BallPositionerGenerator(EventConsumer eventConsumer, BallFactory ballFactory, BallPositionGenerator ballPositionGenerator) {
        super(eventConsumer);
        this.ballFactory=ballFactory;
        this.ballPositionGenerator=ballPositionGenerator;
    }
    @Override
    public List<BallPositioner> generate(int count) {
        List<BallPositioner> result = new ArrayList<>();
        for(int i =0;i<count;i++){
            Ball ball = ballFactory.getNextBall();
            BallPosition ballPosition = ballPositionGenerator.generate();
            BallPositioner ballPositioner = new BallPositioner(ball, ballPosition);
            result.add(ballPositioner);
        }
        return result;
    }

    @Override
    public BallPosition generate() {
        return getBallPositionGenerator().generate();
    }

}
