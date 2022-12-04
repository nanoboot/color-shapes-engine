
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
import org.nanoboot.colorshapes.engine.entity.core.OtherCompositionDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public interface OtherCompositionRepository extends Crudl<OtherCompositionDto> {

    @Override
    default void update(OtherCompositionDto t) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(UUID id) {
        throw new UnsupportedOperationException();
    }
  
//    static OtherComposition getOtherComposition(int otherCompositionId) {
//        OtherComposition otherComposition;
//        JsonObject otherCompositionJsonObject = databaseConnection.getRow(TABLENAME, otherCompositionId);
//
//        otherComposition = new OtherComposition(
//                Integer.parseInt(otherCompositionJsonObject.getString(ALLOWED_STEP_BACK)) == 1,
//                Integer.parseInt(otherCompositionJsonObject.getString(FREEMODE)) == 1,
//                Integer.parseInt(otherCompositionJsonObject.getString(TRAINER)) == 1
//        );
//        return otherComposition;
//    }
//
//    /**
//     * @param allowedStepBack
//     * @param freeMode
//     * @param trainer
//     * @return
//     */
//    public static int saveOther(boolean allowedStepBack, boolean freeMode, boolean trainer) {
//        StringBuilder insertCommandStringBuilder = new StringBuilder("INSERT INTO other VALUES (null,");
//        insertCommandStringBuilder.append(booleanToInt(allowedStepBack)).append(",");
//        insertCommandStringBuilder.append(booleanToInt(freeMode)).append(",");
//        insertCommandStringBuilder.append(booleanToInt(trainer)).append(")");
//        return databaseConnection.execute(insertCommandStringBuilder.toString());
//    }
//
//    /**
//     * @param otherComposition
//     * @return
//     */
//    public static int getId(OtherComposition otherComposition) {
//        boolean allowedStepBack = otherComposition.getAllowedStepBack();
//        boolean freeMode = otherComposition.getFreeMode();
//        boolean trainer = otherComposition.getTrainer();
//
//        String sqlQueryString
//                = "SELECT * FROM other WHERE "
//                + "allowed_step_back = "
//                + (allowedStepBack ? 1 : 0)
//                + " AND free_mode= "
//                + (freeMode ? 1 : 0)
//                + " AND trainer= "
//                + (trainer ? 1 : 0);
//
//        Table resultOfSqlQuery = databaseConnection.executeAndReturn(sqlQueryString);
//        if (resultOfSqlQuery.isEmpty()) {
//            return saveOther(allowedStepBack, freeMode, trainer);
//        } else {
//            resultOfSqlQuery.moveToTheNextRow();
//            return resultOfSqlQuery.getInt("id");
//        }
//    }
}
