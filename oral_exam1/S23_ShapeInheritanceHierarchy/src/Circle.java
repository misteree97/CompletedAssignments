import java.awt.*;

public class Circle extends TwoDShape {
    private double radius;

    public Circle(int xCoord, int yCoord, String name, Color c, double radius)
    {
        super(xCoord, yCoord, name, c);
        this.radius = radius;
    }
    public double getArea()
    {
        double area = Math.PI * radius * radius;
        return area;
    }
    public double getCircumference()
    {
        double circumference = Math.PI * 2 * radius;
        return circumference;
    }
}
