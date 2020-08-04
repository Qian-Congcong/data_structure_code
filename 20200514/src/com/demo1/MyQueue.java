package com.demo1;

import java.util.LinkedList;
import java.util.Stack;

/**
 * program: 20200514
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-14 19
 * Time:56
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) {
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.empty() && stack2.empty()) {
            return true;
        }
        return false;
    }
    /*private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    *//** Initialize your data structure here. *//*
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    *//** Push element x to the back of queue. *//*
    public void push(int x) {

    }

    *//** Removes the element from in front of queue and returns that element. *//*
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    *//** Get the front element. *//*
    public int peek() {
        return -1;
    }

    *//** Returns whether the queue is empty. *//*
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }*/
}
