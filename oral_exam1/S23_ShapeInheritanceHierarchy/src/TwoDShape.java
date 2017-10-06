import java.awt.*;

/**
 * @author Elliot lohr
 * This program provides a template for a twodshape object
 */
public abstract class TwoDShape extends Shape {
    /**
     * the area of the shape
     */
    private double area;

    /**
     * Constructor for TwoDShape Object
     * @param xCoord    xcoord for shape to be drawn at
     * @param yCoord    ycoord for shape to be drawn at
     * @param name      the name of the shape
     * @param c         the color of the shape to be drawn in
     */
    public TwoDShape(int xCoord, int yCoord, String name, Color c)
    {
        super(xCoord, yCoord, name, c);
    }

    /**
     * abstract so children classes can have getArea method
     * @return double
     */
    public abstract double getArea();

    /**
     * abstract so children classes can have getPerimeter method
     * @return double
     */
    public abstract double getPerimeter();
}
