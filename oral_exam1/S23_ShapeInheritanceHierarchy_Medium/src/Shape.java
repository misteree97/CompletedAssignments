import java.awt.*;

/**
 * @author Elliot Lohr
 * This program provides a template for a shape object
 */
public abstract class Shape {
    /**
     * the xcoord for shape to be drawn at
     */
    private int xCoord;
    /**
     * the ycoord for shape to be drawn at
     */
    private int yCoord;
    /**
     * the name of the shape
     */
    private String name;
    /**
     * the color for shape to be drawn in
     */
    private Color shapeColor;

    /**
     * Constructor for Shape object
     * @param xCoord    the xcoord for shape to be drawn at
     * @param yCoord    the ycoord for shape to be drawn at
     * @param name      the name of the shape
     * @param shapeColor the color of shape to be drawn in
     */
    public Shape(int xCoord, int yCoord, String name, Color shapeColor)
    {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.name = name;
        this.shapeColor = shapeColor;
    }

    /**
     * sets the xCoord of shape
     * @param xCoord
     */
    public void setXCoord(int xCoord)
    {
        this.xCoord = xCoord;
    }

    /**
     * sets the yCoord of the shape
     * @param yCoord
     */
    public void setYCoord(int yCoord)
    {
        this.yCoord = yCoord;
    }

    /**
     * sets the color of the shape
     * @param c
     */
    public void setColor(Color c)
    {
        this.shapeColor = c;
    }

    /**
     * returns the color of the shape
     * @return shapeColor
     */
    public Color getColor()
    {
        return shapeColor;
    }

    /**
     * returns the xCoord of the shape
     * @return xCoord
     */
    public int getXCoord()
    {
        return xCoord;
    }

    /**
     * returns an the yCoord of the shape
     * @return yCoord
     */
    public int getYCoord()
    {
        return yCoord;
    }

    /**
     * sets the name of the shape to a new String variable
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * returns the name of the shape
     * @return name
     */
    public String getName()
    {
        return name;
    }

}
