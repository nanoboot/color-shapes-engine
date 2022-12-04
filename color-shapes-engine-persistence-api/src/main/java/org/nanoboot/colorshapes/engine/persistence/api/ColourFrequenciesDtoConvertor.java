
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

package org.nanoboot.colorshapes.engine.persistence.api;

import org.nanoboot.colorshapes.engine.composition.factory.colors.ColourFrequencies;
import org.nanoboot.colorshapes.engine.entity.core.ColourFrequenciesDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ColourFrequenciesDtoConvertor implements DtoConvertor<ColourFrequencies, ColourFrequenciesDto> {

    @Override
    public ColourFrequenciesDto convertToDto(ColourFrequencies t) {
        return new ColourFrequenciesDto(
                t.getId(), 
                t.getColour1Frequency().getValue(),
                t.getColour2Frequency().getValue(),
                t.getColour3Frequency().getValue(),
                t.getColour4Frequency().getValue(),
                t.getColour5Frequency().getValue(),
                t.getColour6Frequency().getValue(),
                t.getColour7Frequency().getValue(),
                t.getColour8Frequency().getValue(),
                t.getColour9Frequency().getValue(),
                t.getColour10Frequency().getValue(),
                t.getColour11Frequency().getValue(),
                t.getColour12Frequency().getValue(),
                t.getColour13Frequency().getValue(),
                t.getColour14Frequency().getValue(),
                t.getColour15Frequency().getValue(),
                t.getColour16Frequency().getValue()
                );
    }

    @Override
    public ColourFrequencies convertFromDto(ColourFrequenciesDto t) {
        return new ColourFrequencies(
                t.getId(), 
                t.getColour1Frequency(),
                t.getColour2Frequency(),
                t.getColour3Frequency(),
                t.getColour4Frequency(),
                t.getColour5Frequency(),
                t.getColour6Frequency(),
                t.getColour7Frequency(),
                t.getColour8Frequency(),
                t.getColour9Frequency(),
                t.getColour10Frequency(),
                t.getColour11Frequency(),
                t.getColour12Frequency(),
                t.getColour13Frequency(),
                t.getColour14Frequency(),
                t.getColour15Frequency(),
                t.getColour16Frequency()
                );
    }

}
