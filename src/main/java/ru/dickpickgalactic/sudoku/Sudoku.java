package ru.dickpickgalactic.sudoku;

class Sudoku {

  public Cell[][] values = new Cell[9][9];

  public int emptyValues = 0;

  public Sudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        values[i][j] = new Cell(board[i][j]);
        if (board[i][j] == '.') {
          emptyValues++;
        }
      }
    }
  }

  private Sudoku(Sudoku that) {
    this.emptyValues = that.emptyValues;
    for (int i = 0; i < that.values.length; i++) {
      for (int j = 0; j < that.values[i].length; j++) {
        this.values[i][j] = new Cell(that.values[i][j]);
      }
    }
  }

  public static Sudoku solveSudoku(Sudoku sudoku, int iteration, int predictionDepth) {
    int prevEmptyCellsCount = 0;
    int tries = 0;
    while (sudoku.emptyValues != prevEmptyCellsCount && sudoku.emptyValues != 0 && tries < 10) {
      prevEmptyCellsCount = sudoku.emptyValues;
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (sudoku.values[i][j].value == null) {
            sudoku.eraseSuggested(i, j);
          }
        }
      }
      tries++;
    }
    if (iteration > 2) {
      System.out.println(" Too much iterations! Probably dead-end!");
      return sudoku;
    }
    if (sudoku.emptyValues != 0) {
      System.out.println("We need to predict!");
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (sudoku.values[i][j].value == null
              && !sudoku.values[i][j].suggested.isEmpty()
              && sudoku.values[i][j].suggested.size() <= predictionDepth) {
            Sudoku sudokuPredicted = sudoku.solveWithPredict(i, j, iteration, predictionDepth);
            System.out.println(sudokuPredicted);
            if (sudokuPredicted.emptyValues == 0) {
              System.out.println(" HUUUUUUUI");
              System.out.println(sudokuPredicted);
              return sudokuPredicted;
            }
          }
        }
      }
    }
    return sudoku;
  }

  private Sudoku solveWithPredict(int row, int col, int iteration, int predictionDepth) {
    iteration++;

    System.out.printf(" Position: row [%d], col [%d]\n", row, col);
    for (Integer suggestedValue : values[row][col].suggested) {
      System.out.printf(" Predict number: %d\n", suggestedValue);
      Sudoku sudokuPredicted = new Sudoku(this);
      sudokuPredicted.values[row][col].suggested.clear();
      sudokuPredicted.values[row][col].value = suggestedValue;
      sudokuPredicted.emptyValues--;
      Sudoku result = Sudoku.solveSudoku(sudokuPredicted, iteration, predictionDepth);
      if (result.emptyValues == 0) {
        return result;
      }
    }
    return this;
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
      cell.suggested.clear();
      emptyValues--;
    }
  }

  @Override
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
