package game.turn;

import game.GameOperator;
import game.GameState;
import player.Computer;
import player.Human;
import player.Player;

public class AiTurn extends TurnState {


    public AiTurn(GameOperator gameOperator, Computer ai, Human player) {
        super(gameOperator, ai, player);
    }

    @Override
    public void playTurn(Player player, Player ai) {
        if (attackSequence()) {
            gameOperator.setGameState(GameState.CPU_VICTORY);
        } else {
            gameOperator.nextTurn();
        }

    }


}
