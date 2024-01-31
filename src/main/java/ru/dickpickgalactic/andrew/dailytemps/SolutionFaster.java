package ru.dickpickgalactic.andrew.dailytemps;

import java.util.HashMap;
import java.util.Stack;

public class SolutionFaster {

  record Pair(Integer temp, Integer pos) {

  }

  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    HashMap<Integer, Integer> map = new HashMap<>();
    Stack<Pair> temps = new Stack<>();
    for (int i = temperatures.length - 1; i >= 0; i--) {
      if (temps.isEmpty()) {
        temps.push(new Pair(temperatures[i], i));
        map.put(i, 0);
        continue;
      }
      if (temps.peek().temp > temperatures[i]) {
        map.put(i, temps.peek().pos - i);
        temps.push(new Pair(temperatures[i], i));
        continue;
      }
      while (!temps.isEmpty() && temps.peek().temp <= temperatures[i]) {
        temps.pop();
      }
      if (temps.isEmpty()) {
        map.put(i, 0);
        temps.push(new Pair(temperatures[i], i));
      } else {
        map.put(i, temps.peek().pos - i);
        temps.push(new Pair(temperatures[i], i));
      }
    }
    for (int i = 0; i < result.length; i++) {
      result[i] = map.get(i);
    }
    return result;
  }

  public static void main(String[] args) {
    (new SolutionFaster()).dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
//    (new Solution()).dailyTemperatures(new int[]{5, 4, 3, 2, 1, 0});
  }

}
