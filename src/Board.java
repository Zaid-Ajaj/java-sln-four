import java.util.*;
import java.lang.*;

/** The logic of the board 
 * 
 * @author Zaid Ajaj - s4807561
 * @author Luna-Elise Schernthaner - s4703928 
 */
public class Board
{
    private BoardField[][] fields;

    public Board() 
    {
        initFields();
    }

    private void initFields()
    {
        this.fields = new BoardField[3][3];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                this.fields[i][j] = BoardField.Empty;
            }
        }
    }

    public boolean isFilled()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(this.fields[i][j] == BoardField.Empty)
                {
                    return false;
                }
            }
        }
        return true;
    }

    private void setField(int i, int j, BoardField field)
    {
        if (i < 0 || j < 0 || i > 2 || j > 2) 
        {
            return;
        }

        if (this.fields[i][j] == BoardField.Empty)
        {
            this.fields[i][j] = field;
        } 
    }

    public void setCircle(int i, int j)
    {
        setField(i, j, BoardField.Circle);
    }

    public void setCross(int i, int j) 
    {
         setField(i, j, BoardField.Cross);
    }

  
    private boolean topRowFilledWith(BoardField field) 
    {
        for (int j = 0; j < 3; j++)
        {
            if(this.fields[0][j] != field) 
            {
                return false;
            }
        }

        return true;
    }

    private boolean bottomRowFilledWith(BoardField field) 
    {
        for (int j = 0; j < 3; j++)
        {
            if(this.fields[2][j] != field) 
            {
                return false;
            }
        }

        return true;
    }

    private boolean leftColumnFilledWith(BoardField field) 
    {
        for (int j = 0; j < 3; j++)
        {
            if(this.fields[j][0] != field) 
            {
                return false;
            }
        }

        return true;
    }

    private boolean rightColumnFilledWith(BoardField field) 
    {
        for (int j = 0; j < 3; j++)
        {
            if(this.fields[j][2] != field) 
            {
                return false;
            }
        }

        return true;
    }

    // [ [ X, O, O ], 
    //   [ X, O, O ],
    //   [ X, O, O ] ]
    // 

    private boolean middleColumnFilledWith(BoardField field) 
    {
        for (int j = 0; j < 3; j++)
        {
            if(this.fields[j][1] != field) 
            {
                return false;
            }
        }

        return true;
    }

    private boolean middleRowFilledWith(BoardField field) 
    {
        for (int j = 0; j < 3; j++)
        {
            if(this.fields[1][j] != field) 
            {
                return false;
            }
        }

        return true;
    }

    private boolean leftDiagonalFilledWith(BoardField field) 
    {
        for (int j = 0; j < 3; j++)
        {
            if(this.fields[j][j] != field) 
            {
                return false;
            }
        }

        return true;
    }

    private boolean rightDiagonalFilledWith(BoardField field) 
    {
        for (int j = 0; j < 3; j++)
        {
            if(this.fields[j][2 - j] != field) 
            {
                return false;
            }
        }

        return true;
    }

    public boolean hasWinningConfiguration()
    {
       return circleHasWon() || crossHasWon();
    }

    public boolean circleHasWon()
    {
        return topRowFilledWith(BoardField.Circle)
            || bottomRowFilledWith(BoardField.Circle)
            || leftColumnFilledWith(BoardField.Circle)
            || rightColumnFilledWith(BoardField.Circle)
            || middleColumnFilledWith(BoardField.Circle)
            || middleRowFilledWith(BoardField.Circle)
            || leftDiagonalFilledWith(BoardField.Circle)
            || rightDiagonalFilledWith(BoardField.Circle);
    }

    public boolean crossHasWon()
    {
        return topRowFilledWith(BoardField.Cross)
            || bottomRowFilledWith(BoardField.Cross)
            || leftColumnFilledWith(BoardField.Cross)
            || rightColumnFilledWith(BoardField.Cross)
            || middleColumnFilledWith(BoardField.Cross)
            || middleRowFilledWith(BoardField.Cross)
            || leftDiagonalFilledWith(BoardField.Cross)
            || rightDiagonalFilledWith(BoardField.Cross);       
    }

    private String printField(BoardField field)
    {
        if (field == BoardField.Cross) 
            return "X";
        else if (field == BoardField.Circle) 
            return "O";
        else 
            return " ";
    }

    public boolean isEmpty(int x, int y)
    {
        return this.fields[x][y] == BoardField.Empty;
    }

    @Override
    public String toString() 
    {
        ArrayList<String> rows = new ArrayList();
        for (int x = 0; x < 3; x++)
        {
            ArrayList<String> elements = new ArrayList();
            for(int y = 0; y < 3; y++) 
            {
                elements.add(printField(fields[x][y]));
            }

            String row = String.join(" | ", elements.toArray(new String[3]));
            rows.add(row);
        }    
        return String.join("\n----------\n", rows.toArray(new String[3]));
    }
}