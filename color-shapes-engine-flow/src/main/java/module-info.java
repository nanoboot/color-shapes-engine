
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

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
module colorshapes.engine.flow {
    exports org.nanoboot.colorshapes.engine.flow.event.core;
    exports org.nanoboot.colorshapes.engine.flow.event.types;
    exports org.nanoboot.colorshapes.engine.flow.handler;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.misc;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.wait;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.move;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.jumping;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.add;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.inflate;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.lock;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.wall;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.explode;
    exports org.nanoboot.colorshapes.engine.flow.event.impl.in;
    requires lombok;
    requires powerframework.time;
    requires powerframework.utils;
    requires powerframework.json;
}
