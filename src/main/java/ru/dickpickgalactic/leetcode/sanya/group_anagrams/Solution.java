package ru.dickpickgalactic.leetcode.sanya.group_anagrams;

import java.util.*;

import static ru.dickpickgalactic.util.Utils.log;

public class Solution {

    String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.copyValueOf(c);
    }
/*
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> sorted = new ArrayList<>();
        for (String s: strs) {
            String sortedString = sortString(s);
            boolean inserted = false;
            for (int i=0; i< result.size(); i++){
                if(sortedString.equals(sortString(result.get(i).getFirst()))) {
                    result.get(i).add(s);
                    inserted = true;
                }
            }
            if (!inserted) {
                ArrayList<String> temp = new ArrayList<>(); temp.add(s);
                result.add(temp);
            }
        }
        return result;
    }
*/
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] sorted = new String[strs.length];
        for (int i=0; i<strs.length; i++){
            sorted[i] = sortString(strs[i]);
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i=0; i < strs.length; i++){
            if (map.containsKey(sorted[i])) {
                map.get(sorted[i]).add(strs[i]);
            }
            else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(sorted[i], temp);
            }
        }
        return new ArrayList<>(map.values().stream().toList()) ;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        log( s.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}) );
        log( s.groupAnagrams(new String[]{""}));
        log( s.groupAnagrams(new String[]{"a"}));

    }
}
