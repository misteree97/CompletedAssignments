import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    Scanner sc = new Scanner(System.in);
    private Board gameBoard;
    private boolean player1Turn = true;


    public Game()
    {
        Board gameBoard = new Board();

        player1 = new HumanPlayer(1);

        System.out.println("Would you like to play against another human(1) or a computer(2)?");
        int secondPlayer = sc.nextInt();

        if(secondPlayer == 1)
        {
            player2 = new HumanPlayer(2);
        }
        if(secondPlayer == 2)
        {
            player2 = new ComputerPlayer(2);
        }
    }
    public boolean playGame()
    {
        gameBoard.printBoard();
        if(gameBoard.catsGame())
        {
            System.out.println("Cats game, program will now exit");
            System.exit(0);
        }

        if(player1Turn)
        {
            System.out.println("It is player X's turn");
            player1.play(gameBoard);
        }
        else
        {
            System.out.println("It is player O's turn");
            player2.play(gameBoard);
        }
    }
    public void whoWon()
    {
        if(gameBoard.checkLineW() == 3)
        {
            System.out.println("Player 1 won!");
            System.exit(0);

        }
        else if(gameBoard.checkLineW() == 6)
        {
            System.out.println("Player 2 won!");
            System.exit(0);
        }
        else if(gameBoard.checkDiagonalW() == 3)
        {
            System.out.println("Player 1 won!");
            System.exit(0);
        }
        else if(gameBoard.checkDiagonalW() == 6)
        {
            System.out.println("Player 2 won");
            System.exit(0);
        }
        else
        {
            System.out.println("Next move");
        }
    }
}
