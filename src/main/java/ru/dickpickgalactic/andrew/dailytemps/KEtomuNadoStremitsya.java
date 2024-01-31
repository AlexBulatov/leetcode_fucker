package ru.dickpickgalactic.andrew.dailytemps;

import java.util.Stack;

public class KEtomuNadoStremitsya {

  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stk = new Stack<>();

    int[] res = new int[temperatures.length];
    int n = temperatures.length;

    for(int i = 0;i<n;i++){
      while(!stk.empty() && temperatures[i] > temperatures[stk.peek()]){
        int idx = stk.pop();
        res[idx] = i-idx;
      }
      stk.push(i);
    }

    return res;

  }

}
