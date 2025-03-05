package view;

import javafx.util.StringConverter;

public class StringIntegerConverter extends StringConverter<Number>
{
    @Override public String toString(Number n)
    {
        if (n == null || n.intValue() == 0)
        {
            return "";
        }
        return n.toString();
    }

    @Override public Number fromString(String s)
    {
        try
        {
            return Integer.parseInt(s);
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}
