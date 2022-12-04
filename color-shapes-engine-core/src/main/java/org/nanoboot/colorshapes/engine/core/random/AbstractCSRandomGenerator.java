
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

package org.nanoboot.colorshapes.engine.core.random;

import lombok.Getter;
import org.nanoboot.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;

/**
 * Abstract random generator class.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class AbstractCSRandomGenerator
        extends W5RandomGenerator implements CSRandomGenerator {
    /**
     * Magic number.
     */
    @Getter
    private final long magicNumber;
    /**
     * Universal date time.
     */
    @Getter
    private final UniversalDateTime udt;
    /**
     * Constructor.
     * RandomNumberGenerator for Color Shapes application.
     *
     * @param magicNumberIn magic number
     * @param udtIn         date time
     */
    public AbstractCSRandomGenerator(
            final long magicNumberIn,
            final UniversalDateTime udtIn) {
        super(magicNumberIn,
                udtIn.getYear(),
                udtIn.getMonth(),
                udtIn.getDay(),
                udtIn.getHour(),
                udtIn.getMinute(),
                udtIn.getSecond(),
                udtIn.getMillisecond());
        this.magicNumber = magicNumberIn;
        this.udt = udtIn;
    }

}
