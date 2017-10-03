import java.awt.*;

public class Triangle extends TwoDShape {
    private double side1;
    private double side2;
    private double side3; 
    public Triangle(int xCoord, int yCoord, String name, Color c, double side1, double side2, double side3)
    {
        super(xCoord,yCoord, name, c);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    @Override
    public double getPerimeter()
    {
        return side1 + side2 + side3;
    }
    @Override
    public double getArea()
    {
        double p = (side1+side2+side3)/2.0;
        double sqrt = (p*(p-side1)*(p-side2)*(p-side3));
        double area = Math.sqrt(sqrt);
        return area;
    }
}
