package player;

import coordinate.Coordinate;
import grid.Ocean;
import grid.Targeting;
import ship.Ship;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Player abstract with the methods to be used for human and cpu
 */
public abstract class Player {
    //each player consists of an ocean grid
    private Ocean ocean;
    //each player consists of a target grid
    private Targeting target;
    //each player consists of a fleet of ships
    private ArrayList<Ship> ships;

    public Player(){
        this.ocean = new Ocean();
        this.ships = new ArrayList<>();
    }

    /**
     * get the ocean of the user (only possible in this package)
     * @return the users ocean
     */
    public Ocean getOcean() {
        return ocean;
    }

    /**
     * get the target of the user (only possible in this package)
     * @return the users target
     */
    public Targeting getPlayerTarget() {
        return new Targeting(ocean);
    }

    public void setTarget(Targeting target){
        this.target = target;
    }
    
    /**
     * add a ship to the current fleet
     * @param ship to be stored in the fleet (ships)
     */
    protected void addShip(Ship ship){
        ships.add(ship);
    }

    /**
     * check if the users fleet is destroyed
     * @return true or false based on if the fleet is destroyed
     */
    public boolean isFleetDestroyed(){
        AtomicInteger health = new AtomicInteger();
        ships.forEach(ship -> health.addAndGet(ship.getHealth()));
        return health.get() <= 0;
    }

    /**
     * empty method to display that each player has this method
     * Implementation will take place in each associated player
     * @return null
     */
    public Coordinate attack(){return null;}
    /**
     * empty method to display that each player has this method
     * Implementation will take place in each associated player
     */
    public abstract void fleetPlacement();

    /**
     * draw the target grid of the user
     */
    public void drawTarget(){
        //this.target.printGrid();
    }

    /**
     * draw the ocean grid of the user
     */
    public void drawOcean(){
        this.ocean.printGrid();
    }

    /**
     * draw the final grid (target grid of the winner and ocean grid of the winner with the enemy attacks)
     * @param t loser
     */
    public void drawFinal(Player t){
        //t.target.printGrid();
        this.ocean.drawFinal(t.getOcean(),this.getPlayerTarget());
    }

    /**
     * draw the game flow -> target and then ocean with a line inbetween
     */
    public void drawGameFlow(){
        drawTarget();
        System.out.println("");
        System.out.println("---------------------------");
        System.out.println("");
        drawOcean();
    }
}
