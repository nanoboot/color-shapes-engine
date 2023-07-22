
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

package org.nanoboot.colorshapes.engine.services.impl;

import org.nanoboot.colorshapes.engine.dto.PlayerDto;
import org.nanoboot.colorshapes.engine.persistence.api.PlayerDetailRepository;
import org.nanoboot.colorshapes.engine.services.api.AuthenticationService;

/**
 * This class is used to manage access to the game.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    private PlayerDetailRepository playerDetailRepository;

    /**
     * This method is used to verify nick and password.
     *
     * @param nick
     * @param password
     * @return Returns true for right nick and password.
     */
    @Override
    public boolean authenticateUser(String nick, String password) {
        String hashedOrig = playerDetailRepository.findByNick(nick).getPasswordHash();
        String hashedToCheck = hashPassword(password);

        return hashedOrig.equals(hashedToCheck);
    }

    private String hashPassword(String password) {
        return "";//todo
    }
    @Override
    public void updatePassword(PlayerDto playerDto, String currentPassword, String newPassword) {
        //todo
    }

    @Override
    public void setupPassword(PlayerDto playerDto, String password) {

    }

//    /**
//     * This method is used to create new player.
//     *
//     * @param nick     <ul><li>From 1 to 16 characters.</li><li>Only a-z, A-Z and
//     *                 0-1 characters</li><li>This nick cannot be already used.</li></ul>
//     * @param password <ul><li>From 0 to 16 characters.</li><li>Only a-z, A-Z
//     *                 and 0-1 characters</li><li>For empty password use "".</li></ul>
//     * @return True for successful login. False for failed login.
//     */
//    public NewPlayerCreatingResult createNewPlayer(String nick, String password, String confirmPassword, String languageId, int skin, int zoom, String timeZoneId) {//NOSONAR
//        Player player = new Player();
//        player.setNick(nick);
//        player.setLanguage(languageId);
//        player.setSkin(skin);
//        player.setZoom(zoom);
//        player.setTimeZoneId(timeZoneId);
//        return playerService.addPlayer(player, password, confirmPassword);
//    }
//
//    public boolean logIn(String nick, String password, boolean keepingLogged) {
//        PlayerSession playerSession = this.playerSessionService.startSession(nick, password, keepingLogged);
//        return playerSession != null;
//    }

//    /**
//     * @param oldPassword
//     * @param newPassword
//     * @param confirmNewPassword
//     */
//    public void updatePassword(String oldPassword, String newPassword, String confirmNewPassword) {
//        getPlayer().updatePassword(oldPassword, newPassword, confirmNewPassword);
//
//    }
}
