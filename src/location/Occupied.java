package location;

import ship.Ship;

/**
 * State pattern to represent the occupied coordinates
 * Singleton here is not possible as the coordinate can be occupied but the underlying ship is a different one
 */
public class Occupied implements LocationState {
    private Ship ship;
    private Location location;

    /**
     * Create a new occupied state with the abbreviation
     *
     * @param shipType to get the abbreviation
     */
    public Occupied(Location location, Ship ship) {
        this.location = location;
        this.ship = ship;
    }


    @Override
    public String toString() {
        return String.valueOf(ship.getShipType());
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public void addShip(Ship ship) {
        throw new RuntimeException();
    }

    @Override
    public void attack() {
        ship.shipGotHit();
        location.setTargetState(TargetState.HIT);
    }
}
