
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

package org.nanoboot.colorshapes.engine.composition.factory;

import org.nanoboot.colorshapes.engine.composition.factory.ManualBombFrequency;
import org.nanoboot.colorshapes.engine.composition.utils.Frequency;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ManualBombFrequencyTest {
    @Test
    public void constructor_int() {
        //prepare
        ManualBombFrequency manualBombFrequency = new ManualBombFrequency(10);
        //execute
        //assert
        assertEquals(10, manualBombFrequency.getValue().intValue());
    }
    @Test
    public void constructor_empty() {
        //prepare
        ManualBombFrequency manualBombFrequency = new ManualBombFrequency();
        //execute
        //assert
        assertEquals(0, manualBombFrequency.getValue().intValue());
    }
    @Test
    public void constructor_jo() {
        //prepare
        ManualBombFrequency manualBombFrequency = new ManualBombFrequency();
        ManualBombFrequency manualBombFrequency2 = new ManualBombFrequency(manualBombFrequency.toJsonObject());
        //execute
        //assert
        assertEquals(manualBombFrequency.toJsonObject().toMinimalString(), manualBombFrequency2.toJsonObject().toMinimalString());
    }
    @Test
    public void returnThis() {
        //prepare
        ManualBombFrequency manualBombFrequency = new ManualBombFrequency(10);
        //execute
        //assert
        assertEquals(manualBombFrequency, manualBombFrequency.returnThis());
    }

    @Test
    public void setDefaultValues() {
        //prepare
        ManualBombFrequency manualBombFrequency = new ManualBombFrequency();
        manualBombFrequency.setDefaultValues();
        //execute
        //assert
        assertEquals(Frequency.MIN_VALUE, manualBombFrequency.getValue().intValue());
    }
}
