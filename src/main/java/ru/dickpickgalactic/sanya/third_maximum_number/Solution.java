package ru.dickpickgalactic.sanya.third_maximum_number;

import java.util.Comparator;
import java.util.LinkedList;

import static ru.dickpickgalactic.util.Utils.log;

public class Solution {

    public int thirdMax(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int num: nums) {
            if (!list.contains(num))
                list.add(num);
            list.sort(Comparator.reverseOrder());
            if (list.size() > 3) {
                list.removeLast();
            }
        }
        if (list.size() < 3) return list.getFirst();
        else return list.getLast();
    }

    public static void main(String[] args) {
        log((new Solution()).thirdMax(new int[]{3,2,1}));
        log((new Solution()).thirdMax(new int[]{-2147483648,1,1}));
    }
}
