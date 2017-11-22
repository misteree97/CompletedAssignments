/**
 *@author Elliot Lohr
 * This class extends the player class and creates a computer player
 */
public class ComputerPlayer extends Player {

    public ComputerPlayer(int player)
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
        for(int row = 0; row < 3; row++)
        {
            for(int column = 0; column < 3; column++)
            {
                if(gameBoard[row][column] = 0)
                {
                    //move[row][column] == 3;
                }
            }
        }
    }
}
