import javax.swing.*;

/**
 * @author Elliot Lohr
 * This class will test the RandomCircle and RandomCircleSpace classes
 */
public class RandomCircleDriver {
    /**
     * Main method that runs the developed classes
     * @param args
     */
    public static void main(String[] args)
    {
        RandomCircleSpace run = new RandomCircleSpace();
        run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        run.setSize(960,960);
        run.setVisible(true);
    }
}
