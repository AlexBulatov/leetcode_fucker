package ru.dickpickgalactic.sudoku;

import java.util.Arrays;
import java.util.TreeSet;

public class Cell {

  public Integer value = null;
  public TreeSet<Integer> suggested = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

  public Cell() {
  }

  public Cell(char value) {
    if (value != '.') {
      this.value = value - '0';
      this.suggested.clear();
    }
  }

  private Cell(Integer theValue, TreeSet<Integer> theSuggested) {
    Cell thatCell = new Cell();
    thatCell.value = theValue;
    thatCell.suggested = (TreeSet<Integer>) theSuggested.clone();
  }

  @Override
  public Cell clone() {
    Cell that;
    try {
      that = (Cell) super.clone();
    } catch (CloneNotSupportedException e) {
      that = new Cell(this.value, this.suggested);
    }
    return that;
  }

  public String toString() {
    return (value == null) ? "." : value.toString();
  }
}