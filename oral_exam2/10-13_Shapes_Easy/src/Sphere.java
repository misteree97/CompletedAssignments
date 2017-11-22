/**
 * @author Elliot Lohr
 * This class provides a blueprint for a sphere object
 */
public class Sphere extends ThreeDShape {
    /**
     * constructor for sphere object
     * @param x coord
     * @param y coord
     * @param radius the radius
     */
    public Sphere(int x, int y, int radius)
    {
        super(x, y, radius, radius, radius);
    }

    /**
     * prints information about the sphere
     */
    public void print()
    {
        System.out.println("(" + super.getX() + "," + super.getY() + ") " + "Radius: " + super.getDimension1());
    }

    /**
     * computes the volume of sphere
     * @return volume
     */
    public int computeVolume()
    {
        int volume = (int)((4/3) * Math.PI * super.getDimension1() * super.getDimension1() * super.getDimension1());
        return volume;
    }

    /**
     * computes the surface area of sphere
     * @return surface area
     */
    public int computeSurfaceArea()
    {
        int surfaceArea = (int)(4*Math.PI*super.getDimension1()*super.getDimension1());
        return surfaceArea;
    }

    /**
     * returns the name of the sphere
     * @return name
     */
    public String getName()
    {
        return "Sphere";
    }
}
