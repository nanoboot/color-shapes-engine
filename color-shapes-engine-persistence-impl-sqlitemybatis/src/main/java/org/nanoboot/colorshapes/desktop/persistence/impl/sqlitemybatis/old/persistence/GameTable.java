
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

package org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence;

import org.nanoboot.colorshapes.engine.game.composition.GameComposition;
import org.nanoboot.colorshapes.engine.game.composition.Shape;
import org.nanoboot.powerframework.db.manager.Table;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class GameTable extends StaticTable {

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    private GameTable() {
        //Not meant to be instantiated.
    }

    /**
     * @param sessionId
     * @param playerId
     * @param gameCompositionId
     * @param pseudoRandomNumberGeneratorId
     * @return
     */
    public static int saveGameTable(int sessionId, int playerId, int gameCompositionId, int pseudoRandomNumberGeneratorId) {
        String command
                = "INSERT INTO game VALUES (null,"
                + sessionId + ","
                + playerId + ","
                + gameCompositionId + ",-999999,"
                + pseudoRandomNumberGeneratorId
                + ")";
        return databaseConnection.execute(command);
    }

    /**
     * @param playerId
     * @return
     */
    public static int getLastPlayedGameCompositionId(int playerId) {
        String command
                = "SELECT game_composition_id FROM game WHERE id = (select max(id) from game where player_id = " + playerId + ");";
        Table resultOfSqlQuery = databaseConnection.executeAndReturn(command);

        if (resultOfSqlQuery.isEmpty()) {
            GameComposition defaultGameComposition = new GameComposition();
            defaultGameComposition.getBoardComposition().setShape(new Shape(9, 9));
            return GameCompositionTable.getId(defaultGameComposition);
        }
        resultOfSqlQuery.moveToTheNextRow();
        return resultOfSqlQuery.getInt("game_composition_id");
    }

    /**
     * @param gameId
     * @param score
     */
    public static void setScore(int gameId, int score) {
        databaseConnection.updateValue("game", gameId, "result_score", score);
    }
}
