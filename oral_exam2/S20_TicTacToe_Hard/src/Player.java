/**
 * @author Elliot Lohr
 * This abstract provides a Parent class for ComputerPlayer and HumanPlayer
 */
public abstract class Player {
    /**
     * The players spot in array that they want to make a marking in
     */
    int[] move = new int[2];
    /**
     * Player number used to identify player 1 and 2
     */
    int playerNumber;

    /**
     * Constructor for a Player object
     * @param player    the player #
     */
    public Player(int player)
    {
        playerNumber = player;
    }

    /**
     * Lets player make a move on gameBoard
     * @param gameBoard the tictactoe board
     */
    public abstract void makeMove(Board gameBoard);

    /**
     * Determines whether the move the player wants to make is valid
     * @param move      the row and column player wants to make move
     * @param gameBoard tictactoe board
     * @return          1 if the move is valid, -1 otherwise
     */
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

    /**
     * Gets the player #
     * @return playerNumber
     */
    public int getPlayerNumber()
    {
        return playerNumber;
    }

}
