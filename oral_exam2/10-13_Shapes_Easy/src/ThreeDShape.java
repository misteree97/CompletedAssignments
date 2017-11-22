/**
 * @author Elliot Lohr
 * this abstract provides a template for a shape object
 */
public abstract class ThreeDShape extends Shape {
    /**
     * the dimensions of the shape
     */
    private int dimension1, dimension2, dimension3;

    /**
     * Constructor for threedshape object
     * @param x coord
     * @param y coord
     * @param d1 dimension1 length
     * @param d2 dimension2 length
     * @param d3 dimension3 length
     */
    public ThreeDShape(int x, int y, int d1, int d2, int d3)
    {
        super(x,y);
        this.dimension1 = d1;
        this.dimension2 = d2;
        this.dimension3 = d3;
    }

    /**
     * gets the 1st dimension length
     * @return dimension1
     */
    public int getDimension1()
    {
        return dimension1;
    }

    /**
     * gets the 2nd dimension length
     * @return dimension2
     */
    public int getDimension2()
    {
        return dimension2;
    }

    /**
     * gets the 3rd dimension length
     * @return dimension3
     */
    public int getDimension3()
    {
        return dimension3;
    }

    /**
     * sets the first dimenstion length
     * @param d1 length
     */
    public void setDimension1(int d1)
    {
        this.dimension1 = d1;
    }

    /**
     * sets the second dimension length
     * @param d2 length
     */
    public void setDimension2(int d2)
    {
        this.dimension2 = d2;
    }

    /**
     * sets the third dimension length
     * @param d3 length
     */
    public void setDimension3(int d3)
    {
        this.dimension3 = d3;
    }

    /**
     * abstract that will allow children classes to compute the volume
     * @return
     */
    public abstract int computeVolume();

    /**
     * abstract that will allow children classes to compute the surface area
     * @return
     */
    public abstract int computeSurfaceArea();
}
