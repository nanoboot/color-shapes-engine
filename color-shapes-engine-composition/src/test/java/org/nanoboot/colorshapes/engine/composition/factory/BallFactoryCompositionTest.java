
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
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallFactoryCompositionTest {
    @Test
    public void constructor_empty() {
        //prepare
        BallFactoryComposition ballFactoryComposition = new BallFactoryComposition();
        //execute
        //assert
        assertEquals(true, ballFactoryComposition.isDefault());
    }

    @Test
    public void constructor_jo() {
        //prepare
        BallFactoryComposition ballFactoryComposition = new BallFactoryComposition();
        BallFactoryComposition ballFactoryComposition2 = new BallFactoryComposition(ballFactoryComposition.toJsonObject());
        //execute
        //assert
        assertEquals(ballFactoryComposition.toJsonObject().toMinimalString(), ballFactoryComposition2.toJsonObject().toMinimalString());
    }

    @Test
    public void constructor_6args() {
        //prepare
        BallFactoryComposition ballFactoryComposition = new BallFactoryComposition(
                null, 100, 0, 0, 0, 0, 0, 0, new ColourFrequencies(), new ValueFrequencies());
        //execute
        //assert
        assertEquals(false, ballFactoryComposition.isDefault());
    }
    @Test
    public void getChildren() {
        //prepare
        BallFactoryComposition ballFactoryComposition = new BallFactoryComposition();
        //execute
        //assert
        assertEquals(9, ballFactoryComposition.getChildren().size());
    }
    @Test
    public void returnThis() {
        //prepare
        BallFactoryComposition ballFactoryComposition = new BallFactoryComposition();
        //execute
        //assert
        assertEquals(ballFactoryComposition, ballFactoryComposition.returnThis());
    }
    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        BallFactoryComposition ballFactoryComposition = new BallFactoryComposition();
        //execute
        //assert
        Assert.assertNotNull(ballFactoryComposition.describePossibleReasonsIfInvalid());
    }
}
