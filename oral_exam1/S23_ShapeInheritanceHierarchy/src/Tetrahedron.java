import java.awt.*;

public class Tetrahedron extends ThreeDShape {
    private double side;

    public Tetrahedron(int xCoord, int yCoord, String name, Color c, double side)
    {
        super(xCoord,yCoord,name,c);
        this.side = side;
    }

    @Override
    public double getVolume()
    {
        double cubedSide = side * side * side;
        double volume = cubedSide / (6 *Math.sqrt(2));
        return volume;
    }
    @Override
    public double getSurfaceArea()
    {
        return Math.sqrt(3) * side * side;
    }
}
