/*
* Given a string consisting of opening and closing parenthesis,
* find length of the longest valid parenthesis substring.
*
* Input : ((() or )()()) or ()(()))))
*
* http://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0
 */

import java.util.*;
import java.lang.*;

class LongestValidParentheses {
    public static void main (String[] args) {
        balancedParentheses("((()".split(""));
        balancedParentheses(")()())".split(""));
        balancedParentheses("()(()))))".split(""));
        System.out.println("-----------------");
        balancedParentheses2("((()".split(""));
        balancedParentheses2(")()())".split(""));
        balancedParentheses2("()(()))))".split(""));
    }

    static void balancedParentheses(String[] string) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);

        for(int i = 0; i < string.length; i++) {
            if (string[i].equals("(")) {
                stack.push(i);
            }
            else {
                stack.pop();
                if (!stack.empty()) {
                    res = Math.max(res, i - stack.peek());
                }
                else {
                    stack.push(i);
                }
            }
        }

        System.out.println(res);
    }

    static void balancedParentheses2(String[] string) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, temp = 0;
        int[] colors = new int[string.length];

        for (int i = 0; i < string.length; i++) {
            if(string[i].equals("(")) {
                stack.push(i);
            }
            else {
                if (!stack.empty()) {
                    colors[i] = 1;
                    colors[stack.pop()] = 1;
                }
            }
        }

        for (int i : colors){
            if (i==1) {
                temp++;
            }
            else {
                res = Math.max(temp, res);
                temp = 0;
            }
        }
        System.out.println(Math.max(temp, res));
    }
}
