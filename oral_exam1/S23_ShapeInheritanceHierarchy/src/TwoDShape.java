import java.awt.*;

public abstract class TwoDShape extends Shape {
    private double area;

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
