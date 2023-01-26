package location;

import coordinate.Coordinate;
import ship.Ship;
import ship.ShipType;

/**
 * State pattern to represent the sunken ship's coordinates
 * Singleton here is not possible as the coordinate can be sunken but the underlying ship is a different one
 */
public class Sunk implements LocationState {
    private Ship ship;

    public Sunk(Ship ship){
        this.ship = ship;
    }


    @Override
    public String toString(){
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
}
