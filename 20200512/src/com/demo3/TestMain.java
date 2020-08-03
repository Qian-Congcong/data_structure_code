package com.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * program: 20200512
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-13 14
 * Time:07
 */
public class TestMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add(1,"abc");
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("iron man");
        list2.add("java");

        list.addAll(1,list2);
        System.out.println(list);

        String s = list.remove(0);
        System.out.println(s);
        list.remove("java");
        System.out.println(list);

        System.out.println("========get=========");
        s = list.get(0);
        System.out.println(s);

        System.out.println("========set===========");
        list.set(1,"haha");     //更新
        System.out.println(list);

        System.out.println(list.contains("haha"));
        System.out.println(list.indexOf("haha"));

        list.add("haha");
        System.out.println(list.lastIndexOf("haha"));

        List<String> retList = list.subList(0,2);
        System.out.println(retList);

        retList.set(0,"boy");
        System.out.println(retList);
        System.out.println(list);

        list.clear();
        System.out.println(list);
    }
}
