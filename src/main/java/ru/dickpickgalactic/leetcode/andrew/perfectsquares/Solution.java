package ru.dickpickgalactic.leetcode.andrew.perfectsquares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {


  public static int[] squares = new int[] { 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196,
      225, 256, 289, 324, 361, 400, 441, 484, 529, 576, 625, 676, 729, 784, 841, 900, 961, 1024,
      1089, 1156, 1225, 1296, 1369, 1444, 1521, 1600, 1681, 1764, 1849, 1936, 2025, 2116, 2209,
      2304, 2401, 2500, 2601, 2704, 2809, 2916, 3025, 3136, 3249, 3364, 3481, 3600, 3721, 3844,
      3969, 4096, 4225, 4356, 4489, 4624, 4761, 4900, 5041, 5184, 5329, 5476, 5625, 5776, 5929,
      6084,
      6241, 6400, 6561, 6724, 6889, 7056, 7225, 7396, 7569, 7744, 7921, 8100, 8281, 8464, 8649,
      8836,
      9025, 9216, 9409, 9604, 9801, 10000 };

  public static Map<Integer, Integer> map = new HashMap<>();
  public static boolean isFilled = false;
  public int numSquaresRecursive(int n) {
    if (map.containsKey(n)) {
      return map.get(n);
    }
    int min = Integer.MAX_VALUE;
    for (int idx = squares.length - 1; idx >= 0; idx--) {
      if (squares[idx] < n) {
        min = Math.min(min, numSquaresRecursive(n - squares[idx]) + 1);
      }
    }
    map.put(n, min);
    return min;
  }

  public int numSquares(int n) {
    for (int i = 0; i < squares.length && !isFilled; i++) {
      map.put(squares[i], 1);
    }
    isFilled = true;
    int result = numSquaresRecursive(n);
    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.numSquares(12));
    System.out.println(solution.numSquares(13));
  }
}

