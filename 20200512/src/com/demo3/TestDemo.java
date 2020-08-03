package com.demo3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * program: 20200512
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-13 15
 * Time:05
 */
class Student {
    private String name;
    private String myclass;
    private double score;

    public Student(String name, String myclass, double score) {
        this.name = name;
        this.myclass = myclass;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMyclass() {
        return myclass;
    }

    public void setMyclass(String myclass) {
        this.myclass = myclass;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", myclass='" + myclass + '\'' +
                ", score=" + score +
                '}';
    }
}
public class TestDemo {
    public static List<Character> func(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch +"")) {
                list.add(ch);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String str = "welcome to bit";
        String str2 = "come";
        List<Character> ret = func(str,str2);
        for (char c: ret) {
            System.out.print(c);
        }
        System.out.println();
        //System.out.println(ret);
    }

    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(7);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }

    public static void main1(String[] args) {
        Student student = new Student("小明","1711",45);
        Student student2 = new Student("小红","1712",34);
        Student student3 = new Student("小聪","1713",58);
        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student2);
        list.add(student3);
        System.out.println(list);
    }

}
