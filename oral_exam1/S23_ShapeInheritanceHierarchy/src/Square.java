public class Square extends TwoDShape {
    private int side;

    public Square(int xCoord, int yCoord, String name, int side)
    {
        super(xCoord,yCoord,name);
        this.side = side;
    }

    @Override
    public int getArea() {
        return super.getArea();
    }
    public int getPerimeter()
    {
        return side + side + side + side;
    }
}
