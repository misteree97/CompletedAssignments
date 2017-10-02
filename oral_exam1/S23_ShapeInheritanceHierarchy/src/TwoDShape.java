import java.awt.*;

public abstract class TwoDShape extends Shape {
    private double area;

    public TwoDShape(int xCoord, int yCoord, String name, Color c)
    {
        super(xCoord, yCoord, name, c);
    }
    public double getArea()
    {
        return 0.0;
    }
    public double getPerimeter()
    {
        return 0.0;
    }
}
