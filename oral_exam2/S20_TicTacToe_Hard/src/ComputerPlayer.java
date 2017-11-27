/**
 * @author Elliot Lohr
 * This class provides functionality for the ComputerPlayer
 */
public class ComputerPlayer extends Player {
    /**
     * Constructor for ComputerPlayer object
     * @param player    Player # (1 or 2)
     */
    public ComputerPlayer(int player)
    {
        super(player);
    }

    /**
     * Simple Computer Player that makes move going left to right through board
     * @param gameBoard
     */
    @Override
    public void makeMove(Board gameBoard)
    {
        //sometimes works sometimes doesn't
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
