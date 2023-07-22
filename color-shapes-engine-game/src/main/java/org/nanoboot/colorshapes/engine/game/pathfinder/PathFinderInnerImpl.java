
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

package org.nanoboot.colorshapes.engine.game.pathfinder;

import org.nanoboot.colorshapes.engine.base.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.parts.core.Cell;
import org.nanoboot.colorshapes.engine.parts.utils.Direction;
import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.collections.PowerStack;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class PathFinderInnerImpl {

    private final PowerStack<Cell> pathFromStartToEndStack = new PowerStack<>();
    private final PowerList<Cell> visitedCells = new PowerList<>();
    private final PowerStack<ParentNode<Cell>> nodesBeforeExamined = new PowerStack<>();
    private final PowerStack<ParentNode<Cell>> nodesAfterExamined = new PowerStack<>();
    private final ParentNode<Cell> startNode;
    private ParentNode<Cell> endNode;
    private boolean cellToFound = false;
    private boolean cellToNotFound = false;
    private Cell cellFrom;
    private final Cell cellTo;
    private boolean pathWasSearched = false;
    private final Direction[] directions = new Direction[]{Direction.TOP, Direction.RIGHT, Direction.BOTTOM, Direction.LEFT};

    /**
     * @param cellFrom
     * @param cellTo
     */
    public PathFinderInnerImpl(Cell cellFrom, Cell cellTo) {
        startNode = new ParentNode<>(null, cellFrom);
        this.cellFrom = cellFrom;
        this.cellTo = cellTo;

        nodesBeforeExamined.push(startNode);

        visitedCells.add(cellFrom);

    }

    /**
     * @return
     */
    public PowerStack<Cell> findPath() {
        if (pathWasSearched) {
            throw new ColorShapesEngineException("This method can be used only once.");
        }
        pathWasSearched = true;

        while (!this.cellToFound && !this.cellToNotFound) {
            moveAllNodesFromBeforeToAfterExamindes();
            examineAllNodesInNodesAfterExamined();
        }

        if (cellToFound) {
            fillPathFromStartToEndStack();
        }
        return cellToFound ? this.pathFromStartToEndStack : null;
    }

    private void moveAllNodesFromBeforeToAfterExamindes() {
        nodesAfterExamined.clear();
        if (this.nodesBeforeExamined.isEmpty()) {
            cellToNotFound = true;
        }
        for (ParentNode<Cell> node : nodesBeforeExamined) {
            nodesAfterExamined.push(node);
        }
    }

    private void examineAllNodesInNodesAfterExamined() {
        for (ParentNode<Cell> node : nodesAfterExamined) {
            examineNode(node);
        }
    }

    private void examineNode(ParentNode<Cell> node) {
        final Cell cellToExamin = node.getValue();
        if (cellToExamin.equals(this.cellTo)) {
            this.endNode = node;
            this.cellToFound = true;

            return;
        }
        for (Direction direction : directions) {
            if (!cellToExamin.getWalls().isWallAtDirection(direction)) {

                Cell cellBeforeExaming = cellToExamin.getCellAtDirection(direction);

                if (cellBeforeExaming == null || this.visitedCells.contains(cellBeforeExaming)) {
                    continue;
                }

                boolean addCellWithWallsToVisitedCells = true;

                if (cellBeforeExaming.getWalls().hasAWall()) {
                    addCellWithWallsToVisitedCells = false;
                }

                if (addCellWithWallsToVisitedCells) {
                    this.visitedCells.add(cellBeforeExaming);
                }

                if (cellBeforeExaming.isEmpty() && !cellBeforeExaming.isLocked() && !cellBeforeExaming.getWalls().isWallAtDirection(direction.overTurn())) {
                    this.nodesBeforeExamined.push(node.createChild(cellBeforeExaming));
                }

            }
        }
    }

    private void fillPathFromStartToEndStack() {

        if (this.endNode != null) {
            ParentNode<Cell> tempNode = endNode;
            while (tempNode.getParent() != null) {
                this.pathFromStartToEndStack.push(tempNode.getValue());
                tempNode = tempNode.getParent();
            }
        }
    }

}
