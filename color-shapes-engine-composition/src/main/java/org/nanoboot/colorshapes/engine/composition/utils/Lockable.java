
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

package org.nanoboot.colorshapes.engine.composition.utils;

import org.nanoboot.colorshapes.engine.base.exceptions.ColorShapesEngineException;

import java.util.List;

/**
 * Interface for objects, which are able to be locked.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public interface Lockable {
    /**
     * Locks the object for any changes.
     */
    void lock();

    /**
     * Checked, if the object is locked for changes.
     * @return true, if this object is locked, otherwise false
     */
    boolean isLocked();

    /**
     * Returns list of children or null, if there is no child.
     * @return children, if they exist, otherwise null
     */
    List<Lockable> getLockableChildren();

    /**
     * Unlocks the object, if supported.
     * @throws ColorShapesEngineException if the unlock() is not implemented
     */
    default void unlock() {
        throw new ColorShapesEngineException("Not implemented.");
    }
}
