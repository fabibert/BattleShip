package grid;

import coordinate.Coordinate;
import location.Empty;
import location.Location;
import ship.Ship;

/**
 * Abstract class Grid
 * - Subclasses are Ocean and Target, which will be used to log the shots and boats
 */
public class Ocean {
    //define the grid size
    private final int SIZE = 10;
    //grid consists of a m x n coordinate array
    private Location[][] grid;
    //the name for the grid (ocean or target) - will be used in the print method
    private String name;


    public Ocean(){
        grid = new Location[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++){
            for(int column = 0; column < SIZE; column++){
                grid[row][column] = new Location();
            }
        }
        this.name = "OCEAN";
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
    
    /**
     * Method to get the reference of teh coordinate on the grid
     * @param coordinate coordinate which will be looked up on the grid
     * @return coordinate from the grid
     */
    protected Location getLocation(Coordinate coordinate){
        return grid[coordinate.getY()][coordinate.getX()];
    }

    /**
     * method to access the gridsize
     * @return gridsize
     */
    public int getGridSize(){
        return SIZE;
    }

    /**
     *
     * @param name the gird name (OCEAN | TARGET)
     */
    protected void setName(String name){this.name=name;}
    /**
     * Print the grid
     */
    public void printGrid(){
        System.out.print("=======  "+name+" GRID =======\n");
        System.out.print("   A B C D E F G H I J  \n");
        System.out.print("  +-+-+-+-+-+-+-+-+-+-+ \n");
        for (int row = 0; row < SIZE; row++){
            System.out.print(row+" |");
            for(int value = 0; value < 10; value++){
                System.out.print(grid[row][value]+"|");
            }
            System.out.print(" " + row+"\n");
        }

        System.out.print("   +-+-+-+-+-+-+-+-+-+-+ \n");
        System.out.print("    A B C D E F G H I J  \n");
        System.out.print("===========================\n");
    }

    /**
     * Draw the final grid once the game is finished -> map the loser target onto the winner ocean to show the hits, misses and sunken ships
     * @param o: ocean of the winner
     * @param t: target of the loser
     */
    public void drawFinal(Ocean o, Targeting t){

        System.out.print("=======  FINAL GRID =======\n");
        System.out.print("   A B C D E F G H I J  \n");
        System.out.print("  +-+-+-+-+-+-+-+-+-+-+ \n");
        for (int row = 0; row < SIZE; row++){
            System.out.print(row+" |");
//            for(int value = 0; value < 10; value++){
//                if (t.getCoordinate(row, value).getState() instanceof Empty){
//                    System.out.print(o.getCoordinate(row, value).getState()+"|");
//                } else{
//                    System.out.print(t.getCoordinate(row, value).getState()+"|");
//                }
//            }
//            System.out.print(" " + row+"\n");
        }
        System.out.print("   +-+-+-+-+-+-+-+-+-+-+ \n");
        System.out.print("    A B C D E F G H I J  \n");
        System.out.print("===========================\n");
    }

}
