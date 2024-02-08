package ru.dickpickgalactic.codewars.andrew.eight_kyu;

/**
 * 8 kyu
 * Rock Paper Scissors
 * https://www.codewars.com/kata/rock-paper-scissors/train
 *
 * @author dickpickalactic
 */

public class RockPaperScissors {

  public static String rps(String p1, String p2) {
    if (p1.equals(p2)) {
      return "Draw!";
    }
    if (p1.equals("rock")) {
      if (p2.equals("scissors")) {
        return "Player 1 won!";
      }
      return "Player 2 won!";
    }
    if (p1.equals("paper")) {
      if (p2.equals("rock")) {
        return "Player 1 won!";
      }
      return "Player 2 won!";
    }
    if (p1.equals("scissors")) {
      if (p2.equals("paper")) {
        return "Player 1 won!";
      }
      return "Player 2 won!";
    }
    return "Error!";
  }
}

