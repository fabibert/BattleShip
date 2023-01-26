package grid;

import ship.Ship;
import coordinate.Coordinate;
import location.Occupied;

/**
 * the grid for the ocean showing the attacks
 */
public class Ocean extends Grid {

    public Ocean(){
        setName("OCEAN");
    }

    public boolean canPlaceShip(Ship ship){
        for(Coordinate coordinate : ship.getPlacement()){
            if(getLocation(coordinate).isOccupied()){
                return false;
            }
        }
        return true;
    }


    /**
     * Update the ocean by changing the states of the underlying coordinates
     * @param ship which will update the state
     */
    public void placeShip(Ship ship){
        //addShipToFleet
        for(Coordinate coordinate : ship.getPlacement()){
            getLocation(coordinate).addShip(ship);
        }
    }

}
