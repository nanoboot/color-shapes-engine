
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

package org.nanoboot.colorshapes.engine.composition.board.shape.holes;

import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import lombok.Getter;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.json.JsonArray;
import org.nanoboot.powerframework.json.JsonObject;

import java.util.List;

/**
 * Represents a list of shape holes.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Holes extends AbstractComposition implements Composition<Holes> {
    /**
     * List of holes.
     *
     * @since 0.0.0
     */
    @Getter
    private final List<CellCoordination> list = new PowerList<>();


    /**
     * Constructor.
     * @param jsonObject given json object
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public Holes(final JsonObject jsonObject) {
        fromJsonObject(jsonObject);
    }

    /**
     * Constructor.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public Holes() {
    }

    @Override
    public final JsonObject toJsonObject() {
        JsonObject jo = getInitialJsonObject();
        JsonArray ja = new JsonArray();
        jo.addArray("list", ja);
        for (CellCoordination f : list) {
            ja.addObject(f.toJsonObject());
        }
        return jo;
    }

    @Override
    public final void fromJsonObject(final JsonObject jsonObject) {
        JsonArray ja = jsonObject.getArray("list");
        for (int index = 0; index < ja.size(); index++) {
            CellCoordination f = new CellCoordination(ja.getObject(index));
            list.add(f);
        }
    }

    @Override
    public final Holes returnThis() {
        return this;
    }

    /**
     * Adds new coordination.
     * @param row row number
     * @param column column number
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public final void add(final int row, final int column) {
        this.list.add(new CellCoordination(row, column));
    }
    @Override
    public final boolean validate() {
        for (CellCoordination e : list) {
            if (!e.validate()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final String describePossibleReasonsIfInvalid() {
        for (CellCoordination e : list) {
            if (!e.validate()) {
                return e.describePossibleReasonsIfInvalid();
            }
        }
        return "";
    }

    @Override
    public final boolean setRandomValues() {
        return setDefaultValues();
    }
    @Override
    public final boolean setDefaultValues() {
        this.list.clear();
        return true;
    }
    @Override
    public final boolean isDefault() {
        return this.list.isEmpty();
    }

    /**
     * @return true, if there is no hole, otherwise false
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
