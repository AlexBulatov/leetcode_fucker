package ru.dickpickgalactic.sanchous.sudoku;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public void solveSudoku(char[][] board) {
    Sudoku sudoku = new Sudoku(board);
    Sudoku res = sudoku.solveSudoku();
    for (int i=0; i<9; i++)
      for (int j=0; j<9; j++)
        board[i][j] = (char) (res.values[i][j].value + '0');
    System.out.println(res);
  }

  public static void main(String[] args) {
    (new Main()).solveSudoku(new char[][]{{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
        {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
        {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
        {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
        {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
        {'.', '.', '.', '2', '7', '5', '9', '.', '.'}});
  }
}