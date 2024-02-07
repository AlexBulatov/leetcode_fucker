package ru.dickpickgalactic.sanya.sort_by_frequency;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import static ru.dickpickgalactic.util.Utils.log;

/**
 * <h1>451. Sort Characters By Frequency</h1>
 * <br/>
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 * <br/>
 * Return the sorted string. If there are multiple answers, return any of them.
 */
public class Solution {

    public String frequencySort(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        ArrayList<Entry<Character, Integer>> arr =  new ArrayList<>(
                map
                        .entrySet()
                        .stream()
                        .sorted((x, y) -> y.getValue() - x.getValue())
                        .toList()
        );
        StringBuilder sb = new StringBuilder();
        for (Entry<Character, Integer> e: arr) {
            sb.append(e.getKey().toString().repeat(e.getValue()));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        log( s.frequencySort("tree") );
        log( s.frequencySort("cccaaa") );
    }
}
