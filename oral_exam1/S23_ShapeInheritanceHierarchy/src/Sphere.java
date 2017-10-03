import java.awt.*;

public class Sphere extends ThreeDShape {
    private double radius;

    public Sphere(int xCoord, int yCoord, String name, Color c, double radius)
    {
        super(xCoord,yCoord, name, c);
        this.radius = radius;
    }
    @Override
    public double getVolume()
    {
        return (4/3)*Math.PI*radius*radius*radius;
    }
    @Override
    public double getSurfaceArea()
    {
        return 4 * Math.PI * radius * radius;
    }
}
