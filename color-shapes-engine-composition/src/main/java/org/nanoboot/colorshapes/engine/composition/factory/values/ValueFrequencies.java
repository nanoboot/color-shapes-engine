
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

package org.nanoboot.colorshapes.engine.composition.factory.values;

import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.colorshapes.engine.base.misc.BallValue;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.colorshapes.engine.composition.utils.Frequency;
import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.json.JsonObject;

import java.util.List;

/**
 * Value frequencies.
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ValueFrequencies extends AbstractComposition
        implements Composition<ValueFrequencies> {
    /**
     * Value -2.
     *
     * @since 0.0.0
     */
    public static final int VALUE_MINUS_2 = -2;
    /**
     * Value -1.
     *
     * @since 0.0.0
     */
    public static final int VALUE_MINUS_1 = -1;
    /**
     * Value 0.
     *
     * @since 0.0.0
     */
    public static final int VALUE_0 = 0;
    /**
     * Value 1.
     *
     * @since 0.0.0
     */
    public static final int VALUE_PLUS_1 = 1;
    /**
     * Value 2.
     *
     * @since 0.0.0
     */
    public static final int VALUE_PLUS_2 = 2;
    /**
     * Min Value (-2).
     *
     * @since 0.0.0
     */
    public static final int MIN_VALUE = VALUE_MINUS_2;
    /**
     * Max Value (2).
     *
     * @since 0.0.0
     */
    public static final int MAX_VALUE = VALUE_PLUS_2;
    /**
     * Default Value (1).
     *
     * @since 0.0.0
     */
    public static final int DEFAULT_VALUE = VALUE_PLUS_1;
    /**
     * Frequency of value -2.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ValueFrequency valueMinus2Frequency =
            new ValueFrequency(Frequency.MAX_VALUE, VALUE_MINUS_2);
    /**
     * Frequency of value -1.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ValueFrequency valueMinus1Frequency =
            new ValueFrequency(Frequency.MAX_VALUE, VALUE_MINUS_1);
    /**
     * Frequency of value 0.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ValueFrequency value0Frequency =
            new ValueFrequency(Frequency.MAX_VALUE, VALUE_0);
    /**
     * Frequency of value 1.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ValueFrequency valuePlus1Frequency =
            new ValueFrequency(Frequency.MAX_VALUE, VALUE_PLUS_1);
    /**
     * Frequency of value 2.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private ValueFrequency valuePlus2Frequency =
            new ValueFrequency(Frequency.MAX_VALUE, VALUE_PLUS_2);

    /**
     * textToDescribe.
     * @param valueFrequenciesJsonObject textToDescribe
     */
    public ValueFrequencies(final JsonObject valueFrequenciesJsonObject) {
        this.fromJsonObject(valueFrequenciesJsonObject);
    }

    /**
     * Constructor.
     */
    public ValueFrequencies() {
    }

    public ValueFrequencies(String id, Integer valueMinus2Frequency, Integer valueMinus1Frequency, Integer value0Frequency, Integer valuePlus1Frequency, Integer valuePlus2Frequency) {
        this.id = id;
        this.valueMinus2Frequency.setValue(valueMinus2Frequency);
        this.valueMinus1Frequency.setValue(valueMinus1Frequency);
        this.value0Frequency.setValue(value0Frequency);
        this.valuePlus1Frequency.setValue(valuePlus1Frequency);
        this.valuePlus2Frequency.setValue(valuePlus2Frequency);
    }
    /**
     * @param value number of the value
     * @return ColourFrequency with the given number
     */
    public final ValueFrequency getValueFrequency(final int value) {
        switch (value) {
            case VALUE_MINUS_2: return this.valueMinus2Frequency;
            case VALUE_MINUS_1: return this.valueMinus1Frequency;
            case VALUE_0: return this.value0Frequency;
            case VALUE_PLUS_1: return this.valuePlus1Frequency;
            case VALUE_PLUS_2: return this.valuePlus2Frequency;
            default :
                String msg =
                        "Value must be >= -2 and <= 2, but it is " + value;
                throw new IllegalArgumentException(msg);
        }
    }
    /**
     * Sets the given value frequency.
     * @param value given value
     * @param frequency frequency to be set
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public void setFrequency(final int value, final int frequency) {
        this.getValueFrequency(value).setValue(frequency);
    }
    /**
     * Gets the frequency for the given value.
     * @param value given value
     * @return frequency of the given value
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public int getFrequency(final int value) {
        return this.getValueFrequency(value).getValue().intValue();
    }

    @Override
    public final boolean setDefaultValues() {
        for (int value = BallValue.MIN_VALUE;
             value <= BallValue.MAX_VALUE;
             value++) {
            if (value != DEFAULT_VALUE) {
                this.setFrequency(value, Frequency.MIN_VALUE);
            } else {
                this.setFrequency(value, Frequency.MAX_VALUE);
            }
        }

        return true;
    }

    @Override
    public final ValueFrequencies returnThis() {
        return this;
    }
    @Override
    public final List<Composition> getChildren() {
        return new PowerList<>(
                valueMinus2Frequency,
                valueMinus1Frequency,
                value0Frequency,
                valuePlus1Frequency,
                valuePlus2Frequency
        );
    }

    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "One of children is not valid.";
    }
}
