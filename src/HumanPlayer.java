import java.util.Optional;

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