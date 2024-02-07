package ru.dickpickgalactic.leetcode.sanya.first_unique;

/** <h1>387. First Unique Character in a String</h1>
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * */
public class Solution {

    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        for(char c : s.toCharArray()){
            letters[c-'a']++;
        }
        for(int i=0; i<s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.firstUniqChar("leetcode");
        s.firstUniqChar("loveleetcode");
        s.firstUniqChar("aabb");
    }
}
