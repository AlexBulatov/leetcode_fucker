package ru.dickpickgalactic.andrew;

public class MedianOfSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int bothArrayLength = nums1.length + nums2.length;
    int maxIter = bothArrayLength / 2 + 1;
    boolean stepped;

    int iter, prevNum, curNum, idx1, idx2, num1, num2;
    iter = prevNum = curNum = idx1 = idx2 = num1 = num2 = 0;

    while (iter < maxIter) {
      stepped = false;

      if (idx1 < nums1.length) {
        num1 = nums1[idx1];
      } else {
        num1 = idx2 < nums2.length ? nums2[idx2] : num2;
      }
      if (idx2 < nums2.length) {
        num2 = nums2[idx2];
      } else {
        num2 = idx1 < nums1.length ? nums1[idx1] : num1;
      }

      if ((num1 < num2) || (idx2 == nums2.length)) {
        ++idx1;
        stepped = true;
      } else if ((num2 < num1) || (idx1 == nums1.length)) {
        ++idx2;
        stepped = true;
      }
      if (!stepped) {
        if ((num1 == num2) && (idx1 < nums1.length)) {
          ++idx1;
        } else if ((num1 == num2) && (idx2 < nums2.length)) {
          ++idx2;
        }
      }

      if (iter == 0) {
        prevNum = Math.min(num1, num2);
        curNum = prevNum;
      }
      if (iter > 0) {
        prevNum = curNum;
        curNum = Math.min(num1, num2);
      }

      iter++;
    }

    if (bothArrayLength % 2 == 0) {
      return (prevNum + curNum) / 2.0;
    }
    return curNum;
  }

  public static void main(String[] args) {
    double res;
    res = (new MedianOfSortedArrays()).findMedianSortedArrays(new int[]{2, 2, 4, 4},
        new int[]{2, 2, 4, 4}); // 2 2 2 2 ((3)) 4 4 4 4
    System.out.printf("\nres = %.2f\n", res);
  }
}
