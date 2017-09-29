import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomCircle extends JFrame
{
    private JTextArea displayStats;
    public RandomCircle()
    {
        displayStats = new JTextArea()
        setTitle("Random Circle Generator");
        setSize(960, 960);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void paintCircle(Graphics graphics)
    {
        Random rand = new Random();
        int radius = rand.nextInt() * 50  + 1;
        int diameter = radius * 2;
        //float red = rand.nextFloat();
       // float green = rand.nextFloat();
       // float blue = rand.nextFloat();
       // Color randomColor = new Color(red, green, blue);

       // graphics.setColor(randomColor);
        graphics.drawOval(480, 480, diameter, diameter);
    }
}
