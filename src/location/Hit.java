package location;

import ship.Ship;

/**
 * Singleton state pattern to represent the hits
 */
public class Hit implements LocationState {
    private static Hit instance;

    private Hit(){}

    public static Hit getInstance() {
        if(instance == null){
            instance = new Hit();
        }
        return instance;
    }

    @Override
    public String toString(){
        return "X";
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
    public AttackSucess attack() {
        throw new RuntimeException();
    }
}
