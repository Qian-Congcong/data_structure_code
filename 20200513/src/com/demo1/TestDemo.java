package com.demo1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * program: 20200513
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-13 19
 * Time:12
 */
public class TestDemo {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());//出栈
        System.out.println(myQueue.peek());
    }

    public static void main3(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());//出栈
        System.out.println(queue.peek());

    }

    public static void main2(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());//3
        System.out.println(stack.pop());//3
        System.out.println(stack.peek());//2
        System.out.println(stack.empty());
        System.out.println(stack.size());//2
    }

    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        System.out.println(stack.peek());//拿到栈顶元素但是不删除
        System.out.println(stack.pop());//出栈并且删除栈顶元素
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        System.out.println(stack.search(1));
    }
}
