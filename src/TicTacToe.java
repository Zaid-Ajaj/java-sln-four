import java.util.*;
import java.lang.*;

public class TicTacToe
{
    private final IPlayer playerOne; 
    private final IPlayer playerTwo;
    private boolean isPlayerOneTurn;
    public final Board board;

    public TicTacToe(IPlayer playerOne, IPlayer playerTwo)
    {
        if (playerOne.getBoardField() == playerTwo.getBoardField())
        {
            throw new RuntimeException("Players cannot have the same board field");
        }

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.isPlayerOneTurn = true;
        
        board = new Board();
    }


    public IPlayer currentPlayer() 
    {
        if (isPlayerOneTurn) 
        {
            return playerOne;
        }
        else
        {
            return playerTwo;
        }
    }

    public boolean hasFinished()
    {
        return board.hasWinningConfiguration() || board.isFilled();
    }

    public void makeMove(int i, int j)
    {
        if (isPlayerOneTurn)
        {
            BoardField field = playerOne.getBoardField();
            
            if (field == BoardField.Circle)
            {
                board.setCircle(i, j);
            }

            if (field == BoardField.Cross)
            {
                board.setCross(i, j);
            }

            isPlayerOneTurn = false;
        }
        else
        {
            BoardField field = playerTwo.getBoardField();
            
            if (field == BoardField.Circle)
            {
                board.setCircle(i, j);
            }

            if (field == BoardField.Cross)
            {
                board.setCross(i, j);
            }

            isPlayerOneTurn = true;
        }
    }

    public Optional<IPlayer> winningPlayer()
    {
        if (board.circleHasWon())
        {
            if(playerOne.getBoardField() == BoardField.Circle)
            {
                return Optional.of(playerOne);
            }
            else
            {
                return Optional.of(playerTwo);
            }
        }
        else if(board.crossHasWon())
        {
            if(playerOne.getBoardField() == BoardField.Cross)
            {
                return Optional.of(playerOne);
            }
            else
            {
                return Optional.of(playerTwo);
            }
        }
        else 
        {
            return Optional.empty();
        }
    }

    @Override
    public String toString() 
    {
        return this.board.toString();
    }

}