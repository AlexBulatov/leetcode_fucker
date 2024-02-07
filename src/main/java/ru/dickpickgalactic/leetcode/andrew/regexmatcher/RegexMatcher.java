package ru.dickpickgalactic.leetcode.andrew.regexmatcher;

public class RegexMatcher {

  public boolean isMatch(String source, String regex) {
    if (regex.isEmpty()) {
      return source.isEmpty();
    }
    if (regex.length() > 1 && regex.charAt(1) == '*') {
      if (source.isEmpty() && regex.length() == 2) {
        return true;
      }
      String sourceTemp = source;
      while (!source.isEmpty() && (regex.charAt(0) == source.charAt(0) || regex.charAt(0) == '.')) {
        if (isMatch(source.substring(1), regex.substring(2))) {
          return true;
        }
        source = source.substring(1);
      }
      return isMatch(sourceTemp, regex.substring(2));
    } else {
      if (source.isEmpty()) {
        return false;
      }
      return (source.charAt(0) == regex.charAt(0) || regex.charAt(0) == '.') && isMatch(
          source.substring(1),
          regex.substring(1));
    }
  }

  public static void main(String[] args) {
//    System.out.println((new RegexMatcher()).isMatch("mississippi", "mis*is*p*.")); //false
//    System.out.println((new RegexMatcher()).isMatch("ab", ".*c")); // false
//    System.out.println((new RegexMatcher()).isMatch("a", "ab*")); // true
//    System.out.println((new RegexMatcher()).isMatch("a", "ab*a")); // false
//    System.out.println((new RegexMatcher()).isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*c")); // false
//    System.out.println((new RegexMatcher()).isMatch("a", "..*")); // true
//      System.out.println((new RegexMatcher()).isMatch("aa", "a*")); // true
//    System.out.println((new RegexMatcher()).isMatch("ab", ".*..")); // true
    System.out.println((new RegexMatcher()).isMatch("bbbba", ".*a*a")); // true
  }

}
