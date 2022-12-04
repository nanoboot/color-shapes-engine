
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

package org.nanoboot.colorshapes.engine.composition.factory;

import org.nanoboot.colorshapes.engine.composition.factory.colors.ColourFrequencies;
import org.nanoboot.colorshapes.engine.composition.factory.values.ValueFrequencies;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import org.nanoboot.colorshapes.engine.composition.AbstractComposition;

import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.powerframework.json.JsonObject;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallFactoryComposition extends AbstractComposition
        implements Composition<BallFactoryComposition> {
    /**
     * Standard Ball .
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private ColoredBallFrequency coloredBallFrequency = new ColoredBallFrequency();
    /**
     * jokerBallFrequency.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private JokerBallFrequency jokerBallFrequency =
            new JokerBallFrequency();
    /**
     * Automatic bomb frequency.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private AutomaticBombFrequency automaticBombFrequency =
            new AutomaticBombFrequency();
    /**
     * Manual bomb frequency.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private ManualBombFrequency manualBombFrequency =
            new ManualBombFrequency();
    /**
     * Paint bomb frequency.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private PaintBombFrequency paintBombFrequency =
            new PaintBombFrequency();

    /**
     * unmovableBallProbability.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private MovableBallProbability movableBallProbability =
            new MovableBallProbability();
    /**
     * unbreakableBallProbability.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private BreakableBallProbability breakableBallProbability =
            new BreakableBallProbability();

    /**
     * colorFrequencies.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private ColourFrequencies colourFrequencies = new ColourFrequencies();
    /**
     * valueFrequencies.
     *
     * @since 0.0.0
     */
    @Setter
    @Getter
    private ValueFrequencies valueFrequencies = new ValueFrequencies();

    /**
     * @param ballFactoryCompositionJsonObject
     * BallFactoryComposition as json object
     */
    public BallFactoryComposition(
            final JsonObject ballFactoryCompositionJsonObject) {
        fromJsonObject(ballFactoryCompositionJsonObject);
    }

    /**
     * Constructor.
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    public BallFactoryComposition() {
        this.setDefaultValues();
    }

    /**
     * Constructor.
     *
     * @param id
     * @param standardBallFrequencyIn      standardBallFrequencyIn
     * @param jokerBallFrequencyIn       jokerBallFrequencyIn
     * @param automaticBombFrequencyIn       automaticBombFrequencyIn
     * @param manualBombFrequencyIn       manualBombFrequency
     * @param paintBombFrequencyIn       paintBombFrequency
     * @param movableBallProbabilityIn   movableBallProbability
     * @param breakableBallProbabilityIn breakableBallProbability
     * @param colourFrequenciesIn          colorFrequencies
     * @param valueFrequenciesIn           valueFrequencies
     *
     * @author Robert Vokac
     * @since 0.0.0
     */
    @SuppressWarnings("checkstyle:ParameterNumber")
    public BallFactoryComposition(
            final String id, 
            final int standardBallFrequencyIn,
            final int jokerBallFrequencyIn,
            final int automaticBombFrequencyIn,
            final int manualBombFrequencyIn,
            final int paintBombFrequencyIn,
            final int movableBallProbabilityIn,
            final int breakableBallProbabilityIn,
            final ColourFrequencies colourFrequenciesIn,
            final ValueFrequencies valueFrequenciesIn) {
        this.id = id;
        this.setColoredBallFrequency(
                new ColoredBallFrequency(standardBallFrequencyIn));
        this.setJokerBallFrequency(
                new JokerBallFrequency(jokerBallFrequencyIn));
        this.setAutomaticBombFrequency(
                new AutomaticBombFrequency(automaticBombFrequencyIn));
        this.setManualBombFrequency(
                new ManualBombFrequency(manualBombFrequencyIn));
        this.setPaintBombFrequency(
                new PaintBombFrequency(paintBombFrequencyIn));
        this.setMovableBallProbability(
                new MovableBallProbability(movableBallProbabilityIn));
        this.setBreakableBallProbability(
                new BreakableBallProbability(breakableBallProbabilityIn));
        this.setColourFrequencies(colourFrequenciesIn);
        this.setValueFrequencies(valueFrequenciesIn);
    }

    @Override
    public final List<Composition> getChildren() {
        List<Composition> list = new ArrayList<>();
        list.add(this.coloredBallFrequency);
        list.add(this.jokerBallFrequency);
        list.add(this.coloredBallFrequency);
        list.add(this.manualBombFrequency);
        list.add(this.paintBombFrequency);
        list.add(this.movableBallProbability);
        list.add(this.breakableBallProbability);
        list.add(this.colourFrequencies);
        list.add(this.valueFrequencies);
        return list;
    }

    @Override
    public final BallFactoryComposition returnThis() {
        return this;
    }
    @Override
    public final String describePossibleReasonsIfInvalid() {
        return "One of children is not valid.";
    }
}
