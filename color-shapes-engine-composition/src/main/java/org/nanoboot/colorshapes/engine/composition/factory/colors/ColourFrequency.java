
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

package org.nanoboot.colorshapes.engine.composition.factory.colors;

import org.nanoboot.colorshapes.engine.composition.utils.Frequency;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.colorshapes.engine.entity.misc.BallColour;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * Colour frequency.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ColourFrequency extends Frequency {
    /**
     * Colour number.
     */
    @Getter
    @Setter
    private int colourNumber;

    /**
     * Constructor.
     *
     * @param value    value to be hold
     * @param colourIn colour frequency number
     */
    public ColourFrequency(final int value, final int colourIn) {
        super(value);
        this.colourNumber = colourIn;
    }
    /**
     * Constructor.
     *
     */
    public ColourFrequency() {
        super();
        this.colourNumber = BallColour.MIN_VALUE;
    }
    /**
     * Constructor.
     *
     * @param jo    json object
     */
    public ColourFrequency(final JsonObject jo) {
        super(jo);
    }

    /**
     * @return
     */
    @Override
    public JsonObject toJsonObject() {
        JsonObject jo = super.toJsonObject();
        jo.addInt("colourNumber", this.colourNumber);
        return jo;
    }
    /**
     *
     * @param jo
     */
    @Override
    public void fromJsonObject(final JsonObject jo) {
        super.fromJsonObject(jo);
        this.colourNumber = jo.getInt("colourNumber");
    }

    @Override
    public final String getName() {
        return "colour" + colourNumber + "Frequency";
    }

    @Override
    public final ColourFrequency returnThis() {
        return this;
    }
}
