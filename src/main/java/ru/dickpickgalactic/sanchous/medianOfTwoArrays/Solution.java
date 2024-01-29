package ru.dickpickgalactic.sanchous.medianOfTwoArrays;

class Solution {

    public boolean checkBounds(int[] nums, int idx) {
        return nums.length != 0 && nums.length > idx;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;
        int len = nums1.length + nums2.length;
        int resPrev = 0;
        int resCur = 0;
        for (int i = 0; i < (len / 2) + 1; i++) {
            if (!checkBounds(nums1, idx1)) {
                resPrev = resCur;
                resCur = nums2[idx2];
                idx2++;
            } else if (!checkBounds(nums2, idx2)) {
                resPrev = resCur;
                resCur = nums1[idx1];
                idx1++;
            } else if (nums1[idx1] < nums2[idx2]) {
                resPrev = resCur;
                resCur = nums1[idx1];
                idx1++;
            } else {
                resPrev = resCur;
                resCur = nums2[idx2];
                idx2++;
            }
        }
        return len % 2 == 0 ? (resPrev + resCur) / 2.0 : resCur;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println((new Solution()).findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println((new Solution()).findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println((new Solution()).findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
}