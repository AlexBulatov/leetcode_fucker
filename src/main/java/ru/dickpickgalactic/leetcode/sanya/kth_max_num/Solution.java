package ru.dickpickgalactic.leetcode.sanya.kth_max_num;


import static ru.dickpickgalactic.util.Utils.log;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int[] array = new int[20001];
        int idxZero = 10000;
        for (int num : nums) {
            array[num + idxZero]++;
        }
        int idx=20000;
        while (k > 0) {
            k-=array[idx];
            idx--;
        }
        System.gc();
        return idx-idxZero+1;
    }

    public static void main(String[] args) {
        log((new Solution()).findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        log((new Solution()).findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
