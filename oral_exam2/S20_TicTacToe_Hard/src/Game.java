import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    Scanner sc = new Scanner(System.in);
    private Board gameBoard;
    private int whosTurn =1;


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
    public boolean PlayGame()
    {
        gameBoard.printBoard();

        if(!Won())
        {
            System.out.println("It's player" + determineWhosTurn() + "turn");

            if(determineWhosTurn() == 1)
            {
                player1.play(gameBoard);
            }
            else
            {
                player2.play(gameBoard);
            }

            if(gameBoard.catsGame())
            {
                System.out.println("Cats game, program will now exit");
                System.exit(0);
            }
            return true;
        }
        else
        {
            if(gameBoard.checkDiagonalW() == 3 || gameBoard.checkLineW() == 3)
            {
                System.out.println("Player 1 won");
            }
            else if(gameBoard.checkDiagonalW() == 6 || gameBoard.checkDiagonalW() == 6)
            {
                System.out.println("Player 2 won");
            }
            return false;
        }

    }
    public int determineWhosTurn()
    {
        if(whosTurn % 2 == 1)
        {
            return 1;
        }
        else if(whosTurn % 2 == 0)
        {
            return 2;
        }
        else
        {
            return 0;
        }
    }
    public boolean whoWon()
    {
        boolean player1Wins = false;
        if(gameBoard.checkLineW() == 3)
        {
            player1Wins = true;
        }
        else if(gameBoard.checkLineW() == 6)
        {

        }
        else if(gameBoard.checkDiagonalW() == 3)
        {
            player1Wins = true;
        }
        else if(gameBoard.checkDiagonalW() == 6)
        {

        }
        else
        {
            System.out.println("Next move");
        }
    }
}
