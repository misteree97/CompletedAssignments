public class Circle extends TwoDShape {
    private int radius;

    public Circle(int x, int y, int radius)
    {
        super(x, y, radius, radius);
    }

    public String getName()
    {
        return "Circle";
    }
    public void print()
    {
        System.out.println("(" + super.getX() + "," + super.getY() + ")" + " Radius: " + super.getDimension1());
    }
    public int computeArea()
    {
        int area = (int)(Math.PI * super.getDimension1() * super.getDimension1());
        return area;
    }
    public int computePerimeter()
    {
        int perimeter = (int)(Math.PI * 2 * super.getDimension1());
        return perimeter;
    }
    public void setRadius(int radius)
    {
        super.setDimension1(radius);
    }
    public int getRadius()
    {
        return super.getDimension1();
    }
}
