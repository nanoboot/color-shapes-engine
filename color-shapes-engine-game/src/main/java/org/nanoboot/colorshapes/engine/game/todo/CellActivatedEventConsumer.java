
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

import org.nanoboot.colorshapes.engine.flow.event.core.Event;
import org.nanoboot.colorshapes.engine.flow.event.impl.in.CellActivatedEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.misc.EndGameEvent;
import org.nanoboot.colorshapes.engine.game.parts.*;
import org.nanoboot.colorshapes.engine.game.pathfinder.OldPathFinderImpl;
import org.nanoboot.powerframework.collections.PowerStack;

import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CellActivatedEventConsumer {
//    public boolean consumeEvent(Event event) {
//        CellActivatedEvent cellActivatedEvent = null;
//        if (event instanceof CellActivatedEvent) {
//            cellActivatedEvent = (CellActivatedEvent) event;
//        } else {
//            return false;
//        }
//
//        int row = cellActivatedEvent.getInteger("row");
//        int column = cellActivatedEvent.getInteger("column");
//
//        Board board = gameContainer.getGame().getBoard();
//
//        Cell deactivatedCell = board.hasAnActivatedCell() ? board.deactivateActivatedCell() : null;
//        Cell activatedCell = board.activateCell(row, column);
//        if (activatedCell.equals(deactivatedCell)) {
//            Ball ball = activatedCell.getBall();
//            if (ball.getBallType().isManualBomb()) {
//                ball.executeExplosion();
//            }
//        }
//
//        if (!activatedCell.isEmpty() && activatedCell.getBall().getBallType().isABomb() && activatedCell.getBall().isExploded()) {
//            gameContainer.getGame().getGameTools().getShapeFinder().detonateIfNeeded(activatedCell);
//            board.deactivateActivatedCell();
//        } else {
//            if (activatedCell.isEmpty()) {
//                if (deactivatedCell != null) {
//                    moveRollableIfPossible(deactivatedCell, activatedCell);
//                }
//                board.deactivateActivatedCell();
//            }
//        }
//
//        if (board.isFull()) {
//            gameContainer.getGame().handleEvent(new EndGameEvent(gameContainer.getGame().getTotalScore().getCurrentTotalScore()));
//        }
//        return true;
//    }
//
//    public void moveRollableIfPossible(Cell deactivatedCell, Cell activatedCell) {
//        final Cell cellFrom = deactivatedCell;
//        final Cell cellTo = activatedCell;
//        Rollable rollable = cellFrom.getRollable();
//        if (rollable instanceof Ball) {
//            Ball ball = (Ball) rollable;
//            if (ball.isUnmovable()) {
//                return;
//            }
//        }
//        if (rollable instanceof Bomb && (((Bomb) rollable)).isAutomatic()) {
//            return;
//        }
//        OldPathFinderImpl pathFinder = new OldPathFinderImpl();
//        List<Cell> pathList = pathFinder.findPath(cellFrom, cellTo);
//        PowerStack<Cell> pathStack = new PowerStack<>();
//        for (Cell c : pathList) {
//            pathStack.push(c);
//        }
//
//        boolean wasPathFound = pathStack != null;
//        if (wasPathFound) {
//
//            getGame().getBoard().moveBallFromTo(cellFrom, cellTo, pathStack);
//
//            List<Rollable> listOfExplodedRollable = getGame().getGameTools().getShapeFinder().detonateIfNeeded(cellTo);
//
//            int addedScore = getGame().getTotalScore().addExplodedBalls(listOfExplodedRollable);
//
//            if (addedScore == 0) {
//                this.getGame().getGameTools().getBallThrower().throwDuringGame();
//            }
//
//        }
//    }

}
