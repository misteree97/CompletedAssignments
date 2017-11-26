import java.util.Scanner;

public class MazeTraverse {
    /**
     * 2D array of characters that represents the maze to be traversed through
     */
    char maze[][] =         {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                            {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
                            {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
                            {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
                            {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.'},
                            {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                            {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                            {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
                            {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
                            {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
                            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}} ;
    /**
     * Scanner used to input what the user wants to do with the maze
     */
    Scanner sc = new Scanner(System.in);
    /**
     * integer used to track how many moves through the maze have been made
     */
    int move = 0;
    /**
     * integer that keeps track of which row of the maze the starting location is at
     */
    int startX = 2;
    /**
     * integer that keeps track of which column of the maze the starting location is at
     */
    int startY = 0;

    /**
     * Method that checks whether the next move in the maze can be made
     * @param mazeCopy
     * @param x
     * @param y
     * @return whether the maze can be traversed
     */
    public boolean mazeTraversal(char mazeCopy[][], int x, int y)
    {
        mazeCopy[x][y] = 'X';
        //updates # of moves
        move++;

        printMaze();
        //System.out.println("Maze should be printed");
        if(mazeExited(x, y) && move > 1)
        {
            System.out.println("Maze has been exited");
            System.out.println("Total moves taken: " + move);
            System.exit(0);
        }
        else if(x == startX && y == startY && move >1) //if the current location is = to the starting location
        {
            System.out.println("Back at Start");
        }
        else //continues to move through maze if it hasn't been exited or back at the start
        {
            System.out.println("Enter 1 to continue or 2 to exit");
            int kontinue = sc.nextInt();
            if(kontinue == 1)
            {
                   if(validMove(x, y+1)) //determines whether the player can move right
                   {
                       if(mazeTraversal(mazeCopy, x, y+1))  //received help from SWD office hours  with calling method recursively
                       {
                           return true;
                       }
                   }
                   else if(validMove(x+1, y)) //determines whether the player can move down
                   {
                       if(mazeTraversal(mazeCopy, x+1, y))
                       {
                           return true;
                       }
                   }
                   else if(validMove(x - 1, y)) //determines whether the player can move up
                   {
                       if (mazeTraversal(mazeCopy, x - 1, y))
                       {
                           return true;
                       }
                   }
                   else if(validMove(x, y -1)) //determines where the player can move left
                   {
                       if(mazeTraversal(mazeCopy, x, y -1))
                       {
                           return true;
                       }
                   }
                   else //if no moves are valid, switch the spot to a 0 to mark it as a spot that has already been traversed over
                   {
                       mazeCopy[x][y] = '0';
                   }
            }
            if(kontinue == 2) //if the user wants to exit the program exit
            {
                System.exit(0);
            }
        }
        return false;
    }

    /**
     * Method that determines whether the next move is valid before doing it
     * @param row the row
     * @param column the column
     * @return boolean
     */
    public boolean validMove(int row, int column)
    {
        if (row >= 0 && row <= 11 && column >= 0 && column <= 11 && maze[row][column] == '.') //if the move is within the maze and the char at the spot in the maze is a '.', return true
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * method that is called by tester class to start maze traversal
     */
    public void traverseMaze()
    {
        //calls the mazeTraversal method
        boolean canTraverse = mazeTraversal(maze, startX, startY);
        //if the maze can't be traversed, exit program and tell user maze can't be completed
        if(!canTraverse)
        {
            System.out.println("No Path to complete maze");
            System.exit(0);
        }
    }

    /**
     * method determines whether the maze has been exited
     * @param row       the row the cursor is in
     * @param column    the column the cursor is in
     * @return          true if the cursor is at the exit spot of the maze
     */
    public boolean mazeExited(int row, int column)
    {
        if(row == 4 && column == 11) //if the player makes it to the exit of the maze
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Method that prints the maze
     */
    public void printMaze()
    {

        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze[i].length; j++)
            {
                if(maze[i][j] == '0')
                {
                    System.out.print("0");
                }
                else
                {
                    System.out.print(" " + maze[i][j]);
                }
            }
            System.out.println();
        }
    }
}
