
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
import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import org.nanoboot.colorshapes.engine.composition.factory.BallFactoryComposition;
import org.nanoboot.colorshapes.engine.composition.factory.colors.ColourFrequencies;
import org.nanoboot.colorshapes.engine.composition.factory.values.ValueFrequencies;
import org.nanoboot.colorshapes.engine.dto.BallFactoryCompositionDto;
import org.nanoboot.colorshapes.engine.dto.ColourFrequenciesDto;
import org.nanoboot.colorshapes.engine.dto.ValueFrequenciesDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallFactoryCompositionDtoConvertor implements DtoConvertor<BallFactoryComposition, BallFactoryCompositionDto> {
private ColourFrequenciesRepository colourFrequenciesRepository;
private ValueFrequenciesRepository valueFrequenciesRepository;
private ColourFrequenciesDtoConvertor colourFrequenciesDtoConvertor;
private ValueFrequenciesDtoConvertor valueFrequenciesDtoConvertor;

    @Override
    public BallFactoryCompositionDto convertToDto(BallFactoryComposition t) {
        return new BallFactoryCompositionDto(
                t.getIdAsUUID(),
                t.getColoredBallFrequency().getValue(),
                t.getJokerBallFrequency().getValue(),
                t.getAutomaticBombFrequency().getValue(),
                t.getManualBombFrequency().getValue(),
                t.getPaintBombFrequency().getValue(),
                t.getMovableBallProbability().getValue(),
                t.getBreakableBallProbability().getValue(),
                AbstractComposition.convertStringToUUID(t.getColourFrequencies().getId()),
                AbstractComposition.convertStringToUUID(t.getValueFrequencies().getId())
                        );
    }

    @Override
    public BallFactoryComposition convertFromDto(BallFactoryCompositionDto t) {
        UUID colourFrequenciesId = t.getColourFrequenciesId();
        UUID valueFrequenciesId = t.getValueFrequenciesId();
        ColourFrequenciesDto colourFrequenciesDto = colourFrequenciesRepository.read(colourFrequenciesId);
        ValueFrequenciesDto valueFrequenciesDto = valueFrequenciesRepository.read(valueFrequenciesId);
        ColourFrequencies colourFrequencies = colourFrequenciesDtoConvertor.convertFromDto(colourFrequenciesDto);
        ValueFrequencies valueFrequencies = valueFrequenciesDtoConvertor.convertFromDto(valueFrequenciesDto);
        return new BallFactoryComposition(
                t.getIdAsString(), 
                t.getColoredBallFrequency(),
                t.getJokerBallFrequency(),
                t.getAutomaticBombFrequency(),
                t.getManualBombFrequency(),
                t.getPaintBombFrequency(),
                t.getMovableBallProbability(),
                t.getBreakableBallProbability(),
                colourFrequencies,
                valueFrequencies
                
        );
    }

}
