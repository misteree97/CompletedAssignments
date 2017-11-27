/**
 * Created by elohr on 11/26/17.
 */
public abstract class Player {
    int[] move;
    int playerNumber;

    public Player(int player)
    {
        playerNumber = player;
    }

    public abstract void makeMove(Board gameBoard);

    public int validMove(int[] move, Board gameBoard)
    {
        if(gameBoard.getBoardLocation(move) == 0)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

}
