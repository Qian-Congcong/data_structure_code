package com.demo1;

import java.util.Scanner;

/**
 * program: 20200603
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-04 16
 * Time:46
 */
class Person {
    private String name = "Person";
    int age = 0;
}
public class TestMain extends Person{


    /**
     * 数字串
     * 1、数字串的截取
     * 2、比较最长返回
     */

    public static String[] intercept(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

        }
        return null;
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        intercept(str);
    }

    /*public String grade;

    public static void main(String[] args) {
        Person p = new TestMain();
        System.out.println(p.name);
    }*/

    public static void main1(String[] args) {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1 == str2);
    }
}
