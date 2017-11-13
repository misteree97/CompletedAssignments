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

        for(int i = 0; i <= 9; i++)
        {
            buttonLabel = String.valueOf(i); //
            buttons[i] = new JButton(buttonLabel);
        }

        buttons[10] = new JButton("/");
        buttons[11] = new JButton("*");
        buttons[12] = new JButton("+");
        buttons[13] = new JButton("-");
        buttons[14] = new JButton("=");
        buttons[15] = new JButton(".");

        keyPad = new JPanel(new GridLayout(4,4));

        for(int i = 7; i <= 10; i++)
        {
            keyPad.add(buttons[i]);
        }
        for(int i = 4; i <= 6; i++)
        {
            keyPad.add(buttons[i]);
        }
        keyPad.add(buttons[11]);

        for(int i = 1; i <= 3; i++)
        {
            keyPad.add(buttons[i]);
        }

        keyPad.add(buttons[13]);
        keyPad.add(buttons[0]);

        keyPad.add(buttons[15]);
        keyPad.add(buttons[14]);
        keyPad.add(buttons[12]);

    }
}
