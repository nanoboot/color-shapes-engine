
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

package org.nanoboot.colorshapes.engine.persistence.api;

import java.util.UUID;
import org.nanoboot.colorshapes.engine.dto.ValueFrequenciesDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public interface ValueFrequenciesRepository extends Crudl<ValueFrequenciesDto> {

    @Override
    default void update(ValueFrequenciesDto t) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(UUID id) {
        throw new UnsupportedOperationException();
    }
 
}
