import java.awt.*;

public class Square extends TwoDShape {
    private double side;

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
