
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

package org.nanoboot.colorshapes.engine.services.impl;

import org.nanoboot.colorshapes.engine.entity.core.PlayerDto;
import org.nanoboot.colorshapes.engine.persistence.api.PlayerRepository;
import org.nanoboot.colorshapes.engine.services.utils.RegistrationError;
import org.nanoboot.colorshapes.engine.services.api.AuthenticationService;
import org.nanoboot.colorshapes.engine.services.api.PlayerService;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;
    private AuthenticationService authenticationService;

    @Override
    public PlayerDto getPlayer(String id) {
        return null;
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) {
        return null;
    }

    /**
     * This method is used to create new player.
     *
     * @param nick     <ul><li>From 1 to 16 characters.</li><li>Only a-z, A-Z and
     *                 0-1 characters</li><li>This nick cannot be already used.</li></ul>
     * @param password <ul><li>From 0 to 16 characters.</li><li>Only a-z, A-Z
     *                 and 0-1 characters</li><li>For empty password use "".</li></ul>
     * @return null, if no error happened, otherwise RegistrationError instance.
     */
    @Override
    public RegistrationError addPlayer(String nick, String password, String confirmPassword) {
        if (this.existsNick(nick)) {
            return RegistrationError.NICK_ALREADY_EXISTS;
        }
        if (nick.length() > 16) {
            return RegistrationError.TOO_LONG_NICK;
        }
        if (nick.isEmpty()) {
            return RegistrationError.NICK_IS_EMPTY;
        }
        if (!password.equals(confirmPassword)) {
            return RegistrationError.PASSWORD_AND_CONFIRM_PASSWORD_DO_NOT_MATCH;
        }
        if (password.length() > 16) {
            return RegistrationError.TOO_LONG_PASSWORD;
        }
        String regexp = "[A-Za-z0-9]+";
        if (!(nick.matches(regexp) && (("".equals(password)) || (password.matches(regexp))))) {
            return RegistrationError.NICK_OR_PASSWORD_CONTAINS_FORBIDDEN_CHARACTERS;
        }
        //todo
        PlayerDto playerDto = new PlayerDto();
        playerRepository.create(playerDto);
        authenticationService.setupPassword(playerDto, password);

        return null;

    }

    /**
     * This method is used to check whether a nick exists.
     *
     * @param nick
     * @return If this nick exists, returns true, otherwise returns false.
     */
    @Override
    public boolean existsNick(String nick) {
        return playerRepository.findByNick(nick) != null;
    }
}
