package com.demo1;

import java.util.Stack;

/**
 * program: 20200514
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-14 20
 * Time:41
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        }else {
            int top = minStack.peek();
            if (x < top) {
                minStack.push(x);
            }
        }
    }
}
