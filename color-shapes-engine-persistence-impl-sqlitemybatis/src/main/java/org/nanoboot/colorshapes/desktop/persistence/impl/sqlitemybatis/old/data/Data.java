
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

package org.nanoboot.colorshapes.desktop.persistence.impl.powper.old.data;

import org.nanoboot.powerframework.db.manager.Databases;
import org.nanoboot.powerframework.db.manager.Database;

/**
 * Represents data layer.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 */
public class Data {

    private static final String DATABASENAME = "data";

    private final Database database;

    private final boolean launchedForFirstTime;

    /**
     * Constructor
     */
    public Data() {
        launchedForFirstTime = !Databases.existsDatabase(DATABASENAME);
        if (launchedForFirstTime) {
            Databases.createDatabase(DATABASENAME);
        }
        this.database = Databases.getDatabase(DATABASENAME);
    }

    /**
     * @return
     */
    public Database getDatabase() {
        return this.database;
    }

    /**
     * @return
     */
    public boolean isLaunchedForFirstTime() {
        return this.launchedForFirstTime;
    }
}
