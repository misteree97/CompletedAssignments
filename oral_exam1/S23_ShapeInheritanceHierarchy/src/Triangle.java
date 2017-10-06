import java.awt.*;

/**
 * @author Elliot Lohr
 * This program provides a template for a triangle object
 */
public class Triangle extends TwoDShape {
    /**
     * the length of 1st side of triangle
     */
    private double side1;
    /**
     * the length of 2nd side of triangle
     */
    private double side2;
    /**
     * the length of 3rd side of triangle
     */
    private double side3;

    /**
     * Constructor for a triangle object
     * @param xCoord    xcoord for triangle to be drawn at
     * @param yCoord    ycoord for triangle to be drawn at
     * @param name      the name of the triangle
     * @param c         the color of the triangle to be drawn in
     * @param side1     the length of 1st side
     * @param side2     the length of 2nd side
     * @param side3     the length of the 3rd side
     */
    public Triangle(int xCoord, int yCoord, String name, Color c, double side1, double side2, double side3)
    {
        super(xCoord,yCoord, name, c);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    @Override
    /**
     * returns the perimeter of a triangle (side1 + side2 + side3)
     * @return perimeter
     */
    public double getPerimeter()
    {
        return side1 + side2 + side3;
    }
    @Override
    /**
     * returns the area of a triangle
     * @return area
     */
    public double getArea()
    {
        double p = (side1+side2+side3)/2.0;
        double sqrt = (p*(p-side1)*(p-side2)*(p-side3));
        double area = Math.sqrt(sqrt);
        return area;
    }
}
