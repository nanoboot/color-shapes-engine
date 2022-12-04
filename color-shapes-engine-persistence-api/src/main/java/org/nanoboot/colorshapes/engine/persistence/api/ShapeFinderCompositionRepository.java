
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

package org.nanoboot.colorshapes.engine.persistence.api;

import java.util.UUID;
import org.nanoboot.colorshapes.engine.entity.core.ShapeFinderCompositionDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public interface ShapeFinderCompositionRepository extends Crudl<ShapeFinderCompositionDto> {

    @Override
    default void update(ShapeFinderCompositionDto t) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(UUID id) {
        throw new UnsupportedOperationException();
    }
 
//    static ShapeFinderComposition getBallDetonatorComposition(int ballDetonatorCompositionId) {
//        ShapeFinderComposition ballDetonatorComposition;
//        JsonObject ballDetonatorCompositionJsonObject = databaseConnection.getRow("ball_detonator", ballDetonatorCompositionId);
//
//        int explodingShapeTypeId = Integer.parseInt(ballDetonatorCompositionJsonObject.getString("exploding_shape_type_id"));
//
//        ExplodingShapeType explodingShapeType = ExplodingShapeTypeTable.getExplodingShapeType(explodingShapeTypeId);
//
//        ballDetonatorComposition = new ShapeFinderComposition(
//                explodingShapeType,
//                Integer.parseInt(ballDetonatorCompositionJsonObject.getString("minimum_lenght_line")),
//                Integer.parseInt(ballDetonatorCompositionJsonObject.getString("minimum_block_size")),
//                null
//        );
//        return ballDetonatorComposition;
//    }
//
//    /**
//     * @param explodingShapeTypeId
//     * @param minimumLineLenght
//     * @param minimumBlockSize
//     * @param customExplodingShapeId
//     * @return
//     */
//    public static int saveBallDetonator(int explodingShapeTypeId, int minimumLineLenght, int minimumBlockSize, int customExplodingShapeId) {
//        StringBuilder insertCommandStringBuilder = new StringBuilder("INSERT INTO ball_detonator VALUES (null,");
//        insertCommandStringBuilder.append(explodingShapeTypeId).append(",");
//        insertCommandStringBuilder.append(minimumLineLenght).append(",");
//        insertCommandStringBuilder.append(minimumBlockSize).append(",");
//        insertCommandStringBuilder.append(customExplodingShapeId).append(")");
//        return databaseConnection.execute(insertCommandStringBuilder.toString());
//    }
//
//    /**
//     * @param ballDetonatorComposition
//     * @return
//     */
//    public static int getId(ShapeFinderComposition ballDetonatorComposition) {
//        int explodingShapeTypeId = ExplodingShapeTypeTable.getId(ballDetonatorComposition.getExplodingShapeType().toString());
//        int minimumLineLenght = ballDetonatorComposition.getMinimumSize().getValue();
//        int minimumSizeBlock = ballDetonatorComposition.getMinimumSize().getValue();//todo
//
//        String sqlQueryString
//                = "SELECT * FROM ball_detonator WHERE "
//                + "exploding_shape_type_id = "
//                + explodingShapeTypeId
//                + " AND minimum_lenght_line= "
//                + minimumLineLenght
//                + " AND minimum_block_size= "
//                + minimumSizeBlock;
//
//        Table resultOfSqlQuery = databaseConnection.executeAndReturn(sqlQueryString);
//        if (resultOfSqlQuery.isEmpty()) {
//            return saveBallDetonator(explodingShapeTypeId, minimumLineLenght, minimumSizeBlock, 0);
//        } else {
//            resultOfSqlQuery.moveToTheNextRow();
//            return resultOfSqlQuery.getInt("id");
//        }
//    }
   
}
