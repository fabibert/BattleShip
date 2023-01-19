package utility;

import ship.ShipType;

public class Messaging {

    public static void showUserCoordinateError(Exception e){
        System.out.println("\nPlease enter valid coordinates...\n\n");
        System.out.println("Specific error message");
        System.out.println(e.getMessage());
        System.out.println("\n\nEnter them again...\n");
    }

    public static void shipLocationRequest(ShipType shipType, int shipFromType) {
        System.out.println("Where do you want to place your " + shipType + " (size: " + shipType.getShipLength() + ") (Ship no. " + (shipFromType + 1) + "/ " + shipType.getNumberOfShips() + ")\n" +
                "Enter Start end End Coordinates (e.g. A1,A" + shipType.getShipLength() + ")");
    }

    public static void attack(){
        System.out.println("Attack attack attack, Captain enter the coordinates");
    }

}
