package location;

import ship.Ship;

import java.util.Optional;

public interface LocationState {

    boolean isOccupied();

    void addShip(Ship ship);

    void attack();
}
