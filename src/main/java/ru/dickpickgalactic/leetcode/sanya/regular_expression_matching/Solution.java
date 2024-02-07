package ru.dickpickgalactic.leetcode.sanya.regular_expression_matching;

/**
 * Example 1:
 * <p>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int idxS=0;
        int idxP=0;
        char aChar = '.';
        boolean see = false;
        try {
            for (int i = 0; i < s.length(); i++) {
                if (see) {
                    if (aChar == '.') {
                        if (s.charAt(idxS) == aChar) {
                            idxP++;
                            idxS++;
                        } else idxS++;
                    }
                    else {

                    }
                } else if (p.charAt(idxP) == '.') {
                    aChar = p.charAt(idxS);
                    idxS++;
                    idxP++;
                } else if (p.charAt(idxP) == '*') {
                    see = true;
                    idxS++;
                    idxP++;
                } else {
                    idxS++;
                    idxP++;
                }
            }
        }
        catch (Exception e){
            System.out.println("Пошёл нахуй по причине: "+e.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        (new Solution()).isMatch("aa", "b");
        (new Solution()).isMatch("aa", "a*");
        (new Solution()).isMatch("ab", ".*");
    }
}
