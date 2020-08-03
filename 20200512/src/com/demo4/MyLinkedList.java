package com.demo4;

/**
 * program: 20200512
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-13 17
 * Time:37
 */
class Node<T> {
    private T val;
    protected Node<T> prev;
    protected Node<T> next;

    public Node(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
public class MyLinkedList<T> {
    protected Node<T> head;
    protected Node<T> tail;


}
