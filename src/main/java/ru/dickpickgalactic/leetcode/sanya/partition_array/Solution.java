package ru.dickpickgalactic.leetcode.sanya.partition_array;

import java.util.Arrays;

/** 1043. Partition Array for Maximum Sum
 * <p>
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 * </p>
 * <p>
 * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 * </p>
 *
 */

public class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);

        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);

            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                // Store the maximum of all options for the current subarray.
                dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3);
        sol.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4);
        sol.maxSumAfterPartitioning(new int[]{1}, 1);
    }
}
