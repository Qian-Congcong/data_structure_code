package com.demo1;

/**
 * program: 20200513
 * Created with IntelliJ IDEA.
 * Description:
 * 链式队列
 * User: YouName
 * Date:2020-05-13 19
 * Time:26
 */

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }

}
public class MyQueue<T> {
    public int usedSize;
    public Node<T> front;//头部
    public Node<T> rear;//尾部

    public boolean offer(T val) {
        Node<T> node = new Node<>(val);
        if (this.front == null) {
            this.front = node;
            this.rear = node;
        }else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
        return true;
    }

    //出队且删除队头元素
    public T poll() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        T data = this.front.data;
        this.front = this.front.next;
        return data;
    }

    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return this.front.data;
    }

    public boolean isEmpty() {
        return this.usedSize ==0;
    }

    public int size() {
        return this.usedSize;
    }
}
