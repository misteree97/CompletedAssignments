public abstract class Player {
    int[] move;
    int player;

    public Player(int player)
    {
        this.player = player;
    }
    public abstract void play(Board gameBoard);
    public abstract void makeMove(Board gameBoard);
    public boolean checkMove(int[] move, Board gameBoard)
    {
        if(gameBoard.getLocation(move) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
