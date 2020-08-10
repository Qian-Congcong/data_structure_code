package com.demo1;

import java.util.Scanner;
import java.util.Stack;

/**
 * program: 20200603
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-04 17
 * Time:12
 */
public class Parenthesis {
    /**
     * 合法括号串
     *1、栈的录入比较
     *
     */
    public static boolean chkParenthesis1(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        if (n % 2 != 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (ch == ')') {
                if (stack.empty()) {
                    return false;
                }else {
                    stack.pop();
                }

            }else if (ch == '('){
                stack.push(A.charAt(i));
            }else if (ch != '(' && ch != ')') {
                return false;
            }
        }

        if (!stack.empty()) {
            return false;
        }else {
            return true;
        }
    }

    public static boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        if (n % 2 != 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c != '(' && c != ')') {
                return false;
            }
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        /*String str = "()(()()";
        System.out.println(chkParenthesis(str, str.length()));*/
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(chkParenthesis(str, str.length()));
    }
}
