
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
import org.nanoboot.colorshapes.engine.entity.core.ColourFrequenciesDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public interface ColourFrequenciesRepository extends Crudl<ColourFrequenciesDto> {

    @Override
    default void update(ColourFrequenciesDto t) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(UUID id) {
        throw new UnsupportedOperationException();
    }
 
//    /**
//     * @param number
//     * @return columnName
//     */
//    public static String getColumnNameForColourFrequency(int number) {
//        return "colour" + number + "_frequency";
//    }
//
//    static int[] getColourFrequency(int colourFrequencyId) {
//        int[] colourFrequency = new int[17];
//        JsonObject colourFrequencyJsonObject = databaseConnection.getRow(TABLENAME, colourFrequencyId);
//
//        for (int i = 1; i <= 16; i++) {
//            colourFrequency[i] = Integer.parseInt(colourFrequencyJsonObject.getString(getColumnNameForColourFrequency(i)));
//        }
//        return colourFrequency;
//    }
//
//    /**
//     * @param colourFrequency
//     * @return
//     */
//    public static int saveColourFrequency(int[] colourFrequency) {
//        StringBuilder insertCommandStringBuilder = new StringBuilder("INSERT INTO colour_frequency VALUES (null,");
//        for (int i = 1; i <= 16; i++) {
//            insertCommandStringBuilder.append(colourFrequency[i]);
//            if (i != 16) {
//                insertCommandStringBuilder.append(",");
//            }
//        }
//        insertCommandStringBuilder.append(")");
//        return databaseConnection.execute(insertCommandStringBuilder.toString());
//    }
//
//    /**
//     * @param colourFrequency
//     * @return
//     */
//    public static int getId(int[] colourFrequency) {
//        List columnList = new ArrayList<>();
//        for (int i = 1; i <= 16; i++) {
//            columnList.add(getColumnNameForColourFrequency(i));
//        }
//
//        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM colour_frequency WHERE ");
//        for (int i = 1; i <= 16; i++) {
//            stringBuilder.append(getColumnNameForColourFrequency(i)).append(" = ");
//            stringBuilder.append(colourFrequency[i]);
//            if (i != 16) {
//                stringBuilder.append(" AND ");
//            }
//        }
//
//        Table resultOfSqlQuery = databaseConnection.executeAndReturn(stringBuilder.toString());
//        if (resultOfSqlQuery.isEmpty()) {
//            return saveColourFrequency(colourFrequency);
//        } else {
//            resultOfSqlQuery.moveToTheNextRow();
//            return resultOfSqlQuery.getInt("id");
//        }
//    }
}
