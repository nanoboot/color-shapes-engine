
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

package org.nanoboot.colorshapes.engine.composition;

import org.nanoboot.colorshapes.engine.composition.utils.Lockable;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;

import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class LockableObject implements Lockable {
            
    /**
     * Locked for changes.
     */
    private boolean locked;

    /**
     * Locks the object for any changes.
     */
    @Override
    public void lock() {
        if (!isLocked()) {
            throw new ColorShapesEngineException("The object is already locked.");
        }
        this.locked = true;
        List<Lockable> children = getLockableChildren();
        if (children != null) {
            for (Lockable e : children) {
                e.lock();
            }
        }
    }

    /**
     * Checked, if the object is locked for changes.
     * @return true, if this object is locked, otherwise false
     */
    @Override
    public boolean isLocked() {
        return locked;
    }
}
