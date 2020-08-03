package com.demo2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * program: 20200511
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-11 19
 * Time:12
 */
class Student {
    private String name;
    private String classes;
    private double size;


}
public class TestMain {
    public static List<Character> func(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")) {
                list.add(ch);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String str1 = "welcome xian";
        String str2 = "come";
        List<Character> ret = new ArrayList<>();

        System.out.println(ret);

    }

    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

}
