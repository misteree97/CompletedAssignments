public abstract class ThreeDShape extends Shape {
    private int dimension1, dimension2, dimension3;

    public ThreeDShape(int x, int y, int d1, int d2, int d3)
    {
        super(x,y);
        this.dimension1 = d1;
        this.dimension2 = d2;
        this.dimension3 = d3;
    }

    public int getDimension1()
    {
        return dimension1;
    }
    public int getDimension2()
    {
        return dimension2;
    }
    public int getDimension3()
    {
        return dimension3;
    }
    public void setDimension1(int d1)
    {
        this.dimension1 = d1;
    }
    public void setDimension2(int d2)
    {
        this.dimension2 = d2;
    }
    public void setDimension3(int d3)
    {
        this.dimension3 = d3;
    }
    public abstract int computeVolume();
    public abstract int computeSurfaceArea();
}
