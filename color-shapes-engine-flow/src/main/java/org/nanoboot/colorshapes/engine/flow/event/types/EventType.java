
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

package org.nanoboot.colorshapes.engine.flow.event.types;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public enum EventType {
    /**
     * nothing to do.
     */
    NOTHING_TO_DO(EventGroup.MISC, EventDirection.OUTPUT, "nothingToDo"),
    /**
     * Lock cell.
     */
    LOCK_CELL(EventGroup.LOCK, EventDirection.OUTPUT, "lockCell", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    /**
     * Unlock cell.
     */
    UNLOCK_CELL(EventGroup.LOCK, EventDirection.OUTPUT, "unlockCell", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),

    /**
     * startJumping.
     */
    START_JUMPING(EventGroup.BALL_JUMPING, EventDirection.OUTPUT, "startJumping", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    /**
     * stopJumping.
     */
    STOP_JUMPING(EventGroup.BALL_JUMPING, EventDirection.OUTPUT, "stopJumping", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),

    /**
     * setTopWallOn.
     */
    SET_TOP_WALL_ON(EventGroup.WALL, EventDirection.OUTPUT, "setTopWallOn", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    /**
     * setRightWallOn.
     */
    SET_RIGHT_WALL_ON(EventGroup.WALL, EventDirection.OUTPUT, "setRightWallOn", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    /**
     * setBottomWallOn.
     */
    SET_BOTTOM_WALL_ON(EventGroup.WALL, EventDirection.OUTPUT, "setBottomWallOn", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    /**
     * setLeftWallOn.
     */
    SET_LEFT_WALL_ON(EventGroup.WALL, EventDirection.OUTPUT, "setLeftWallOn", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
//    //
//    /**
//     * setTopWallOff.
//     */
//    SET_TOP_WALL_OFF(EventGroup.WALL, EventDirection.OUT, "setTopWallOff", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
//    /**
//     * setRightWallOff.
//     */
//    SET_RIGHT_WALL_OFF(EventGroup.WALL, EventDirection.OUT, "setRightWallOff", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
//    /**
//     * setBottomWallOff.
//     */
//    SET_BOTTOM_WALL_OFF(EventGroup.WALL, EventDirection.OUT, "setBottomWallOff", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
//    /**
//     * setLeftWallOff.
//     */
//    SET_LEFT_WALL_OFF(EventGroup.WALL, EventDirection.OUT, "setLeftWallOff", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    //
    /**
     * setAllWallsOff.
     */
    SET_ALL_WALLS_OFF(EventGroup.WALL, EventDirection.OUTPUT, "setAllWallsOff", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    //
    MOVE(EventGroup.MOVE, EventDirection.OUTPUT, "move", new EventArgument[]{
            new EventArgument(EventArgumentType.NUMBER, "row"),
            new EventArgument(EventArgumentType.NUMBER, "column"),
            new EventArgument(EventArgumentType.NUMBER_ARRAY, "numbers")
    }),
    INFLATE_BALL(EventGroup.INFLATE, EventDirection.OUTPUT, "inflateBall", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    ADD_BALL(EventGroup.ADD, EventDirection.OUTPUT, "addBall", new EventArgument[]{
            new EventArgument(EventArgumentType.NUMBER, "row"),
            new EventArgument(EventArgumentType.NUMBER, "column"),
            new EventArgument(EventArgumentType.NUMBER, "colour"),
            new EventArgument(EventArgumentType.NUMBER, "value"),
            new EventArgument(EventArgumentType.BOOLEAN, "movable"),
            new EventArgument(EventArgumentType.BOOLEAN, "breakable"),
    }),
    ADD_MANUAL_BOMB(EventGroup.ADD, EventDirection.OUTPUT, "addManualBomb", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    ADD_AUTOMATIC_BOMB(EventGroup.ADD, EventDirection.OUTPUT, "addAutomaticBomb", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    ADD_NEXT_BALL(EventGroup.ADD, EventDirection.OUTPUT, "addNextBall", new EventArgument[]{
            new EventArgument(EventArgumentType.NUMBER, "column"),
            new EventArgument(EventArgumentType.NUMBER, "colour"),
            new EventArgument(EventArgumentType.NUMBER, "value"),
            new EventArgument(EventArgumentType.BOOLEAN, "movable"),
            new EventArgument(EventArgumentType.BOOLEAN, "breakable"),
    }),
    ADD_NEXT_MANUAL_BOMB(EventGroup.ADD, EventDirection.OUTPUT, "addNextManualBomb", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS[1]),
    ADD_NEXT_AUTOMATIC_BOMB(EventGroup.ADD, EventDirection.OUTPUT, "addNextAutomaticBomb", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS[1]),
    ADD_NEXT_PAINT_BOMB(EventGroup.ADD, EventDirection.OUTPUT, "addNextPaintBomb", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS[1]),
    EXPLODE(EventGroup.EXPLODE, EventDirection.OUTPUT, "explode", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    WAIT(EventGroup.MISC, EventDirection.OUTPUT, "wait", new EventArgument(EventArgumentType.NUMBER, "nanoseconds")),
    UPDATE_PLAYER_SCORE(EventGroup.MISC, EventDirection.OUTPUT, "updatePlayerScore", new EventArgument(EventArgumentType.NUMBER, "newScore")),
    NEW_GAME(EventGroup.MISC, EventDirection.OUTPUT, "newGame", new EventArgument[]{
            new EventArgument(EventArgumentType.NUMBER, "height"),
            new EventArgument(EventArgumentType.NUMBER, "width"),
            new EventArgument(EventArgumentType.NUMBER, "newBallCount")
    }),
    END_GAME(EventGroup.MISC, EventDirection.OUTPUT, "endGame", new EventArgument(EventArgumentType.NUMBER, "finalScore")),
    CELL_ACTIVATED(EventGroup.IN, EventDirection.INPUT, "cellActivated", EventArgument.ROW_COLUMN_EVENT_ARGUMENTS),
    STEP_BACK(EventGroup.IN, EventDirection.INPUT, "stepBack"),
    FREE_MODE(EventGroup.IN, EventDirection.INPUT, "freeMode", new EventArgument[]{
            new EventArgument(EventArgumentType.TEXT_ARRAY, "arguments")
    });


    //    /**
//     * clear command.
//     */
//    CLEAR("clear", EventGroup.TODO, EventDirection.OUT, EventDirection.OUT),
//
//    /**
//     * clear command.
//     */
//    NEW_GAME("newGame", EventGroup.TODO, EventDirection.OUT, EventDirection.OUT),
//
//    /**
//     * clear command.
//     */
//    MOVE("move", EventGroup.TODO, EventDirection.OUT, EventDirection.OUT);
    @Getter
    private final int instructionNumber;
    @Getter
    private final EventGroup eventGroup;
    @Getter
    private final EventDirection eventDirection;
    /**
     * Name of the change type.
     */
    @Getter
    private final String name;

    @Getter
    private final List<EventArgument> eventArguments;

    //todo: create the instruction set- assign instruction number
    @Deprecated
    EventType(EventGroup eventGroup, final EventDirection eventDirection, final String nameIn, EventArgument... eventArgumentsArray) {
        this(-1, eventGroup, eventDirection, nameIn, eventArgumentsArray);
    }

    EventType(int instructionNumber, EventGroup eventGroup, final EventDirection eventDirection, final String nameIn, EventArgument... eventArgumentsArray) {
        this.instructionNumber = instructionNumber;
        this.eventGroup = eventGroup;
        this.eventDirection = eventDirection;
        this.name = nameIn;
        this.eventArguments = new ArrayList<>();
        if (eventArguments != null) {
            for (EventArgument ea : eventArgumentsArray) {
                this.eventArguments.add(ea);
            }
        }
    }

    /**
     *
     * @param argumentName
     * @return index, if found, otherwise -1
     */
    public int getEventArgumentIndex(String argumentName) {
        for (int i = 0; i < eventArguments.size(); i++) {
            EventArgument eventArgument = eventArguments.get(i);
            if(eventArgument.getName().equals(argumentName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param valueIn name to find
     * @return ChangeType based on the given name
     */
    public static EventType ofValue(final String valueIn) {
        for (EventType e : EventType.values()) {
            if (e.getName().equalsIgnoreCase(valueIn)) {
                return e;
            }
        }
        return null;
    }
}
