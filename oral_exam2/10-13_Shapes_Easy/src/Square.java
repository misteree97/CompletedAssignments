public class Square extends TwoDShape {

    public Square(int x, int y, int side)
    {
        super(x,y,side,side);
    }
    public void print()
    {
        System.out.println("(" + super.getX() + "," + super.getY() + ") " + "Side Length: " + super.getDimension1());
    }
    public String getName()
    {
        return "Square";
    }
    public int computeArea()
    {
        int area = super.getDimension1() * super.getDimension2();
        return area;
    }
    public int computePerimeter()
    {
        int perimeter = super.getDimension1() + super.getDimension1() + super.getDimension2() + super.getDimension2();
        return perimeter;
    }
    public void setSide(int side)
    {
        super.setDimension1(side);
        super.setDimension2(side);
    }
    public int getSide()
    {
        return super.getDimension1();
    }
}
