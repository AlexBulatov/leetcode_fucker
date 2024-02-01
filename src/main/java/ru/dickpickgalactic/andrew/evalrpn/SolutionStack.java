package ru.dickpickgalactic.andrew.evalrpn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SolutionStack {

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    Set<String> operators = new HashSet<>(Arrays.asList("/", "*", "-", "+"));
    for (String token : tokens) {
      if (!operators.contains(token)) {
        stack.push(Integer.parseInt(token));
        continue;
      }
      if (stack.size() < 2) {
        return 0;
      }
      Integer op2 = stack.pop();
      Integer op1 = stack.pop();
      switch (token) {
        case "/":
          stack.push(op1 / op2);
          break;
        case "-":
          stack.push(op1 - op2);
          break;
        case "+":
          stack.push(op1 + op2);
          break;
        case "*":
          stack.push(op1 * op2);
          break;
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    int res = (new SolutionStack()).evalRPN(new String[]{"2", "1", "+", "3", "*"});
    System.out.println(res);
  }
}
