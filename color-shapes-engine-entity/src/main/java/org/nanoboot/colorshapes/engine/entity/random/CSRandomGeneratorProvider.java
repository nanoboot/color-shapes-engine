
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

package org.nanoboot.colorshapes.engine.entity.random;

import org.nanoboot.powerframework.random.generators.linearcongruent.combined.w5.W5RandomGenerator;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;

/**
 * Provider of random generator.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public final class CSRandomGeneratorProvider extends W5RandomGenerator {
    /**
     * Default code.
     */
    public static final String DEFAULT_CODE =
            CSRandomGenerator0001.GENERATOR_CODE;

    /**
     * Constructor.
     *
     * @param code        name of the generator to create
     * @param magicNumber magic number
     * @param udt         date time
     * @return generator implementation
     */
    public static CSRandomGenerator lookup(
            final String code,
            final long magicNumber,
            final UniversalDateTime udt) {
        switch (code) { //NOSONAR
            case CSRandomGenerator0001.GENERATOR_CODE:
                return new CSRandomGenerator0001(magicNumber, udt);
            default:
                return null;
        }
    }

    /**
     * Constructor.
     *
     * @param magicNumber magic number
     * @param udt         date time
     * @return generator implementation
     */
    public static CSRandomGenerator lookupDefault(
            final long magicNumber,
            final UniversalDateTime udt) {
        return lookup(DEFAULT_CODE, magicNumber, udt);
    }
    private CSRandomGeneratorProvider() {
        //Not meant to be instantiated.
    }
}
