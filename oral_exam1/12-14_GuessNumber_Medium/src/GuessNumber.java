import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumber extends JFrame {
    private int numberToGuess = (int)(Math.random() * 1000)+1;
    private int numberGuessed;
    private int numberOfGuess = 0;
    private Color backColor;
    private JLabel text1, text2, text3;
    private JTextField userGuess;
    private JButton newGame;
    private int ogDifference;
    Container container;

    /**
     * No argument constructor
     */
    public GuessNumber()
    {
        super("Guess Number Game");
        backColor = Color.WHITE;
        container = getContentPane();
        container.setLayout(new FlowLayout());
        container.setBackground(backColor);
        text1 = new JLabel("I have a number between 1-1000. Guess the number!");
        text1.setSize(270,20);
        text1.setLocation(300,35);
        text2 = new JLabel("Enter your first guess: ");
        text2.setSize(270,20);
        text2.setLocation(300,60);
        text3 = new JLabel("Messages will display here");
        text3.setSize(270,20);
        text3.setLocation(300,95);




        userGuess = new JTextField(5);
        userGuess.addActionListener(new inputListener());
        userGuess.setSize(50,30);
        userGuess.setLocation(350,80);

        container.add(text1);
        container.add(text2);
        container.add(text3);
        container.add(userGuess);


        setSize(960, 960);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        container.setBackground(backColor);
    }
    public class inputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            numberGuessed = Integer.parseInt(userGuess.getText());
            displayColor();
        }
    }
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
            difference = Math.abs(numberGuessed - numberToGuess);
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
                text3.setText("Correct! The number was: " + numberToGuess + "\nGuesses taken: " + numberOfGuess);
                backColor = Color.GREEN;
                userGuess.setEditable(false);
                numberOfGuess = 0;
            }
            repaint();
        }

    }

    /**
     * private class ButtonListener implements ActionListener
     {
     public void actionPerformed(ActionEvent e)
     {
     numberOfGuess++;

     int numberGuessed = Integer.parseInt(userGuess.getText());//parseInt takes string and stores integer type in numberGuessed
     int originalDifference = Math.abs(numberGuessed - numberToGuess);
     if(numberGuessed < numberToGuess)
     {
     text3.setText("Number was too low. Try again!");
     setBackground(Color.BLUE);
     }
     else if(numberGuessed > numberToGuess)
     {
     text3.setText("Number was too high. Try again!");
     setBackground(Color.RED);
     }
     else
     {
     text3.setText("Correct! You win!");
     setBackground(Color.GREEN);
     }
     }



     }
     */


}
