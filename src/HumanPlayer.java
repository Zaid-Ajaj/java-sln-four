import java.util.Optional;

/** The logic of the human player 
 * 
 * @author Zaid Ajaj - s4807561
 * @author Luna-Elise Schernthaner - s4703928 
 */
public class HumanPlayer implements IPlayer
{
    private BoardField boardField;
    private String playerName;

    public HumanPlayer(BoardField boardField, String playerName)
    {
        this.boardField = boardField;
        this.playerName = playerName;    
    }

    public boolean isHuman() 
    {
        return true;
    }

    public BoardField getBoardField()
    {
        return this.boardField;
    }

    public String getName()
    {
        return this.playerName;
    }

    public boolean requiresUserInput()
    {
        return true;
    }

    public Optional<Move> nextMove(Board board) 
    {
        return Optional.empty();
    }
}