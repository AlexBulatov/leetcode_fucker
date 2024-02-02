package ru.dickpickgalactic.sanya.powerset;

import java.util.*;
import java.util.stream.IntStream;

import static ru.dickpickgalactic.util.Utils.log;


public class Solution {

    public static long intPow(int x, int n){
        return (long) Math.pow(x,n);
    }

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long mod = intPow(10, 9) + 7; // 1000-7 zxc
        long res = 0;
        for (int k=0; k<nums.length; k++){
            res += (nums[k]  * (nums[k]  * nums[k])); // o/
            res %= mod;
            for (int i=k+1; i<nums.length; i++){
                long val = (nums[k] * nums[i]  * nums[i]) * intPow(2, (i-k-1));
                res += val;
            }
        }
        return (int) (res);
    }

    public static void main(String[] args) {
        log((new Solution()).sumOfPower(new int[]{2, 1, 4}));
        log((new Solution()).sumOfPower(new int[]{1, 1, 1}));
        log((new Solution()).sumOfPower(new int[]{658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206}));
        // 567530242
    }


}
