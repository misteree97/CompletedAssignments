import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Elliot Lohr
 * This class will create a calculator gui that the user can use to compute basic calculations
 */
public class CalculatorGUI extends JFrame {
    /**
     * Array of buttons that contains calculator #s and functions
     */
    private JButton buttons[];
    /**
     * Jpanel that will hold the buttons
     */
    private JPanel keyPad;
    /**
     * Textfield that will display numbers and functions
     */
    private JTextField textField;
    /**
     * integer to track which operation the user wants to use
     */
    private int operation;

    /**
     * A string representation of the answer used to display in JTextField
     */
    private String answer;

    /**
     * Strings used to track the first number entered in calc and the 2nd number entered in calc
     */
    String firstNumString, lastNumString;
    /**
     * Doubles used to apply math operations to the input in the calculator
     */
    double firstDouble, lastDouble;

    /**
     * double used to convert the answer back into a string
     */
    double computation;




    /**
     * Constructor for the calculator GUI
     */
    public CalculatorGUI()
    {
        super("Calculator GUI");
        buttons = new JButton[16];
        String buttonLabel;
        textField = new JTextField(20);


        //creates 1-9 buttons
        for(int i = 0; i <= 9; i++)
        {
            buttonLabel = String.valueOf(i); //learned how to convert int to string from https://stackoverflow.com/questions/4105331/how-do-i-convert-from-int-to-string
            buttons[i] = new JButton(buttonLabel);
            buttons[i].addActionListener(new NumberListener());//adds number listener to num buttons
        }
        //adds operator buttons to button array
        buttons[10] = new JButton("/");
        buttons[11] = new JButton("*");
        buttons[12] = new JButton("+");
        buttons[13] = new JButton("-");
        buttons[14] = new JButton("=");
        buttons[15] = new JButton(".");

        //adds an operator listener to operator buttons
        for(int i = 10; i <=13; i++)
        {
            buttons[i].addActionListener(new OperationListener());
        }
        buttons[14].addActionListener(new EqualsListener()); //adds equals listener to the = button

        keyPad = new JPanel(new GridLayout(4,4));
        //adds 7,8,9, / buttons
        for(int i = 7; i <= 10; i++)
        {
            keyPad.add(buttons[i]);
        }
        //adds 4,5,6 buttons
        for(int i = 4; i <= 6; i++)
        {
            keyPad.add(buttons[i]);
        }
        //adds * button
        keyPad.add(buttons[11]);
        //adds 1,2,3 buttons
        for(int i = 1; i <= 3; i++)
        {
            keyPad.add(buttons[i]);
        }
        //adds - button
        keyPad.add(buttons[13]);
        //adds 0 button
        keyPad.add(buttons[0]);
        //adds .,=,+ buttons
        keyPad.add(buttons[15]);
        keyPad.add(buttons[14]);
        keyPad.add(buttons[12]);


        //creates container for the textfield and keyPad components to be added to
        Container container = getContentPane();
        container.add(textField, BorderLayout.NORTH);
        container.add(keyPad, BorderLayout.CENTER);

        setSize(200,200);
        setVisible(true);
    }

    /**
     * @author Elliot Lohr
     * This class provides the functionality for the number buttons
     */
    private class NumberListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //adds the number to whatever is already in the textfield
            String number = e.getActionCommand();
            textField.setText(textField.getText() + number);
        }
    }

    /**
     * @author Elliot Lohr
     * This class provides the functionality for the operator buttons
     */
    private class OperationListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //retrieves the first number entered and then clears the textfield so next number can be entered
            firstNumString = textField.getText();
            firstDouble = Double.parseDouble(firstNumString);
            textField.setText("");
            String operator = e.getActionCommand(); //returns the operator chosen

            //updates operation so that the answer can be computed and stores the first number entered
            if(operator.equals("/"))
            {
                operation = 1;
            }
            else if(operator.equals("*"))
            {
                operation = 2;
            }
            else if(operator.equals("-"))
            {
                operation = 3;
            }
            else if(operator.equals("+"))
            {
                operation = 4;
            }
        }
    }

    /**
     * @author Elliot Lohr
     * This class provides functionality for the = button
     */
    private class EqualsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //gets the 2nd number entered by user
            lastNumString = textField.getText();
            lastDouble = Double.parseDouble(lastNumString);

            //calls the calc logic functions depending on which operation was chosen
            if(operation == 1)
            {
                computation = divide(firstDouble, lastDouble);
                answer = Double.toString(computation);
                textField.setText(answer);
            }
            else if(operation == 2)
            {
                computation = multiply(firstDouble, lastDouble);
                answer = Double.toString(computation);
                textField.setText(answer);
            }
            else if(operation == 3)
            {
                computation = subtract(firstDouble, lastDouble);
                answer = Double.toString(computation);
                textField.setText(answer);
            }
            else if(operation == 4)
            {
                computation = add(firstDouble, lastDouble);
                answer = Double.toString(computation);
                textField.setText(answer);
            }


        }
    }

    /**
     * Add function
     * @param num1
     * @param num2
     * @return the sum of both #s
     *
     */
    public static double add(double num1, double num2)
    {
        return num1 + num2;
    }

    /**
     * subtract function
     * @param num1
     * @param num2
     * @return the difference of both #s
     */
    public static double subtract(double num1, double num2)
    {
        return num1 - num2;
    }

    /**
     * multiply function
     * @param num1
     * @param num2
     * @return the product of both #s
     */
    public static double multiply(double num1, double num2)
    {
        return num1 * num2;
    }

    /**
     * divide function
     * @param num1
     * @param num2
     * @return the quotient of both #s
     */
    public static double divide(double num1, double num2)
    {
        return num1 / num2;
    }
}
