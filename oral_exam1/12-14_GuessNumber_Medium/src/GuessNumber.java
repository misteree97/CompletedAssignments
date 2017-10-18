import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Elliot Lohr
 */
public class GuessNumber extends JFrame {
    /**
     * The number the user has to guess, initialized to a random number between 1 and 1000
     */
    private int numberToGuess = (int)(Math.random() * 1000)+1;
    /**
     * The number the user guessed
     */
    private int numberGuessed;
    /**
     * The number of guesses the user used
     */
    private int numberOfGuess = 0;
    /**
     * The color of the background of JFrame display
     */
    private Color backColor;
    /**
     * JLabels used to create and display text to user
     */
    private JLabel text1, text2, text3;
    /**
     * JTextField used for the user to input a guess
     */
    private JTextField userGuess;
    /**
     * JButton that user can press to start a new game
     */
    private JButton newGameButton;
    /**
     * The original difference between the users first guess and the actual number
     */
    private int ogDifference;
    /**
     * Container used to hold graphic components
     */
    Container container;
    /**
     * No argument constructor generates game and runs
     */
    public GuessNumber()
    {
        super("Guess Number Game");
        backColor = Color.WHITE;
        container = getContentPane(); //getContentPane calls layer that holds objects on it(https://stackoverflow.com/questions/16744152/java-gui-about-getcontentpane-method-and-content)
        container.setLayout(new FlowLayout());//arranges in directional flow, like lines in a paragraph (https://docs.oracle.com/javase/7/docs/api/java/awt/FlowLayout.html)
        container.setBackground(backColor);
        text1 = new JLabel("I have a number between 1-1000. Guess the number!");
        text1.setSize(270,20);
        text2 = new JLabel("Enter guess here: ");
        text2.setSize(270,20);
        text3 = new JLabel("Messages will display here");
        text3.setSize(270,20);

        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
                GuessNumber newGame = new GuessNumber();
                dispose(); //closes previous window (Learned from StackOverFlow:https://stackoverflow.com/questions/2352727/closing-jframe-with-button-click5)
           }
       });


        userGuess = new JTextField(10);//user input field
        userGuess.addActionListener(new inputListener());
        userGuess.setSize(50,30);


        //adds components to container
        container.add(text1);
        container.add(text2);
        container.add(userGuess);
        container.add(text3);
        container.add(newGameButton);


        setSize(960, 960);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Method that paints the components to the panel and sets background color of panel
     * @param g        graphics class
     */
    public void paint(Graphics g)
    {
        super.paint(g); //paints components on pane
        container.setBackground(backColor);
    }

    /**
     * Creates an inputlistener object that gathers information from the keyboard
     */
    public class inputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            numberGuessed = Integer.parseInt(userGuess.getText()); //parseint takes string and returns as an integer
            displayColor();
        }
    }

    /**
     * Method that determines whether guess was too high or too low and whether guess is warmer or cooler
     * Prints red to screen for warmer, blue for colder
     */
    public void displayColor()
    {
        numberOfGuess++;
        int difference = 1000;//set to 1000 initially because first guess should be no greater than 1000 away from the correct answer

        if(numberOfGuess==1)
        {
            ogDifference = Math.abs(numberToGuess-numberGuessed);
            if(numberGuessed > numberToGuess)
            {
                text3.setText("Guess was too high. Try again!");
            }
            else
            {
                text3.setText("Guess was too low. Try again!");
            }
        }
        else if(numberOfGuess > 1)
        {
            difference = Math.abs(numberGuessed - numberToGuess);//doesn't matter which difference since absolute val
            if(numberGuessed > numberToGuess)
            {
                text3.setText("Guess too high, try a lower number");
                if(difference > ogDifference)
                {
                    backColor = Color.BLUE; //if user guess was farther than the previous guess, display blue to indicate colder
                }
                else if(difference < ogDifference)
                {
                    backColor = Color.RED;//if user guess was closer than the previous guess, display red to indicate warmer
                }
                ogDifference = difference;
            }
            else if(numberGuessed < numberToGuess)
            {
                text3.setText("Guess too low, try a higher number");
                if(difference > ogDifference)
                {
                    backColor = Color.BLUE;
                }
                else if(difference < ogDifference)
                {
                    backColor = Color.RED;
                }
                ogDifference = difference;
            }
            else
            {
                text3.setText("Correct! The number was: " + numberToGuess + " Guesses taken: " + numberOfGuess);
                backColor = Color.GREEN;
                userGuess.setEditable(false);//once user guesses number, can no longer enter new number
                numberOfGuess = 0;
            }
            repaint();
        }

    }
}
