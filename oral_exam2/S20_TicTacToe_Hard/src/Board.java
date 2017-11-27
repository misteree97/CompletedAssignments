/**
 * Created by elohr on 11/26/17.
 */
public class Board {
    /**
     * 2d array used to create rows and columns of a tic tac toe board
     */
    private int[][] board;

    public Board()
    {
        board = new int[3][3];
        //sets up an empty game board
        for(int row = 0; row < 3; row++)
        {
            for(int column = 0; column < 3; column++)
            {
                board[row][column] = 0;
            }
        }
    }

    public void printBoard()
    {
        for(int row = 0; row < 3; row++)
        {
            for(int column = 0; column < 3; column++)
            {
                if(board[row][column] == 0)
                {
                    System.out.print(" _ ");
                }
                else if(board[row][column] == 1)
                {
                    System.out.print("X");
                }
                else if(board[row][column] == -1)
                {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }
    public int checkWin()
    {
        //Checks to see if a player has one with a horizontal row of X's/O;s
        for(int row = 0; row < 3; row++)
        {
            if(board[row][0] + board[row][1] + board[row][2] == 3)
            {
                return 1;
            }
            else if(board[row][0] + board[row][1] + board[row][3] == -3)
            {
                return -1;
            }
        }
        //Checks to see if a player has one with a vertical row of X's/O's
        for(int column = 0; column < 3; column++)
        {
            if(board[0][column] + board[1][column] + board[2][column] == 3)
            {
                return 1;
            }
            if(board[0][column] + board[1][column] + board[2][column] == -3)
            {
                return -1;
            }
        }
        //if statements check whether player has won on a diagonal
        if(board[0][0] + board[1][1] + board[2][2] == 3)
        {
            return 1;
        }
        if(board[0][0] + board[1][1] + board[2][2] == 6)
        {
            return -1;
        }
        if(board[3][0] + board[1][1] + board[0][2] == 3)
        {
            return 1;
        }
        if(board[3][0] + board[1][1] + board[0][2] == 6)
        {
            return -1;
        }
        return 0;
    }
    public void setArrayLocation(int move[], int player)
    {
        if(player == 1)
        {
            board[move[0]][move[1]] = 1;
        }
        if(player == -1)
        {
            board[move[0]][move[1]] = -1;
        }
    }
    public int getBoardLocation(int[] location)
    {
        if(board[location[0]][location[1]] == 1)
        {
            return 1;
        }
        else if(board[location[0]][location[1]] == -1)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    public int catsGame()
    {
        //if there is a spot that hasn't been filled yet return -1, game can still be played
        for(int row = 0; row < 3; row++)
        {
            for(int column = 0; column < 3; column++)
            {
                if(board[row][column] == 0)
                {
                    return -1;
                }
            }
        }
        //if there are no empty spots left on board return 1
        return 1;
    }

    public static void main(String[] args)
    {
        Board newBoard = new Board();
        newBoard.printBoard();
    }
}
