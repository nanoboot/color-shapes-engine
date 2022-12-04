
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

import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.colorshapes.engine.entity.misc.BallColour;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.colorshapes.engine.composition.utils.Frequency;
import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.json.JsonObject;

import java.util.List;

/**
 * Colour frequencies.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ColourFrequencies extends AbstractComposition implements Composition {
    /**
     * Colour 1.
     *
     * @since 0.0.0
     */
    public static final int COLOUR1 = 1;
    /**
     * Colour 2.
     *
     * @since 0.0.0
     */
    public static final int COLOUR2 = 2;
    /**
     * Colour 3.
     *
     * @since 0.0.0
     */
    public static final int COLOUR3 = 3;
    /**
     * Colour 4.
     *
     * @since 0.0.0
     */
    public static final int COLOUR4 = 4;
    /**
     * Colour 5.
     *
     * @since 0.0.0
     */
    public static final int COLOUR5 = 5;
    /**
     * Colour 6.
     *
     * @since 0.0.0
     */
    public static final int COLOUR6 = 6;
    /**
     * Colour 7.
     *
     * @since 0.0.0
     */
    public static final int COLOUR7 = 7;
    /**
     * Colour 8.
     *
     * @since 0.0.0
     */
    public static final int COLOUR8 = 8;
    /**
     * Colour 9.
     *
     * @since 0.0.0
     */
    public static final int COLOUR9 = 9;
    /**
     * Colour 10.
     *
     * @since 0.0.0
     */
    public static final int COLOUR10 = 10;
    /**
     * Colour 11.
     *
     * @since 0.0.0
     */
    public static final int COLOUR11 = 11;
    /**
     * Colour 12.
     *
     * @since 0.0.0
     */
    public static final int COLOUR12 = 12;
    /**
     * Colour 13.
     *
     * @since 0.0.0
     */
    public static final int COLOUR13 = 13;
    /**
     * Colour 14.
     *
     * @since 0.0.0
     */
    public static final int COLOUR14 = 14;
    /**
     * Colour 15.
     *
     * @since 0.0.0
     */
    public static final int COLOUR15 = 15;
    /**
     * Colour 16.
     *
     * @since 0.0.0
     */
    public static final int COLOUR16 = 16;
    /**
     * Min Colour (1).
     *
     * @since 0.0.0
     */
    public static final int MIN_COLOUR = COLOUR1;
    /**
     * Max Colour (16).
     *
     * @since 0.0.0
     */
    public static final int MAX_COLOUR = COLOUR16;
    /**
     * Frequency of colour 1.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour1Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR1);
    /**
     * Frequency of colour 2.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour2Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR2);
    /**
     * Frequency of colour 3.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour3Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR3);
    /**
     * Frequency of colour 4.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour4Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR4);
    /**
     * Frequency of colour 5.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour5Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR5);
    /**
     * Frequency of colour 6.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour6Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR6);
    /**
     * Frequency of colour 7.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour7Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR7);
    /**
     * Frequency of colour 8.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour8Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR8);
    /**
     * Frequency of colour 9.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour9Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR9);
    /**
     * Frequency of colour 10.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour10Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR10);
    /**
     * Frequency of colour 11.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour11Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR11);
    /**
     * Frequency of colour 12.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour12Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR12);
    /**
     * Frequency of colour 13.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour13Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR13);
    /**
     * Frequency of colour 14.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour14Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR14);
    /**
     * Frequency of colour 15.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour15Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR15);
    /**
     * Frequency of colour 16.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ColourFrequency colour16Frequency =
            new ColourFrequency(Frequency.MAX_VALUE, COLOUR16);
    /**
     * Constructor.
     * @param colorFrequenciesJsonObject ColourFrequencies as json object
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public ColourFrequencies(final JsonObject colorFrequenciesJsonObject) {
        this.fromJsonObject(colorFrequenciesJsonObject);
    }

    /**
     * Constructor.
     */
    public ColourFrequencies() {

    }

    public ColourFrequencies(String id, Integer colour1Frequency, Integer colour2Frequency, Integer colour3Frequency, Integer colour4Frequency, Integer colour5Frequency, Integer colour6Frequency, Integer colour7Frequency, Integer colour8Frequency, Integer colour9Frequency, Integer colour10Frequency, Integer colour11Frequency, Integer colour12Frequency, Integer colour13Frequency, Integer colour14Frequency, Integer colour15Frequency, Integer colour16Frequency) {
        this.id = id;
        this.colour1Frequency.setValue(colour1Frequency);
        this.colour2Frequency.setValue(colour2Frequency);
        this.colour3Frequency.setValue(colour3Frequency);
        this.colour4Frequency.setValue(colour4Frequency);
        this.colour5Frequency.setValue(colour5Frequency);
        this.colour6Frequency.setValue(colour6Frequency);
        this.colour7Frequency.setValue(colour7Frequency);
        this.colour8Frequency.setValue(colour8Frequency);
        this.colour9Frequency.setValue(colour9Frequency);
        this.colour10Frequency.setValue(colour10Frequency);
        this.colour11Frequency.setValue(colour11Frequency);
        this.colour12Frequency.setValue(colour12Frequency);
        this.colour13Frequency.setValue(colour13Frequency);
        this.colour14Frequency.setValue(colour14Frequency);
        this.colour15Frequency.setValue(colour15Frequency);
        this.colour16Frequency.setValue(colour16Frequency);
    }

    /**
     * @param colour number of the colour
     * @return ColourFrequency with the given number
     */
    public final ColourFrequency getColourFrequency(final int colour) {
        switch (colour) {
            case COLOUR1: return this.colour1Frequency;
            case COLOUR2: return this.colour2Frequency;
            case COLOUR3: return this.colour3Frequency;
            case COLOUR4: return this.colour4Frequency;
            case COLOUR5: return this.colour5Frequency;
            case COLOUR6: return this.colour6Frequency;
            case COLOUR7: return this.colour7Frequency;
            case COLOUR8: return this.colour8Frequency;
            case COLOUR9: return this.colour9Frequency;
            case COLOUR10: return this.colour10Frequency;
            case COLOUR11: return this.colour11Frequency;
            case COLOUR12: return this.colour12Frequency;
            case COLOUR13: return this.colour13Frequency;
            case COLOUR14: return this.colour14Frequency;
            case COLOUR15: return this.colour15Frequency;
            case COLOUR16: return this.colour16Frequency;
            default :
                String msg =
                        "Colour must be >= 1 and <= 16, but it is " + colour;
                throw new IllegalArgumentException(msg);
        }
    }
    /**
     * Sets the given colour frequency.
     * @param colour given colour
     * @param frequency frequency to be set
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public void setFrequency(final int colour, final int frequency) {
        this.getColourFrequency(colour).setValue(frequency);
    }
    /**
     * Gets the frequency for the given colour.
     * @param colour given colour
     * @return frequency of the given colour
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public int getFrequency(final int colour) {
        return this.getColourFrequency(colour).getValue();
    }

    @Override
    public final boolean setDefaultValues() {
        for (int i = BallColour.MIN_VALUE;
             i <= BallColour.MAX_VALUE_FOR_DEFAULT; i++) {
            this.setFrequency(i, Frequency.MAX_VALUE);
        }
        for (int i = BallColour.MAX_VALUE_FOR_DEFAULT + 1;
             i <= BallColour.MAX_VALUE; i++) {
            this.setFrequency(i, Frequency.MIN_VALUE);
        }
        return true;
    }

    @Override
    public final List<Composition> getChildren() {
        return new PowerList<>(
                colour1Frequency,
                colour2Frequency,
                colour3Frequency,
                colour4Frequency,
                colour5Frequency,
                colour6Frequency,
                colour7Frequency,
                colour8Frequency,
                colour9Frequency,
                colour10Frequency,
                colour11Frequency,
                colour12Frequency,
                colour13Frequency,
                colour14Frequency,
                colour15Frequency,
                colour16Frequency
        );
    }

    @Override
    public final Composition returnThis() {
        return this;
    }

    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "One of children is not valid.";
    }
}
