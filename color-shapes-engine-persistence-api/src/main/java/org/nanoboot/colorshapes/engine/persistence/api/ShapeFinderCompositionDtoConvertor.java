
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
import org.nanoboot.colorshapes.engine.composition.board.shape.Shape;
import org.nanoboot.colorshapes.engine.composition.shapefinder.ExplodingShapeType;
import org.nanoboot.colorshapes.engine.composition.shapefinder.ShapeFinderComposition;
import org.nanoboot.colorshapes.engine.entity.core.ShapeDto;
import org.nanoboot.colorshapes.engine.entity.core.ShapeFinderCompositionDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ShapeFinderCompositionDtoConvertor implements DtoConvertor<ShapeFinderComposition, ShapeFinderCompositionDto> {

    private ShapeRepository shapeRepository;
    private ShapeDtoConvertor shapeDtoConvertor;

    @Override
    public ShapeFinderCompositionDto convertToDto(ShapeFinderComposition t) {
        return new ShapeFinderCompositionDto(
                t.getIdAsUUID(),
                t.getExplodingShapeType().name(),
                t.getMinimumSize().getValue(),
                t.getCustomExplodingShape() == null ? null : t.getCustomExplodingShape().getIdAsUUID()
        );
    }

    @Override
    public ShapeFinderComposition convertFromDto(ShapeFinderCompositionDto t) {
        UUID shapeId = t.getCustomExplodingShapeId();
        ShapeDto shapeDto = shapeId == null ? null : shapeRepository.read(shapeId);
        Shape customExplodingShape = shapeDto == null ? null : shapeDtoConvertor.convertFromDto(shapeDto);
        return new ShapeFinderComposition(
                t.getIdAsString(),
                ExplodingShapeType.valueOf(t.getExplodingShapeType()),
                t.getMinimumSize(),
                customExplodingShape
        );
    }

}
