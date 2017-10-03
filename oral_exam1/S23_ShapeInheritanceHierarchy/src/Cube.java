import java.awt.*;

public class Cube extends ThreeDShape {
    private double side;

    public Cube(int xCoord, int yCoord, String name, Color c, double side)
    {
        super(xCoord,yCoord,name,c);
        this.side = side;
    }
    @Override
    /** Computes and returns the volume of cube
     * @return volume
     */
    public double getVolume()
    {
        return side * side * side;
    }
    @Override
    /**
     * Computes and returns the surface area of the cube
     * @return surfaceArea
     */
    public double getSurfaceArea()
    {
        double oneSide = side * side;
        return oneSide * 6;
    }
}
