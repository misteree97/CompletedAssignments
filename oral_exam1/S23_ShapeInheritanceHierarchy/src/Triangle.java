public class Triangle extends TwoDShape {
    private double side1;
    private double side2;
    private double side3; 
    public Triangle(int xCoord, int yCoord, int side)
    {
        super(xCoord,yCoord,side,side);
    }
    public int getPerimeter()
    {
        return side + side + side
    }
}
