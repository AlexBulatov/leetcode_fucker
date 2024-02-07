package ru.dickpickgalactic.leetcode.andrew.validanalgram;

public class Solution {

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();
    for (char c : sArr) {
      int j = 0;
      while (j < tArr.length) {
        if (c == tArr[j]) {
          tArr[j] = ' ';
          break;
        }
        j++;
      }
      if (j == tArr.length) {
        return false;
      }
    }
    return String.valueOf(tArr).isBlank();
  }

  public static void main(String[] args) {
    System.out.println(isAnagram("ate", "eta"));
  }
}

