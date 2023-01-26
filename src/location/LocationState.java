package location;

import ship.Ship;

public interface LocationState {

    boolean isOccupied();

    void addShip(Ship ship);

    AttackSucess attack();
}
