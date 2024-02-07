package ru.dickpickgalactic.leetcode.andrew.findthediff;

public class Solution {
  public char findTheDifference(String s, String t) {
    StringBuilder res = new StringBuilder(t);
    for (int i = 0; i < s.length(); i++) {
      res.deleteCharAt(res.indexOf(String.valueOf(s.charAt(i))));
    }
    return res.charAt(0);
  }

  public static void main(String[] args) {
    char c = 0;
    c ^= 'x';
    c ^= 'y';
    c ^= 'u';
    c ^= 'x';
    c ^= 'u';
    System.out.println(c);
  }
}
