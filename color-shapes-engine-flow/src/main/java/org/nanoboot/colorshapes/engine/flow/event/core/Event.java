
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

package org.nanoboot.colorshapes.engine.flow.event.core;

import org.nanoboot.colorshapes.engine.flow.event.types.EventGroup;
import org.nanoboot.colorshapes.engine.flow.event.types.EventType;
import lombok.Getter;
import org.nanoboot.powerframework.time.moment.UniversalDateTime;
import org.nanoboot.powerframework.utils.CommandReader;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Event {
    /**
     * Number of the event for a game starting from 1.
     */
    @Getter
    private /*final*/ int number;
    /**
     * Universal date and time of the event.
     */
    @Getter
    private /*final*/ UniversalDateTime universalDateTime;
    /**
     * Static i.
     */
    private static int staticI = 0;
    /**
     * Change type.
     */
    @Getter
    private EventType eventType;
    /**
     * Arguments.
     */
    @Getter
    private Object[] arguments;
    /**
     * String representation of this change.
     */
    @Getter
    private String stringRepresentation;

    /**
     * Name of the change.
     */
    @Getter
    private String name;

    @Getter
    private EventGroup eventGroup;

    /**
     * Constructor.
     *
     * @param change command instructions
     */
    public Event(final String change) {
        this.stringRepresentation = change;
        staticI++;
        name = staticI + " " + change;
        parseString(change);
    }

    private void parseString(final String change) {
        CommandReader reader = new CommandReader(change);
        if (change == null || change.isEmpty()) {
            this.eventType = EventType.NOTHING_TO_DO;
            this.arguments = new Object[] {};
            return;
        }
        this.eventType = EventType.ofValue(reader.next());

        if (this.eventType == null) {
            throw new IllegalStateException("changeType is null.");
        }
        Object[] args = new Object[reader.size() - 1];
        int index = 0;
        while (reader.hasNext()) {
            String arg = reader.next();
            Object o = null;
            if (arg.equals("true")) {
                o = Boolean.TRUE;
            }
            if (arg.equals("false")) {
                o = Boolean.FALSE;
            }
            if (o == null) {
                try {
                    Integer integer = Integer.parseInt(arg);
                    o = integer;
                } catch (Exception e) {
                    //Nothing to do.
                }
            }
            if (o == null) {
                o = arg;
            }
            args[index] = o;
            index++;
        }
        this.arguments = args;
    }

    /**
     * Constructor.
     *
     * @param eventTypeIn type
     * @param argumentsIn  arguments
     */
    public Event(final EventType eventTypeIn, final Object... argumentsIn) {
        this.eventType = eventTypeIn;
        this.arguments = argumentsIn;
        StringBuilder sb = new StringBuilder();
        sb.append(eventType.getName());
        for (Object o : arguments) {
            sb.append(" ");
            sb.append(o);
        }
        this.stringRepresentation = sb.toString();
        name = staticI + " " + stringRepresentation;
    }

    /**
     * @return count of arguments
     */
    public final int argumentCount() {
        return arguments.length;
    }

    /**
     * @param argumentName argumentName
     * @return string
     */
    public final String getString(final String argumentName) {
        return (String) getArgument(getEventType().getEventArgumentIndex(argumentName));
    }

    /**
     * @param index number
     * @return string
     */
    public final String getString(final int index) {
        return (String) getArgument(index);
    }
    /**
     * @param argumentName argumentName
     * @return string
     */
    public final int getInteger(final String argumentName) {
        return (Integer) getArgument(getEventType().getEventArgumentIndex(argumentName));
    }
    /**
     * @param index number
     * @return integer
     */
    public final Integer getInteger(final int index) {
        return (Integer) getArgument(index);
    }

    /**
     * @param fromIndex number
     * @return integer array
     */
    public final Integer[] getIntegerArray(final int fromIndex) {
        Integer[] array = new Integer[this.argumentCount() - fromIndex];
        int index = 0;
        for (int i = fromIndex; i < this.argumentCount(); i++) {
            Integer integer = getInteger(i);
            array[index] = integer;
            index++;
        }
        return array;
    }

    /**
     * @param index number
     * @return boolean
     */
    public final Boolean getBoolean(final int index) {
        return (Boolean) getArgument(index);
    }

    /**
     * @param index number
     * @return object
     */
    public final Object getArgument(final int index) {
        return arguments[index];
    }

    @Override
    public final String toString() {
        return stringRepresentation;
    }

    /**
     * Produces revert event.
     * @return revert event
     */
    public Event produceRevertEvent() {
        //todo
        throw new UnsupportedOperationException();
    }

}
