package grid;

import ship.Ship;
import utility.Coordinate;
import utility.Empty;
import utility.Occupied;

/**
 * the grid for the ocean showing the attacks
 */
public class Ocean extends Grid {

    public Ocean(){
        setName("OCEAN");
    }

    public boolean canPlaceShip(Ship ship){
        Coordinate[][] grid = getGrid();
        for(Coordinate coordinate : ship.getPlacement()){
            if(grid[coordinate.getX()][coordinate.getY()].getState() instanceof Occupied){
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
        Coordinate[][] grid = getGrid();
        for(Coordinate coordinate : ship.getPlacement()){
            grid[coordinate.getX()][coordinate.getY()].setState(new Occupied(ship.getShipType()));
        }
        setGrid(grid);
    }

}
