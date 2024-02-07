package ru.dickpickgalactic.leetcode.andrew.firstnonrepsymb;

import static ru.dickpickgalactic.util.Utils.log;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int firstUniqChar(String s) {
    if (s.length() == 1) {
      return 0;
    }

    Map<Character, Integer> freqs = new HashMap<>();

    int res = -1;
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (freqs.containsKey(c)) {
        freqs.put(c, freqs.get(c) + 1);
      } else {
        freqs.put(c, 1);
      }
    }

    for (int i = 0; i < s.length(); i++) {
      if (freqs.get(s.charAt(i)) == 1) {
        return i;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    log(new Solution().firstUniqChar("leetcode"));
  }
}
