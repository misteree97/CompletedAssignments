import java.awt.*;

public class Rectangle extends TwoDShape{
    private double side1, side2;
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
