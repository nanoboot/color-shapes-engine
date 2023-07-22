
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

package org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence;

import org.nanoboot.powerframework.db.manager.Table;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallMoveEffectTable extends StaticTable {

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    private BallMoveEffectTable() {
        //Not meant to be instantiated.
    }

    /**
     * @param description
     * @return
     */
    public static int saveBallMoveEffect(String description) {
        StringBuilder insertCommandStringBuilder = new StringBuilder("INSERT INTO ball_move_effect VALUES (null,'");
        insertCommandStringBuilder.append(description).append("')");
        return databaseConnection.execute(insertCommandStringBuilder.toString());
    }

    /**
     * @param description
     * @return id of the row with the given name
     */
    public static int getId(String description) {
        Table resultOfSqlQuery = databaseConnection.executeAndReturn("SELECT id FROM ball_move_effect WHERE name='" + description + "'");
        resultOfSqlQuery.moveToTheNextRow();
        return resultOfSqlQuery.getInt("id");
    }

    /**
     * @param id
     * @return
     */
    public static String getName(int id) {
        Table resultOfSqlQuery = databaseConnection.executeAndReturn("SELECT name FROM ball_move_effect WHERE id=" + id);
        resultOfSqlQuery.moveToTheNextRow();
        return resultOfSqlQuery.getString("name");
    }
}
