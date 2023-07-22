
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

package org.nanoboot.colorshapes.engine.persistence.api;

import java.util.UUID;
import org.nanoboot.colorshapes.engine.dto.BoardCompositionDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public interface BoardCompositionRepository extends Crudl<BoardCompositionDto> {

    @Override
    default void update(BoardCompositionDto t) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(UUID id) {
        throw new UnsupportedOperationException();
    }
    
    
//        static BoardComposition getBoardComposition(int boardCompositionId) {
//        BoardComposition boardComposition;
//        JsonObject boardCompositionJsonObject = databaseConnection.getRow("board", boardCompositionId);
//
//        int shapeId = Integer.parseInt(boardCompositionJsonObject.getString("shape_id"));
//
//        Shape shape = ShapeTable.getShape(shapeId);
//
//        boardComposition = new BoardComposition(shape,
//                Integer.parseInt(boardCompositionJsonObject.getString("grid_probability")),
//                Integer.parseInt(boardCompositionJsonObject.getString("grid_count")),
//                Integer.parseInt(boardCompositionJsonObject.getString("wall_probability")),
//                Integer.parseInt(boardCompositionJsonObject.getString("wall_count"))
//        );
//        return boardComposition;
//    }
//
//    /**
//     * @param gridProbability
//     * @param gridCount
//     * @param wallProbaility
//     * @param wallCount
//     * @param shapeId
//     * @return
//     */
//    public static int saveBoard(int gridProbability, int gridCount, int wallProbaility, int wallCount, int shapeId) {
//        StringBuilder insertCommandStringBuilder = new StringBuilder("INSERT INTO board VALUES (null,");
//        insertCommandStringBuilder.append(gridProbability).append(",");
//        insertCommandStringBuilder.append(gridCount).append(",");
//        insertCommandStringBuilder.append(wallProbaility).append(",");
//        insertCommandStringBuilder.append(wallCount).append(",");
//        insertCommandStringBuilder.append(shapeId).append(")");
//        return databaseConnection.execute(insertCommandStringBuilder.toString());
//    }
//
//    /**
//     * @param boardComposition
//     * @return
//     */
//    public static int getId(BoardComposition boardComposition) {
//        int gridProbability = boardComposition.getGridProbability();
//        int gridCount = boardComposition.getGridCount();
//        int wallProbability = boardComposition.getWallProbability();
//        int wallCount = boardComposition.getWallCount();
//
//        int shapeId = ShapeTable.getId(boardComposition.getShape());
//
//        String sqlQueryString
//                = "SELECT * FROM board,shape WHERE grid_probability = "
//                + gridProbability
//                + " AND grid_count = "
//                + gridCount
//                + " AND wall_probability = "
//                + wallProbability
//                + " AND wall_count = "
//                + wallCount
//                + " AND shape_id = "
//                + shapeId;
//
//        Table resultOfSqlQuery = databaseConnection.executeAndReturn(sqlQueryString);
//        if (resultOfSqlQuery.isEmpty()) {
//            return saveBoard(gridProbability, gridCount, wallProbability, wallCount, shapeId);
//        } else {
//            resultOfSqlQuery.moveToTheNextRow();
//            return resultOfSqlQuery.getInt("id");
//        }
//    }

}
