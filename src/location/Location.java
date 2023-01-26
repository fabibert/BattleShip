package location;


import ship.Ship;

/**
 * Interface for the state pattern
 */
public class Location {

    private LocationState state;

    public Location(){
        state = new Empty(this);
    }

    public boolean isOccupied(){
        return state.isOccupied();
    }

    public void addShip(Ship ship) {
        state.addShip(ship);
    }

    protected void setState(LocationState state){
        this.state = state;
    }

    public AttackSucess attack() {
        return state.attack();
    }
}
