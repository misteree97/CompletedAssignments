import java.util.Scanner;

public class MazeTraverse {
    static char maze[][];
    static Scanner sc = new Scanner(System.in);
    static int move = 0;

    public boolean mazeTraversal(char maze2[][], int x, int y)
    {
        maze[x][y] = 'X';
        move++;

        printMaze();
    }
    public void traverse()
    {

    }
    public void printMaze()
    {
        int x = 5;
        int y = 30;

        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze[i].length; j++)
            {
                if(maze[i][j] == "0")
                {
                    System.out.print(".");
                }
                else
                {
                    System.out.print(" " + maze[i][j]);
                }
                System.out.println(); 
            }
        }
    }
}
