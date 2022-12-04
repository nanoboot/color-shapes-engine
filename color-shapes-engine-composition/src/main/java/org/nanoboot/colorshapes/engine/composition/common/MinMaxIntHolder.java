
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

package org.nanoboot.colorshapes.engine.composition.common;

import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.random.generators.RandomGenerator;

/**
 * Class holding an Integer value implementing Composition.
 * @param <C> composition type
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class MinMaxIntHolder<C extends Composition>  extends IntHolder
        implements Composition<C>, MinMaxDefault {
    /**
     * Internal randon generator.
     */
    protected static final RandomGenerator RANDOM =
            RandomGenerator.getDefaultImplStatic();
    /**
     * Min value.
     */
    @Getter
    @Setter
    private int minValue;
    /**
     * Max value.
     */
    @Getter
    @Setter
    private int maxValue;
    /**
     * Default value.
     */
    @Getter
    @Setter
    private int defaultValue;

    /**
     * Constructor.
     *
     * @param value value to be hold
     * @param minV min value
     * @param maxV max value
     * @param defaultV default value
     */
    public MinMaxIntHolder(
            final int value,
            final int minV, final int maxV, final int defaultV) {
        this.setValue(value);
        this.minValue = minV;
        this.maxValue = maxV;
        this.defaultValue = defaultV;
    }

    /**
     * Constructor.
     */
    public MinMaxIntHolder() {
    }
    /**
     * Constructor.
     *
     * @param jo json object
     */
    public MinMaxIntHolder(final JsonObject jo) {
        fromJsonObject(jo);
    }

    /**
     * Can be overridden.
     * @return result of the validation
     */
    @Override
    public boolean validate() {
        return (getValue() >= minValue) && (getValue() <= maxValue)
                && additionalValidate();
    }
    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "Value is not in the range." + "("
                + getMinValue() + ", " + getMaxValue() + ")";
    }

    /**
     * Default implementation for MinMaxIntHolder.
     * @return
     */
    @Override
    public boolean setRandomValues() {
        int random = RANDOM.nextInt(this.getMinValue(), this.getMaxValue());
        this.setValue(random);
        return true;
    }

    /**
     * @return true
     */
    @Override
    public boolean setDefaultValues() {
        int defaultV = this.getDefaultValue();
        this.setValue(defaultV);
        return true;

    }

    @Override
    public final boolean isDefault() {
        return this.getValue() == this.getDefaultValue();
    }

    /**
     * @return json object
     */
    @Override
    public JsonObject toJsonObject() {
        JsonObject jo = getInitialJsonObject();
        jo.add("value", this.getValue());
        jo.add("minValue", this.getMinValue());
        jo.add("maxValue", this.getMaxValue());
        jo.add("defaultValue", this.getDefaultValue());
        return jo;
    }

    /**
     * @param jsonObject json object
     */
    @Override
    public void fromJsonObject(final JsonObject jsonObject) {
        this.setValue(jsonObject.getInt("value"));
        this.setMinValue(jsonObject.getInt("minValue"));
        this.setMaxValue(jsonObject.getInt("maxValue"));
        this.setDefaultValue(jsonObject.getInt("defaultValue"));
    }

    /**
     * @return true, if the value is 0, otherwise false
     */
    public boolean isNotZero() {
        return !isZero();
    }
    /**
     * @return true, if the value is 0, otherwise false
     */
    public boolean isZero() {
        return this.getValue() == 0;
    }

}
