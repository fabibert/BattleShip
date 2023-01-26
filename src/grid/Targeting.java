package grid;

import coordinate.Coordinate;

public class Targeting {
    
    private Ocean ocean;
    
    public Targeting(Ocean ocean){
        this.ocean = ocean;
    }
    
    public boolean attack(Coordinate coordinate){
        return this.ocean.getLocation(coordinate).attack();
    }

    public int getGridSize() {
        return ocean.getGridSize();
    }
}
