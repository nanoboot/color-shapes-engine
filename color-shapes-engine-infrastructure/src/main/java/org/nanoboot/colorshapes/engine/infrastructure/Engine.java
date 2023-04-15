
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

package org.nanoboot.colorshapes.engine.infrastructure;

import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.entity.core.PlayerDto;
import org.nanoboot.colorshapes.engine.services.utils.RegistrationError;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Engine {
    private UUID engineSessionId;
    @Getter
    private EngineStatus status = EngineStatus.getDefault();

    /**
     * Turns the engine on.
     *
     * @throws ColorShapesEngineException if the engine is already running.
     */
    public void start() {
        if (status.isStarted()) {
            throw new ColorShapesEngineException("Engine is already running.");
        }
        this.status = EngineStatus.STARTED;
    }

    /**
     * Turns the engine off.
     *
     * @throws ColorShapesEngineException if the engine is not running.
     */
    public void stop() {
        if (!status.isStarted()) {
            throw new ColorShapesEngineException("Engine is not running.");
        }
        this.status = EngineStatus.STOPPED;
    }

    /**
     * Creates new user, if is allowed for anonymous users.
     *
     * @param playerDto player instance to be created
     * @return the result of this action
     */
    public RegistrationError newPlayer(PlayerDto playerDto, String password, String confirmPassword) {
        return null;
    }

    /**
     * Creates new session.
     * Only one session can be created for one player at one time.
     * <p>
     * If there is already a session for the player, the old session is hibernated.
     *
     * @param nick     nick of the player
     * @param password password of the player
     * @return the uuid of the session
     */
    public String connect(String nick, String password) {
        return "abc";
    }

    public Connection getConnection(String connectionId) {
        return new ConnectionImpl();
    }

    public List<Connection> getConnections() {
        return null;//todo
    }


//    /**
//     * Starts logic layer.
//     */
//    public void start() {
//        running = true;
//        logic.getLogger().logApplicationStart();
//
//        if (!this.isThereAnAutomaticallyLoggedInPlayer()) {
//            logic.addChange("MODE LOGIN");
//        } else {
//
//            Player player = playerService.getPlayer(playerSessionService.getForeverPlayer().getId().toString());
//            String nick = player.getNick();
//            String password = "";//todo
//
//            playerSessionService.startSession(nick, password, true);
//        }
//    }
//
//    /**
//     * Stops the logic layer.
//     */
//    public void exit() {
//        running = false;
//        if (playerSessionService.getCurrentSession() != null) {
//            playerSessionService.endSession();
//        }
//        logic.getLogger().logApplicationEnd();
//        //logic.addChange("EXIT");
//        exitApp();
//    }
//
//    private void exitApp() {
//        //Platform.exit();
//    }
//
//    public boolean isThereAnAutomaticallyLoggedInPlayer() {
//        return playerSessionService.getForeverPlayer() != null;
//    }
//

}
