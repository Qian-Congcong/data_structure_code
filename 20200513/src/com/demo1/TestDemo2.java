package com.demo1;

import java.util.Scanner;
import java.util.Stack;

/**
 * program: 20200513
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-14 14
 * Time:37
 */
public class TestDemo2 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ')' && ch != ']' && ch != '}') {
                stack.push(ch);
            }else {
                if(stack.empty()) {
                    System.out.println("右括号多！");
                    return false;
                }
                char ch2 = stack.peek();
                if(ch2 == '(' && ch == ')' || ch2 == '[' && ch == ']'
                        || ch2 == '{' && ch == '}') {
                    stack.pop();
                }else {
                    System.out.println("左右括号不匹配！");
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            System.out.println("左括号多！");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(isValid(str));
            System.out.println("======================");
        }

    }
}
