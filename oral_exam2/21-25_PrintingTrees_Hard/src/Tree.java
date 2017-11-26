/**
 * @author Elliot Lohr/Java Early Objects book
 * This class provides the blueprint for a tree object
 * @param <T>
 */
public class Tree<T extends Comparable<T>>
{
    /**
     * The root of the tree
     */
    private TreeNode<T> root;

    /**
     * Constructor for a tree object
     */
    public Tree()
    {
        root = null;
    }

    private String textAreaText = "";
    /**
     * Inserts a new node into the tree
     * @param insertValue   value to be inserted
     */
    public void insertNode(T insertValue)
    {
        if(root == null)
        {
            root = new TreeNode<T>(insertValue);
        }
        else
        {
            root.insert(insertValue);
        }
    }

    /**
     * gets the root node of the tree
     * @return root node of tree
     */
    public TreeNode<T> getRoot() {
        return root;
    }
    /**
     * sets the rootNode of the tree
     * @param rootNode
     */
    public void setRoot(TreeNode<T> rootNode)
    {
        root = rootNode;
    }
    public void preorderTraversal()
    {
        preorderHelper(root);
    }

    /**
     * Method that outputs binary tree with rootnode on the left of the console window
     * @param totalSpaces
     * @param node
     */
    public void outputTree(int totalSpaces, TreeNode<T> node)
    {
        //if the node isn't null
        if(node!= null)
        {
            outputTree(totalSpaces + 5, node.rightNode); //recursive call to output trees with the next right node
            for(int i = 1; i <= totalSpaces; i++) //prints spaces between each node of tree
            {
                System.out.print(" ");
                textAreaText = textAreaText + " "; //updates spaces for the TreeGui
            }
            System.out.println(node.data);
            textAreaText = textAreaText + (String.valueOf(node.data)); //adds node values to tree gui
            textAreaText = textAreaText + "\n";
            outputTree(totalSpaces + 5, node.leftNode); //recursive call to output tree with the left node
        }
    }




    public String getTextAreaText()
    {
        return textAreaText;
    }
    private void preorderHelper(TreeNode<T> node)
    {
        if(node == null)
        {
            return;
        }
        System.out.printf("%s ", node.data);
        preorderHelper(node.leftNode);
        preorderHelper(node.rightNode);
    }
    public void inorderTraversal()
    {
        inorderHelper(root);
    }
    private void inorderHelper(TreeNode<T> node)
    {
        if(node == null)
        {
            return;
        }
        inorderHelper(node.rightNode);
        System.out.printf("%s ", node.data);
        inorderHelper(node.leftNode);
    }
    public void postorderTraversal()
    {
        postorderHelper(root);
    }
    private void postorderHelper(TreeNode<T> node)
    {
        if(node == null)
        {
            return;
        }
    }
}
