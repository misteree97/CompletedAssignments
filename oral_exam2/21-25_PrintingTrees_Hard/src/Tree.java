public class Tree<T extends Comparable<T>>
{
    private TreeNode<T> root;
    public Tree()
    {
        root = null;
    }
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
    public void preorderTraversal()
    {
        preorderHelper(root);
    }
    public void outputTree(int totalSpaces, TreeNode<T> node)
    {

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
        inorderHelper(node.leftNode);
        System.out.printf("%s ", node.data);
        inorderHelper(node.rightNode);
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
