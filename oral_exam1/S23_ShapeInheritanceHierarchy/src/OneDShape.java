import java.awt.*;

public abstract class OneDShape extends Shape {
    private double length;
    public OneDShape(int xCoord, int yCoord, String name, Color c)
    {
        super(xCoord,yCoord,name,c);
    }
    public void setLength(double length)
    {
        this.length = length;
    }
    public double getLength()
    {
        return length;
    }
}

