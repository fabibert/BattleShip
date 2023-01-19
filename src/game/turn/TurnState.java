package game.turn;

import game.GameOperator;
import player.Human;
import player.Player;
import utility.Coordinate;
import utility.CoordinateState;

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
        Coordinate c = offensive.attack();
        CoordinateState cs = defensive.underAttack(c);
        c.setState(cs);
        if (defensive.didShipSink(c)){
            ArrayList<Coordinate> cords = defensive.informAboutSunkenShip(c);
            for (Coordinate cord : cords){
                offensive.updateTarget(cord);
            }
        } else{offensive.updateTarget(c);}
        if(offensive instanceof Human){
            offensive.drawGameFlow();
        }
        return defensive.isFleetDestroyed();
    }

    public void gameEndSequence(){
        offensive.drawFinal(defensive);
    }

}
