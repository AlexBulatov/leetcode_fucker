package ru.dickpickgalactic.codewars.andrew.six_kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task "Decode the Morse code" https://www.codewars.com/kata/54b724efac3d5402db00065e
 *
 * @author Andrew Slastenko
 */


public class MorseCodeDecoder {

  class MorseCode {
    public static String get(String morseCode) {
      if (morseCode == null || morseCode.isEmpty()) {return null;}
      return "char";
    }
  }

  public static String decode(String morseCode) {
    return Arrays.stream(morseCode.split(" "))
        .map(s -> !s.isBlank() ? MorseCode.get(s) : " ")
        .collect(Collectors.joining(""))
        .replace("  "," ");
  }

  public static void main(String[] args) {
    System.out.println(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
  }
}

