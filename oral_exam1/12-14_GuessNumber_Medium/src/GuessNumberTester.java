import javax.swing.*;
import javax.swing.JFrame;

/**
 * @author Elliot Lohr
 * This program will test the GuessNumber class
 */
public class GuessNumberTester {
    /**
     * Main method that creates a game object and lets the game run
     * @param args
     */
    public static void main(String[] args)
    {
        GuessNumber game = new GuessNumber();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}
