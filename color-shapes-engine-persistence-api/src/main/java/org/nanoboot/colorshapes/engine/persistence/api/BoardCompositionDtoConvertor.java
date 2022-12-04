
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

import java.util.UUID;
import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import org.nanoboot.colorshapes.engine.composition.board.BoardComposition;
import org.nanoboot.colorshapes.engine.composition.board.shape.BoardShape;
import org.nanoboot.colorshapes.engine.composition.board.shape.Shape;
import org.nanoboot.colorshapes.engine.entity.core.BoardCompositionDto;
import org.nanoboot.colorshapes.engine.entity.core.ShapeDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BoardCompositionDtoConvertor implements DtoConvertor<BoardComposition, BoardCompositionDto> {
private ShapeRepository shapeRepository;
private ShapeDtoConvertor shapeDtoConvertor;

    @Override
    public BoardCompositionDto convertToDto(BoardComposition t) {
        return new BoardCompositionDto(
                t.getIdAsUUID(),
                t.getGridProbability().getValue(),
                t.getGridCount().getValue(),
                t.getWallProbability().getValue(),
                t.getWallCount().getValue(),
                AbstractComposition.convertStringToUUID(t.getBoardShape().getId()));
    }

    @Override
    public BoardComposition convertFromDto(BoardCompositionDto t) {
        UUID shapeId = t.getShapeId();
        ShapeDto shapeDto = shapeRepository.read(shapeId);
        Shape shape = shapeDtoConvertor.convertFromDto(shapeDto);
        return new BoardComposition(
                t.getIdAsString(), 
                (BoardShape) shape,
                t.getGridProbability(),
                t.getGridCount(),
                t.getWallProbability(),
                t.getWallCount()) {
        };
    }

}
