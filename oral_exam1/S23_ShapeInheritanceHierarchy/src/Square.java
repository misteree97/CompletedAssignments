import java.awt.*;

/**
 * @author Elliot Lohr
 * This program provides a template for a square object
 */
public class Square extends TwoDShape {
    /**
     * the length of the side of a square
     */
    private double side;

    /**
     * Constructor for square object
     * @param xCoord    xcoord for square to be drawn at
     * @param yCoord    ycoord fot square to be drawn at
     * @param name      name of the square
     * @param c         color for the square to be drawcdn in
     * @param side      length of the side of square
     */
    public Square(int xCoord, int yCoord, String name, Color c, double side)
    {
        super(xCoord,yCoord, name, c);
        this.side = side;
    }

    @Override
    /**
     * returns the area of the square
     * @return area
     */
    public double getArea()
    {
        return side * side;
    }
    @Override
    /**
     * returns the perimeter of the square
     * @return perimeter
     */
    public double getPerimeter()
    {
        return side * 4;
    }
}
