public abstract class Shape {
    private int xCoord;
    private int yCoord;
    private String name;

    public Shape(int xCoord, int yCoord, String name)
    {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.name = name;
    }
    public void setXCoord(int xCoord)
    {
        this.xCoord = xCoord;
    }
    public void setYCoord(int yCoord)
    {
        this.yCoord = yCoord;
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
