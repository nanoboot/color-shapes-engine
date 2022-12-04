
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

import org.nanoboot.colorshapes.engine.common.random.CSRandomGeneratorProvider;
import org.nanoboot.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import org.nanoboot.powerframework.json.JsonObject;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class RandomGeneratorTable extends StaticTable {

    /**
     * Constructor
     * <p>
     * Not meant to be instantiated.
     */
    private RandomGeneratorTable() {
        //Not meant to be instantiated.
    }

    /**
     * @param magicNumber
     * @param magicUniversalDateTimeId
     * @return
     */
    public static int saveRandomGenerator(int magicNumber, int magicUniversalDateTimeId) {
        StringBuilder insertCommandStringBuilder = new StringBuilder("INSERT INTO pseudo_random_generator VALUES (null,");
        insertCommandStringBuilder.append(magicNumber).append(",");
        insertCommandStringBuilder.append(magicUniversalDateTimeId).append(")");

        return databaseConnection.execute(insertCommandStringBuilder.toString());
    }

    /**
     * @param id
     * @return instance of RandomGenerator
     */
    public static W5RandomGenerator getRandomGenerator(int id) {
        JsonObject jsonObject = databaseConnection.getRow("pseudo_random_generator", id);
        long magicNumber = Long.parseLong(jsonObject.getString("magic_number"));
        int universalDateTimeId = Integer.parseInt(jsonObject.getString("magic_universal_date_time_id"));
        UniversalDateTime udt = UniversalDateTimeTable.getUniversalDateTime(universalDateTimeId);
        return CSRandomGeneratorProvider.lookupDefault(magicNumber, udt);
    }
}
