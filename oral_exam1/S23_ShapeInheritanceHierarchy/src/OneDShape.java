import java.awt.*;

public abstract class OneDShape extends Shape {
    private double length;
    public OneDShape(int xCoord, int yCoord, String name, Color c)
    {
        super(xCoord,yCoord,name,c);
    }

    /**
     * sets the length variable to a new value
     * @param length
     */
    public void setLength(double length)
    {
        this.length = length;
    }

    /**
     * returns the length of the object
     * @return length
     */
    public double getLength()
    {
        return length;
    }
}

