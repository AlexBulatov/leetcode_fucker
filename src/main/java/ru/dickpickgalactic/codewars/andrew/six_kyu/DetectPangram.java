package ru.dickpickgalactic.codewars.andrew.six_kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DetectPangram {

  public static boolean check(String sentence){
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    return Arrays.stream(sentence.toLowerCase().replaceAll("[^a-z]", "").split(""))
        .distinct()
        .sorted()
        .collect(Collectors.joining())
        .equals(alphabet);
  }

  public static void main(String[] args) {
    check("The quick brown fox jumps over the lazy dog.");
  }

}
