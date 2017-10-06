import java.awt.*;

/**
 * @author Elliot Lohr
 * This program provides a template for a 3d shape object
 */
public abstract class ThreeDShape extends Shape{
    /**
     * the volume of the 3d shape
     */
    private double volume;

    /**
     * Constructor for the ThreeDShape
     * @param xCoord    xcoord for the shape to be drawn at
     * @param yCoord    ycoord for the shape to be drawn at
     * @param name      the name of the shape
     * @param c         the color of the shape to be drawn in
     */
    public ThreeDShape(int xCoord, int yCoord, String name, Color c)
    {
        super(xCoord, yCoord, name, c);
    }

    /**
     * Abstract for children classes to have a getVolume method
     * @return double
     */
    public abstract double getVolume();

    /**
     * abstract for children classes to have a getSurfaceArea method
     * @return double
     */
    public abstract double getSurfaceArea();
}
