
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

package org.nanoboot.colorshapes.engine.game.todo;

import org.nanoboot.colorshapes.engine.flow.handler.EventHandler;
import org.nanoboot.colorshapes.engine.game.core.Game;
import org.nanoboot.colorshapes.engine.game.parts.Board;
import org.nanoboot.colorshapes.engine.game.parts.Cell;
import org.nanoboot.colorshapes.engine.game.parts.Walls;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@AllArgsConstructor
public class MainEventHandler extends EventHandler {
    private Game game;


//            this.ballFactory = new BallFactory(
//            getGameComposition().getBallFactoryComposition(),
//    getGenerator());
//        this.ballDetonator = new BallDetonator(
//            getGameComposition().getBallDetonatorComposition(), game);
//
//        this.totalScore = new TotalScore(
//                this.getGameComposition()
//                        .getBallDetonatorComposition()
//                        .getMinimumSize().getValue());
//        this.ballThrower = new BallThrower(ballFactory, ballDetonator, totalScore);

//    /**
//     * Starts board
//     */
//    public void start() {
//        this.ballThrower.throwBallsAtTheBeginningOfTheGame();
//    }
//
//    /**
//     * Creates grids and walls
//     */
//    public void beforeNextPlayerAction() {
//        Board board = boardManager.getBoard();
//        List<Cell> lockedCells = board.getLockedCells();
//        List<Cell> emptyCells = board.getEmptyCells();
//        for (Cell element : lockedCells) {
//            element.unlock();
//            if (element.isEmpty() && !emptyCells.contains(element)) {
//                emptyCells.add(element);
//            }
//        }
//        lockedCells.clear();
//        List<Cell> cellsWithWalls = board.getCellsWithWalls();
//        for (Cell element : cellsWithWalls) {
//            element.getWalls().destroyAll();
//        }
//        cellsWithWalls.clear();
//
//        if (boardManager.getGridProbability() != 0 && boardManager.getGridProbability() >= this.randomGenerator.nextInt(0, 100)) {
//            for (int i = 1; i <= boardManager.getGridCount(); i++) {
//                int row = this.randomGenerator.nextInt(1, board.getHeight());
//                int column = this.randomGenerator.nextInt(1, board.getWidth());
//                Cell cell = board.getCell(row, column);
//                if (lockedCells.contains(cell)) {
//                    continue;
//                }
//                cell.lock();
//                lockedCells.add(cell);
//                if (emptyCells.contains(cell)) {
//                    emptyCells.remove(cell);
//                }
//
//            }
//        }
//        if (boardManager.getWallProbability() != 0 && boardManager.getWallProbability() >= this.randomGenerator.nextInt(0, 100)) {
//
//            for (int i = 1; i <= boardManager.getWallCount(); i++) {
//                int row = this.randomGenerator.nextInt(1, board.getHeight());
//                int column = this.randomGenerator.nextInt(1, board.getWidth());
//                int direction = this.randomGenerator.nextInt(1, 4);
//
//                Cell cell = board.getCell(row, column);
//                Walls walls = cell.getWalls();
//                switch (direction) {
//                    case 1:
//                        walls.setTopWallOn();
//                        break;
//                    case 2:
//                        walls.setRightWallOn();
//                        break;
//
//                    case 3:
//                        walls.setBottomWallOn();
//                        break;
//                    case 4:
//                        walls.setLeftWallOn();
//                        break;
//                }
//                cellsWithWalls.add(cell);
//
//            }
//        }
//
//    }


}
