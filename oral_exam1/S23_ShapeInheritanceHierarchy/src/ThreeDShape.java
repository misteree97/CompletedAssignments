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

    /**
     * Abstract for children classes to have a getVolume method
     * @return double
     */
    public abstract double getVolume();

    /**
     * abstract for children classes to have a getSurfaceArea method
     * @return double
     */
    public abstract double getSurfaceArea();
}
