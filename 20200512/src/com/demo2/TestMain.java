package com.demo2;

/**
 * program: 20200512
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-13 13
 * Time:16
 */
class Person {

}
public class TestMain {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        System.out.println("================");
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        System.out.println(myArrayList);

        MyArrayList<Person> myArrayList2 = new MyArrayList<>();
        System.out.println(myArrayList2);
    }

    public static void main2(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(2);
        myArrayList.add(2);

        int val = myArrayList.getVal(1);
        System.out.println(val);
    }

    /**
     * 问题
     * 1、myArrayList中可以放任意类型
     * 2、取出时不用强转
     * @param args
     */
    public static void main1(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        int val = (int)myArrayList.getVal(1);
        System.out.println(val);
    }
}

