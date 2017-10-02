public class Circle extends TwoDShape {
    private int radius;

    public Circle(int xCoord, int yCoord, int radius, String name)
    {
        super(xCoord, yCoord, radius, name);
    }
    public int getArea()
    {
        int area = (int)Math.PI * radius * radius;
        return area;
    }
    public int getCircumference()
    {
        int circumference = (int)Math.PI * 2 * radius;
        return circumference;
    }
}
