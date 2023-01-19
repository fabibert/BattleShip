package game.turn;

import game.GameOperator;
import game.GameState;
import player.Computer;
import player.Human;
import player.Player;

public class PlayerTurn extends TurnState {


    public PlayerTurn(GameOperator gameOperator, Human offensive, Computer defensive) {
        super(gameOperator, offensive, defensive);
    }

    @Override
    public void playTurn(Player player, Player ai) {
        if (attackSequence()) {
            gameOperator.setGameState(GameState.PLAYER_VICTORY);
        } else {
            gameOperator.nextTurn();
        }
    }

    public void gameEndSequence(){
        offensive.drawFinal(defensive);
    }
}
