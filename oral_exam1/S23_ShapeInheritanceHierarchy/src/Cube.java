import java.awt.*;

public class Cube extends ThreeDShape {
    /**
     * The length of the side of cube
     */
    private double side;


    /**
     * Constructor for cube object
     * @param xCoord    xcoord of the cube
     * @param yCoord    ycoord of the cube
     * @param name      The name of the cube
     * @param c         color for cube to be drawn in
     * @param side      the length of a side of the cube
     */
    public Cube(int xCoord, int yCoord, String name, Color c, double side)
    {
        super(xCoord,yCoord,name,c);
        this.side = side;
    }
    @Override
    /** Computes and returns the volume of cube
     * @return volume
     */
    public double getVolume()
    {
        return side * side * side;
    }
    @Override
    /**
     * Computes and returns the surface area of the cube
     * @return surfaceArea
     */
    public double getSurfaceArea()
    {
        double oneSide = side * side;
        return oneSide * 6;
    }
}
