package com.demo1;

import java.util.Arrays;

/**
 * program: 20200522
 * Created with IntelliJ IDEA.
 * Description:
 * 缺点： 每次业务不同  需要去修改类本身
 *
 * 重点： 自定义类型  为什么要实现可以比较呢？
 * User: YouName
 * Date:2020-05-25 20
 * Time:11
 */
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;

    public Student(String name,int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return o.score - this.score;
    }

    @Override
    public String toString() {
        return  String.format("[name= %s %d %d]",name,age,score);
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        Student student1 = new Student("songjiang", 16, 89);
        Student student2 = new Student("tangseng", 26, 59);
        Student student3 = new Student("caocao", 6, 79);
        Student[] students = new Student[3];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

    public static void main1(String[] args) {
        Student student1 = new Student("songjiang",16,89);
        Student student2 = new Student("gaobao",26,66);
        if (student1.compareTo(student2) > 0) {
            System.out.println("student1大于stu2");
        }
    }

}
