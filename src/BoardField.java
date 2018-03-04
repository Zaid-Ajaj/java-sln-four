import java.util.*;
import java.lang.*;

public enum BoardField
{
    Circle("Circle"), 
    Cross("Cross"), 
    Empty("Empty");

    private String value;

    BoardField(String name) 
    {
        this.value = name;
    }

    @Override
    public String toString() 
    {
        return this.value;
    }
}