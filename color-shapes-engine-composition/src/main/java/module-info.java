
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

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
module colorshapes.engine.composition {
    requires lombok;
    requires powerframework.json;
    requires powerframework.random;
    requires powerframework.collections;
    requires powerframework.reflection;
    requires colorshapes.engine.base;
    exports org.nanoboot.colorshapes.engine.composition;
    exports org.nanoboot.colorshapes.engine.composition.utils;
    exports org.nanoboot.colorshapes.engine.composition.factory;
    exports org.nanoboot.colorshapes.engine.composition.thrower;
    exports org.nanoboot.colorshapes.engine.composition.factory.colors;
    exports org.nanoboot.colorshapes.engine.composition.factory.values;
    exports org.nanoboot.colorshapes.engine.composition.shapefinder;
    exports org.nanoboot.colorshapes.engine.composition.board;
    exports org.nanoboot.colorshapes.engine.composition.board.shape;
    exports org.nanoboot.colorshapes.engine.composition.board.shape.holes;
    exports org.nanoboot.colorshapes.engine.composition.common;
    exports org.nanoboot.colorshapes.engine.composition.other;
    //
    opens org.nanoboot.colorshapes.engine.composition;
    opens org.nanoboot.colorshapes.engine.composition.utils;
    opens org.nanoboot.colorshapes.engine.composition.factory;
    opens org.nanoboot.colorshapes.engine.composition.thrower;
    opens org.nanoboot.colorshapes.engine.composition.factory.colors;
    opens org.nanoboot.colorshapes.engine.composition.factory.values;
    opens org.nanoboot.colorshapes.engine.composition.shapefinder;
    opens org.nanoboot.colorshapes.engine.composition.board;
    opens org.nanoboot.colorshapes.engine.composition.board.shape;
    opens org.nanoboot.colorshapes.engine.composition.board.shape.holes;
    opens org.nanoboot.colorshapes.engine.composition.common;
    opens org.nanoboot.colorshapes.engine.composition.other;
 

}
