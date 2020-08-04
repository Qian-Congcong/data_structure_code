package com.demo2;

/**
 * program: 20200515
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-16 22
 * Time:43
 */
public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.display();

        myLinkedList.addAtIndex(1,2);
        myLinkedList.display();

        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(0);
        myLinkedList.display();

        System.out.println(myLinkedList.get(0));



    }
}
