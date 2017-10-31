public class Sphere extends ThreeDShape {
    public Sphere(int x, int y, int radius)
    {
        super(x, y, radius, radius, radius);
    }
    public void print()
    {
        System.out.println("(" + super.getX() + "," + super.getY() + ") " + "Radius: " + super.getDimension1());
    }
    public int computeVolume()
    {
        int volume = (int)((4/3) * Math.PI * super.getDimension1() * super.getDimension1() * super.getDimension1());
        return volume;
    }
    public int computeSurfaceArea()
    {
        int surfaceArea = (int)(4*Math.PI*super.getDimension1()*super.getDimension1());
        return surfaceArea;
    }
    public String getName()
    {
        return "Sphere";
    }
}
