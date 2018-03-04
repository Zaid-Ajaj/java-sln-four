import java.util.*;
import java.lang.*;

public class UI 
{
    private TicTacToe game;
    private Scanner scanner;

    /** Read user input after prompting him/her with a message  */
    public String readUserInput(String inputMsg)
    {
        System.out.print(inputMsg);

        if (scanner.hasNextLine())
        {
            return scanner.nextLine();
        }

        return "";
    } 

    public UI()
    {
        IPlayer player1 = new HumanPlayer(BoardField.Circle, "Zaid");
        IPlayer player2 = new HumanPlayer(BoardField.Cross, "Luna");
        scanner = new Scanner(System.in);
        this.game = new TicTacToe(player1, player2);
    }

    void writeLn(String input)
    {
        System.out.println(input);
    }

    public void start()
    {
        while (!game.hasFinished())
        {
            writeLn("\n" + game.toString() + "\n");

            IPlayer currentPlayer = game.currentPlayer();
            writeLn("It is " + currentPlayer.getName() + "'s turn");

            if (currentPlayer.isHuman())
            {
                int moveX = Integer.parseInt(readUserInput("Row nr: "));
                int moveY = Integer.parseInt(readUserInput("Col nr: "));
                game.makeMove(moveX, moveY);
            }
            else
            {
                Optional<Move> move = currentPlayer.nextMove(game.board);
                
                if (!move.isPresent())
                {
                    // AI player should always generate a move
                    break;
                }

                game.makeMove(move.get().x, move.get().y);
            }
        }

        Optional<IPlayer> playerWon = game.winningPlayer();
        if(playerWon.isPresent())
        {
            IPlayer player = playerWon.get();
            String playerName = player.getName();
            System.out.println(playerName + " has won the game.");
        }
    }
}