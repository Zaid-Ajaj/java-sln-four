import java.lang.*;
import java.util.*;

public class Runner 
{
    public static void main(String[] args)
    {
        Test.Case("Board is not filled when board is initialised", () -> 
        {   
            Board board = new Board();
            boolean result = board.isFilled();
            Test.AreEqual(false, result, "Result is false");
        });

        Test.Case("Board is filled when every field is circle", () -> 
        {
            Board board = new Board();
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j < 3; j++)
                {
                    board.setCircle(i,j);
                }
            }

            boolean result = board.isFilled();
            Test.AreEqual(true, result, "Board is filled");
        });

        Test.Case("Board has winning config with top row", () -> 
        {
            Board board = new Board();
            board.setCircle(0, 0);
            board.setCircle(0, 1);
            board.setCircle(0, 2);
            boolean result = board.hasWinningConfiguration();
            Test.AreEqual(true, result, "Player won");
        });

        Test.Case("Board does not have winning config with top row", () -> 
        {
            Board board = new Board();
            board.setCircle(0, 0);
            board.setCircle(0, 2);
            boolean result = board.hasWinningConfiguration();
            Test.AreEqual(false, result, "Player didn't win");
        });

        Test.Report();
    }
}