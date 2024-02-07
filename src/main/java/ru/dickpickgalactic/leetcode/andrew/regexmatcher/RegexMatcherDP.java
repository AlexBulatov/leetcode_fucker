package ru.dickpickgalactic.leetcode.andrew.regexmatcher;

public class RegexMatcherDP {

  boolean[][] mem;

  public void showMeWhatYouGot(String source, String regex) {
    System.out.print("   0 ");
    for (int i = 0; i < regex.length(); i++) {
      System.out.print(regex.charAt(i) + " ");
    }
    System.out.println();
    for (int i = 0; i < mem.length; i++) {
      System.out.print(" " + (i == 0 ? '0' : source.charAt(i - 1)));
      for (int j = 0; j < mem[0].length; j++) {
        System.out.print(" " + (mem[i][j] ? 'T' : 'F'));
      }
      System.out.println();
    }
    System.out.println();
  }

  public boolean isMatch(String source, String regex) {
    mem = new boolean[source.length() + 1][regex.length() + 1];
    mem[0][0] = true;

    // For cases like a*b*c*
    System.out.println();
    for (int i = 1; i < mem[0].length; i++) {
      System.out.println("reg char = " + regex.charAt(i - 1));
      mem[0][i] = (regex.charAt(i - 1) == '*') && (i > 1) && mem[0][i - 2];
    }

    for (int i = 1; i < mem.length; i++) {
      for (int j = 1; j < mem[0].length; j++) {
        boolean char_match =
            (regex.charAt(j - 1) == source.charAt(i - 1)) || regex.charAt(j - 1) == '.';
        System.out.println(" regex char = " + regex.charAt(j - 1));
        System.out.println(" source char = " + source.charAt(i - 1));
        System.out.println(" char_match = " + char_match);
        System.out.println();
        if (regex.charAt(j - 1) == '*') {
          mem[i][j] = mem[i][j - 2];
          if (!mem[i][j] && (source.charAt(i - 1) == regex.charAt(j - 2) || regex.charAt(j - 2) == '.')) {
            mem[i][j] = mem[i - 1][j];
          }
        } else {
          mem[i][j] = char_match && mem[i - 1][j - 1];
        }
      }
    }

    showMeWhatYouGot(source, regex);
    return mem[source.length()][regex.length()];
  }

  public static void main(String[] args) {
    //System.out.println((new RegexMatcherDP()).isMatch("mississippi", "mis.*si.pi*"));
    System.out.println((new RegexMatcherDP()).isMatch("acc", "a*b*c*"));
  }
}
