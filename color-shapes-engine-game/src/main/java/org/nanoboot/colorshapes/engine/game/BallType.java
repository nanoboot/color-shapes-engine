
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

package org.nanoboot.colorshapes.engine.game;

import lombok.Getter;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum BallType {
    COLORED(1), JOKER(2), AUTOMATIC_BOMB(3), MANUAL_BOMB(4), PAINT_BOMB(5);
    @Getter
    private final int number;

    BallType(int number) {
        this.number = number;
    }

    public boolean isColored() {
        return this == COLORED;
    }

    public boolean isJoker() {
        return this == JOKER;
    }

    public boolean isAutomaticBomb() {
        return this == AUTOMATIC_BOMB;
    }

    public boolean isManualBomb() {
        return this == MANUAL_BOMB;
    }

    public boolean isPaintBomb() {
        return this == PAINT_BOMB;
    }

    public boolean isNotABomb() {
        return !isABomb();
    }

    public boolean isABomb() {
        return isAutomaticBomb() || isManualBomb() || isPaintBomb();
    }
}
