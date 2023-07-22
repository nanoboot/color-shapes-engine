
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

package org.nanoboot.colorshapes.engine.game.tools;

import org.nanoboot.colorshapes.engine.base.random.CSRandomGenerator;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;
import org.nanoboot.colorshapes.engine.parts.base.GameNode;
import org.nanoboot.colorshapes.engine.parts.core.BallPosition;
import org.nanoboot.colorshapes.engine.parts.core.Board;
import org.nanoboot.colorshapes.engine.parts.core.Cell;
import org.nanoboot.colorshapes.engine.parts.core.PreviewBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates the row and column of a random cell from all empty cells of the board.
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class BallPositionGenerator extends GameNode {
    private final Board board;
    private final PreviewBar previewBar;
    private final CSRandomGenerator random;

    public BallPositionGenerator(EventConsumer eventConsumer, CSRandomGenerator random, Board board, PreviewBar line) {
        super(eventConsumer);
        this.random = random;
        this.board = board;
        this.previewBar = line;
    }

    public BallPosition generate() {
        List<Cell> emptyCells = board.getEmptyCells();
        Cell c = random.getRandomItemFromList(emptyCells);
        BallPosition bp = new BallPosition(c.getRow(), c.getColumn());
        return bp;
    }

    public List<BallPosition> generate(int count) {
        List<Cell> emptyCells = board.getEmptyCells();
        List<Cell> selectedEmptyCells = random.getRandomItemsFromList(emptyCells, count);
        List<BallPosition> result = new ArrayList<>();
        for (Cell c : selectedEmptyCells) {
            BallPosition bp = new BallPosition(c.getRow(), c.getColumn());
            result.add(bp);
        }
        return result;
    }


}
