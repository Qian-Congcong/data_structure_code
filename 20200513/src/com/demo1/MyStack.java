package com.demo1;

import java.util.Arrays;
import java.util.Stack;

/**
 * program: 20200513
 * Created with IntelliJ IDEA.
 * Description:
 * 顺序栈
 * User: YouName
 * Date:2020-05-13 19
 * Time:12
 */
public class MyStack<T> {
    private T[] elem;//数组
    private int top;//表示当前可以存放数据元素的下标

    public MyStack() {
        this.elem = (T[])new Object[10];
    }

    public void push(T val) {
        if (full()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.top++] = val;
    }

    public boolean empty() {
        return this.top == 0;
    }

    public boolean full() {
        return this.top == this.elem.length;
    }

    public T pop() {
        if (empty()) {
            throw new RuntimeException("栈空！");
            //return -1;
        }
       /* int data = this.elem[this.top - 1];
        this.top--;
        return data;*/
        return this.elem[--this.top];
    }

    public T peek() {
        if (empty()) {
            throw new RuntimeException("栈空！");
            //return -1;
        }
        return this.elem[this.top - 1];
    }

    public int size() {
        return this.top;
    }
}
