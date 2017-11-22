/**
 * @author Elliot Lohr
 * This program provides a template for a circle object
 */
public class Circle extends TwoDShape {
    /**
     * The radius of the circle
     */
    private int radius;

    /**
     * Constructor for a circle object
     * @param x
     * @param y
     * @param radius
     */
    public Circle(int x, int y, int radius)
    {
        super(x, y, radius, radius);
    }

    /**
     * returns the name of the circle
     * @return name
     */
    public String getName()
    {
        return "Circle";
    }

    /**
     * Prints the coordinates of the circle and the radius
     */
    public void print()
    {
        System.out.println("(" + super.getX() + "," + super.getY() + ")" + " Radius: " + super.getDimension1());
    }

    /**
     * computes the area of the circle
     * @return the area
     */
    public int computeArea()
    {
        int area = (int)(Math.PI * super.getDimension1() * super.getDimension1());
        return area;
    }

    /**
     * computes the perimeter of the circle
     * @return the perimeter
     */
    public int computePerimeter()
    {
        int perimeter = (int)(Math.PI * 2 * super.getDimension1());
        return perimeter;
    }

    /**
     * Sets the radius of the circle
     * @param radius
     */
    public void setRadius(int radius)
    {
        super.setDimension1(radius);
    }

    /**
     * gets the radius of the circle
     * @return radius
     */
    public int getRadius()
    {
        return super.getDimension1();
    }
}
