package com.demo1;

/**
 * program: 20200517
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-17 11
 * Time:32
 */

class Node<E> {
    public E val;
    public Node<E> next;

    public Node(E val) {
        this.val = val;
    }
}
public class MyLinkedList<E> {
    public Node<E> head;

    //头插法
    public void addFirst(E val) {
        Node<E> node = new Node<>(val);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(E val) {
        Node<E> node = new Node<>(val);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node<E> cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    private void checkIndex(int index) {
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("index 位置不合法！");
        }
    }
    private Node<E> searchIndex(int index) {
        Node<E> cur = this.head;
        Node<E> prev = this.head;
        while (index > 0) {
            if (cur.next == null) {
                break;
            }
            prev = cur;
            cur = cur.next;
            index--;
        }
        return prev;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,E data) {
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == this.size()) {
            addLast(data);
            return;
        }
        Node<E> node = new Node<>(data);
        Node<E> prev = searchIndex(index);
        node.next = prev.next;
        prev.next = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(E key) {
        if (this.head == null) {
            return false;
        }
        Node<E> cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(E key) {
        if (this.head == null) {
            return;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        Node<E> cur = this.head;
        Node<E> prev = this.head;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(E key) {
        if (this.head == null) {
            return;
        }
        Node<E> cur = this.head;
        Node<E> prev = this.head;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.val == key) {
            this.head = this.head.next;
        }
    }
    //得到单链表的长度
    public int size() {
        int count = 0;
        Node<E> cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display() {
        Node<E> node = this.head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    public void clear() {
        this.head = null;
    }

    /** Initialize your data structure here. *//*
    public MyLinkedList() {
        clear();
    }

    public void clear() {
        this.head = null;
    }

    *//** Get the value of the index-th node in the linked list. If the index is invalid, return -1. *//*
    public E get(int index) {
        if (index < 0) {
            return null;
        }
        Node<E> cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        if (cur != null) {
            return cur.val;
        }
        return null;
    }

    *//** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. *//*
    public void addAtHead(E val) {
        Node<E> node = new Node<>(val);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    *//** Append a node of value val to the last element of the linked list. *//*
    public void addAtTail(E val) {
        Node<E> node = new Node<>(val);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node<E> cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    *//** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. *//*
    public void addAtIndex(int index, E val) {
        Node<E> node = new Node<>(val);
        if (index < 0) {
            node.next = this.head;
            this.head = node;
        }
        if (index == 0) {
            this.head = node;
        }
        Node cur = this.head;
        Node prev = cur;
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

    *//** Delete the index-th node in the linked list, if the index is valid. *//*
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
    }*/
}
