package ru.dickpickgalactic.leetcode.andrew.needleinhaystack;

public class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.length() > haystack.length()) return -1;
    for (int i = 0; i < haystack.length();) {
      int zZ = 0;
      if (haystack.charAt(i) != needle.charAt(0)) {
        i++;
        continue;
      }
      while (zZ < needle.length() && haystack.charAt(i+zZ) == needle.charAt(zZ)) {
        zZ++;
      }
      if (zZ == needle.length()) return i-zZ;
      i++;
    }
    return -1;
  }

  public static void main(String[] args) {
    new Solution().strStr("mississippi", "issip");
  }
}
