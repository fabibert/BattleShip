package player;

import coordinate.Coordinate;
import ship.Ship;
import ship.ShipType;
import location.Empty;
import messaging.Messaging;
import location.Occupied;
import java.util.Scanner;

import static messaging.Messaging.shipLocationRequest;
import static messaging.Messaging.showUserCoordinateError;

//imports for mock
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;

/**
 * Human class to represent a physical player
 */
public class Human extends Player {

    /**
     * Method to place the ships for the human
     * The ships will be placed based on the input
     */
    @Override
    public void fleetPlacement() {
        for (ShipType shipType : ShipType.values()){
            for(int shipFromType = 0; shipFromType < shipType.getNumberOfShips(); shipFromType++){
                boolean isShipPlaced = false;
                while (!isShipPlaced){
                    isShipPlaced = attemptToPlaceShip(shipType, shipFromType);
                }
                this.getOcean().printGrid();
            }
        }
    }

    private boolean attemptToPlaceShip(ShipType shipType, int shipFromType) {
        shipLocationRequest(shipType, shipFromType);
        try {
            /*
            //MOCK by deleting the comment from the line below and the associated method, userinput can be mocked
            String[] coords = new Scanner(mockShipPlacement()).next().split(",");
             */
            String[] coords = new Scanner(System.in).next().split(",");
            Coordinate start = new Coordinate(coords[0], new Occupied(shipType));
            Coordinate end = new Coordinate(coords[1], new Occupied(shipType));
            Ship ship = new Ship(start, end, shipType);
            // check ship placement
            if (getOcean().canPlaceShip(ship)){
                addShip(ship);
                getOcean().placeShip(ship);
                return true;
            }
        } catch (Exception e) {
            showUserCoordinateError(e);
        }
        return false;
    }

    /**
     * Human method to attack the opponent
     * @return the coordinate to be attacked
     */
    @Override
    public Coordinate attack() {
        boolean unsuccessfulAttack = true;
        Coordinate coordinate = null;
        while(unsuccessfulAttack) {
            Messaging.attack();
            try {
                coordinate = new Coordinate(new Scanner(System.in).next(), Empty.getInstance());
                if (getTarget().isTargetAttackable(coordinate)){
                    unsuccessfulAttack = false;
                } else {
                    System.out.println("\nTarget already attacked\n\n");
                }
            } catch (Exception e) {
                showUserCoordinateError(e);
            }
        }
        return coordinate;
    }
/*
    private int counter = -1;

    //method for mock placement of the input, returns one value pair at the time
    private InputStream mockShipPlacement(){
        counter++;
        String[] pm = {"E9,J9",
                "G0,J0",
                "A2,A5",
                "D2,F2",
                "G3,I3",
                "J5,J7",
                "A0,B0",
                "A7,B7",
                "F5,F6",
                "J2,J3"};
        InputStream in = new ByteArrayInputStream(pm[counter].getBytes());
        return in;
    }

 */
}
