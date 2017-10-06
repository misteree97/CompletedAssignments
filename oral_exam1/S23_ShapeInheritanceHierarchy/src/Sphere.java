import java.awt.*;

/**
 * @author Elliot Lohr
 * This program provides a template for a sphere object
 */
public class Sphere extends ThreeDShape {
    /**
     * the radius of the sphere
     */
    private double radius;

    /**
     * Constructor for a sphere object
     * @param xCoord    xcoord for sphere to be drawn at
     * @param yCoord    ycoord for sphere to be drawn at
     * @param name      the name of the sphere
     * @param c         the color for sphere to be drawn in
     * @param radius    the radius of the sphere
     */
    public Sphere(int xCoord, int yCoord, String name, Color c, double radius)
    {
        super(xCoord,yCoord, name, c);
        this.radius = radius;
    }
    @Override
    /**
     * returns the volume of the sphere
     * @return volume of Sphere(4/3* PI * r^3)
     */
    public double getVolume()
    {
        return (4/3)*Math.PI*radius*radius*radius;
    }
    @Override
    /**
     * returns the surface area of the sphere
     * @return surface area of sphere(4* PI * radius^2)
     */
    public double getSurfaceArea()
    {
        return 4 * Math.PI * radius * radius;
    }
}
