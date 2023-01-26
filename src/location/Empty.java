package location;

import ship.Ship;

/**
 * Singleton pattern for the empty state
 */
public class Empty implements LocationState {

    private Location location;

    public Empty(Location location){
        this.location = location;
    }


    @Override
    public String toString(){
        return " ";
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public void addShip(Ship ship) {
        location.setState(new Occupied(ship));
    }

    @Override
    public AttackSucess attack() {
        return AttackSucess.MISSED;
    }
}
