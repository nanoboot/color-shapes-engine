
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

package org.nanoboot.colorshapes.engine.services.api;

import org.nanoboot.colorshapes.engine.entity.core.PlayerDto;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public interface AuthenticationService {

    boolean authenticateUser(String nick, String password);

    void updatePassword(PlayerDto playerDto, String currentPassword, String newPassword);

    void setupPassword(PlayerDto playerDto, String password);

    //    /**
//     * Returns the current session.
//     *
//     * @return session or null in case, there is no session
//     */
//    Session getCurrentSession();
//
//    /**
//     * Logs a player in.
//     *
//     * @param nick     nick of the player
//     * @param password password of the player
//     * @return the session
//     * Note: Player to log automatically should not need enter their password.
//     */
//    Session startSession(String nick, String password, boolean logInEveryTime);
//
//    /**
//     * Logs the current player out.
//     *
//     * @return the player to be logged out
//     */
//    Session endSession();

    /**
     * Log out current player. No player will be automatically logged in.
     */
    //public void logOut();
    //this.playerSessionService.endSession();
}
