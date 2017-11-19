import java.util.Scanner;

public class MazeTraverse {
    static char maze[][] = {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                            {'#','.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.'},
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
    static Scanner sc = new Scanner(System.in);
    static int move = 0;
    static final int startX = 2;
    static final int startY = 0;

    public boolean mazeTraversal(char maze2[][], int x, int y)
    {
        maze[x][y] = 'X';
        move++;

        printMaze();

        if(mazeExited(x, y) && move > 1)
        {
            System.out.println("Maze has been exited");
        }
        else if(x == startX && y == startY)
        {
            System.out.println("Back at Start");
        }
        else
        {
            System.out.println("Enter 1 to continue or 2 to exit");
            int kontinue = sc.nextInt();
            if(kontinue == 1)
            {
                for(int i = 0; i < 4; i++)
                {
                   if(validMove(x+1, y))
                    {
                        if (mazeTraversal(maze2, x, y + 1))
                        {
                            return true;
                        }
                        else if(validMove(x - 1, y))
                        {
                            if (mazeTraversal(maze2, x - 1, y))
                            {
                                return true;
                            }
                        }
                        else if(validMove(x, y+1))
                        {
                            if(mazeTraversal(maze2, x, y+1))
                            {
                                return true;
                            }
                        }
                        else if(validMove(x, y -1))
                        {
                            if(mazeTraversal(maze2, x, y -1))
                            {
                                return true;
                            }
                        }
                    }
                }
            }
            else if(kontinue == 2)
            {
                System.exit(0);
            }
        }
        maze2[x][y] = '0';
        return false;
    }
    public static boolean validMove(int row, int column)
    {
        if (row >= 0 && row <= 11 && column >= 0 && column <= 11 && maze[row][column] == '.')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void checkTraverse()
    {
        boolean canTraverse = mazeTraversal(maze, startX, startY);
        if(!canTraverse)
        {
            System.out.println("No Path to complete maze");
            System.exit(0);
        }
    }
    public static boolean mazeExited(int row, int column)
    {
        if(row == 0 || row == 11 || column == 0 || column == 11)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void printMaze()
    {
        int x = 5;
        int y = 30;

        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze[i].length; j++)
            {
                if(maze[i][j] == '0')
                {
                    System.out.print(".");
                }
                else
                {
                    System.out.print(" " + maze[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
