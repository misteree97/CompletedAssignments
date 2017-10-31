public class Cube extends ThreeDShape {

    public Cube(int x, int y, int side)
    {
        super(x,y,side,side,side);
    }

    public void print()
    {
        System.out.print("(" + super.getX() + "," + super.getY() + ") " + "Side Length: " + super.getDimension1());
    }
    public int computeVolume()
    {
        return (super.getDimension1() * super.getDimension1() * super.getDimension1());
    }
    public int computeSurfaceArea()
    {
        return (super.getDimension1() * super.getDimension1() * 6);
    }
    public String getName()
    {
        return "Cube";
    }
}
