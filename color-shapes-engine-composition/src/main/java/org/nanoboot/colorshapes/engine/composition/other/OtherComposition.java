
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

package org.nanoboot.colorshapes.engine.composition.other;

import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.json.JsonObject;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class OtherComposition extends AbstractComposition implements Composition<OtherComposition> {
    /**
     * allowedStepBack text constant.
     *
     * @since 0.0.0
     */
    private static final String ALLOWED_STEP_BACK = "allowedStepBack";
    /**
     * freeMode text constant.
     *
     * @since 0.0.0
     */
    private static final String FREE_MODE = "freeMode";
    /**
     * trainer text constant.
     *
     * @since 0.0.0
     */
    private static final String TRAINER_CONSTANT = "trainer";
    
    /**
     * Boolean indicating, if steps back are allowed.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private boolean allowedStepBack;
    /**
     * Boolean indicating, if free mode is activated.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private boolean freeMode;
    /**
     * Boolean indicating, if trainer is activated.
     *
     * @since 0.0.0
     */
    @Getter
    @Setter
    private boolean trainer;

    /**
     * @param otherJsonObjectIn json object
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public OtherComposition(final JsonObject otherJsonObjectIn) {
        this.fromJsonObject(otherJsonObjectIn);
    }

    /**
     * Constructor.
     * Sets default values.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public OtherComposition() {
        this.setDefaultValues();
    }

        /**
     * @param allowedStepBackIn allowed step back
     * @param freeModeIn free mode
     * @param trainerIn trainer
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public OtherComposition(
            final boolean allowedStepBackIn,
            final boolean freeModeIn,
            final boolean trainerIn) {
        this(null, allowedStepBackIn, freeModeIn, trainerIn);

    }
    
    /**
     * @param id
     * @param allowedStepBackIn allowed step back
     * @param freeModeIn free mode
     * @param trainerIn trainer
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public OtherComposition(
            final String id,
            final boolean allowedStepBackIn,
            final boolean freeModeIn,
            final boolean trainerIn) {

        this.id = id;
        this.allowedStepBack = allowedStepBackIn;
        this.freeMode = freeModeIn;
        this.trainer = trainerIn;

    }

    @Override
    public final boolean validate() {
        //every combination is valid
        return true;
    }

    @Override
    public final boolean setDefaultValues() {
        this.allowedStepBack = false;
        this.freeMode = false;
        this.trainer = false;
        return true;
    }
    /**
     * @implNote This setRandomValues() implementation calls setDefaultValues.
     */
    @Override
    public final boolean setRandomValues() {
        //random values cannot cause activation
        //of some booleans of other composition.
        setDefaultValues();

        return true;
    }

    @Override
    public final OtherComposition createCopy() {
        OtherComposition copy = new OtherComposition();
        copy.id = this.id;
        copy.allowedStepBack = this.allowedStepBack;
        copy.freeMode = this.freeMode;
        copy.trainer = this.trainer;
        return copy;
    }

    @Override
    public final JsonObject toJsonObject() {
        JsonObject otherCompositionJsonObject = getInitialJsonObject();
        otherCompositionJsonObject.addBoolean(
                ALLOWED_STEP_BACK, this.allowedStepBack);
        otherCompositionJsonObject.addBoolean(FREE_MODE, this.freeMode);
        otherCompositionJsonObject.addBoolean(TRAINER_CONSTANT, this.trainer);
        return otherCompositionJsonObject;
    }
    @Override
    public final void fromJsonObject(final JsonObject otherJsonObject) {
//        this.id = otherJsonObject.getString(ID);
        this.allowedStepBack = otherJsonObject.getBoolean(ALLOWED_STEP_BACK);
        this.freeMode = otherJsonObject.getBoolean(FREE_MODE);
        this.trainer = otherJsonObject.getBoolean(TRAINER_CONSTANT);
    }

    @Override
    public final OtherComposition returnThis() {
        return this;
    }


    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "One of children is not valid. todo";
    }
}
