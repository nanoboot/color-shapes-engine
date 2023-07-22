
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

package org.nanoboot.colorshapes.engine.composition;


import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class AbstractComposition extends LockableObject {
    @Getter
    @Setter
    protected String id = null;         
 
    public static UUID convertStringToUUID(String str) {
        return str == null ? null : UUID.fromString(str);
    }
    
    public UUID getIdAsUUID() {
        return convertStringToUUID(id);
    }
    public void setIdFromUUID(UUID uuid) {
        id = uuid == null ? null : uuid.toString();
    }
}
