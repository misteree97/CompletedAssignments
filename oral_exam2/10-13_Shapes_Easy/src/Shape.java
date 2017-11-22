/**
 * @author Elliot Lohr
 * Provides a blueprint for a shape object
 */
public abstract class Shape {
    /**
     * the x and y coordinates of the shape
     */
    private int x, y;

    /**
     * Constructor for shape object
     * @param x coordinate
     * @param y coordinate
     */
    public Shape(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * get x coordinate
     * @return x
     */
    public int getX()
    {
        return x;
    }

    /**
     * get y coordinate
     * @return y
     */
    public int getY()
    {
        return y;
    }

    /**
     * sets x coordinate
     * @param x
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * sets y coordinate
     * @param y
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * abstract to return name of shape
     * @return name
     */
    public abstract String getName();

    /**
     * abstract to print information about shape
     */
    public abstract void print();

}
