
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
import org.nanoboot.colorshapes.engine.composition.GameComposition;
import org.nanoboot.colorshapes.engine.base.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.dto.GameCompositionDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class GameCompositionDtoConvertor implements DtoConvertor<GameComposition, GameCompositionDto> {
private BoardCompositionRepository boardCompositionRepository;
private BallFactoryCompositionRepository ballFactoryCompositionRepository;
private BallThrowerCompositionRepository ballThrowerCompositionRepository;
private ShapeFinderCompositionRepository shapeFinderCompositionRepository;
private OtherCompositionRepository otherCompositionRepository;
//
private BoardCompositionDtoConvertor boardCompositionDtoConvertor;
private BallFactoryCompositionDtoConvertor ballFactoryCompositionDtoConvertor;
private BallThrowerCompositionDtoConvertor ballThrowerCompositionDtoConvertor;
private ShapeFinderCompositionDtoConvertor shapeFinderCompositionDtoConvertor;
private OtherCompositionDtoConvertor otherCompositionDtoConvertor;

    @Override
    public GameCompositionDto convertToDto(GameComposition t) {
        if(t.getBoardComposition().getId() == null) {
            throw new ColorShapesEngineException("Cannot convert, because id of board composition is null.");
        }
        if(t.getBallFactoryComposition().getId() == null) {
            throw new ColorShapesEngineException("Cannot convert, because id of ball factory composition is null.");
        }
        if(t.getBallThrowerComposition().getId() == null) {
            throw new ColorShapesEngineException("Cannot convert, because id of ball thrower composition is null.");
        }
        if(t.getShapeFinderComposition().getId() == null) {
            throw new ColorShapesEngineException("Cannot convert, because id of shape finder composition is null.");
        }
        if(t.getOtherComposition().getId() == null) {
            throw new ColorShapesEngineException("Cannot convert, because id of other composition is null.");
        }
        return new GameCompositionDto(
                t.getIdAsUUID(),
                AbstractComposition.convertStringToUUID(t.getBoardComposition().getId()),
                AbstractComposition.convertStringToUUID(t.getBallFactoryComposition().getId()),
                AbstractComposition.convertStringToUUID(t.getBallThrowerComposition().getId()),
                AbstractComposition.convertStringToUUID(t.getShapeFinderComposition().getId()),
                AbstractComposition.convertStringToUUID(t.getOtherComposition().getId())
                        );
    }

    @Override
    public GameComposition convertFromDto(GameCompositionDto t) {
        return new GameComposition(
                t.getId() == null ? null : t.getId().toString(), 
                boardCompositionDtoConvertor.convertFromDto(boardCompositionRepository.read(t.getBoardCompositionId())),
                ballFactoryCompositionDtoConvertor.convertFromDto(ballFactoryCompositionRepository.read(t.getBallFactoryCompositionId())),
                ballThrowerCompositionDtoConvertor.convertFromDto(ballThrowerCompositionRepository.read(t.getBallThrowerCompositionId())),
                shapeFinderCompositionDtoConvertor.convertFromDto(shapeFinderCompositionRepository.read(t.getShapeFinderCompositionId())),
                otherCompositionDtoConvertor.convertFromDto(otherCompositionRepository.read(t.getOtherCompositionId()))      
        );
    }

}
