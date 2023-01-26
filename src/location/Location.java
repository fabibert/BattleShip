package location;


import ship.Ship;

/**
 * Interface for the state pattern
 */
public class Location {

    private LocationState state;
    private TargetState targetState = TargetState.EMPTY;

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

    public boolean attack() {
        if(targetState == TargetState.EMPTY){
            state.attack();
            return true;
        }
        return false;
    }

    protected void setTargetState(TargetState state){
        this.targetState = state;
    }
}
