package ru.dickpickgalactic.sanya.divide_array;

import java.util.ArrayList;
import java.util.Arrays;

import static ru.dickpickgalactic.util.Utils.log;

public class Solution {

    public int[][] divideArray(int[] nums, int k) {
        int[][] res = new int[nums.length/3][3];
        int[] array = new int[100001];
        for (int num : nums) {
            array[num]++;
        }
        int currIdx=0;
        int currArrayIdx=0;
        while(currIdx < 10000 && currArrayIdx < nums.length/3 ){
            int lenIdx = 0;
            int[] temp = new int[3];
            while (lenIdx < 3) {
                if (array[currIdx] == 0 && currIdx < 20) {
                    currIdx++;
                }
                else {
                    temp[lenIdx] = currIdx;
                    lenIdx++;
                    array[currIdx]--;
                }
            }
            if (temp[2] - temp[0] > k) {
                return new int[][]{};
            }
            res[currArrayIdx] = temp;
            currArrayIdx++;
        }
        return res;
    }

    public static void main(String[] args) {
             int[][] suka =   (new Solution()).divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2);

             suka =  (new Solution()).divideArray(new int[]{1,3,3,2,7,3}, 3);

    }
}
