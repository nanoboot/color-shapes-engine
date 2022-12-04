# TODOS for "color-shapes-engine"

Todos:

"" player: ""/"" (create at the first start of the game)



----
```
@Deprecated
public class ChangeCommands {

    public static final String GAME = "GAME ";
    public static final String NEW = "NEW ";
    public static final String HOLES = "HOLES ";
    public static final String NICK = "NICK ";
    public static final String SCORE = "SCORE ";
    public static final String PLAYER = "PLAYER ";
    public static final String RECORDHOLDER = "RECOR-DHOLDER ";
    public static final String CELL = "CELL ";
    public static final String GRID = "GRID ";
    public static final String ON = "ON ";
    public static final String OFF = "OFF ";
    public static final String WALL = "WALL ";
    public static final String TOP = "TOP ";
    public static final String RIGHT = "RIGHT ";
    public static final String BOTTOM = "BOTTOM ";
    public static final String LEFT = "LEFT ";
    public static final String NEXT = "NEXT ";
    public static final String ROLLABLE = "ROLLABLE ";
    public static final String BALL = "BALL ";
    public static final String UNMOVABLE = "UNMOVEABLE ";
    public static final String MOVABLE = "MOVEABLE ";
    public static final String UNBREAKABLE = "UNBREAKABLE ";
    public static final String BREAKABLE = "BREAKABLE ";
    public static final String BOMB = "BOMB ";
    public static final String AUTOMATIC = "AUTOMATIC ";
    public static final String MANUAL = "MANUAL ";
    public static final String INFLATE = "INFLATE ";
    public static final String JUMPING = "JUMPING ";
    public static final String EXPLODE = "EXPLODE ";
    public static final String MOVE = "MOVE ";
    public static final String TO = "TO ";
    public static final String CLEAR = "CLEAR ";
    public static final String WAIT = "WAIT ";
    public static final String SPACE = " ";

}
```
--------

```
package org.nanoboot.colorshapes.engine.core.orig;

@Deprecated
public interface GameBoardCanvas {
    /**
     *
     */
    void clear();

    /**
     *
     * @param width width of the board
     * @param height height of the board
     * @param nextCount count of next cells
     */
    void newGame(int width, int height, int nextCount);

    /**
     *
     * @param playerName name of the player
     */
    void setPlayerName(String playerName);

    /**
     *
     * @param pretenderName name of the pretender
     */
    void setPretenderName(String pretenderName);

    /**
     *
     * @param playerScore player score
     */
    void setPlayerScore(int playerScore);

    /**
     *
     * @param pretenderScore pretender score
     */
    void setPretenderScore(int pretenderScore);

    /**
     *
     * @param value boolean value
     */
    void setGrid(boolean value);

    /**
     *
     * @param direction
     * 0 for top, 1 for right, 2 for bottom, 3 for left
     * @param value boolean value
     */
    void setWall(int direction, boolean value);

    /**
     *
     * @param row row number
     * @param column column value
     * @param colour colour of the new Ball
     * @param value value of the new Ball
     * @param movable boolean value
     * @param breakable boolean value
     */
    void newBall(
            int row,
            int column,
            int colour,
            int value,
            boolean movable,
            boolean breakable);

    /**
     * Adds new bomb to the board.
     * @param row row number
     * @param column column number
     * @param type 0, if automatic. 1, if manual.
     *             Exception will be thrown for other values.
     */
    void newBomb(int row, int column, int type);

    /**
     *
     * @param row row number
     * @param column column value
     */
    void inflateBall(int row, int column);

    /**
     *
     * @param row row number
     * @param column column value
     */
    void deflateBall(int row, int column);

    /**
     *
     * @param row row number
     * @param column column value
     * @param value boolean value
     */
    void setBallJumping(int row, int column, boolean value);

    /**
     * Explodes ball or bomb in the given cell.
     * @param row row number
     * @param column column value
     */
    void explode(int row, int column);

    /**
     * Moves ball or bomb from the given row and column.
     * @param row start row
     * @param column start column
     * @param tos array of integers. Its size must be even
     * Example: move(1,1,1,2,1,3,2,3)
     * Result:
     *            moved ball from cell(1, 1) to cell (1, 2)
     *            moved ball from cell(1, 2) to cell (1, 3)
     *            moved ball from cell(1, 3) to cell (2, 3)
     */
    void move(int row, int column, Integer[] tos);

    /**
     *
     * @param milliseconds count of milliseconds to wait
     */
    void wait(int milliseconds);

    /**
     * @return player name
     */
    String getPlayerName();

    /**
     *
     * @return pretender name
     */
    String getPretenderName();

    /**
     *
     * @return player score
     */
    int getPlayerScore();

    /**
     *
     * @return pretender score
     */
    int getPretenderScore();

    /**
     *
     * @return width of the board
     */
    int getWidth();

    /**
     *
     * @return height of the board
     */
    int getHeight();

    /**
     *
     * @return count of next cells
     */
    int getNextCount();

    /**
     *
     * @param row row number
     * @param column column value
     * @return true, if the cell has grid, otherwise false
     */
    boolean hasGrid(int row, int column);

    /**
     *
     * @param direction
     * 0 for top, 1 for right, 2 for bottom, 3 for left
     * @return true, if the cell has wall at the given direction,
     * otherwise false
     */
    boolean hasWall(int direction);

    /**
     *
     * @param row row number
     * @param column column value
     * @return true, if the cell is empty,
     * otherwise false
     */
    boolean isEmpty(int row, int column);
    /**
     *
     * @param row row number
     * @param column column value
     * @return true, if the ball is movable,
     * otherwise false
     */
    boolean isMovable(int row, int column);
    /**
     *
     * @param row row number
     * @param column column value
     * @return true, if the ball is breakable,
     * otherwise false
     */
    boolean isBreakable(int row, int column);

    /**
     *
     * @param row row number
     * @param column column value
     * @return value of the ball
     */
    int getValue(int row, int column);
    /**
     *
     * @param row row number
     * @param column column value
     * @return colour number of the ball
     */
    int getColour(int row, int column);
    /**
     *
     * @param row row number
     * @param column column value
     * @return bomb type
     */
    int getBombType(int row, int column);

    /**
     * @return json string from the current board state
     * Example:
     * {
     *     "width" : 9,
     *     "height : 9,
     *     "nextCount" : 3,
     *     "playerName" : "Robert",
     *     "pretenderName" : "Bob",
     *     "playerScore" : 80,
     *     "pretenderScore" : 120,
     *     "cells" : {
     *     "1-1" : {
     *         "ball" : {
     *             "colour" : 1,
     *             "value" : 1,
     *             "movable" : true,
     *             "breakable" " true
     *         },
     *         "bomb" : null,
     *         "grid" : false,
     *         "wall-top" : false,
     *         "wall-right : false,
     *         "wall-bottom" : false,
     *         "wall-left" : false
     *     }
     *     }
     * }
     */
    String asJson();
    /**
     * Rearranges the board according to the json object.
     * @param jsonObject json object in String form
     */
    void fromJson(String jsonObject);
}

```

----
```
package org.nanoboot.colorshapes.engine.core.orig;

import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.json.JsonObjectSerializable;
import org.nanoboot.powerframework.view.EnumColour;
import lombok.Data;

/**
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 */
//todo: move to color-shapes-desktop

@Data
public class ApplicationLook implements JsonObjectSerializable {

    /**
     * skin.
     */
    private EnumColour colourSkin;
    /**
     * zoom.
     */
    private int zoom;
    /**
     * ballLighting.
     */
    private String ballLighting;
    /**
     * linesAround.
     */
    private boolean linesAround;
    /**
     * showWhereABallCanBeMoved.
     */
    private boolean showWhereABallCanBeMoved;
    /**
     * showHighlightCellAfterBallExploded.
     */
    private boolean showHighlightCellAfterBallExploded;
    /**
     * ballMoveEffectName.
     */
    private String ballMoveEffectName;
    /**
     * ballLightingName.
     */
    private String ballLightingName;

    @Override
    public JsonObject toJsonObject() {
        //todo
        return null;
    }

    @Override
    public void fromJsonObject(JsonObject jsonObject) {
        //todo
    }

    //EnumColour.convertNumberToEnumColour();
    
}

```



----

```
    /**
     *
     * @param change
     */
    public synchronized void addChange(String change) {
        changesGoal.notifyAboutChange(change);
    }
``` 

-----

