package ru.dickpickgalactic.leetcode.andrew.kthmaxnum;

public class Solution {
  public int findKthLargest(int[] nums, int k) {
    int[] arr = new int[20001];
    int idxMid = 10000;

    for (int num : nums) {
      arr[num+idxMid]++;
    }

    int idx = arr.length - 1;
    while (k > 0) {
      k -= arr[idx];
      idx--;
    }

    return idx-idxMid+1;
  }

  public static void main(String[] args) {
    int res = new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4); // = 4
    System.out.println(res);
  }
}
