
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

package org.nanoboot.colorshapes.engine.game.parts;

import org.nanoboot.colorshapes.engine.game.BallType;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class ColoredBall extends Ball {
    /**
     * @param colourIn    colour of the ball
     * @param valueIn     value of the ball
     * @param movableIn   moveable of the ball
     * @param breakableIn breakable of the ball
     */
    public ColoredBall(int colourIn, int valueIn, boolean movableIn, boolean breakableIn) {
        super(BallType.COLORED, colourIn, valueIn, movableIn, breakableIn);
    }
}
