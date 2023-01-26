package coordinate;

/**
 * Representation of a coordinate
 */
public class Coordinate {

    //x in a computer matrix is horizontal
    private final int x;
    //y in a computer matrix vertical
    private final int y;

    //values for the input validation
    private final int min_x = 0;
    private final int min_y = 0;
    private final int max_x = 9;
    private final int max_y = 9;

    /**
     * Initialize a coordinate for a human
     * @param coordinate a single coordinate
     */
    public Coordinate(String coordinate) {
        this(coordinate.charAt(0) - 'A', Character.getNumericValue(coordinate.charAt(1)));
    }

    /**
     * initialize coordinate for a cpu
     * @param x number generated from cpu
     * @param y number generated from cpu
     */
    public Coordinate(int x, int y) {
        //validate input
        assert x >= min_x && x <= max_x;
        assert y >= min_y && y <= max_y;

        this.y = y;
        this.x = x;
    }

    /**
     * Get the X value of the coordinate
     * @return x value of the coordinate
     */
    public int getX(){return this.x;}
    /**
     * Get the Y value of the coordinate
     * @return y value of the coordinate
     */
    public int getY(){return this.y;}

}
