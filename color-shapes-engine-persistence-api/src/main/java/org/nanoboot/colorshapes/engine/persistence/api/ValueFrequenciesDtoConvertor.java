
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

import org.nanoboot.colorshapes.engine.composition.factory.values.ValueFrequencies;
import org.nanoboot.colorshapes.engine.dto.ValueFrequenciesDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ValueFrequenciesDtoConvertor implements DtoConvertor<ValueFrequencies, ValueFrequenciesDto> {

    @Override
    public ValueFrequenciesDto convertToDto(ValueFrequencies t) {
        return new ValueFrequenciesDto(
                t.getIdAsUUID(), 
                t.getValueMinus2Frequency().getValue(),
                t.getValueMinus1Frequency().getValue(),
                t.getValue0Frequency().getValue(),
                t.getValuePlus1Frequency().getValue(),
                t.getValuePlus2Frequency().getValue()
                );
    }

    @Override
    public ValueFrequencies convertFromDto(ValueFrequenciesDto t) {
        return new ValueFrequencies(
                t.getIdAsString(), 
                t.getMinus1Frequency(),
                t.getMinus1Frequency(),
                t.getZeroFrequency(),
                t.getPlus1Frequency(),
                t.getPlus2Frequency()
                );
    }

}
