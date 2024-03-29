package ru.dickpickgalactic.andrew.sudoku;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public void solveSudoku(char[][] board) {
    Sudoku sudoku = new Sudoku(board);
    System.out.println(sudoku);
    Sudoku result = Sudoku.solveSudoku(sudoku, 0, 2);
    for (int i = 0; i < result.values.length; i++) {
      for (int j = 0; j < result.values[i].length; j++) {
        board[i][j] = (char) (result.values[i][j].value + '0');
      }
    }
    System.out.println("-----------");
    System.out.println(result);
  }

  public static void main(String[] args) {
//    (new Main()).solveSudoku(new char[][]{{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
//        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//        {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
//        {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
//        {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
//        {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
//        {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
//        {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
//        {'.', '.', '.', '2', '7', '5', '9', '.', '.'}});

//    (new Main()).solveSudoku(new char[][]{{'.', '2', '6', '5', '.', '.', '.', '9', '.'},
//        {'5', '.', '.', '.', '7', '9', '.', '.', '4'},
//        {'3', '.', '.', '.', '1', '.', '.', '.', '.'},
//        {'6', '.', '.', '.', '.', '.', '8', '.', '7'},
//        {'.', '7', '5', '.', '2', '.', '.', '1', '.'},
//        {'.', '1', '.', '.', '.', '.', '4', '.', '.'},
//        {'.', '.', '.', '3', '.', '8', '9', '.', '2'},
//        {'7', '.', '.', '.', '6', '.', '.', '4', '.'},
//        {'.', '3', '.', '2', '.', '.', '1', '.', '.'}});

//    (new Main()).solveSudoku(new char[][]{{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
//        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//        {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
//        {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
//        {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
//        {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
//        {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
//        {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
//        {'.', '.', '.', '2', '7', '5', '9', '.', '.'}});

//    (new Main()).solveSudoku(new char[][]{{'.', '.', '.', '2', '.', '.', '.', '6', '3'},
//        {'3', '.', '.', '.', '.', '5', '4', '.', '1'},
//        {'.', '.', '1', '.', '.', '3', '9', '8', '.'},
//        {'.', '.', '.', '.', '.', '.', '.', '9', '.'},
//        {'.', '.', '.', '5', '3', '8', '.', '.', '.'},
//        {'.', '3', '.', '.', '.', '.', '.', '.', '.'},
//        {'.', '2', '6', '3', '.', '.', '5', '.', '.'},
//        {'5', '.', '3', '7', '.', '.', '.', '.', '8'},
//        {'4', '7', '.', '.', '.', '1', '.', '.', '.'}});

    (new Main()).solveSudoku(new char[][]{{'.', '.', '.', '.', '.', '7', '.', '.', '9'},
        {'.', '4', '.', '.', '8', '1', '2', '.', '.'},
        {'.', '.', '.', '9', '.', '.', '.', '1', '.'},
        {'.', '.', '5', '3', '.', '.', '.', '7', '2'},
        {'2', '9', '3', '.', '.', '.', '.', '5', '.'},
        {'.', '.', '.', '.', '.', '5', '3', '.', '.'},
        {'8', '.', '.', '.', '2', '3', '.', '.', '.'},
        {'7', '.', '.', '.', '5', '.', '.', '4', '.'},
        {'5', '3', '1', '.', '7', '.', '.', '.', '.'}});

  }
}