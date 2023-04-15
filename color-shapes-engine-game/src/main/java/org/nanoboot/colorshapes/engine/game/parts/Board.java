
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

import org.nanoboot.colorshapes.engine.composition.board.shape.BoardShape;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;
import org.nanoboot.colorshapes.engine.game.core.GameNode;

import java.util.ArrayList;
import java.util.List;

import org.nanoboot.colorshapes.engine.flow.event.impl.move.MoveEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.jumping.StartJumpingEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.jumping.StopJumpingEvent;
import org.nanoboot.powerframework.collections.PowerStack;
import org.nanoboot.powerframework.collections.arrays.ObjectArray;
import org.nanoboot.powerframework.json.JsonArray;
import org.nanoboot.powerframework.json.JsonObject;
import lombok.AccessLevel;
import lombok.Getter;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Board extends GameNode {

    private final ObjectArray<Cell> cells;
    @Getter
    private final int height;
    @Getter
    private final int width;
    @Getter
    private Cell activatedCell = null;

    /**
     * @param eventConsumer eventConsumer
     * @param boardShape    boardShape
     */
    public Board(EventConsumer eventConsumer, BoardShape boardShape) {
        super(eventConsumer);
        this.height = boardShape.getHeight().getValue();
        this.width = boardShape.getWidth().getValue();
        this.cells = new ObjectArray<>(getHeight(), getWidth());
        for (int row = 1; row <= this.getHeight(); row++) {
            for (int column = 1; column <= this.getWidth(); column++) {
                this.cells.set(new Cell(this, row, column), row, column);
            }
        }
    }

    /**
     * @param row
     * @param column
     * @return
     */
    public Cell getCell(int row, int column) {
        if (row <= 0 || column <= 0 || row > this.getHeight() || column > this.getWidth()) {
            return null;
        }
        return this.cells.get(row, column);
    }

    /**
     * @return
     */
    public boolean hasAnActivatedCell() {
        return activatedCell != null;
    }

    /**
     * @param row
     * @param column
     * @return
     */
    public Cell activateCell(int row, int column) {
        if (this.activatedCell != null) {
            throw new ColorShapesEngineException("Another cell is activated. This cell can't be activated");
        }
        this.activatedCell = this.getCell(row, column);

        if (activatedCell.hasABallAbleToJump()) {
            produceEvent(new StartJumpingEvent(row, column));
        }

        return this.activatedCell;
    }

    /**
     * @return
     */
    public Cell deactivateActivatedCell() {
        Cell tempCell = activatedCell;
        activatedCell = null;

        if (tempCell.hasABallAbleToJump()) {
            produceEvent(new StopJumpingEvent(tempCell.getRow(), tempCell.getColumn()));
        }
        return tempCell;
    }

    /**
     * @param cellFrom
     * @param cellTo
     * @param pathStack
     */
    public void moveBallFromTo(Cell cellFrom, Cell cellTo, PowerStack<Cell> pathStack) {
        Ball ball = cellFrom.removeBall();
        cellTo.insertBall(ball);

        int[] numbers = new int[pathStack.size() * 2];
        int index = 0;
        for (Cell element : pathStack) {
            int row = element.getRow();
            int column = element.getColumn();
            numbers[index] = row;
            index++;
            numbers[index] = column;
            index++;
        }

        produceEvent(new MoveEvent(cellFrom.getRow(), cellFrom.getColumn(), numbers));
    }

    public boolean isFull() {
        return this.getEmptyCells().isEmpty();
    }

    public boolean hasSomeEmptyCell() {
        return !isFull();
    }

    /**
     * Converts board to json object
     *
     * @return
     */
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addInt("height", getHeight());
        jsonObject.addInt("width", getWidth());
        JsonArray jsonArray = new JsonArray();
        for (int tempRow = 1; tempRow <= getHeight(); tempRow++) {
            for (int tempColumn = 1; tempColumn <= getWidth(); tempColumn++) {
                Cell element = this.cells.get(tempRow, tempColumn);
                JsonObject cellJsonObject = element.toJsonObject();

                jsonArray.addObject(cellJsonObject);
            }
        }
        JsonArray emptyCellsJsonArray = new JsonArray();
        for (Cell element : getEmptyCells()) {
            emptyCellsJsonArray.addObject(element.toJsonObject());
        }
        jsonObject.addArray("cells", jsonArray);
        jsonObject.addArray("empty cells", emptyCellsJsonArray);
        return jsonObject;
    }

    @Getter(AccessLevel.PACKAGE)
    private final List<Cell> cellsWithWalls = new ArrayList<>();

    public List<Cell> getEmptyCells() {
        List<Cell> result = new ArrayList<>();
        for (int row = 1; row <= getHeight(); row++) {
            for (int column = 1; column <= getWidth(); column++) {
                Cell cell = getCell(row, column);
                if(cell.isEmpty()) {
                    result.add(cell);
                }
            }
        }
        return result;
    }
    public List<Cell> getLockedCells() {
        List<Cell> result = new ArrayList<>();
        for (int row = 1; row <= getHeight(); row++) {
            for (int column = 1; column <= getWidth(); column++) {
                Cell cell = getCell(row, column);
                if(cell.isLocked()) {
                    result.add(cell);
                }
            }
        }
        return result;
    }
    public List<Cell> getCellsWithWalls() {
        List<Cell> result = new ArrayList<>();
        for (int row = 1; row <= getHeight(); row++) {
            for (int column = 1; column <= getWidth(); column++) {
                Cell cell = getCell(row, column);
                if(cell.hasAWall()) {
                    result.add(cell);
                }
            }
        }
        return result;
    }
    public List<Cell> getEmptyCellsWithFourWalls() {
        List<Cell> result = new ArrayList<>();
        for (int row = 1; row <= getHeight(); row++) {
            for (int column = 1; column <= getWidth(); column++) {
                Cell cell = getCell(row, column);
                if(cell.getWalls().hasAllWalls()) {
                    result.add(cell);
                }
            }
        }
        return result;
    }

}
