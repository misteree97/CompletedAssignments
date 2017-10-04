import javax.swing.*;
import java.awt.*;

public class GuessNumber extends JFrame {
    private int numberToGuess = (int)(Math.random() * 1000)+1;
    private int numberOfGuess = 0;
    private Color backColor;
    private JLabel text1, text2;
    private JTextField userGuess;

    public GuessNumber()
    {
        super("Guess Number Game");
        backColor = Color.WHITE;
        text1 = new JLabel("I have a number between 1-1000. Guess the number!");
        text2 = new JLabel("Enter your first guess");

        userGuess = new JTextField()
    }

    public void playerGuess(int userInput)
    {
        numberOfGuess = numberToGuess + 1;


    }

}
