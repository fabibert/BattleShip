package player;

import coordinate.Coordinate;
import ship.Ship;
import ship.ShipType;

import java.util.Random;

/**
 * Computer class (represents the AI)
 */
public class Computer extends Player {


    public Computer() {
    }

    /**
     * Method to place the ships for the computer
     * The ships will be placed randomly
     */
    @Override
    public void fleetPlacement() {
        Random rand = new Random();
        for (ShipType shipType : ShipType.values()) {
            // generate horizontal / vertical placement
            boolean horizontal = rand.nextBoolean();
            for (int shipFromType = 0; shipFromType < shipType.getNumberOfShips(); shipFromType++) {
                boolean entered_unsuccessfully = true;
                while(entered_unsuccessfully) {
                    try {
                        //generate rando
                        Coordinate start;
                        Coordinate end;
                        if (horizontal) {
                            //horizontal
                            int randomX = rand.nextInt(getPlayerTarget().getGridSize() - shipType.getShipLength());
                            int randomY = rand.nextInt(getPlayerTarget().getGridSize());
                            start = new Coordinate(randomX, randomY);
                            end = new Coordinate(randomX + shipType.getShipLength()-1, randomY);
                        } else {
                            //vertical
                            int randomX = rand.nextInt(getPlayerTarget().getGridSize());
                            int randomY = rand.nextInt(getPlayerTarget().getGridSize() - shipType.getShipLength());
                            start = new Coordinate(randomX, randomY);
                            end = new Coordinate(randomX, randomY + shipType.getShipLength()-1);
                        }
                        Ship ship = new Ship(start, end, shipType);
                        if (this.getOcean().canPlaceShip(ship)){
                            try{
                                //ship can be placed
                                entered_unsuccessfully = false;
                                addShip(ship);
                                getOcean().placeShip(ship);
                            }catch(AssertionError e){
                                entered_unsuccessfully = true;
                            }
                        }
                    } catch (Exception e) {
                        entered_unsuccessfully = true;
                    }
                }
            }
        }
    }

    /**
     * CPU method to attack the opponent
     * @return the coordinate to be attacked
     */
    @Override
    public Coordinate attack() {
        boolean unsuccessfulAttack = true;
        Coordinate coordinate = null;
        Random rand = new Random();
        while(unsuccessfulAttack) {
            try {
                //generate a random value
                int randomX = rand.nextInt(getPlayerTarget().getGridSize());
                int randomY = rand.nextInt(getPlayerTarget().getGridSize());
                coordinate = new Coordinate(randomX, randomY);
                unsuccessfulAttack = !getPlayerTarget().attack(coordinate);
            } catch (Exception e) {
                //exceptions happen due to wrongly created coordinates
                //we do not want to spam, hence left out
            }
        }

        return coordinate;
    }
}
