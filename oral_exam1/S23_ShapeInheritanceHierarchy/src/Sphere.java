import java.awt.*;

public class Sphere extends ThreeDShape {
    private double radius;

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
