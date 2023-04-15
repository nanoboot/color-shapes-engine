
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

import org.nanoboot.colorshapes.engine.entity.misc.Coordination;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.composition.shapefinder.ShapeFinderComposition;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;
import org.nanoboot.colorshapes.engine.game.BallType;
import org.nanoboot.colorshapes.engine.game.core.GameNode;
import org.nanoboot.colorshapes.engine.game.parts.Ball;
import org.nanoboot.colorshapes.engine.game.parts.Board;
import org.nanoboot.colorshapes.engine.game.parts.Cell;
import org.nanoboot.colorshapes.engine.game.utils.Direction;


import org.nanoboot.colorshapes.engine.flow.event.impl.explode.ExplodeEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.wait.WaitEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ShapeFinder extends GameNode {

    private final ShapeFinderComposition shapeFinderComposition;
    private final Board board;
    private Cell cellToCheck;
    private Cell currentCell;
    private boolean shapeWasFound;
    private ArrayList<Cell> cellWithExplodedBallsList = new ArrayList<>();
    private int colourToFind;

    private static final List<Coordination> coordinationsToExplodeByBombsList;

    static {
        coordinationsToExplodeByBombsList = Arrays.asList(BoardNineNine.coordinations);
    }

    public ShapeFinder(final EventConsumer eventConsumer, Board board, ShapeFinderComposition shapeFinderComposition) {
        super(eventConsumer);
        this.board=board;
        this.shapeFinderComposition = shapeFinderComposition;
    }

    private void setToDefault(Cell cell) {
        if (cell.isEmpty() || cell.isLocked()) {
            throw new ColorShapesEngineException("Cell is empty or locked");
        }
        this.cellToCheck = cell;
        this.currentCell = this.cellToCheck;
        this.shapeWasFound = false;
        this.cellWithExplodedBallsList.clear();
        BallType ballType = cellToCheck.getBall().getBallType();
        this.colourToFind = ballType.isColored() || ballType.isJoker() ? cellToCheck.getBall().getColour() : -1;
    }

    /**
     * @param cell
     * @return
     */
    public List<Ball> detonateIfNeeded(Cell cell) {
        setToDefault(cell);
        List<Ball> ballsList = new ArrayList<>();
        if (cell.getBall().getBallType().isABomb()) {
            Ball bomb = cell.getBall();
            if (bomb.isExploded()) {
                int boardHeight = board.getHeight();
                int boardWidth = board.getWidth();
                int boardDimensionAverage = (int) Math.floor((boardHeight + boardWidth) / 2);
                if (boardDimensionAverage < 5) boardDimensionAverage = 5;
                int i = 0;
                int explodedBallsCount = 0;
                for (Coordination element : ShapeFinder.coordinationsToExplodeByBombsList) {
                    i++;
                    if (i > ((int) Math.floor((boardDimensionAverage * 1.0))) || explodedBallsCount > boardDimensionAverage) {
                        break;
                    }
                    Cell cellToCheck = board.getCell(cell.getRow() + element.getX(), cell.getColumn() + element.getY());
                    if (cellToCheck != null
                            && cellToCheck.isFull()
                            && ((cellToCheck.getBall().getBallType().isNotABomb())
                            ? !(cellToCheck.getBall().isUnbreakable())
                            : true)
                            && !cellToCheck.isLocked()) {
                        if (cellToCheck.getBall().getBallType().isABomb()) {
                            Ball bombInstance = cellToCheck.getBall();
                            if (!bombInstance.isExploded()) {
                                bombInstance.executeExplosion();
                            }

                        }
                        this.cellWithExplodedBallsList.add(cellToCheck);
                        explodedBallsCount++;
                    }
                }
                this.shapeWasFound = true;
            }

        } else {
            switch (this.shapeFinderComposition.getExplodingShapeType()) {
                case LINE:
                    findLine();
                    break;
                case BLOCK:
                    findBlock();
                    break;
                case RING:
                    findRing();
                    break;
                case SQUARE:
                    findRectangle();
                    break;
                case CUSTOM:
                    findCustom();
                    break;
                default:
            }
        }

        if (shapeWasFound) {

            for (Cell element : this.cellWithExplodedBallsList) {
                produceEvent(new ExplodeEvent(element.getRow(), element.getColumn()));
                Ball removedBall = element.removeBall();
                ballsList.add(removedBall);

            }
            produceEvent(new WaitEvent(1500));

            return ballsList;
        } else {
            return null;
        }
    }

    /**
     * Tries to find line shape of balls
     */
    public void findLine() {
        Direction[] directions = new Direction[]{Direction.TOP, Direction.RIGHT, Direction.TOP_LEFT, Direction.TOP_RIGHT};
        for (Direction direction : directions) {
            if (this.shapeWasFound) {
                break;
            } else {
                findLineInPosition(direction);
            }
        }
    }

    private void findLineInPosition(Direction direction) {
        this.currentCell = this.cellToCheck;
        while ((this.currentCell != null)
                && this.currentCell.isFull()
                && !this.currentCell.getBall().getBallType().isABomb()
                && (this.colourToFind == currentCell.getBall().getColour()
                || currentCell.getBall().getBallType().isJoker())
                && currentCell.getBall().isBreakable()
                && !this.currentCell.isLocked()
                && (direction.isSlant() ? true : !this.currentCell.getWalls().isWallAtDirection(direction.overTurn()))
                && ((this.currentCell.equals(this.cellToCheck) || direction.isSlant()) ? true : !currentCell.getWalls().isWallAtDirection(direction))) {
            this.cellWithExplodedBallsList.add(currentCell);
            this.currentCell = this.currentCell.getCellAtDirection(direction);
        }

        this.currentCell = this.cellToCheck.getCellAtDirection(direction.overTurn());

        while ((this.currentCell != null)
                && this.currentCell.isFull()
                && (this.currentCell.getBall().getBallType().isNotABomb())
                && (this.colourToFind == currentCell.getBall().getColour()
                || currentCell.getBall().getBallType().isJoker())
                && currentCell.getBall().isBreakable()
                && !this.currentCell.isLocked()
                && (direction.isSlant() ? true : !this.currentCell.getWalls().isWallAtDirection(direction))
                && ((this.currentCell.equals(this.cellToCheck) || direction.isSlant()) ? true : (!currentCell.getWalls().isWallAtDirection(direction.overTurn())))) {
            this.cellWithExplodedBallsList.add(currentCell);
            this.currentCell = this.currentCell.getCellAtDirection(direction.overTurn());
        }
        if (this.cellWithExplodedBallsList.size() >= this.shapeFinderComposition.getMinimumSize().getValue()) {
            this.shapeWasFound = true;
        } else {
            this.cellWithExplodedBallsList.clear();
        }
    }

    private void findBlock() {
    }

    private void findRectangle() {
        String[] ballPositions = {"row1column1", "row1column2", "row2column1", "row2column2"};
        for (String ballPosition : ballPositions) {
            if (this.shapeWasFound) {
                break;
            } else {
                findRectangleInPosition(ballPosition);
            }

        }
    }

    private void findRectangleInPosition(String string) {
        this.currentCell = this.cellToCheck;
        Cell cell1 = null;
        Cell cell2 = null;
        Cell cell3 = null;
        Cell cellRow1Column1 = null;
        switch (string) {
            case "row1column1": {
                cell1 = currentCell.getCellAtDirection(Direction.RIGHT);
                cell2 = currentCell.getCellAtDirection(Direction.BOTTOM);
                cell3 = currentCell.getCellAtDirection(Direction.BOTTOM_RIGHT);
                cellRow1Column1 = currentCell;
            }
            break;
            case "row1column2": {
                cell1 = currentCell.getCellAtDirection(Direction.LEFT);
                cell2 = currentCell.getCellAtDirection(Direction.BOTTOM_LEFT);
                cell3 = currentCell.getCellAtDirection(Direction.BOTTOM);
                cellRow1Column1 = cell1;

            }
            break;
            case "row2column1": {
                cell1 = currentCell.getCellAtDirection(Direction.TOP);
                cell2 = currentCell.getCellAtDirection(Direction.TOP_RIGHT);
                cell3 = currentCell.getCellAtDirection(Direction.RIGHT);
                cellRow1Column1 = cell1;
            }
            break;
            case "row2column2": {
                cell1 = currentCell.getCellAtDirection(Direction.TOP_LEFT);
                cell2 = currentCell.getCellAtDirection(Direction.TOP);
                cell3 = currentCell.getCellAtDirection(Direction.LEFT);
                cellRow1Column1 = cell1;
            }
            break;
        }

        Cell[] cells = {currentCell, cell1, cell2, cell3};
        for (Cell cell : cells) {
            boolean cellCanHaveBallWhichCouldBePartOfAShape = cell != null
                    && cell.isFull()
                    && !cell.getBall().getBallType().isABomb()
                    && (this.colourToFind == cell.getBall().getColour()
                    || (cell.getBall().getBallType().isJoker()))
                    && cell.getBall().isBreakable()
                    && !cell.isLocked();
            if (!cellCanHaveBallWhichCouldBePartOfAShape) {
                return;
            }
        }
        if (cellRow1Column1.getWalls().isRight()
                || cellRow1Column1.getWalls().isBottom()
                || cellRow1Column1.getCellAtDirection(Direction.RIGHT).getWalls().isLeft()
                || cellRow1Column1.getCellAtDirection(Direction.RIGHT).getWalls().isBottom()
                || cellRow1Column1.getCellAtDirection(Direction.BOTTOM).getWalls().isTop()
                || cellRow1Column1.getCellAtDirection(Direction.BOTTOM).getWalls().isRight()
                || cellRow1Column1.getCellAtDirection(Direction.BOTTOM_RIGHT).getWalls().isTop()
                || cellRow1Column1.getCellAtDirection(Direction.BOTTOM_RIGHT).getWalls().isLeft()) {
            return;
        }
        for (Cell cell : cells) {
            this.cellWithExplodedBallsList.add(cell);
        }
        this.shapeWasFound = true;
    }

    private void findRing() {
        String[] ballPositions = {"row1column2", "row2column1", "row2column3", "row3column2"};
        for (String ballPosition : ballPositions) {
            if (this.shapeWasFound) {
                break;
            } else {
                findRingInPosition(ballPosition);
            }

        }
    }

    private void findRingInPosition(String string) {
        this.currentCell = this.cellToCheck;
        Cell cellRow2Column2 = null;
        switch (string) {
            case "row1column2": {
                cellRow2Column2 = currentCell.getCellAtDirection(Direction.BOTTOM);
            }
            break;
            case "row2column1": {
                cellRow2Column2 = currentCell.getCellAtDirection(Direction.RIGHT);
            }
            break;
            case "row2column3": {
                cellRow2Column2 = currentCell.getCellAtDirection(Direction.LEFT);
            }
            break;
            case "row3column2": {
                cellRow2Column2 = currentCell.getCellAtDirection(Direction.TOP);
            }
            break;
        }
        if (cellRow2Column2 == null) {
            return;
        }
        Cell cell12 = cellRow2Column2.getCellAtDirection(Direction.TOP);
        Cell cell21 = cellRow2Column2.getCellAtDirection(Direction.LEFT);
        Cell cell23 = cellRow2Column2.getCellAtDirection(Direction.RIGHT);
        Cell cell32 = cellRow2Column2.getCellAtDirection(Direction.BOTTOM);
        Cell[] cells = {cell12, cell21, cell23, cell32};
        for (Cell cell : cells) {
            boolean cellCanHaveBallWhichCouldBePartOfAShape = cell != null
                    && cell.isFull()
                    && !cell.getBall().getBallType().isABomb()
                    && (this.colourToFind == cell.getBall().getColour()
                    || cell.getBall().getBallType().isJoker())
                    && cell.getBall().isBreakable()
                    && !cell.isLocked()
                    && !cell.getWalls().hasAllWalls();
            if (!cellCanHaveBallWhichCouldBePartOfAShape) {
                return;
            }
        }

        for (Cell cell : cells) {
            this.cellWithExplodedBallsList.add(cell);
        }
        this.shapeWasFound = true;
    }

    /**
     * Tries to find custom shape.
     */
    public void findCustom() {
        throw new ColorShapesEngineException("Not yet implemented");
    }

}

