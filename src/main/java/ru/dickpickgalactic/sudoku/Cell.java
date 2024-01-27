package ru.dickpickgalactic.sudoku;

import java.util.Arrays;
import java.util.TreeSet;

public class Cell {
    public Integer value = null;
    public TreeSet< Integer > suggested =
            new TreeSet < Integer > (Arrays.asList (1, 2, 3, 4, 5, 6, 7, 8, 9));

    public Cell (char value)
    {
        if (value != '.')
        {
            this.value = Integer.valueOf (value - '0');
        }
    }

    public String toString ()
    {
        return (value == null) ? "." : value.toString ();
    }
}