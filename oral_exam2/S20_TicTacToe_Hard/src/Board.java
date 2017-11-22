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
    public static void main(String [] args)
    {
        Board board = new Board();
        board.printBoard();
    }

    public void printBoard()
    {
        for(int row = 0; row < 3; row++)
        {
            for(int column = 0; column < 3; column++)
            {
                if(board[row][column] == 0)
                {
                    System.out.print(" ");
                }
                else if(board[row][column] == 1)
                {
                    System.out.print("X");
                }
                else if(board[row][column] == 2)
                {
                    System.out.print("O");
                }
            }
            System.out.println("____________");
        }
    }

    public int checkLineW()
    {
        for(int row = 0; row < 3; row++)
        {
            if(board[row][0] + board[row][1] + board[row][2] == 3)
            {
                return 3;
            }
            if(board[row][0] + board[row][1] + board[row][3] == 6)
            {
                return 6;
            }
        }
        for(int column = 0; column < 3; column++)
        {
            if(board[0][column] + board[1][column] + board[2][column] == 3)
            {
                return 3;
            }
            if(board[0][column] + board[1][column] + board[2][column] == 6)
            {
                return 6;
            }
        }
        return 0;
    }
    public int checkDiagonalW()
    {
        if(board[0][0] + board[1][1] + board[2][2] == 3)
        {
            return 3;
        }
        if(board[0][0] + board[1][1] + board[2][2] == 6)
        {
            return 6;
        }
        if(board[3][0] + board[1][1] + board[0][2] == 3)
        {
            return 3;
        }
        if(board[3][0] + board[1][1] + board[0][2] == 6)
        {
            return 6;
        }
        return 0;
    }
    public void fillBoardLocation(int move[], int player)
    {
        if(player == 1)
        {
            board[move[0]][move[1]] = 1;
        }
        if(player == 2)
        {
            board[move[0]][move[1]] = 3;
        }
    }
    public int getBoardLocation(int[] move)
    {
        if(board[move[0]][move[1]] == 1)
        {
            return 1;
        }
        else if(board[move[0]][move[1]] == 3)
        {
            return 3;
        }
        else
        {
            return 0;
        }
    }
    public boolean catsGame()
    {
        for(int row = 0; row < 3; row++)
        {
            for(int column = 0; column < 3; column++)
            {
                if(board[row][column] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

}
