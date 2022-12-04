
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

package org.nanoboot.colorshapes.engine.game.tools;

import org.nanoboot.colorshapes.engine.entity.misc.Coordination;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BoardNineNine {

    public static final Coordination[] coordinations;

    static {
        coordinations = new Coordination[81];
        int[] order = new int[]{
            56, 77, 61, 65, 49, 69, 57, 73, 53,
            76, 32, 45, 37, 25, 33, 41, 29, 79,
            60, 44, 16, 21, 9, 17, 13, 47, 63,
            72, 36, 24, 8, 1, 5, 19, 39, 67,
            52, 28, 12, 4, 0, 3, 11, 27, 51,
            68, 40, 20, 6, 2, 7, 23, 35, 71,
            64, 48, 14, 18, 10, 22, 15, 43, 59,
            80, 30, 42, 34, 26, 38, 46, 31, 75,
            54, 74, 58, 70, 50, 66, 62, 78, 55,};

        int index = 0;
        for (int row = 4; row >= -4; row--) {
            for (int column = -4; column <= 4; column++) {
                final int coordinationsIndex = order[index];
                coordinations[coordinationsIndex] = new Coordination(row, column);
                index++;
            }
        }
    }
}
