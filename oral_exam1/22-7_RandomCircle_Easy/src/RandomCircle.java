import javax.swing.*;
import java.awt.*;
import java.lang.Math;

/**
 * @author Elliot Lohr
 * Program that displays a circle of random radius and computes the area and circumference and displays in jframe
 */
public class RandomCircle extends JPanel
{
    /**
     * The radius, initialized to a random number between 1-250
     */
    private int radius = (int)(Math.random() * 250 + 1);

    /**
     * No argument constructor for a RandomCircle object
     */
    public RandomCircle()
    {
        setSize(300, 300);
    }

    @Override
    /**
     * Paints the circle object on Jpanel
     * @param Graphics g
     */
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawOval(150,150, computeDiameter(), computeDiameter());//drawOval draws using the diameter as opposed to radius
    }
    /**
     * computes and returns the diameter (radius*2)
     * @return diameter
     */
    public int computeDiameter()
    {
        return radius * 2;
    }

    /**
     * computes the area of the circle(PI * radius^2)
     * @return area
     */
    public int computeArea()
    {
        int area = (int)(Math.PI * radius * radius);
        return area;
    }

    /**
     * computes the circumference of the circle
     * @return
     */
    public int computeCircumference()
    {
        int circumference = (int)(2*Math.PI*radius);
        return circumference;
    }

    /**
     * returns the radius of the circle
     * @return radius
     */
    public int getRadius()
    {
        return radius;
    }
}
