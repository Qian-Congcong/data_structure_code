package com.demo1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * program: 20200517
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-17 11
 * Time:30
 */
public class TestMain {
    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<>();
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.display();
        /*System.out.println(myArrayList.contains(5));//false
        System.out.println(myArrayList.search(5));//-1*/
        System.out.println(myArrayList.getPos(3));
        myArrayList.setPos(4,6);
        myArrayList.display();
        myArrayList.remove(6);
        myArrayList.display();

    }

    public static void main1(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addLast(3);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        myLinkedList.addLast(3);
        myLinkedList.display();
        myLinkedList.addIndex(4,5);
        myLinkedList.display();
        myLinkedList.remove(5);
        myLinkedList.display();
        myLinkedList.removeAllKey(3);
        myLinkedList.display();

    }

}
