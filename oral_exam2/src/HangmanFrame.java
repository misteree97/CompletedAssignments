import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanFrame extends JFrame {
    private JTextField enterWord;
    private JLabel numGuessLabel;
    private char letterGuessed;
    private String[] wordBank = {"java", "intellij", "casavant", "johnson"};
    private String wordToGuess;
    private int numGuessLeft = 6;
    private JLabel displayAsterik;
    private boolean gameOver = false;
    private Container container;

    public HangmanFrame()
    {
        super("Hangman Game");
        container = getContentPane();
        container.setLayout(new GridLayout());
        container.setBackground(Color.WHITE);


        numGuessLabel = new JLabel("Number of Guesses Left" + numGuessLeft);
        enterWord = new JTextField(1);
        enterWord.addActionListener(new inputListener());
        enterWord.setSize(50,30);
        displayAsterik = new JLabel("");
        startGame();
        //displayHangman():

    }
    public void startGame()
    {
        wordToGuess = wordBank[(int)Math.random() * 3];
    }
    public void displayHangman()
    {

    }

    private class inputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String stringGuess = enterWord.getText();
            letterGuessed = stringGuess.charAt(0);
        }
    }


}
