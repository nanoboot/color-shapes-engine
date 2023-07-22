
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

package org.nanoboot.colorshapes.engine.flow.handler;

import org.nanoboot.colorshapes.engine.flow.event.core.Event;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class EventHandler {
    private final List<EventConsumer> eventConsumers = new ArrayList<>();

    /**
     * @param event event to be handled
     * @return true, if the event was handled, otherwise false
     * Handled events are not passed to the parent or child EventHandler
     */
    public final boolean handle(Event event) {
        boolean consumed;
        for (EventConsumer consumer : eventConsumers) {
            consumed = consumer.consumeEvent(event);
            if (consumed) {
                return true;
            }
        }

        return false;
        //throw new ColorShapesEngineException("Unsupported event direction. " + event.getEventType().getEventDirection().name());
    }
}
