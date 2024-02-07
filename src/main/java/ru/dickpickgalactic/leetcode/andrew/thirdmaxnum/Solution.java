package ru.dickpickgalactic.leetcode.andrew.thirdmaxnum;


class Solution {

  public int thirdMax(int[] nums) {
    Integer max1 = null;
    Integer max2 = null;
    Integer max3 = null;

    for (Integer num : nums) {
      if (num.equals(max1) || num.equals(max2) || num.equals(max3)) {
        continue;
      }
      if (max1 == null || max1 < num) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (max2 == null || max2 < num) {
        max3 = max2;
        max2 = num;
      } else if (max3 == null || max3 < num) {
        max3 = num;
      }
    }
    System.gc();
    return max3 == null ? max1 : max3;
  }

  public static void main(String[] args) {
    int res = new Solution().thirdMax(new int[]{5, 2, 4, 1, 3, 6, 0}); // = 4
    System.out.println(res);
  }
}
