
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

package org.nanoboot.colorshapes.engine.game.utils;

import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.game.parts.Board;
import org.nanoboot.colorshapes.engine.game.parts.Cell;

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
                if (!CellPosition.hasPositionCode(cell, 11)) {
                    return board.getCell(cellRow - 1, cellColumn);
                } else {
                    return null;
                }
            case RIGHT:
                if (!CellPosition.hasPositionCode(cell, 12)) {
                    return board.getCell(cellRow, cellColumn + 1);
                } else {
                    return null;
                }
            case BOTTOM:
                if (!CellPosition.hasPositionCode(cell, 13)) {
                    return board.getCell(cellRow + 1, cellColumn);
                } else {
                    return null;
                }
            case LEFT:
                if (!CellPosition.hasPositionCode(cell, 14)) {
                    return board.getCell(cellRow, cellColumn - 1);
                } else {
                    return null;
                }
            case TOP_RIGHT:
                if (!CellPosition.hasPositionCode1OrCode2(cell, 11, 12)) {
                    return board.getCell(cellRow - 1, cellColumn + 1);
                } else {
                    return null;
                }
            case BOTTOM_RIGHT:
                if (!CellPosition.hasPositionCode1OrCode2(cell, 12, 13)) {
                    return board.getCell(cellRow + 1, cellColumn + 1);
                } else {
                    return null;
                }
            case BOTTOM_LEFT:
                if (!CellPosition.hasPositionCode1OrCode2(cell, 13, 14)) {
                    return board.getCell(cellRow + 1, cellColumn - 1);
                } else {
                    return null;
                }
            case TOP_LEFT:
                if (!CellPosition.hasPositionCode1OrCode2(cell, 14, 11)) {
                    return board.getCell(cellRow - 1, cellColumn - 1);
                } else {
                    return null;
                }
            default:
                throw new ColorShapesEngineException("Unknown direction");
        }
    }

}
