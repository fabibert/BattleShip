package game;

import game.turn.AiTurn;
import game.turn.PlayerTurn;
import game.turn.TurnState;
import player.Computer;
import player.Human;

import java.util.List;
import java.util.Random;

/**
 * Game Operator Singleton, responsible to start the game and run it
 */
public class GameOperator {

    private final List<TurnState> turns;
    private TurnState currentTurn;
    private GameState gameState = GameState.RUNNING;
    private int playerIndex;

    /**
     * Game Operator instructor used to evaluate the game state and run the game
     */
    public GameOperator(){
        Human player = new Human();
        Computer ai = new Computer();
        player.setTarget(ai.getPlayerTarget());
        ai.setTarget(player.getPlayerTarget());
        player.fleetPlacement();
        ai.fleetPlacement();

        //initialize turns and change the game state
        turns = List.of(new PlayerTurn(this, player, ai), new AiTurn(this, ai, player));
        playerIndex = new Random().nextInt(turns.size());
        currentTurn = turns.get(playerIndex);

        //loop to run turns
        while(gameState.equals(GameState.RUNNING)){
            currentTurn.playTurn(player, ai);
        }
        System.out.println(gameState.getMessage());
        currentTurn.gameEndSequence();
    }

    public void nextTurn() {
        playerIndex = (playerIndex + 1) % turns.size();
        currentTurn = turns.get(playerIndex);
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
