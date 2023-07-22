
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

package org.nanoboot.colorshapes.engine.composition;

import org.nanoboot.colorshapes.engine.composition.board.BoardComposition;
import org.nanoboot.colorshapes.engine.composition.shapefinder.ShapeFinderComposition;
import org.nanoboot.colorshapes.engine.composition.factory.BallFactoryComposition;
import org.nanoboot.colorshapes.engine.composition.other.OtherComposition;
import org.nanoboot.colorshapes.engine.composition.thrower.BallThrowerComposition;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class GameCompositionTest {

    public static final int UUID_LENGTH = 36;
    @Test
    public void constructor_5args() {
        //prepare
        GameComposition gameComposition = new GameComposition(
                new BoardComposition(),
                new BallFactoryComposition(),
                new BallThrowerComposition(),
                new ShapeFinderComposition(),
                new OtherComposition()
        );
        //execute
        //assert
        assertNotNull(gameComposition.getBoardComposition());
        assertNotNull(gameComposition.getBallFactoryComposition());
        assertNotNull(gameComposition.getBallThrowerComposition());
        assertNotNull(gameComposition.getShapeFinderComposition());
        assertNotNull(gameComposition.getOtherComposition());
    }

    @Test
    public void constructor_empty() {
        //prepare
        GameComposition gameComposition = new GameComposition(
        );
        //execute
        //assert
        assertNotNull(gameComposition.getBoardComposition());
        assertNotNull(gameComposition.getBallFactoryComposition());
        assertNotNull(gameComposition.getBallThrowerComposition());
        assertNotNull(gameComposition.getShapeFinderComposition());
        assertNotNull(gameComposition.getOtherComposition());
    }

    @Test
    public void constructor_jo() {
        //prepare
        GameComposition gameComposition = new GameComposition();

        //todo
        //if(true) throw new RuntimeException(gameComposition.toJsonObject().toPrettyString());
        GameComposition gameComposition2 = new GameComposition(gameComposition.toJsonObject());
        //execute
        //assert
        assertEquals(gameComposition.toJsonObject().toMinimalString(), gameComposition2.toJsonObject().toMinimalString());
    }
    @Test
    public void returnThis() {
        //prepare
        GameComposition gameComposition = new GameComposition();
        //execute
        //assert
        assertEquals(gameComposition, gameComposition.returnThis());
    }

    @Test
    public void getChildren() {
        //prepare
        GameComposition gameComposition = new GameComposition();
        //execute
        //assert
        assertEquals(5, gameComposition.getChildren().size());
    }

    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        GameComposition gameComposition = new GameComposition();
        //execute
        //assert
        assertNotNull(gameComposition.describePossibleReasonsIfInvalid());
    }

}
