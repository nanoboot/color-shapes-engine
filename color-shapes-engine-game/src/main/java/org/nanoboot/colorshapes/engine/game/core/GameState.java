
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

package org.nanoboot.colorshapes.engine.game.core;

import lombok.Getter;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum GameState {
    /**
     * Game just started, no game action happened.
     */
    START(1, 2, 4),
    /**
     * Waiting for activation of full cell.
     */
    WAITING_FOR_FULL_CELL_ACTIVATION(2, 3, 4),
    /**
     * Waiting for activation of empty cell.
     */
    WAITING_FOR_EMPTY_CELL_ACTIVATION(3, 2, 4),
    /**
     * The game was ended. The board was full.
     */
    END(4);
    /**
     * Number of the game state.
     */
    @Getter
    private final int number;
    /**
     * numbers of the allowed game states for this state to migrate to.
     */
    @Getter
    private final int[] allowedChanges;

    /**
     * @param numberIn         number of the game state
     * @param allowedChangesIn numbers of the allowed game states for this state to migrate to
     */
    GameState(final int numberIn, final int... allowedChangesIn
    ) {
        this.number = numberIn;
        this.allowedChanges = allowedChangesIn;
    }

    public boolean isEnd() {
        return this == END;
    }

    /**
     * @return default game state
     */
    public static GameState getDefault() {
        return START;
    }

    /**
     * Checks, if the game state can be changed to another game state.
     *
     * @param gameState new game state
     * @return result of the check
     */
    public final boolean canBeChangedTo(final GameState gameState) {
        for (int n : allowedChanges) {
            if (gameState.getNumber() == n) {
                return true;
            }
        }
        return false;
    }
}
