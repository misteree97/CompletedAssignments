import java.awt.*;

public abstract class Shape {
    private int xCoord;
    private int yCoord;
    private String name;
    private Color shapeColor;


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
    public Color getShapeColor()
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
