package ru.dickpickgalactic.codewars.andrew.six_kyu;

import java.util.HashMap;
import java.util.Map;

/**
 * Duplicate Encoder
 * https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/java
 *
 * @author Andrew Slastenko
 */
public class DuplicateEncoder {

  static String encode(String word) {
    Map<Character, Integer> map = new HashMap<>();
    String loweredWord = word.toLowerCase();
    for (int i = 0; i < word.length(); i++) {
      map.put(loweredWord.charAt(i), map.getOrDefault(loweredWord.charAt(i), 0) + 1);
    }
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < loweredWord.length(); j++) {
      if (map.get(loweredWord.charAt(j)).equals(1)) {
        sb.append("(");
      } else {
        sb.append(")");
      }
    }
    return sb.toString();
  }
  public static void main(String[] args) {
    //System.out.println(encode("din"));
    //System.out.println(encode("recede"));
    System.out.println(encode("Success"));
    //System.out.println(encode("(( @"));
  }
}
