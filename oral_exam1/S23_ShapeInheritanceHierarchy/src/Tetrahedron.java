import java.awt.*;

/**
 * @author Elliot Lohr
 * This program provides a template for a tetrahedron object
 */
public class Tetrahedron extends ThreeDShape {
    /**
     * the length of the sides on a tetrahedron
     */
    private double side;

    /**
     * Constructor for a tetrahedron object
     * @param xCoord    xcoord for tetrahedron to be drawn at
     * @param yCoord    ycoord for tetrahedron to be drawn at
     * @param name      the name of the tetrahedron
     * @param c         the color for the tetrahedron to be drawn in
     * @param side      the length of the sides of the tetrahedron
     */
    public Tetrahedron(int xCoord, int yCoord, String name, Color c, double side)
    {
        super(xCoord,yCoord,name,c);
        this.side = side;
    }

    @Override
    /**
     * returns the volume of the tetrahedron
     * @return volume
     */
    public double getVolume()
    {
        double cubedSide = side * side * side;
        double volume = cubedSide / (6 *Math.sqrt(2));
        return volume;
    }
    @Override
    /**
     * returns the surface area of the tetrahedron
     * @return surface area
     */
    public double getSurfaceArea()
    {
        return Math.sqrt(3) * side * side;
    }
}
