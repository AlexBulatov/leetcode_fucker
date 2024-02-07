package ru.dickpickgalactic.andrew.sortcharsbyfreq;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((c1, c2) -> c2.getValue() - c1.getValue());
    pq.addAll(map.entrySet());
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> entry = pq.poll();
      sb.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().frequencySort("ccaaaaa"));
  }
}
