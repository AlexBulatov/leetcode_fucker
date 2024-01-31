package ru.dickpickgalactic.andrew.nextgreaterelement;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = nums2.length - 1; i >= 0; i--) {
      if (stack.isEmpty()) {
        map.put(nums2[i], -1);
        stack.push(nums2[i]);
        continue;
      }
      if (stack.peek() > nums2[i]) {
        map.put(nums2[i], stack.peek());
        stack.push(nums2[i]);
        continue;
      }
      while (!stack.isEmpty() && stack.peek() < nums2[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        map.put(nums2[i], stack.peek());
      } else {
        map.put(nums2[i], -1);
      }
      stack.push(nums2[i]);

    }
    for (int i = 0; i < nums1.length; i++) {
      result[i] = map.get(nums1[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    (new Solution()).nextGreaterElement(new int[]{4, 1, 2}, new int[]{4, 2, 1, 3, 5, 6});
    (new Solution()).nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
  }

}
