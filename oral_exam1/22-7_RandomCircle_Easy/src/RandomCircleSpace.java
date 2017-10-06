import javax.swing.*;
import java.awt.*;

/**
 * @author Elliot Lohr
 * Program creates a JFrame that holds components for a random circle generator
 */
public class RandomCircleSpace extends JFrame
{
    /**
     * JTextArea that displays the information about the random circle
     */
    private JTextArea displayStats;

    /**
     * No argument constructor that creates a Jframe and puts a randomCircle Jpanel on it along with a jtextarea that displays information about the circle
     */
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
