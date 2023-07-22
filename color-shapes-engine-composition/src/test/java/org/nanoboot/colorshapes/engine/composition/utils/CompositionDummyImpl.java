
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

package org.nanoboot.colorshapes.engine.composition.utils;

import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.json.JsonObject;

import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CompositionDummyImpl extends AbstractComposition implements Composition<CompositionDummyImpl> {
    public CompositionDummyImpl() {
    }

    public CompositionDummyImpl(JsonObject jo) {
        fromJsonObject(jo);
    }
    @Setter
    @Getter
    private PlusComposition plusComposition;
    @Setter
    @Getter
    private MinusComposition minusComposition;

    @Override
    public String getName() {
        return "compositionDummyImpl";
    }

    @Override
    public CompositionDummyImpl returnThis() {
        return this;
    }
    @Override
    public List<Composition> getChildren() {

        List<Composition> list = new PowerList<>();
        if(plusComposition != null) {
            list.add(plusComposition);
        }
        if(minusComposition != null) {
            list.add(minusComposition);
        }
        return list;
    }
    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "test";
    }
}
