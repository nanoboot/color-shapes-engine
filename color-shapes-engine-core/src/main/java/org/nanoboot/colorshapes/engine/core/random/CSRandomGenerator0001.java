
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

import org.nanoboot.powerframework.time.moment.UniversalDateTime;

/**
 * 0001 random generator.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class CSRandomGenerator0001 extends AbstractCSRandomGenerator {

    /**
     * Code of this generator.
     */
    public static final String GENERATOR_CODE = "0001";

    /**
     * RandomNumberGenerator for Color Shapes application.
     *
     * @param magicNumber magic number
     * @param udt         date time
     */
    public CSRandomGenerator0001(
            final long magicNumber,
            final UniversalDateTime udt) {
        super(magicNumber, udt);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCode() {
        return GENERATOR_CODE;
    }
}
