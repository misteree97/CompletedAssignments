import java.util.Scanner;
/**
 * Created by elohr on 11/26/17.
 */
public class HumanPlayer extends Player {
    Scanner sc = new Scanner(System.in);

    public HumanPlayer(int player)
    {
        super(player);
    }

    @Override
    public void makeMove(Board gameBoard)
    {
        System.out.println("which row would you like to place a marker in?");
        move[0] = sc.nextInt();

        System.out.println("which column would you like to place a marker in?");
        move[1] = sc.nextInt();

        if(validMove(move, gameBoard) == -1)
        {
            System.out.println("This spot was already taken bozo");
            System.exit(0);
        }
        else
        {
            gameBoard.setArrayLocation(move, getPlayerNumber());
        }
    }


}
