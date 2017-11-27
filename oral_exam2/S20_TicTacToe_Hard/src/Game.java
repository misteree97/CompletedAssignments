import java.util.Scanner;

/**
 * @author Elliot Lohr
 * This class provides functionality for the TicTacToe game
 */
public class Game {
    /**
     * Player 1
     */
    private Player player1;
    /**
     * Player 2
     */
    private Player player2;
    /**
     * gameBoard that will be used to play
     */
    private Board gameBoard;
    /**
     * Used to determine who's move it is
     */
    private boolean player1Turn = true;
    /**
     * Scanner used to input
     */
    Scanner sc = new Scanner(System.in);
    public Game()
    {
        gameBoard = new Board();
        System.out.println("Will player 1 be a human(1) or computer(2)? ");
        int humanOrComputer1 = sc.nextInt();
        System.out.println("Will player 2 be a human(1) or computer(2)?");
        int humanOrComputer2 = sc.nextInt();

        //creates human or computer player depending on what user chooses
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
        //while the game is not won
        while(playGame() == 1)
        {
            playGame();
        }

    }

    /**
     * function used to play the game
     * @return 1 if the game hasn't been won, otherwise return -1 if game is won
     */
    public int playGame()
    {
        gameBoard.printBoard();

        //checks to see if somebody won before making moves
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
        else//nobody has won yet
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
