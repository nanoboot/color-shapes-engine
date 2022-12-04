
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

import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import lombok.Data;

import java.util.UUID;

/**
 * Log of a game internal event.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@Data
public class LogDto {
    /**
     * Id.
     */
    private UUID id;
    /**
     * Id of game.
     */
    private UUID gameId;
    /**
     * Id of player.
     */
    private UUID playerId;
    /**
     * Date and time, when this log happened.
     */
    private UniversalDateTime dateTime;
    /**
     * Log type.
     */
    private LogType logType;
    /**
     * Note.
     */
    private String note;
    /**
     * Optional json object.
     */
    private JsonObject jsonObject;
}
