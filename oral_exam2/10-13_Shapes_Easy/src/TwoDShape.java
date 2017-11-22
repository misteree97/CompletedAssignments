/**
 * @author Elliot Lohr
 * This class will provide a blueprint for a twodshape object
 */
public abstract class TwoDShape extends Shape {
    /**
     * the side lengths of the twodshape
     */
    private int dimension1, dimension2;

    /**
     * Constructor for a twodshape object
     * @param x coord
     * @param y coord
     * @param d1 length
     * @param d2 length
     */
    public TwoDShape(int x, int y, int d1, int d2)
    {
        super(x,y);
        this.dimension1 = d1;
        this.dimension2 = d2;
    }

    /**
     * Gets the length of the first dimension
     * @return dimension1
     */
    public int getDimension1()
    {
        return dimension1;
    }

    /**
     * Gets the length of the second dimension
     * @return dimension2
     */
    public int getDimension2()
    {
        return dimension2;
    }

    /**
     * sets the length of the first dimension
     * @param d1
     */
    public void setDimension1(int d1)
    {
        this.dimension1 = d1;
    }

    /**
     * Sets the length of the second dimension
     * @param d2
     */
    public void setDimension2(int d2)
    {
        this.dimension2 = d2;
    }

    /**
     * abstract that will allow children class to compute area
     * @return
     */
    public abstract int computeArea();

    /**
     * abstract that will allow children class to compute perimeter
     * @return
     */
    public abstract int computePerimeter();
}
