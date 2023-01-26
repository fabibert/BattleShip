package location;


import ship.Ship;

/**
 * Singleton state pattern to represent the missed shots
 */
public class Missed implements LocationState {
    private static Missed instance;

    private Missed(){}

    public static Missed getInstance() {
        if(instance == null){
            instance = new Missed();
        }
        return instance;
    }

    @Override
    public String toString(){
        return "o";
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
        throw  new RuntimeException();
    }
}
