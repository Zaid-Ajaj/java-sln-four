import java.util.*;
import java.lang.*;

/** The logic of the computer player 
 * 
 * @author Zaid Ajaj - s4807561
 * @author Luna-Elise Schernthaner - s4703928 
 */
public class ComputerPlayer implements IPlayer
{
    private BoardField boardField;
    private String playerName;

    public ComputerPlayer(BoardField boardField, String playerName)
    {
        this.boardField = boardField;
        this.playerName = playerName;    
    }

    public boolean isHuman() 
    {
        return false;
    }

    public BoardField getBoardField()
    {
        return this.boardField;
    }

    public String getName()
    {
        return this.playerName;
    }

    /** Generates the next move of the computer */
    public Optional<Move> nextMove(Board board)
    {
        ArrayList<Move> possibleMoves = nextPossibleMoves(board);
        Random rnd = new Random();
        rnd.nextInt(possibleMoves.size());
        return Optional.of(possibleMoves.get(rnd.nextInt(possibleMoves.size())));
    }


    ArrayList<Move> nextPossibleMoves(Board board) 
    {
        ArrayList<Move> moves = new ArrayList();
        for(int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                if (board.isEmpty(x, y))
                {
                    moves.add(new Move(x, y));
                }
            }
        }

        return moves;
    }

}