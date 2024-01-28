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
  public Cell(Cell that) {
    this.value = that.value;
    this.suggested = (TreeSet<Integer>) that.suggested.clone();
  }

  public String toString() {
    return (value == null) ? "." : value.toString();
  }
}