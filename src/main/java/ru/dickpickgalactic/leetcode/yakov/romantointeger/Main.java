package ru.dickpickgalactic.leetcode.yakov.romantointeger;

public class Main {

  public static void main(String[] args) {
    System.out.println(romanToInt("MCMXCIV"));
  }

  public static int getCharIndex(char[] romans, char j) {
    for (int k = 0; k < romans.length; k++) {
      if (j == romans[k]) {
        return k;
      }
    }
    return -1;
  }

  public static int romanToInt(String s) {
    int result = 0;
    char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int[] numbs = {1, 5, 10, 50, 100, 500, 1000};
    for (int i = s.length() - 1; i >= 0; ) {

      char j = s.charAt(i);
      int k = getCharIndex(romans, j);
      result += numbs[k];
      if (i == 0) {
        break;
      }
      for (int l = i - 1; l >= 0; l--) {
        char y = s.charAt(l);
        int b = getCharIndex(romans, y);
        if (b < k) {
          result -= numbs[b];
          if (l == 0) {
            return result;
          }

        } else {
          i = l;
          break;
        }

      }
    }
    return result;

  }

}
