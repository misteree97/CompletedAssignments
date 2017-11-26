import javax.swing.*;

/**
 * @author Elliot Lohr
 * This program will create the template for a TreeGui which prints out the tree to a window
 */
public class TreeFrame extends JFrame {
    /**
     * textArea that will store the tree String that can be added to the frame
     */
    private JTextArea textArea = new JTextArea() ;


    /**
     * Constructor for a TreeFrame Object
     * @param tree  tree in String form to be displayed
     */
    public TreeFrame(String tree)
    {
        super("Tree Frame");

        textArea.setText(tree);
        //adds the tree to the frame
        add(textArea);

        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
