import java.security.SecureRandom;

/**
 * @author Elliot Lohr
 * This program tests the tree class
 */
public class TreeTester {
    public static void main(String[] args)
    {
        Tree<Integer> tree = new Tree<Integer>();
        SecureRandom randomNumber = new SecureRandom();

        System.out.println("Inserting the following values: \n");

        for(int i = 1; i <= 10; i++)
        {
            int value = randomNumber.nextInt(100);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

      // System.out.printf("%n%nPreorder Traversal%n");
      //  tree.preorderTraversal();;

       // System.out.printf("%n%nPostorder Traversal%n");
       // tree.postorderTraversal();

        //System.out.printf("%n%nInorder Traversal%n");
        //tree.postorderTraversal();


        tree.outputTree(0, tree.getRoot());
        //System.out.print(tree.getTextAreaText());
        TreeFrame gui = new TreeFrame(tree.getTextAreaText());
        gui.setVisible(true);
    }
}
