import java.awt.*;

/**
 * @Author Elliot Lohr
 * This program provides a template for a rectangle object
 */
public class Rectangle extends TwoDShape{
    /**
     * The length of the rectangle
     */
    private double side1;
    /**
     * The width of the rectangle
     */
    private double side2;

    /**
     * Constructor for Rectangle object
     * @param xCoord    xcoord for rectangle to be drawn at
     * @param yCoord    ycoord for rectangle to be drawn at
     * @param name      the name of the rectangle
     * @param c         color for rectangle to be drawn in
     * @param side1     length of the rectangle
     * @param side2     width of the rectangle
     */
    public Rectangle(int xCoord, int yCoord, String name, Color c, double side1, double side2)
    {
        super(xCoord,yCoord, name, c);
        this.side1 = side1;
        this.side2 = side2;
    }
    @Override
    /**
     * returns the area of the rectangle
     * @return area
     */
    public double getArea()
    {
        return side1 * side2;
    }
    @Override
    /**
     * gets the perimeter of the rectangle
     * @return perimeter
     */
    public double getPerimeter()
    {
        return side1 + side1 + side2 + side2;
    }
}
