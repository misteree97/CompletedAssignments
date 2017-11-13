import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    private JButton buttons[];
    private JPanel keyPad;
    private JTextField textField;

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
        }

        buttons[10] = new JButton("/");
        buttons[11] = new JButton("*");
        buttons[12] = new JButton("+");
        buttons[13] = new JButton("-");
        buttons[14] = new JButton("=");
        buttons[15] = new JButton(".");

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

    public static void main(String[] args)
    {
        CalculatorGUI calc = new CalculatorGUI();
        calc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
