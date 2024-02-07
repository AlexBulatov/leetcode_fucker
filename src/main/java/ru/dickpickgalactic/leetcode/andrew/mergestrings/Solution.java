package ru.dickpickgalactic.leetcode.andrew.mergestrings;

public class Solution {

  public String mergeAlternately(String wordX, String wordY) {
    StringBuilder strRes = new StringBuilder();
    int idXMax = wordX.length();
    int idYMax = wordY.length();
    for (int i = 0; i < Math.max(idXMax, idYMax); i++) {
      if (i < idXMax) {
        strRes.append(wordX.charAt(i));
      }
      if (i < idYMax) {
        strRes.append(wordY.charAt(i));
      }
    }
    return strRes.toString();
  }
}


