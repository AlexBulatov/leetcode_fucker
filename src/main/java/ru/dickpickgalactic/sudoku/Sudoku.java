package ru.dickpickgalactic.sudoku;

public class Sudoku {

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

  public static Sudoku solveSudoku(Sudoku sudoku, int iteration, int predictionDepth) {
    System.out.printf("Iteration: %d\n", iteration);
    int prevEmptyCellsCount = 0;
    while (sudoku.emptyValues != prevEmptyCellsCount && sudoku.emptyValues != 0) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (sudoku.values[i][j].value == null) {
            prevEmptyCellsCount = sudoku.emptyValues;
            sudoku.eraseSuggested(i, j);
          }
        }
      }
    }
    if (iteration > 3) {
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
            if (sudokuPredicted.emptyValues == 0) {
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
      Sudoku sudokuPredicted = this.clone();
      sudokuPredicted.values[row][col].suggested.clear();
      sudokuPredicted.values[row][col].value = suggestedValue;
      sudokuPredicted.emptyValues--;
      sudokuPredicted = Sudoku.solveSudoku(sudokuPredicted, iteration, predictionDepth);
      if (sudokuPredicted.emptyValues == 0) {
        return sudokuPredicted;
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

  public char[][] getBoard() {
    int rowNum = this.values.length;
    int colNum = this.values[0].length;
    char[][] newBoard = new char[rowNum][colNum];
    for (int i = 0; i < rowNum; i++) {
      for (int j = 0; j < colNum; j++) {
        newBoard[i][j] =
            this.values[i][j].value != null ? (char) (this.values[i][j].value + '0') : '.';
      }
    }
    return newBoard;
  }

  @Override
  public Sudoku clone() {
    Sudoku that;
    try {
      that = (Sudoku) super.clone();
    } catch (CloneNotSupportedException e) {
      that = new Sudoku(this.getBoard());
    }
    return that;
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
