package ru.dickpickgalactic.andrew.evalrpn;

public class Solution {

  public int evalRPN(String[] tokens) {
    for (int i = 0; i < tokens.length; i++) {
      int num1, num2, pos1, pos2;
      num1 = num2 = pos1 = pos2 = -1;
      if (tokens[i].matches("[/*\\-+]")) {
        System.out.println(" pos = " + i);
        for (int j = i - 1; j >= 0; j--) {
          if (tokens[j] != null && !tokens[j].matches("[/*\\-+]")) {
            if (pos1 < 0) {
              pos1 = j;
              num1 = Integer.parseInt(tokens[j]);
              System.out.println(" pos1 = " + pos1);
              System.out.println(" num1 = " + num1);
              continue;
            }
            pos2 = j;
            num2 = Integer.parseInt(tokens[j]);
            System.out.println(" num2 = " + num2);
            System.out.println(" pos2 = " + pos2);
            break;
          }
        }
        switch (tokens[i]) {
          case "/":
            tokens[pos2] = String.valueOf(num2 / num1);
            break;
          case "*":
            tokens[pos2] = String.valueOf(num2 * num1);
            break;
          case "-":
            tokens[pos2] = String.valueOf(num2 - num1);
            break;
          case "+":
            tokens[pos2] = String.valueOf(num2 + num1);
            break;
        }
        tokens[pos1] = null;
        tokens[i] = null;
      }
    }
    return Integer.parseInt(tokens[0]);
  }

  public static void main(String[] args) {
    int res = (new Solution()).evalRPN(new String[]{"2","1","+","3","*"});
    System.out.println(res);
  }

}
