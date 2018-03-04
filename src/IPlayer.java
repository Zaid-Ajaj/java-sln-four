import java.util.*;

public interface IPlayer
{
    boolean isHuman();
    BoardField getBoardField();
    String getName();
    Optional<Move> nextMove(Board board);
}