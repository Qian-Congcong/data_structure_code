package com.demo2;

/**
 * program: 20200515
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-16 21
 * Time:31
 */
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyLinkedList {
    public Node head;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        Node cur = this.head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        if (cur != null) {
            return cur.val;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (index < 0) {
            node.next = this.head;
            this.head = node;
        }
        Node cur = this.head;
        Node prev = this.head;
        while (index > 0) {
            if (cur == null) {
                break;
            }
            prev= cur;
            cur = cur.next;
            index--;
        }
        if (cur != null) {
            node.next = prev.next;
            prev.next = node;
        }else {
            prev.next = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            throw new RuntimeException("index位置不合法!");
        }
        Node cur = this.head;
        Node prev = cur;
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        while (index > 0) {
            prev = cur;
            cur = cur.next;
            index--;
        }
        if (cur != null) {
            prev.next = cur.next;
        }else {
            return;
        }
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
