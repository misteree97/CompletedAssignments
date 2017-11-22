import javax.swing.*;

/**
 * @author Elliot Lohr
 * This class will provide
 */
public class TreeFrame extends JFrame {
    private JPanel treePanel;
    private JTextArea textArea = new JTextArea() ;


    public TreeFrame(String tree)
    {
        super("Tree Frame");

        textArea.setText(tree);
        add(textArea);

        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
