package ru.dickpickgalactic.sudoku;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public void solveSudoku(char[][] board) {
    Sudoku sudoku = new Sudoku(board);
    System.out.println(sudoku);
    Sudoku result = Sudoku.solveSudoku(sudoku, 0, 3);
    System.out.println("-----------");
    System.out.println(result);
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