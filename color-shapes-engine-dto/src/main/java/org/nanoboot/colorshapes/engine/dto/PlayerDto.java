
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

package org.nanoboot.colorshapes.engine.dto;


import java.util.UUID;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import lombok.Data;
import org.nanoboot.powerframework.time.moment.LocalDate;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * Player.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@Data
public class PlayerDto extends AbstractEntity {
    /**
     * Default time zone id - Europe/Prague.
     */
    public static final String DEFAULT_TIME_ZONE_ID = "Europe/Prague";
    private UUID id;
    /**
     * Player nick.
     * The nick format has some rules.
     * If these rules are not followed,
     * an error code is returned after registration or nick change try.
     */
    private String nick;
    /**
     * Date and time, when this player was created.
     */
    private UniversalDateTime created;
    /**
     * Language code of the language, this user uses.
     */
    private String language;
    /**
     * Name of this player.
     */
    private String name;
    /**
     * Surame of this player.
     */
    private String surname;
    /**
     * Sex.
     */
    private String sex;
    /**
     * Date of birth of the player.
     */
    private LocalDate dateOfBirth;
    /**
     * Time zone id of the player.
     */
    private String timeZoneId;

    /**
     * Player properties used to store some settings.
     * Example: application look
     */
    private JsonObject properties;
}
