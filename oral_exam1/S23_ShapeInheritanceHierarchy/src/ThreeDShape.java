import java.awt.*;

/**
 * Created by elohr on 10/2/17.
 */
public abstract class ThreeDShape extends Shape{
    private double volume;
    public ThreeDShape(int xCoord, int yCoord, String name, Color c)
    {
        super(xCoord, yCoord, name, c);
    }
    public abstract double getVolume();
    public abstract double getSurfaceArea();
}
