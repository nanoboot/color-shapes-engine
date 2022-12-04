
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

package org.nanoboot.colorshapes.engine.entity.core;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@AllArgsConstructor
public class BallFactoryCompositionDto extends AbstractEntity{
    /**
     * Id.
     */
    @Getter @Setter
    protected UUID id;
    @Setter
    @Getter
    private Integer coloredBallFrequency;
    @Setter
    @Getter
    private Integer jokerBallFrequency;
    @Setter
    @Getter
    private Integer automaticBombFrequency;
    @Setter
    @Getter
    private Integer manualBombFrequency;
    @Setter
    @Getter
    private Integer paintBombFrequency;
    @Setter
    @Getter
    private Integer movableBallProbability;
    @Setter
    @Getter
    private Integer breakableBallProbability;
    @Setter
    @Getter
    private UUID colourFrequenciesId;
    @Setter
    @Getter
    private UUID valueFrequenciesId;
    
}
