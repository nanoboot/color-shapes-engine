
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

package org.nanoboot.colorshapes.engine.parts.utils;

import org.nanoboot.colorshapes.engine.base.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.parts.core.Board;
import org.nanoboot.colorshapes.engine.parts.core.Cell;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CellFinder {

    /**
     * @param direction
     * @return Cell
     */
    public static Cell findCellAtDirection(Cell cell, Direction direction) {//NOSONAR
        Board board = cell.getBoard();
        int cellRow = cell.getRow();
        int cellColumn = cell.getColumn();

        switch (direction) {
            case TOP:
                if (!CellPosition.hasPosition(cell, CellPosition.TOP)) {
                    return board.getCell(cellRow - 1, cellColumn);
                } else {
                    return null;
                }
            case RIGHT:
                if (!CellPosition.hasPosition(cell, CellPosition.RIGHT)) {
                    return board.getCell(cellRow, cellColumn + 1);
                } else {
                    return null;
                }
            case BOTTOM:
                if (!CellPosition.hasPosition(cell, CellPosition.BOTTOM)) {
                    return board.getCell(cellRow + 1, cellColumn);
                } else {
                    return null;
                }
            case LEFT:
                if (!CellPosition.hasPosition(cell, CellPosition.LEFT)) {
                    return board.getCell(cellRow, cellColumn - 1);
                } else {
                    return null;
                }
            case TOP_RIGHT:
                if (!CellPosition.hasPosition1OrPosition2(cell, CellPosition.TOP, CellPosition.RIGHT)) {
                    return board.getCell(cellRow - 1, cellColumn + 1);
                } else {
                    return null;
                }
            case BOTTOM_RIGHT:
                if (!CellPosition.hasPosition1OrPosition2(cell, CellPosition.BOTTOM, CellPosition.RIGHT)) {
                    return board.getCell(cellRow + 1, cellColumn + 1);
                } else {
                    return null;
                }
            case BOTTOM_LEFT:
                if (!CellPosition.hasPosition1OrPosition2(cell, CellPosition.BOTTOM, CellPosition.LEFT)) {
                    return board.getCell(cellRow + 1, cellColumn - 1);
                } else {
                    return null;
                }
            case TOP_LEFT:
                if (!CellPosition.hasPosition1OrPosition2(cell, CellPosition.TOP, CellPosition.LEFT)) {
                    return board.getCell(cellRow - 1, cellColumn - 1);
                } else {
                    return null;
                }
            default:
                throw new ColorShapesEngineException("Unknown direction");
        }
    }

}
