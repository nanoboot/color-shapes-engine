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
import org.nanoboot.colorshapes.engine.game.utils.CellFinder;
import org.nanoboot.colorshapes.engine.game.core.GameNode;
import org.nanoboot.colorshapes.engine.flow.event.impl.add.AddAutomaticBombEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.add.AddBallEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.add.AddManualBombEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.inflate.InflateBallEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.lock.LockCellEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.lock.UnlockCellEvent;
import lombok.Getter;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.game.utils.Direction;
import org.nanoboot.powerframework.json.JsonObject;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Cell extends GameNode {

    /**
     * board.
     */
    @Getter
    private final Board board;
    /**
     * row.
     */
    @Getter
    private final int row;
    /**
     * board.
     */
    @Getter
    private final int column;
    /**
     * locked.
     */
    @Getter
    private boolean locked = false;
    /**
     * walls.
     */
    @Getter
    private final Walls walls;
    /**
     * ball
     */
    @Getter
    private Ball ball;

    /**
     *
     * @param boardIn board
     * @param rowIn row
     * @param columnIn column
     */
    public Cell(final Board boardIn, final int rowIn, final int columnIn) {
        super(boardIn.getConsumer());
        this.board = boardIn;
        this.row = rowIn;
        this.column = columnIn;
        this.ball = null;
        this.walls = new Walls(this);
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return this.ball == null;
    }

    /**
     * @return
     */
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public boolean isFull() {
        return isNotEmpty();
    }

    /**
     * Lock the cell.
     */
    public void lock() {
        setLocked(true);
    }

    /**
     * Unlock the cell.
     */
    public void unlock() {
        setLocked(false);
    }

    /**
     * Lock the cell.
     *
     * @param value true or false
     */
    private void setLocked(final boolean value) {
        this.locked = value;
        this.produceEvent(value
                ? new LockCellEvent(getRow(), getColumn())
                : new UnlockCellEvent(getRow(), getColumn())
        );
    }

    /**
     * @return
     */
    public boolean hasAWall() {
        return this.walls.hasAWall();
    }

    /**
     * @param insertedBall
     */
    public void insertBall(Ball insertedBall) {
        if (this.isLocked()) {
            throw new UnsupportedOperationException("No ball can be inserted. The cell is locked.");
        }
        if (!this.isEmpty()) {
            throw new IllegalArgumentException("No ball can be inserted. The cell " + this.toString() + "is not empty.");
        }
        if (insertedBall == null) {
            throw new NullPointerException("Inserted ball is null and can't be inserted.");
        }
        this.ball = insertedBall;

        if (ball.getBallType().isColored() || ball.getBallType().isJoker()) {
            produceEvent(new AddBallEvent(getRow(), getColumn(), ball.getColour(), ball.getValue(), ball.isMovable(), ball.isBreakable()));
            produceEvent(new InflateBallEvent(getRow(), getColumn()));
        } else if (ball.getBallType().isAutomaticBomb()) {
            produceEvent(new AddAutomaticBombEvent(getRow(), getColumn()));
        } else if (ball.getBallType().isManualBomb()) {
            produceEvent(new AddManualBombEvent(getRow(), getColumn()));
        } else {
            throw new ColorShapesEngineException("Rollable is not ball and is not bomb. This is an illegal state.");
        }
    }

    /**
     * @return
     */
    public Ball removeBall() {
        if (this.isLocked()) {
            throw new ColorShapesEngineException("Cell is locked by the bars. No ball can be removed.");
        }
        if (this.getBall().isUnmovable()) {
            throw new ColorShapesEngineException("Cell is unmoveable ball. No ball can be removed.");
        }
        if (isEmpty()) {
            throw new ColorShapesEngineException("There is no ball to remove.");
        }
        Ball temporaryBall = this.ball;
        this.ball = null;
        return temporaryBall;
    }

    /**
     * @param direction
     * @return cell
     */
    public Cell getCellAtDirection(Direction direction) {//NOSONAR
        return CellFinder.findCellAtDirection(this, direction);
    }

    /**
     * Converts cell to json object
     *
     * @return
     */
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addInt("row", row);
        jsonObject.addInt("column", column);
        jsonObject.addBoolean("lockedByGrid", locked);
        jsonObject.addString("walls", "unknown");
        if (ball == null) {
            jsonObject.addNull("ball");
        } else {
            jsonObject.addObject("ball", ball.toJsonObject());
        }

        return jsonObject;
    }

    /**
     *
     * @return true, if this cell has a ball, which can jump, otherwise false
     */
    public boolean hasABallAbleToJump() {
        boolean empty = isEmpty();
        boolean isLocked = isLocked();
        boolean unmovable = getBall().isUnmovable();
        BallType ballType = getBall().getBallType();
        boolean automaticBomb = ballType.isAutomaticBomb();
        boolean paintBomb = ballType.isPaintBomb();
        boolean unableToJump = empty
                || isLocked
                || unmovable
                || automaticBomb
                || paintBomb;
        boolean ableToJump = !unableToJump;
        return ableToJump;
    }

    @Override
    public String toString() {
        return "{row: " + row + ", column: " + column + "}";
    }

}
