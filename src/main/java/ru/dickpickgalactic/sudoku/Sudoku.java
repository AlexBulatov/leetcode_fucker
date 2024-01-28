package ru.dickpickgalactic.sudoku;

public class Sudoku{

  public Cell[][] values = new Cell[9][9];

  public int emptyValues = 81;

  public int prevEmptyValues = 0;

  public Sudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        values[i][j] = new Cell(board[i][j]);
        if (board[i][j] != '.') {
          emptyValues--;
        }
      }
    }
  }

  public Sudoku(Sudoku other) {
    this.values = new Cell[9][9];
    for (int i=0; i<9; i++)
      for (int j=0; j<9; j++)
      {
        this.values[i][j] = new Cell(other.values[i][j]);
      }
    this.emptyValues = other.emptyValues;
    this.prevEmptyValues = 0;
  }

  public Sudoku solveSudoku() {
    int guard = 0;
    while (emptyValues >= 0 && guard < 10 && emptyValues != prevEmptyValues) {
      prevEmptyValues = emptyValues;
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (values[i][j].value == null) {
            eraseSuggested(i, j);
          }
        }
      }
      guard++;
    }
    if (prevEmptyValues == emptyValues && emptyValues != 0) {
      assert getEmptyCell() != null;
      int[] idx = getEmptyCell();
        assert idx != null;
        Cell emptyCell = values[idx[0]][idx[1]];
      for (int suggestedNum: emptyCell.suggested) {
        Sudoku recSudoku = new Sudoku(this);
        recSudoku.values[idx[0]][idx[1]].value = suggestedNum;
        recSudoku.emptyValues--;
        recSudoku.solveSudoku();
        if (recSudoku.emptyValues == 0) {
          this.values = recSudoku.values;
          this.emptyValues = recSudoku.emptyValues;
          return this;
        }
      }
    }
    return this;
  }


  private int[] getEmptyCell(){
    for (int i=0; i<9; i++)
      for (int j=0; j<9; j++){
        if (values[i][j].value==null) {
          return new int[]{i,j};
        }
      }
    return null;
  }

  private void eraseSuggested(int row, int col) {
    //erase cols and rows;
    Cell cell = values[row][col];
    for (int i = 0; i < 9; i++) {
      if (values[row][i].value != null) {
        cell.suggested.remove(values[row][i].value);
      }
      if (values[i][col].value != null) {
        cell.suggested.remove(values[i][col].value);
      }
    }
    int rowBlock = row / 3;
    int colBlock = col / 3;
    for (int i = rowBlock * 3; i < rowBlock * 3 + 3; i++) {
      for (int j = colBlock * 3; j < colBlock * 3 + 3; j++) {
        if (values[i][j].value != null) {
          cell.suggested.remove(values[i][j].value);
        }
      }
    }
    if (cell.suggested.size() == 1) {
      cell.value = cell.suggested.first();
      emptyValues--;
    }
  }

  public String toString() {
    StringBuilder res = new StringBuilder();
    for (Cell[] valuesArr : values) {
      for (Cell value : valuesArr) {
        res.append(value.toString()).append(" ");
      }
      res.append("\n");
    }
    return res.toString();
  }
}
