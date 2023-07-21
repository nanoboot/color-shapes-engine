
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

package org.nanoboot.colorshapes.engine.game.core;

import org.nanoboot.colorshapes.engine.composition.GameComposition;
import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.nanoboot.colorshapes.engine.entity.misc.Task;
import org.nanoboot.colorshapes.engine.entity.random .CSRandomGenerator;
import org.nanoboot.colorshapes.engine.entity.core.GameDto;
import org.nanoboot.colorshapes.engine.flow.event.core.Event;
import org.nanoboot.colorshapes.engine.flow.event.core.EventConsumer;
import org.nanoboot.colorshapes.engine.flow.event.impl.in.CellActivatedEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.misc.NewGameEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.misc.UpdatePlayerScoreEvent;
import org.nanoboot.colorshapes.engine.flow.event.impl.wait.WaitEvent;
import org.nanoboot.colorshapes.engine.flow.event.types.EventDirection;
import org.nanoboot.colorshapes.engine.game.parts.*;
import org.nanoboot.colorshapes.engine.game.tools.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
//todo: idea: fork a game

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public class Game extends GameNode implements EventConsumer {
    /**
     * id of the game.
     */
    @Getter
    @Setter
    private String id;

    @Getter
    private final GameComposition gameComposition;
    @Getter
    private final CSRandomGenerator randomGenerator;

    /**
     * Main board.
     */
    @Getter
    private final Board board;
    /**
     * Next board.
     */
    @Getter
    private final PreviewBar previewBar;


    @Getter
    private TotalScore totalScore;
    @Getter
    private GameTools gameTools;

    /**
     * Game state.
     */
    @Getter
    @Setter
    private GameState gameState = GameState.getDefault();
    private final Queue<Event> unprocessedEvents = new ConcurrentLinkedQueue<>();
    private List<Event> allEvents = new ArrayList<>();
    private List<Event> inputEvents = new ArrayList<>();
    private List<Event> outputEvents = new ArrayList<>();


    Task unprocessedInputEventsConsumingTask;


    /**
     * @param gameComposition gameComposition
     */
    public Game(GameComposition gameComposition, CSRandomGenerator randomGenerator) {
        super(null);
        if(!gameComposition.validate()) {
            String msg = "Game composition is not valid. "
                    + gameComposition.getInvalidReason()
                    + " "
                    + gameComposition.describePossibleReasonsIfInvalid();
            throw new ColorShapesEngineException(msg);
        }
        this.gameComposition = gameComposition;
        this.randomGenerator = randomGenerator;
//         = new CSRandomGenerator0001(
//                AbstractCSRandomGenerator.getStaticInstance().next(),
//                UniversalDateTime.random());
        this.board = new Board(this, gameComposition.getBoardComposition().getBoardShape());
        this.previewBar = new PreviewBar(this,randomGenerator,gameComposition.getBallThrowerComposition(), gameTools.getBallPositionerGenerator());

        totalScore = new TotalScore(this,gameComposition.getShapeFinderComposition());
        gameTools = new GameTools(this);

        unprocessedInputEventsConsumingTask = new Task("Checking for cell activation", () -> {
            while (!getGameState().isEnd()) {
                if (!this.unprocessedEvents.isEmpty()) {
                    Event event = this.unprocessedEvents.poll();
                    this.processInputEvent(event);
                    this.allEvents.add(event);
                    this.inputEvents.add(event);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        //init
        produceEvent(new NewGameEvent(board.getHeight(), board.getWidth(), this.gameComposition.getBallThrowerComposition().getNextBallCount().getValue()));
        produceEvent(new WaitEvent(1000));
        produceEvent(new UpdatePlayerScoreEvent(0));

        startGame();
    }
    public void startGame() {
        if(this.gameState!= GameState.START){
            throw new ColorShapesEngineException("Game has already started.");
        }
        this.gameTools.getBallThrower().throwAtTheStart();
        this.gameState=GameState.WAITING_FOR_EMPTY_CELL_ACTIVATION;
    }


    private void processInputEvent(Event event) {
        if(event instanceof CellActivatedEvent) {
            processInputEvent((CellActivatedEvent)event);
        } else {
            //todo: error
        }
    }
    private void processCellActivated(CellActivatedEvent event) {

    }

    public void save() {
        throw new UnsupportedOperationException();
    }

    public GameDto toGameDto() {
        return null;//todo
    }

    @Override
    public final void produceEvent(Event event) {
        this.outputEvents.add(event);
        this.allEvents.add(event);
    }

    public boolean consumeEvent(Event event) {
        if (event.getEventType().getEventDirection() != EventDirection.INPUT) {
            throw new ColorShapesEngineException("Cannot pass event, which does not have the direction IN.");
        }
        this.unprocessedEvents.add(event);
        return true;
    }

    //        Screen.setZoom(this.applicationLook.getZoom());

//    /**
//     * It is used to store a new command in commandBox
//     *
//     * @param change
//     * @return void
//     */
//    public void addChange(String change) {
//        this.changeNotifier.addChange(change);
//    }


//    public JsonObject getGameComposition() {
//        return this.gameContainer.getGameCompositionAsJsonObject();
//    }
//
//    public void setGameComposition(JsonObject gameComposition) {
//        this.gameContainer.setGameCompositionByJsonObject(gameComposition);
//    }
//
//    public void setGameCompositionRandom() {
//        this.gameContainer.setGameCompositionRandom();
//    }
//
//    public void setGameCompositionDefault() {
//        this.gameContainer.setGameCompositionDefault();
//    }




//    /**
//     * Ends the game
//     */
//    public void end(boolean aborting) {
////        this.gameRepository.setScore(this.id, totalScore.getCurrentTotalScore());
//
//        Task task = new Task("Game end(",
//                () -> {
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
//                        Thread.currentThread().interrupt();
//                    }
//                    handleEvent(new EndGameEvent(this.totalScore.getCurrentTotalScore()));
//                }
//        );
//    }

    //------------
    //    private AuthenticationService authenticationService;
//    private sessionRepository sessionRepository;
//
//    /**
//     * @return * If a player is logged in, returns true, otherwise returns
//     * false.
//     */
//    @Deprecated
//    public boolean isLoggedIn() {
//        return getCurrentSession() != null;
//    }
//
//    @Override
//    public Session getCurrentSession() {
//        return null;
//    }
//
//    @Override
//    public Session startSession(String nick, String password, boolean logInEveryTime) {
////        if (this.isLoggedIn()) {
////            throw new ColorShapesEngineException("A player is already logged in.");
////        }
////        if (authenticationService.authenticateUser(nick, password)) {
////            OldPlayer player = new OldPlayer(PlayerTable.getId(nick), logic);
////            logic.setPlayer(player);
////            logic.setApplicationLook(player.getApplicationLook());
////            logic.getTextSource().setLanguageId(logic.getApplicationLook().getLanguageId());
////            Screen.setZoom(this.logic.getApplicationLook().getZoom());
////            this.logic.getLogger().logPlayerLoggedIn(PlayerTable.getId(nick));
////            if (keepingLogged) {
////                player.setKeepingSignedIn(true);
////            }
////            this.logic.getGameManager().setGameComposition(player.getLastPlayedGameComposition());
////
////            Look.setBallLighting(player.getBallLightingName());
////            Look.setShowLineAroundBall(player.getLinesAround());
////            Look.setShowWhereABallCanBeMoved(player.getShowWhereABallCanBeMoved());
////            Look.setHightlightCellsAfterBallExploded(player.getHighlightCellAfterBallExploded());
////            Look.setBallMoveEffect(player.getBallMoveEffectName());
////            this.logic.addChange("MODE GAME");
////            this.logic.addChange("WAIT 2000");
////
////            return true;
////        } else {
////            return false;
////        }
//
//        sessionRepository.addPlayerSession(new Session());
//        return getCurrentSession();
//    }
//    /**
//     * Log out current player. No player will be automatically logged in.
//     */
//    @Override
//    public PlayerSession endSession() {
//
//        getCurrentSession().getSession().setEnd(UniversalDateTime.now());
//        sessionRepository.updatePlayerSession(this.getCurrentSession());
//        return getCurrentSession();
//    }
//
//    @Override
//    public Player getForeverPlayer() {
////        this.logic.getLogger().logPlayerLoggedOut();
////        logic.setPlayer(null);
////        logic.setApplicationLook(logic.getApplication().getApplicationLook());
////        logic.getTextSource().setLanguageId(logic.getApplicationLook().getLanguageId());
////        Screen.setZoom(this.logic.getApplicationLook().getZoom());
////        this.logic.addChange("MODE LOGIN");
//        return null;
//    }
//
//    @Override
//    public Player setForeverPlayer(Player player) {
//        return null;
//    }
}
