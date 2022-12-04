
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

package org.nanoboot.colorshapes.engine.game.tools;

import org.nanoboot.colorshapes.engine.entity.misc.BallColour;
import org.nanoboot.colorshapes.engine.entity.misc.BallValue;
import org.nanoboot.colorshapes.engine.composition.factory.BallFactoryComposition;
import org.nanoboot.colorshapes.engine.composition.factory.colors.ColourFrequencies;
import org.nanoboot.colorshapes.engine.composition.factory.values.ValueFrequencies;
import org.nanoboot.colorshapes.engine.core.misc.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.core.random.CSRandomGenerator;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;
import org.nanoboot.colorshapes.engine.game.BallType;
import org.nanoboot.colorshapes.engine.game.core.GameNode;
import org.nanoboot.colorshapes.engine.game.parts.AutomaticBomb;
import org.nanoboot.colorshapes.engine.game.parts.Ball;
import org.nanoboot.colorshapes.engine.game.parts.ColoredBall;
import org.nanoboot.colorshapes.engine.game.parts.JokerBall;
import org.nanoboot.colorshapes.engine.game.parts.ManualBomb;
import org.nanoboot.powerframework.random.choicegenerators.ChoiceEntry;
import org.nanoboot.powerframework.random.choicegenerators.ChoiceGenerator;
import org.nanoboot.powerframework.random.choicegenerators.ProbabilityGenerator;

import java.util.ArrayList;
import java.util.List;
//todo: replace frequency by power

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallFactory extends GameNode {
    private final ChoiceGenerator<BallType> ballTypeGenerator;
    private final ChoiceGenerator<BallColour> colourGenerator;
    private final ChoiceGenerator<BallValue> valueGenerator;
    private final ProbabilityGenerator movableGenerator;
    private final ProbabilityGenerator breakableGenerator;

    public BallFactory(final EventConsumer eventConsumer,
                       BallFactoryComposition ballFactoryComposition,
                       CSRandomGenerator random) {
        super(eventConsumer);

        ChoiceEntry<BallType> coloredBallType = new ChoiceEntry<>(BallType.COLORED, ballFactoryComposition.getColoredBallFrequency().getValue());
        ChoiceEntry<BallType> jokerBallType = new ChoiceEntry<>(BallType.JOKER, ballFactoryComposition.getJokerBallFrequency().getValue());
        ChoiceEntry<BallType> automaticBombType = new ChoiceEntry<>(BallType.AUTOMATIC_BOMB, ballFactoryComposition.getAutomaticBombFrequency().getValue());
        ChoiceEntry<BallType> manualBombType = new ChoiceEntry<>(BallType.MANUAL_BOMB, ballFactoryComposition.getManualBombFrequency().getValue());
        ChoiceEntry<BallType> paintBombType = new ChoiceEntry<>(BallType.PAINT_BOMB, ballFactoryComposition.getPaintBombFrequency().getValue());
        this.ballTypeGenerator = new ChoiceGenerator<>(random,
                coloredBallType,
                jokerBallType,
                automaticBombType,
                manualBombType,
                paintBombType);
        //
        ChoiceEntry<BallColour>[] ballColoursChoiceEntryArray = (ChoiceEntry<BallColour>[]) new Object[BallColour.MAX_VALUE];
        ColourFrequencies colorFrequency = ballFactoryComposition.getColourFrequencies();
        for (int ballColourNumber = BallColour.MIN_VALUE; ballColourNumber <= BallColour.MAX_VALUE; ballColourNumber++) {
            int frequency = colorFrequency.getFrequency(ballColourNumber);
            ChoiceEntry<BallColour> item = new ChoiceEntry<>(BallColour.ofNumber(ballColourNumber), frequency);
            ballColoursChoiceEntryArray[ballColourNumber - 1] = item;
        }

        this.colourGenerator = new ChoiceGenerator<>(random, ballColoursChoiceEntryArray);
        //
        ChoiceEntry<BallValue>[] ballValuesChoiceEntryArray = (ChoiceEntry<BallValue>[]) new Object[BallValue.values().length];
        ValueFrequencies valueFrequency = ballFactoryComposition.getValueFrequencies();
        int index = 0;
        for (int ballValue = BallValue.MIN_VALUE; ballValue <= BallValue.MAX_VALUE; ballValue++) {
            int frequency = valueFrequency.getFrequency(ballValue);
            ChoiceEntry<BallValue> item = new ChoiceEntry<>(BallValue.ofNumber(ballValue), frequency);
            ballValuesChoiceEntryArray[index] = item;
            index++;
        }
        this.valueGenerator = new ChoiceGenerator<>(random, ballValuesChoiceEntryArray);
        //
        this.movableGenerator = new ProbabilityGenerator(random, ballFactoryComposition.getMovableBallProbability().getValue());
        this.breakableGenerator = new ProbabilityGenerator(random, ballFactoryComposition.getBreakableBallProbability().getValue());
    }

    private List<Ball> getNextBall(int count) {
        List<Ball> balls = new ArrayList<>();
        for(int i = 0; i< count;i++){
            balls.add(getNextBall());
        }
        return balls;
    }
    /**
     * @return
     */
    public Ball getNextBall() {
        BallType ballType = getNextBallType();
        switch (ballType) {
            case COLORED:
                return new ColoredBall(getNextColour(), getNextValue(), getNextMoveable(), getNextBreakable());
            case JOKER:
                return new JokerBall(getNextValue(), getNextMoveable(), getNextBreakable());
            case AUTOMATIC_BOMB:
                return new AutomaticBomb();
            case MANUAL_BOMB:
                return new ManualBomb();
            default:
                throw new ColorShapesEngineException("Unknown ball type: " + ballType);
        }
    }

    private BallType getNextBallType() {
        return ballTypeGenerator.generate().getObject();
    }

    private int getNextColour() {
        return colourGenerator.generate().getObject().getNumber();
    }

    private int getNextValue() {
        return valueGenerator.generate().getObject().getNumber();
    }

    private boolean getNextMoveable() {
        return movableGenerator.generate();
    }

    private boolean getNextBreakable() {
        return breakableGenerator.generate();
    }
}
