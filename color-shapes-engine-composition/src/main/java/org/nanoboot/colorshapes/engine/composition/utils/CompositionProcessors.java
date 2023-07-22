
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

package org.nanoboot.colorshapes.engine.composition.utils;

/**
 * Function, consumes a Composition, returns a Boolean.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
final class CompositionProcessors {
    /**
     * Constructor.
     */
    private CompositionProcessors() {
        //Instantiation not needed.
    }
    /**
     * A CompositionProcessor, which calls setDefaultValues() method.
     *
     * @since 0.0.0
     */

    static final CompositionProcessor DEFAULT_PROCESSOR =
            (composition -> {
        composition.setDefaultValues(); return true;
    });

    /**
     * A CompositionProcessor, which calls setRandomValues() method.
     *
     * @since 0.0.0
     */
    static final CompositionProcessor RANDOM_PROCESSOR =
            (composition -> {
        composition.setRandomValues(); return true;

    });

    /**
     * A CompositionProcessor, which calls validate() method.
     *
     * @since 0.0.0
     */
    static final CompositionProcessor VALIDATE_PROCESSOR =
            (Composition::validate);
}
