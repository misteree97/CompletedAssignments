import javax.swing.*;
import java.awt.*;
import java.lang.Math;

/**
 * @author Elliot Lohr
 */
public class RandomCircle extends JPanel
{
    private int radius = (int)(Math.random() * 250 + 1);
    public RandomCircle()
    {
        setSize(300, 300);
        //setBackground(Color.BLACK);
    }

    @Override
    /**
     * Paints the circle object on Jpanel
     * @param Graphics g
     */
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawOval(150,150, computeDiameter(), computeDiameter());
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
    public int getRadius()
    {
        return radius;
    }
}
