import javax.swing.*;
import java.awt.*;

public class RandomCircleSpace extends JFrame
{
    private JTextArea displayStats;
    public RandomCircleSpace()
    {
        super("Random Circle Generator");
        RandomCircle ranCircle = new RandomCircle();
        displayStats = new JTextArea(15, 30);
        displayStats.setText("Radius: " + ranCircle.getRadius() + "\nDiameter: " + ranCircle.computeDiameter() + "\n Area: " + ranCircle.computeArea() + "\n Cicumference: " + ranCircle.computeCircumference());
        displayStats.setEditable(false);
        Container display = new Container();
        display.add(ranCircle, BorderLayout.SOUTH);
        display.add(displayStats, BorderLayout.NORTH);
        display.setVisible(true);

    }
}
