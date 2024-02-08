package ru.dickpickgalactic.codewars.andrew.six_kyu;

import static ru.dickpickgalactic.util.Utils.log;

import java.util.Arrays;

public class BreakCamelCase {
  public static String camelCase(String input) {
    //return input.replaceAll("([A-Z])", " $1");
    return Arrays.stream(input.split(""))
        .map(s -> s.matches("[A-Z]") ? " " + s : s)
        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
        .toString();
  }

  public static void main(String[] args) {
    log (camelCase("camelCase"));
  }

}
