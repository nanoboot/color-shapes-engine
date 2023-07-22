
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

import org.nanoboot.colorshapes.engine.game.core.Game;
import org.nanoboot.colorshapes.engine.parts.base.GameNode;
import lombok.Getter;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@Getter
public class GameTools extends GameNode {
    private BallFactory ballFactory;
    private BallPositionGenerator ballPositionGenerator;
    private BallPositionerGenerator ballPositionerGenerator;
    private ShapeFinder shapeFinder;
    private BallThrower ballThrower;
    private GridBuilder gridBuilder;
    private WallBuilder wallBuilder;

    //
    @Getter
    private Game game;

    public GameTools(Game game) {
        super(game);
        this.game = game;
        ballFactory = new BallFactory(this.getConsumer(), game.getGameComposition().getBallFactoryComposition(), game.getRandomGenerator());
        ballPositionGenerator = new BallPositionGenerator(this.getConsumer(),game.getRandomGenerator(),game.getBoard(), game.getPreviewBar());
        ballPositionerGenerator = new BallPositionerGenerator(this.getConsumer(), ballFactory,ballPositionGenerator);
        shapeFinder = new ShapeFinder(this.getConsumer(), game.getBoard(), game.getGameComposition().getShapeFinderComposition());
        ballThrower = new BallThrower(this.getConsumer(), game.getGameComposition().getBallThrowerComposition(), game.getBoard(), game.getPreviewBar(), ballPositionerGenerator, shapeFinder, game.getTotalScore());
        gridBuilder = new GridBuilder(this.getConsumer(), game.getBoard(), game.getGameComposition().getBoardComposition());
        wallBuilder = new WallBuilder(this.getConsumer(), game.getBoard(), game.getGameComposition().getBoardComposition());
    }

}
