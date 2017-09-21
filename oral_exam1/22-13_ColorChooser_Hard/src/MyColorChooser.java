import javax.swing.*;
import java.awt.*;
import java.util.*;
public class MyColorChooser extends JFrame {
    JSlider redOption, greenOption, blueOption;
    JLabel redLabel, greenLabel, blueLabel;
    JPanel panel = new JPanel();
    JTextField tf = new JTextField(25);

    public MyColorChooser()
    {
        // redOption = new JSlider(0,255, 0);
        // greenOption = new JSlider(0,255,0);
        // blueOption = new JSlider(0,255,0);



        //event e = new event();
        //redOption.addChangeListener(e);
        // greenOption.addChangeListener(e);
        //  blueOption.addChangeListener(e);

        // panel = new JPanel();
        //  panel.setBackground(Color.BLACK);
        setTitle("MyColorChooser");
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.add(tf);
        add(panel);





    }
    public static void main(String[] args)
    {
        MyColorChooser a = new MyColorChooser();
    }
}
