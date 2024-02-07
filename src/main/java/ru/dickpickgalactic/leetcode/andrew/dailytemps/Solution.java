package ru.dickpickgalactic.leetcode.andrew.dailytemps;

public class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int[] tempDiffs = new int[temperatures.length - 1];
    int[] result = new int[temperatures.length];
    result[result.length - 1] = 0;
    for (int i = 0; i < temperatures.length - 1; i++) {
      tempDiffs[i] = temperatures[i + 1] - temperatures[i];
    }
    for (int i = 0; i < temperatures.length - 1; i++) {
      int sumOfDiffs = 0;
      int j = i;
      if (i < tempDiffs.length && tempDiffs[i] > 0)  {
        result[i] = 1;
        continue;
      }
      while(sumOfDiffs <= 0 && j < tempDiffs.length) {
        sumOfDiffs += tempDiffs[j];
        j++;
      }
      result[i] = sumOfDiffs > 0 ? j - i : 0;
    }
    return result;
  }

  public static void main(String[] args) {
    (new Solution()).dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
//    (new Solution()).dailyTemperatures(new int[]{5, 4, 3, 2, 1, 0});

  }

}
