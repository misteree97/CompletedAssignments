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
    public void setXCoord(int xCoord)
    {
        this.xCoord = xCoord;
    }
    public void setYCoord(int yCoord)
    {
        this.yCoord = yCoord;
    }
    public void setColor(Color c)
    {
        this.shapeColor = c;
    }
    public Color getShapeColor()
    {
        return shapeColor;
    }
    public int getXCoord()
    {
        return xCoord;
    }
    public int getYCoord()
    {
        return yCoord;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

}
