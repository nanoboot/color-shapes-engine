
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

package org.nanoboot.colorshapes.engine.parts.core;

import org.nanoboot.colorshapes.engine.base.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.flow.event.impl.wall.*;
import lombok.AccessLevel;
import lombok.Getter;
import org.nanoboot.colorshapes.engine.parts.base.GameNode;
import org.nanoboot.colorshapes.engine.parts.utils.Direction;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Walls extends GameNode {

    @Getter
    private boolean top = false;
    @Getter
    private boolean right = false;
    @Getter
    private boolean bottom = false;
    @Getter
    private boolean left = false;

    @Getter(AccessLevel.PRIVATE)
    private final Cell cell;

    public Walls(Cell cell) {
        super(cell.getConsumer());
        this.cell = cell;
    }

    /**
     * @param direction
     * @return
     */
    public boolean isWallAtDirection(Direction direction) {
        switch (direction) {
            case TOP:
                return top;
            case RIGHT:
                return right;
            case BOTTOM:
                return bottom;
            case LEFT:
                return left;
            default:
                throw new ColorShapesEngineException("Fatal error");
        }
    }

    public void setTopWallOn() {
        this.top = true;
        this.produceEvent(new SetTopWallOnEvent(getCell().getRow(), getCell().getColumn()));
    }

    public void setRightWallOn() {
        this.right = true;
        this.produceEvent(new SetRightWallOnEvent(getCell().getRow(), getCell().getColumn()));
    }

    public void setBottomWallOn() {
        this.bottom = true;
        this.produceEvent(new SetBottomWallOnEvent(getCell().getRow(), getCell().getColumn()));
    }

    public void setLeftWallOn() {
        this.left = true;
        this.produceEvent(new SetLeftWallOnEvent(getCell().getRow(), getCell().getColumn()));
    }

    /**
     * Destroys all walls.
     */
    public void destroyAll() {
        top = false;
        right = false;
        bottom = false;
        left = false;
        this.produceEvent(new SetAllWallsOffEvent(getCell().getRow(), getCell().getColumn()));
    }

    /**
     * @return
     */
    public boolean hasAWall() {
        return top || right || bottom || left;
    }

    /**
     * @return
     */
    public boolean hasAllWalls() {
        return top && right && bottom && left;
    }

    @Override
    public final String toString() {
        return top + " " + right + " " + bottom + " " + left;
    }

}
