import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class RandomCircle extends JPanel
{
    private int radius = 100; //(int)(Math.random() * 250 + 1);
    public RandomCircle()
    {
        setSize(300, 300);
        //paintComponent(null);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        //int radius = (int)(Math.random() * 250) + 1;
        //int diameter = radius * 2;
        //float red = rand.nextFloat();
       // float green = rand.nextFloat();
       // float blue = rand.nextFloat();
       // Color randomColor = new Color(red, green, blue);

       // graphics.setColor(randomColor);
        //graphics.setColor(Color.BLACK);
        //graphics.drawOval(480, 480, diameter, diameter);
       // super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(0,0, computeDiameter(), computeDiameter());
    }
    public int computeDiameter()
    {
        return radius * 2;
    }
    public int computeArea()
    {
        int area = (int)(Math.PI * Math.sqrt(radius));
        return area;
    }
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
