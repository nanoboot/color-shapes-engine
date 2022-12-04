
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

import org.nanoboot.colorshapes.engine.core.misc.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.game.parts.Board;
import org.nanoboot.colorshapes.engine.game.parts.Cell;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum CellPosition {
    TOP_LEFT(1),

    TOP_MIDDLE(2),

    TOP_RIGHT(3),

    MIDDLE_LEFT(4),

    MIDDLE_MIDDLE(5),

    MIDDLE_RIGHT(6),

    BOTTOM_LEFT(7),

    BOTTOM_MIDDLE(8),

    BOTTOM_RIGHT(9),

    TOP(11),

    RIGHT(12),

    BOTTOM(13),

    LEFT(14);

    @Getter
    private final int code;

    CellPosition(int code) {
        this.code = code;
    }

    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();
        String[] array = this.name().split("_");
        if (array.length == 1) {
            positions.add(Position.valueOf(this.name()));
        }
        if (array.length == 2) {
            positions.add(Position.valueOf(array[0]));
            positions.add(Position.valueOf(array[1]));
        }
        if (array.length == 0 || array.length > 2) {
            throw new ColorShapesEngineException("Invalid array length: CellPosition." + name() + ".name().split(\"_\").length=" + array.length);
        }
        return positions;
    }

    /**
     * It examines the position of the cell on the board <br />
     * <pre>
     *                  11
     *               --------
     *               |1 2 3 |
     *            14 |4 5 6 | 12
     *               |7 8 9 |
     *               --------
     *                  13
     * </pre> For example: If the cell is in the position 6, the cell has
     * following attributes:<br />
     * <ul>
     * <li>The column is the last column.</li>
     * <li>The row is between the first and the last.</li>
     * </ul>
     *
     * @param code<br />Position code for cell on board.<br />
     * @return boolean
     */
    public static boolean hasPositionCode(Cell cell, int code) {//NOSONAR
        Board board = cell.getBoard();
        if (!((code >= 1) && (code <= 14) && (code != 10))) {
            throw new IllegalArgumentException("Illegal position code.");
        }

        int lastRow = board.getHeight();
        int lastColumn = board.getWidth();
        int cellRow = cell.getRow();
        int cellColumn = cell.getColumn();
        switch (code) {

            case 1:
                return (cellRow == 1) && (cellColumn == 1);
            case 2:
                return (cellRow == 1) && (cellColumn > 1) && (cellColumn < lastColumn);
            case 3:
                return (cellRow == 1) && (cellColumn == lastColumn);
            case 4:
                return (cellRow > 1) && (cellRow < lastRow) && (cellColumn == 1);
            case 5:
                return (cellRow > 1) && (cellRow < lastRow) && (cellColumn > 1) && (cellColumn < lastColumn);
            case 6:
                return (cellRow > 1) && (cellRow < lastRow) && (cellColumn == lastColumn);
            case 7:
                return (cellRow == lastRow) && (cellColumn == 1);
            case 8:
                return (cellRow == lastRow) && (cellColumn > 1) && (cellColumn < lastColumn);
            case 9:
                return (cellRow == lastRow) && (cellColumn == lastColumn);
            case 11:
                return cellRow == 1;
            case 12:
                return cellColumn == lastColumn;
            case 13:
                return cellRow == lastRow;
            case 14:
                return cellColumn == 1;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * @param code1
     * @param code2
     * @return
     */
    public static boolean hasPositionCode1OrCode2(Cell cell, int code1, int code2) {
        return (hasPositionCode(cell, code1)) || (hasPositionCode(cell, code2));
    }
}
