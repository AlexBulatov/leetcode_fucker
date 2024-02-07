package ru.dickpickgalactic.andrew.groupanalgrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);

      if (!map.containsKey(sorted)) {
        map.put(sorted, new ArrayList<>());
      }

      map.get(sorted).add(str);
    }
    return new ArrayList<>(map.values());

  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> result = solution.groupAnagrams(strs);
    System.out.println(result);
  }

}
