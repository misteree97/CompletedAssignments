/**
 * Created by elohr on 11/26/17.
 */
public class ComputerPlayer extends Player {
    public ComputerPlayer(int player)
    {
        super(player);
    }
    @Override
    public void makeMove(Board gameBoard)
    {
        for(int row = 0; row < 3; row++)
        {
            move[0] = row;
            for(int column = 0; column < 3; column++)
            {
                move[1] = column;
                if(validMove(move, gameBoard) == 1)
                {
                    gameBoard.setArrayLocation(move, getPlayerNumber());
                    break;
                }
            }
            break;
        }
    }
}
