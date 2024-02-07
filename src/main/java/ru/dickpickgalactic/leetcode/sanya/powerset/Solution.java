package ru.dickpickgalactic.leetcode.sanya.powerset;

import java.util.*;

import static ru.dickpickgalactic.util.Utils.log;


public class Solution {

    public static long intPow(int x, int n){
        return (long) Math.pow(x,n);
    }

    /*
    *         long res = 0, s = 0, base = 1000000007;
        Arrays.sort(nums);
        for (int x: nums) {
            res = (res + (s + x) * x % base * x % base) % base;
            s = (s * 2 + x) % base;
        }
        return (int)res;
    * */

    public int sumOfPower(int[] nums) {
        long res = 0, s = 0, base = 1000000007;
        Arrays.sort(nums);
        for (int x: nums) {
            res = (res + (s + x) * x % base * x % base) % base;
            s = (s * 2 + x) % base;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        log((new Solution()).sumOfPower(new int[]{2, 1, 4}));
        log((new Solution()).sumOfPower(new int[]{1, 1, 1}));
        log((new Solution()).sumOfPower(new int[]{658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206}));
        log((new Solution()).sumOfPower(new int[]{2342,1892,2349,1217,2073,73,813,68,1569,1041,1912,43,838,1315,2290,18,2283,2374,1815,1433,544,505,1881,1876,293,160,1327,408,1913,2415,94,256,222,2434,2103,1483,2038,213,900,2218,212,514,955,1968,1344,1409} ));
        log((new Solution()).sumOfPower(new int[]{35,21,77,82,30,94,55,76,94,51}));
    }


}
