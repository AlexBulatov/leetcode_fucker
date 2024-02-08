package ru.dickpickgalactic.codewars.andrew.six_kyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Enough is enough!
 * (Delete occurrences of an element if it occurs more than n times)
 *
 * https://www.codewars.com/kata/554ca54ffa7d91b236000023/train/java
 *
 * @author Dick (c) GigaCode
 */

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
      Map<Integer, Integer> map = new HashMap<>();
      ArrayList<Integer> result = new ArrayList<>();

      for (int i = 0; i < elements.length; i++) {
        if (map.containsKey(elements[i])) {
          if (map.get(elements[i]) <= maxOccurrences) {
            map.put(elements[i], map.get(elements[i]) + 1);
            result.add(elements[i]);
          }
        } else {
          map.put(elements[i], 1);
          result.add(elements[i]);
        }
      }

      return result.stream().mapToInt(i -> i).toArray();
    }
}
