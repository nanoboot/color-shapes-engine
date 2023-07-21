
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

package org.nanoboot.colorshapes.engine.game.parts;

import org.nanoboot.colorshapes.engine.game.BallType;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.nanoboot.powerframework.json.JsonObject;

import java.util.UUID;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class Ball{
    /**
     * Id.
     */
    @Getter
    private final UUID id = UUID.randomUUID();
    /**
     * Ball type.
     */
    @Getter
    private final BallType ballType;

    /**
     * colour.
     */
    @Getter
    private final int colour;
    /**
     * value.
     */
    @Getter
    private final int value;

    /**
     * movable.
     */
    @Getter
    private final boolean movable;
    /**
     * breakable.
     */
    @Getter
    private final boolean breakable;
    @Getter
    @Setter
    private boolean exploded;

    /**
     *
     * @param ballTypeIn ballType of the ball
     * @param colourIn colour of the ball
     * @param valueIn value of the ball
     * @param movableIn moveable of the ball
     * @param breakableIn breakable of the ball
     */
    public Ball(
            final BallType ballTypeIn,
            final int colourIn,
            final int valueIn,
            final boolean movableIn,
            final boolean breakableIn) {

        if (!isColourValid(colourIn)) {
            throw new ColorShapesEngineException("Colour must be between 0 and 16.");
        }
        this.colour = colourIn;
        if (!isValueValid(valueIn)) {
            throw new ColorShapesEngineException("Value is out of range <-2;2>.");
        }
        this.value = valueIn;
        this.movable = movableIn;
        this.breakable = movableIn;
        if(ballTypeIn.isColored() && colour == 0) {
            throw new ColorShapesEngineException("Ball type is colored, but colour is 0.");
        }
        if(!ballTypeIn.isColored() && colour != 0) {
            throw new ColorShapesEngineException("Ball type is not colored, but colour is not 0.");
        }
        if(ballTypeIn.isABomb() && !movableIn) {
            throw new ColorShapesEngineException("Ball type is bomb, but movable is false.");
        }
        if(ballTypeIn.isABomb() && !breakableIn) {
            throw new ColorShapesEngineException("Ball type is bomb, but breakable is false.");
        }
        this.ballType = ballTypeIn;
    }

    private boolean isColourValid(int colour) {
        return (colour >= 0) && (colour <= 16);
    }

    private boolean isValueValid(int value) {
        return (value >= -2) && (value <= 2);
    }

    /**
     * @return
     */
    public boolean isColorful() {;
        return colour != 0;
    }
    /**
     * Executes the explosion.
     */
    public void executeExplosion() {
        if (exploded) {
            throw new ColorShapesEngineException("Bomb has already exploded");
        }
        this.exploded = true;
    }
    @Override
    public String toString() {
        return colour
                + " "
                + value
                + " "
                + (movable ? 1 : 0)
                + " "
                + (breakable ? 1 : 0);
    }

    /**
     * Converts ball to json object.
     *
     * @return
     */
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addString("colour", String.valueOf(colour));
        jsonObject.addInt("value", value);
        jsonObject.addBoolean("moveable", this.movable);
        jsonObject.addBoolean("breakable", this.breakable);
        return jsonObject;
    }

    public boolean isUnmovable() {
        return !movable;
    }

    public boolean isUnbreakable() {
        return !breakable;
    }
}
