package game.turn;

import game.GameOperator;
import location.TargetState;
import player.Human;
import player.Player;
import coordinate.Coordinate;

import java.util.ArrayList;

/**
 * Design State Pattern to represent the current turn
 */
public abstract class TurnState {

    protected GameOperator gameOperator;
    protected Player offensive;
    protected Player defensive;

    public TurnState(GameOperator gameOperator, Player offensive, Player defensive){
        this.gameOperator = gameOperator;
        this.offensive = offensive;
        this.defensive = defensive;
    }

    abstract public void playTurn(Player player, Player ai);

    /**
     * the whole attack sequence in a method
     * - the method consists several submethod calls
     * @return return if the defender fleet has been destroyed
     */
    protected boolean attackSequence(){
        offensive.attack();
        if(offensive instanceof Human){
            offensive.drawGameFlow();
        }
        return defensive.isFleetDestroyed();
    }

    public void gameEndSequence(){
        offensive.drawFinal(defensive);
    }

}
