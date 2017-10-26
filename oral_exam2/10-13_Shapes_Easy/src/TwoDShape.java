public abstract class TwoDShape extends Shape {
    private int dimension1, dimension2;

    public TwoDShape(int x, int y, int d1, int d2)
    {
        super(x,y);
        this.dimension1 = d1;
        this.dimension2 = d2;
    }

    public int getDimension1()
    {
        return dimension1;
    }
    public int getDimension2()
    {
        return dimension2;
    }
    public void setDimension1(int d1)
    {
        this.dimension1 = d1;
    }
    public void setDimension2(int d2)
    {
        this.dimension2 = d2;
    }

    public abstract int computeArea();
    public abstract int computePerimeter();
}
