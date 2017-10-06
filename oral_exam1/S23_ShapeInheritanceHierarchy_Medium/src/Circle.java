import java.awt.*;

/**
 * @author Elliot Lohr
 * This program provides a template for a circle object
 */
public class Circle extends TwoDShape {
    /**
     * the radius of the circle
     */
    private double radius;


    /**
     * Constructor for a circle object
     * @param xCoord    the xcoord for circle to be drawn on
     * @param yCoord    the ycoord for the circle to be drawn on
     * @param name      the name of the circle
     * @param c         the color for circle to be drawn in
     * @param radius    the radius of the circle
     */
    public Circle(int xCoord, int yCoord, String name, Color c, double radius)
    {
        super(xCoord, yCoord, name, c);
        this.radius = radius;
    }

    /**
     * computes and returns the area of the circle
     *
     * @return area  the area of the circle
     */
    @Override
    public double getArea()
    {
        double area = Math.PI * radius * radius;
        return area;
    }
    @Override
    /**
     * Calls the getCircumference method to return the perimeter of the circle
     * @return perimeter
     */
    public double getPerimeter()
    {
        return getCircumference();
    }

    /**
     * computes the circumference of the circle object
     * @return circumference  the circumference
     */
    public double getCircumference()
    {
        double circumference = Math.PI * 2 * radius;
        return circumference;
    }
}
