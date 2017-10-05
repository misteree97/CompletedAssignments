import javax.swing.*;
import javax.swing.JFrame;

public class GuessNumberTester {
    public static void main(String[] args)
    {
        GuessNumber game = new GuessNumber();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}
