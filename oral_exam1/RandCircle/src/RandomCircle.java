import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomCircle extends JFrame {

    public RandomCircle()
    {
        setTitle("Random Circle Generator");
        setSize(960, 960);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void PaintCircle(Graphics graph)
    {
        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        Color randomColor = new Color(red, green, blue);

        graph.setColor(randomColor);
        graph.drawOval(480, 480, 200, 200);
    }
}
