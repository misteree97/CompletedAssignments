import java.awt.*;

/**
 * @author Elliot Lohr
 * This program provides a template for a OneDShape object
 */
public abstract class OneDShape extends Shape {
    /**
     * the length of the shape
     */
    private double length;

    /**
     * Constructor for 1dShape object
     * @param xCoord    xcoord for shape to be drawn at
     * @param yCoord    ycoord for shape to be drawn at
     * @param name      the name of the shape
     * @param c         the color of the shape to be drawn in
     * @param length    the lenth of the shape
     */
    public OneDShape(int xCoord, int yCoord, String name, Color c, double length)
    {
        super(xCoord,yCoord,name,c);
        this.length = length;
    }

    /**
     * sets the length variable to a new value
     * @param length
     */
    public void setLength(double length)
    {
        this.length = length;
    }

    /**
     * returns the length of the object
     * @return length
     */
    public double getLength()
    {
        return length;
    }
}

