package ru.dickpickgalactic.leetcode.sanya.sequential_digits;

import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
/*        ArrayList<Integer> result = new ArrayList<>();
        String fullInt = "123456789";
        for (int j=2; j<=9; j++){
            for(int i=0; i<=9-j; i++) {
                int val = Integer.valueOf(fullInt.substring(i, i + j));
                if (val >= low && val <= high) result.add(val);
            }
        }
        System.out.println(result);
        return result;*/
        return IntStream.of(12,23,34,45,56,67,78,89,
                123,234,345,456,567,678,789,
                1234,2345,3456,4567,5678,6789,
                12345,23456,34567,45678,56789,
                123456,234567,345678,456789,
                1234567,2345678,3456789,
                12345678,23456789,
                123456789).filter( x -> x>=low && x<=high).boxed().toList();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println( sol.sequentialDigits(100, 300) );
    }
}