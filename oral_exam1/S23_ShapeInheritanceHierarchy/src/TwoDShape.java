import java.awt.*;

public abstract class TwoDShape extends Shape {
    private double area;

    public TwoDShape(int xCoord, int yCoord, String name, Color c)
    {
        super(xCoord, yCoord, name, c);
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}
