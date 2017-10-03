import java.awt.*;

public class Square extends TwoDShape {
    private double side;

    public Square(int xCoord, int yCoord, String name, Color c, double side)
    {
        super(xCoord,yCoord, name, c);
        this.side = side;
    }

    @Override
    public double getArea()
    {
        return side * side;
    }
    @Override
    public double getPerimeter()
    {
        return side * 4;
    }
}
