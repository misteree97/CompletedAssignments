import java.awt.*;

/**
 * @Author Elliot Lohr
 * This program provides a template for a OneDShape object
 */
public abstract class OneDShape extends Shape {
    private double length;
    public OneDShape(int xCoord, int yCoord, String name, Color c, double length)
    {
        super(xCoord,yCoord,name,c);
        this.length = length;
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

