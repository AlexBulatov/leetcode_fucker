package ru.dickpickgalactic.leetcode.sanya.valid_brackets;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char symbol: s.toCharArray()) {
            switch (symbol) {
                case '(':
                case '[':
                case '{':
                    stack.push(symbol);
                    break;
                case ')':
                    if(stack.empty() || stack.pop() != '(' ) return false;
                    break;
                case ']':
                    if(stack.empty() || stack.pop() != '[' ) return false;
                    break;
                case '}':
                    if(stack.empty() || stack.pop() != '{' ) return false;
                    break;
                default:
                    break;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args){
        System.out.println((new Solution()).isValid("()"));
        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("(]"));
        System.out.println((new Solution()).isValid("]"));
    }
}
