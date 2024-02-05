package ru.dickpickgalactic.andrew.dividearrayintothrees;

import static ru.dickpickgalactic.util.Utils.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

  public int[][] divideArray(int[] nums, int k) {
    int[][] res = new int[nums.length / 3][3];
    Arrays.sort(nums);

    int idX = 0;
    for (int i = 0; i < nums.length; i += 3) {
      int firstNum = nums[i];
      int prevNum = nums[i + 1];
      int curNum = nums[i + 2];
      if (curNum - firstNum <= k) {
        res[idX][0] = firstNum;
        res[idX][1] = prevNum;
        res[idX][2] = curNum;
        idX++;
      } else {
        return new int[0][0];
      }
    }
    return res;
  }

  public void sort(int[] arr) {
    List<Integer> arrayList = new ArrayList<>();
    for (int num : arr) {
      arrayList.add(num);
    }
    arrayList.sort(Comparator.comparingInt(x -> x));
    log(arrayList);
  }

  public static void main(String[] args) {
//    new Solution().divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2);
//    new Solution().sort(
//        new int[]{15, 13, 12, 13, 12, 14, 12, 2, 3, 13, 12, 14, 14, 13, 5, 12, 12, 2, 13, 2, 2});
    new Solution().divideArray(
        new int[]{15, 13, 12, 13, 12, 14, 12, 2, 3, 13, 12, 14, 14, 13, 4, 12, 12, 2, 13, 2, 2}, 2);
  }
}
