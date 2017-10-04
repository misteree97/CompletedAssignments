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
        Container container = getContentPane();
        container.setBackground(backColor);
        text1 = new JLabel("I have a number between 1-1000. Guess the number!");
        text1.setSize(270,20);
        text2 = new JLabel("Enter your first guess");
        text2.setSize(270,20);

        userGuess = new JTextField(5);
        //userGuess.addActionListener(new InputHandler());
    }

    public void playerGuess(int userInput)
    {
        numberOfGuess = numberToGuess + 1;


    }

}
