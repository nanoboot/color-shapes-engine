
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

package org.nanoboot.colorshapes.engine.composition.board.shape.holes;

import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.json.JsonObject;

import java.util.List;

/**
 * Represents a cell coordination (a column and a row).
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CellCoordination extends AbstractComposition
        implements Composition<CellCoordination> {
    /**
     * Row.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private Row row;
    /**
     * Column.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private Column column;

    /**
     * Constructor.
     *
     * @param jo cell coordination as json object
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public CellCoordination(final JsonObject jo) {
        fromJsonObject(jo);
    }

    /**
     * Constructor.
     *
     * @param rowIn row
     * @param columnIn column
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public CellCoordination(final int rowIn, final int columnIn) {
        this.row = new Row(rowIn);
        this.column = new Column(columnIn);
    }

    /**
     * Constructor.
     */
    public CellCoordination() {
    }

    @Override
    public final CellCoordination returnThis() {
        return this;
    }

    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "Row or column is not valid.";
    }

    @Override
    public final List<Composition> getChildren() {
        return new PowerList<>(row, column);
    }
}
