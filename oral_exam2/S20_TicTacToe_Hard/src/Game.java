import java.util.Scanner;

/**
 * Created by elohr on 11/26/17.
 */
public class Game {
    private Player player1;
    private Player player2;
    private Board gameBoard;
    private boolean player1Turn = true;
    Scanner sc = new Scanner(System.in);
    public Game()
    {
        gameBoard = new Board();
        System.out.println("Will player 1 be a human(1) or computer(2)? ");
        int humanOrComputer1 = sc.nextInt();
        System.out.println("Will player 2 be a human(1) or computer(2)?");
        int humanOrComputer2 = sc.nextInt();

        if(humanOrComputer1 == 1)
        {
            player1 = new HumanPlayer(1);
        }
        if(humanOrComputer1 == 2)
        {
            player1 = new ComputerPlayer(1);
        }

        if(humanOrComputer2 == 1)
        {
            player2 = new HumanPlayer(-1);
        }
        if(humanOrComputer2 == 2)
        {
            player2 = new ComputerPlayer(-1);
        }
        while(playGame() == 1)
        {
            playGame();
        }

    }
    public int playGame()
    {
        gameBoard.printBoard();

        if(gameBoard.checkWin() == 1 || gameBoard.checkWin() == -1)
        {
            if(gameBoard.checkWin() == 1)
            {
                System.out.println("Player 1 won!");
            }
            if(gameBoard.checkWin() == -1) {
                System.out.println("Player 2 won!");
            }
            return -1;
        }
        else
        {
            if(player1Turn)
            {
                System.out.println("It is player 1's turn");
                player1.makeMove(gameBoard);
                player1Turn = false;

            }
            else
            {
                System.out.println("It is player 2's turn");
                player2.makeMove(gameBoard);
                player1Turn = true;
            }
            return 1;
        }

    }
}
