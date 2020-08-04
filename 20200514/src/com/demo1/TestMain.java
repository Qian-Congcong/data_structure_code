package com.demo1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * program: 20200514
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-14 18
 * Time:58
 */
public class TestMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

    }

    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.element());//1
    }
}
