
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

package org.nanoboot.colorshapes.engine.composition.board;

import org.nanoboot.colorshapes.engine.composition.board.shape.BoardShape;
import org.nanoboot.colorshapes.engine.composition.board.shape.Height;
import org.nanoboot.colorshapes.engine.composition.board.shape.Width;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BoardCompositionTest {
    @Test
    public void constructor_empty() {
        //prepare
        BoardComposition boardComposition = new BoardComposition();
        //execute
        //assert
        assertEquals(true, boardComposition.isDefault());
    }

    @Test
    public void constructor_jo() {
        //prepare
        BoardComposition boardComposition = new BoardComposition();
        BoardComposition boardComposition2 = new BoardComposition(boardComposition.toJsonObject());
        //execute
        //assert
        assertEquals(boardComposition.toJsonObject().toMinimalString(), boardComposition2.toJsonObject().toMinimalString());
    }

    @Test
    public void additionalValidate() {
        //prepare
        BoardComposition boardComposition;
        //execute
        //assert
        BoardShape shape = new BoardShape();
        assertEquals(true, new BoardComposition(null, shape, 0, 0, 0, 0).additionalValidate());

        assertEquals(false, new BoardComposition(null, shape, 0, 0, 0, 10).additionalValidate());
        assertEquals(false, new BoardComposition(null, shape, 0, 0, 100, 0).additionalValidate());
        assertEquals(true, new BoardComposition(null, shape, 0, 0, 100, 10).additionalValidate());

        assertEquals(false, new BoardComposition(null, shape, 0, 10, 0, 0).additionalValidate());
        assertEquals(false, new BoardComposition(null, shape, 100, 0, 0, 0).additionalValidate());
        assertEquals(true, new BoardComposition(null, shape, 100, 10, 0, 0).additionalValidate());

        assertEquals(true, new BoardComposition(null, shape, 100, 10, 100, 10).additionalValidate());
    }

    @Test
    public void returnThis() {
        //prepare
        BoardComposition boardComposition = new BoardComposition();
        //execute
        //assert
        assertEquals(boardComposition, boardComposition.returnThis());
    }

    @Test
    public void toJson() {
        //prepare
        BoardShape boardShape = new BoardShape();
        boardShape.setHeight(new Height(10));
        boardShape.setWidth(new Width(16));
        boardShape.addHole(3, 4);
        boardShape.addHole(6, 4);
        boardShape.addHole(9, 13);
        BoardComposition boardComposition = new BoardComposition();
        boardComposition.setGridProbability(new GridProbability(50));
        boardComposition.setGridCount(new GridCount(10));
        boardComposition.setWallProbability(new WallProbability(70));
        boardComposition.setWallCount(new WallCount(12));
        boardComposition.setBoardShape(boardShape);
        //execute
        assertNotNull(boardComposition.toJsonObject().toMinimalString());
        assertNotNull(boardComposition.toJsonObject().toPrettyString());
        new BoardComposition(boardComposition.toJsonObject());
        //assert

        ////
/*
        {
            "class":"org.nanoboot.colorshapes.engine.composition.board.BoardComposition",
                "boardShape":{
            "class":"org.nanoboot.colorshapes.engine.composition.board.shape.BoardShape",
                    "height":{
                "class":"org.nanoboot.colorshapes.engine.composition.board.shape.Height",
                        "value":10,
                        "minValue":1,
                        "maxValue":32,
                        "defaultValue":1
            },
            "width":{
                "class":"org.nanoboot.colorshapes.engine.composition.board.shape.Width",
                        "value":16,
                        "minValue":1,
                        "maxValue":32,
                        "defaultValue":1
            },
            "holes":{
                "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Holes",
                        "list":[
                {
                    "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination",
                        "row":{
                    "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Row",
                            "value":3,
                            "minValue":1,
                            "maxValue":32,
                            "defaultValue":1
                },
                    "column":{
                    "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Column",
                            "value":4,
                            "minValue":1,
                            "maxValue":32,
                            "defaultValue":1
                }
                },
                {
                    "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination",
                        "row":{
                    "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Row",
                            "value":6,
                            "minValue":1,
                            "maxValue":32,
                            "defaultValue":1
                },
                    "column":{
                    "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Column",
                            "value":4,
                            "minValue":1,
                            "maxValue":32,
                            "defaultValue":1
                }
                },
                {
                    "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.CellCoordination",
                        "row":{
                    "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Row",
                            "value":9,
                            "minValue":1,
                            "maxValue":32,
                            "defaultValue":1
                },
                    "column":{
                    "class":"org.nanoboot.colorshapes.engine.composition.board.shape.holes.Column",
                            "value":13,
                            "minValue":1,
                            "maxValue":32,
                            "defaultValue":1
                }
                }
         ]
            }
        },
            "gridProbability":{
            "class":"org.nanoboot.colorshapes.engine.composition.board.GridProbability",
                    "value":50,
                    "minValue":0,
                    "maxValue":100,
                    "defaultValue":0
        },
            "gridCount":{
            "class":"org.nanoboot.colorshapes.engine.composition.board.GridCount",
                    "value":10,
                    "minValue":0,
                    "maxValue":16,
                    "defaultValue":0
        },
            "wallProbability":{
            "class":"org.nanoboot.colorshapes.engine.composition.board.WallProbability",
                    "value":70,
                    "minValue":0,
                    "maxValue":100,
                    "defaultValue":0
        },
            "wallCount":{
            "class":"org.nanoboot.colorshapes.engine.composition.board.WallCount",
                    "value":12,
                    "minValue":0,
                    "maxValue":16,
                    "defaultValue":0
        }
        }
*/
    }

    /**
     * @return String containing the name of the root composition,
     * which is invalid.
     * If this composition is valid, empty String is returned
     */
    @Test
    public void getInvalidReason() {
        //prepare
        BoardShape boardShape = new BoardShape();
        boardShape.setHeight(new Height(10));
        boardShape.setWidth(new Width(18));
        boardShape.addHole(3, 4);
        boardShape.addHole(6, 4);
        boardShape.addHole(13, 13);
        BoardComposition boardComposition = new BoardComposition();
        boardComposition.setGridProbability(new GridProbability(50));
        boardComposition.setGridCount(new GridCount(10));
        boardComposition.setWallProbability(new WallProbability(70));
        boardComposition.setWallCount(new WallCount(12));
        boardComposition.setBoardShape(boardShape);

        assertNotNull(boardComposition.getInvalidReason());
    }
    @Test
    public void describePossibleReasonsIfInvalid() {
        //prepare
        BoardComposition boardComposition = new BoardComposition();
        //execute
        //assert
        assertNotNull(boardComposition.describePossibleReasonsIfInvalid());
    }

}
