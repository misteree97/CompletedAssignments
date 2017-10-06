import javax.swing.*;
import java.awt.*;

/**
 * @Author Elliot Lohr
 */
public class RandomCircleSpace extends JFrame
{
    private JTextArea displayStats;
    public RandomCircleSpace()
    {
        super("Random Circle Generator");
        RandomCircle ranCircle = new RandomCircle();
        displayStats = new JTextArea(1, 1);
        displayStats.setText("Radius: " + ranCircle.getRadius() + "\nDiameter: " + ranCircle.computeDiameter() + "\n Area: " + ranCircle.computeArea() + "\n Cicumference: " + ranCircle.computeCircumference());
        displayStats.setEditable(false);
        add(ranCircle);
        add(displayStats, BorderLayout.SOUTH);//adds jtextarea to south position on frame
        setVisible(true);

    }
}
