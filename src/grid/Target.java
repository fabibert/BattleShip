package grid;

import coordinate.Coordinate;
import location.Empty;
import location.Location;

/**
 * the grid for the targets showing the own placements
 */
public class Target extends Grid{
    public Target(){
        setName("TARGET");
    }

    /**
     * Change the state of the underlying coordinate
     * @param coordinate which will change it state
     */
    public void updateTarget(Coordinate coordinate, Location location){
        //get the grid coordinate reference
        //update the grid reference to the state of the passed coordinate
        this.setLocation(coordinate, location);
    }

    /**
     * Method to check if the target is attackable or not (e.g. already attacked)
     * @param coordinate which will be attacked
     * @return if the coordinate is attackable (true) or not (false)
     */
    public boolean isTargetAttackable(Coordinate coordinate){
        return !getLocation(coordinate).isOccupied();
    }
}
