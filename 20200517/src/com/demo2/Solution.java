package com.demo2;

import java.util.Scanner;
import java.util.Stack;

/**
 * program: 20200517
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-18 16
 * Time:40
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = {"2", "1", "+", "3", "*"};
        int ret = evalRPN(str);
        System.out.println(ret);
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer op1,op2;
        for (String s: tokens) {
            switch (s) {
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();

        /*for (int i = 0;i < tokens.length; i++) {
            if (!"+".equals(tokens[i]) || !"-".equals(tokens[i])
                    || !"*".equals(tokens[i]) || !"/".equals(tokens[i])) {
                stack.push(tokens[i]);
            }else {
                String str = tokens[i];
                switch (str) {
                    case "+":
                        break;
                    case "-":
                        break;
                    case "*":
                        break;
                    case "/":
                        break;
                    default:
                        break;
                }
            }

        }*/

    }


}
