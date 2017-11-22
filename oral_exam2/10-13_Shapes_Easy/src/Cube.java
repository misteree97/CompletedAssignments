/**
 * @author Elliot Lohr
 * This class provides a blueprint for a cube object
 */
public class Cube extends ThreeDShape {

    /**
     * Constructor for cube
     * @param x
     * @param y
     * @param side
     */
    public Cube(int x, int y, int side)
    {
        super(x,y,side,side,side);
    }

    /**
     * prints the coordinates of the cube and the side length
     */
    public void print()
    {
        System.out.print("(" + super.getX() + "," + super.getY() + ") " + "Side Length: " + super.getDimension1());
    }

    /**
     * computes the volume of the cube
     * @return volume
     */
    public int computeVolume()
    {
        return (super.getDimension1() * super.getDimension1() * super.getDimension1());
    }

    /**
     * computes the surface area of the cube
     * @return the surface area
     */
    public int computeSurfaceArea()
    {
        return (super.getDimension1() * super.getDimension1() * 6);
    }

    /**
     * returns the name of the cube
     * @return name
     */
    public String getName()
    {
        return "Cube";
    }
}
