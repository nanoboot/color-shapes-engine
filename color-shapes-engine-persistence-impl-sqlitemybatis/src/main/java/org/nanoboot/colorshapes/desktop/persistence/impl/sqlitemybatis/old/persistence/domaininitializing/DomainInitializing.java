
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

package org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.domaininitializing;

import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.*;
import org.nanoboot.colorshapes.engine.base.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.ApplicationTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.BallDetonatorTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.BallFactoryTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.BallLightingTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.BallMoveEffectTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.BallThrowerTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.BoardTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.ColourFrequencyTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.ExplodingShapeTypeTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.GameCompositionTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.OtherTable;
import org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.persistence.ShapeTable;
import org.nanoboot.powerframework.db.manager.CommandStore;
import org.nanoboot.powerframework.db.manager.Database;
import org.nanoboot.powerframework.db.manager.Databases;
import org.nanoboot.powerframework.json.JsonObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Represents class used to install data, if the game is launched for the first
 * time.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class DomainInitializing {

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    private DomainInitializing() {
// Not meant to be instantiated.
    }

    /**
     * Installs basic data.
     *
     * @param databaseConnection
     */
    public static void install(Database databaseConnection) {
        createTables(databaseConnection);
        insertIntoDatabaseTextSourceData();
        initBasicData();

    }

    private static void createTables(Database databaseConnection) {
        String commandsToCreateTables;

        InputStream input = DomainInitializing.class.getResourceAsStream("/createtables.sql");
        if (input == null) {
            throw new ColorShapesDesktopException("Input is null.");
        }

        commandsToCreateTables = new Scanner(input).next();
        databaseConnection.execute(commandsToCreateTables);
    }

    private static void insertIntoDatabaseTextSourceData() {
        initTextConstantTypeTable();

        Database databaseConnection = Databases.getDatabase("data");

        ArrayList<JsonObject> list;
        list = getJsonObjectsAsArrayList();
        for (JsonObject jsonObject : list) {
            JsonObject language = jsonObject.getObject("language");
            JsonObject values = jsonObject.getObject("values");

            String code = language.getString("code");
            String nameInEnglish = language.getString("name in English");
            String originalName = language.getString("original name");

            StringBuilder stringBuilder = new StringBuilder("INSERT INTO language VALUES(null,'");
            stringBuilder.append(code).append("','");
            stringBuilder.append(originalName).append("','");
            stringBuilder.append(nameInEnglish).append("');");
            int languageId = databaseConnection.execute(stringBuilder.toString());

            List<String> set = values.keyList();
            CommandStore sqlCommandQueue = new CommandStore();
            for (String key : set) {

                String value = values.getString(key);
                StringBuilder insertCommand = new StringBuilder();
                insertCommand.append("INSERT INTO text_constant VALUES(null,");
                insertCommand.append(key).append(",");
                insertCommand.append(languageId).append(",'");
                insertCommand.append(value).append("')");
                sqlCommandQueue.add(insertCommand.toString());
            }
            databaseConnection.executeMoreCommands(sqlCommandQueue);
        }
    }

    private static void initTextConstantTypeTable() {
        InputStream input = DomainInitializing.class.getResourceAsStream("/cls/persistence/languagePacks/types.json");
        JsonObject types = new JsonObject(new Scanner(input).useDelimiter("\\Z").next());
        List<String> set = types.keyList();

        CommandStore sqlCommandQueue = new CommandStore();

        for (String key : set) {
            String description = types.getString(key);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO text_constant_type VALUES (");
            stringBuilder.append(key).append(",'");
            stringBuilder.append(description).append("')");
            sqlCommandQueue.add(stringBuilder.toString());
        }
        Databases.getDatabase("data").executeMoreCommands(sqlCommandQueue);
    }

    private static ArrayList<JsonObject> getJsonObjectsAsArrayList() {
        ArrayList<JsonObject> list;
        list = new ArrayList<>();
        String[] codes = {"en", "cz"};
        for (String code : codes) {
            InputStream input = DomainInitializing.class.getResourceAsStream("/cls/persistence/languagePacks/" + code + ".json");
            list.add(new JsonObject(new Scanner(input, "utf-8").useDelimiter("\\Z").next()));
        }
        return list;
    }

    private static void initBasicData() {
        initExplodingShapeTypeTable();
        initBallLightingTable();
        initBallMoveEffectTable();

        initApplicationTable();

        initGameCompositionTable();
    }

    private static void initExplodingShapeTypeTable() {
        String[] explodingShapeTypeString = {"LINE", "BLOCK", "RING", "SQUARE", "CUSTOM"};
        for (String value : explodingShapeTypeString) {
            ExplodingShapeTypeTable.saveExplodingShapeType(value);
        }
    }

    private static void initBallLightingTable() {
        String[] ballLightingString = {"none", "above", "ahead"};
        for (String value : ballLightingString) {
            BallLightingTable.saveBallLighting(value);
        }
    }

    private static void initBallMoveEffectTable() {
        String[] ballMoveEffectString = {"no", "arrow", "highlight"};
        for (String value : ballMoveEffectString) {
            BallMoveEffectTable.saveBallMoveEffect(value);
        }
    }

    private static void initApplicationTable() {
        int installationUniqueNumber = org.nanoboot.powerframework.random.generators.RandomGenerator.getDefaultImplStatic().nextInt(0, 999999);
        int currentUniversalDateTimeID = UniversalDateTimeTable.saveCurrentUniversalDateTime();

        ApplicationTable.saveApplication(installationUniqueNumber, currentUniversalDateTimeID, 0, 1, 10, 100);
    }

    private static int initGameCompositionTable() {
        ShapeTable.saveEmptyShape();
        int boardShapeId = ShapeTable.saveShape(9, 9, "default");
        int boardId = BoardTable.saveBoard(0, 0, 0, 0, boardShapeId);

        int[] colourFrequency = new int[17];
        int i;
        for (i = 1; i <= 7; i++) {
            colourFrequency[i] = 1;
        }
        for (i = 8; i <= 16; i++) {
            colourFrequency[i] = 0;
        }
        int colourFrequencyId = ColourFrequencyTable.saveColourFrequency(colourFrequency);
        int ballFactoryId = BallFactoryTable.saveBallFactory(colourFrequencyId, 0, 0, 0, 1, 0, 1, 0, 0, 0);

        int ballThrowerId = BallThrowerTable.saveBallThrower(5, 3, 1, 0, 0, false);

        int explodingShapeTypeId = ExplodingShapeTypeTable.getId("LINE");
        int ballDetonatorID = BallDetonatorTable.saveBallDetonator(explodingShapeTypeId, 5, 0, 0);

        int otherId = OtherTable.saveOther(false, false, false);

        return GameCompositionTable.saveGameComposition(boardId, ballFactoryId, ballThrowerId, ballDetonatorID, otherId);
    }

}
