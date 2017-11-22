/**
 * @author Elliot Lohr
 * provides a blueprint for a square object
 */
public class Square extends TwoDShape {
    /**
     * constructor for a square object
     * @param x coord
     * @param y coord
     * @param side sidelength
     */
    public Square(int x, int y, int side)
    {
        super(x,y,side,side);
    }

    /**
     * prints the information of the square
     */
    public void print()
    {
        System.out.println("(" + super.getX() + "," + super.getY() + ") " + "Side Length: " + super.getDimension1());
    }

    /**
     * returns the name of the square
     * @return name
     */
    public String getName()
    {
        return "Square";
    }

    /**
     * computes the area of the square
     * @return area
     */
    public int computeArea()
    {
        int area = super.getDimension1() * super.getDimension2();
        return area;
    }

    /**
     * computes the perimeter of the square
     * @return perimeter
     */
    public int computePerimeter()
    {
        int perimeter = super.getDimension1() + super.getDimension1() + super.getDimension2() + super.getDimension2();
        return perimeter;
    }

    /**
     * sets the side length of square
     * @param side
     */
    public void setSide(int side)
    {
        super.setDimension1(side);
        super.setDimension2(side);
    }

    /**
     * returns the sidelength ofs quare
     * @return sidelength
     */
    public int getSide()
    {
        return super.getDimension1();
    }
}
