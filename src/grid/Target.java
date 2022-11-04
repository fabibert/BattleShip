package grid;

import utility.Coordinate;
import utility.Empty;

/**
 * the grid for the targets showing the own placements
 */
public class Target extends Grid{
    public Target(){
        setName("TARGET");
    }
    public void updateTarget(Coordinate coordinate){
        this.getGridValue(coordinate).setState(coordinate.getState());
    }

    public boolean isTargetAttackable(Coordinate coordinate){
        if (this.getGridValue(coordinate).getState() instanceof Empty) return true;
        return false;
    }
/*
    public char[][] shipAttack(Coordinates attack, Player enemy) throws ShipAlreadyAttackedException {
        Ocean enemyOcean = enemy.getOcean();

        if(getGrid()[attack.getAttack().getX()][attack.getAttack().getY()] == INIT_FILLER_VALUE){
            char[][] localGrid = getGrid();
            if (enemyOcean.getGrid()[attack.getAttack().getX()][attack.getAttack().getY()] == INIT_FILLER_VALUE){
                localGrid[attack.getAttack().getX()][attack.getAttack().getY()] = MISS;
                setGrid(localGrid);
            } else {
                localGrid[attack.getAttack().getX()][attack.getAttack().getY()] = HIT;
                ArrayList<Ship> enemyFleet = enemy.getShips();
                for(Ship ship : enemyFleet){
                    evaluateShipAndValidateAttack(ship, attack);
                }
                setGrid(localGrid);
            }
        } else {
            throw new ShipAlreadyAttackedException("Coordinate already attacked. Please enter different coordinates.");
        }
        return getGrid();
    }

    private void evaluateShipAndValidateAttack(Ship ship,Coordinates attack) throws ShipAlreadyAttackedException {
        if(ship.getShipDirection() == ShipDirection.VERTICAL){
            if(ship.getCoordinates().getStart().getY() == attack.getAttack().getY() &&
                    (ship.getCoordinates().getStart().getX() <= attack.getAttack().getX() && attack.getAttack().getX() <= ship.getCoordinates().getEnd().getX())){
                // attacked ship
                ship.shipGotHit();
                if (ship.getHealth() == 0){
                    //ship sunk
                    overrideSunkenShip(ship);
                }
            }
        } else{
            if(ship.getCoordinates().getStart().getX() == attack.getAttack().getX() &&
                    (ship.getCoordinates().getStart().getY() <= attack.getAttack().getY() && attack.getAttack().getY() <= ship.getCoordinates().getEnd().getY())){
                // attacked ship
                ship.shipGotHit();
                if (ship.getHealth() == 0){
                    // ship sunk
                    overrideSunkenShip(ship);
                }
            }
        }
    }

    private char[][] overrideSunkenShip(Ship ship) throws ShipAlreadyAttackedException {
        char[][] localGrid = getGrid();
        for(int coordinate_values = 0; coordinate_values < ship.getShipType().getShipLength(); coordinate_values++){
            if (ship.getShipDirection() == ShipDirection.HORIZONTAL){
                localGrid[ship.getCoordinates().getStart().getX()][ship.getCoordinates().getStart().getY()+coordinate_values] = ship.getShipType().getAbbreviation();
            }
            else if (ship.getShipDirection() == ShipDirection.VERTICAL){
                localGrid[ship.getCoordinates().getStart().getX()+coordinate_values][ship.getCoordinates().getStart().getY()] = ship.getShipType().getAbbreviation();
            }
            else {
                throw new ShipAlreadyAttackedException("Ship attack was not successful. Please enter correct coordinates.");
            }
        }
        //only overwrite grid if no exception is thrown => if the placement is valid
        setGrid(localGrid);
        return getGrid();
    }*/
}
