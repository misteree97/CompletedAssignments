import java.security.SecureRandom;

public class TreeTester {
    public static void main(String[] args)
    {
        Tree<Integer> tree = new Tree<Integer>();
        SecureRandom randomNumber = new SecureRandom();

        for(int i = 1; i <= 15; i++)
        {
            int value = randomNumber.nextInt(100);
            tree.insertNode(value);
        }
    }
}
