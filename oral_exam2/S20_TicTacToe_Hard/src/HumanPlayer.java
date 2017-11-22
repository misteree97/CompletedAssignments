import java.util.*;
/**
 * @author Elliot Lohr
 * This class extends the player class to create a human player
 */
public class HumanPlayer extends Player {
    Scanner sc = new Scanner(System.in);

    public HumanPlayer(int player)
    {
        super(player);
    }
    @Override
    public void play(Board gameBoard)
    {
        makeMove(gameBoard);
        gameBoard.fillBoardLocation(move, player);

    }
    @Override
    public void makeMove(Board gameBoard)
    {
        int checkValidPositionRow = -1;
        while(checkValidPositionRow != 0 || checkValidPositionRow != 1 || checkValidPositionRow != 2)
        {
            System.out.println("Which row would u like to make a move in? (0, 1, 2)");
            move[0] = sc.nextInt();
            checkValidPositionRow = move[0];
        }
        int checkValidPositionColumn = -1;
        while(checkValidPositionColumn != 0 || checkValidPositionColumn != 1 || checkValidPositionColumn != 2)
        {
            System.out.println("Which column would u like to make a move in? (0, 1, 2)");
            move[1] = sc.nextInt();
            checkValidPositionColumn = move[1];
        }

        if(!checkMove(move, gameBoard))
        {
            System.out.println("Not a valid move, exiting game");
            System.exit(0);
        }
    }

}
