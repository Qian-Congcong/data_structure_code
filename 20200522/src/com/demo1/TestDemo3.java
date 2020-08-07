package com.demo1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * program: 20200522
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-25 22
 * Time:27
 */
class Person {
    public String name;
    public int age;
    public int score;

    public Person(String name,int age,int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public String toString() {
        return String.format("[%s %d %d]",name,age,score);
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        AgeComparator ageComparator = new AgeComparator();
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(ageComparator);
        priorityQueue.offer(new Person("songjiang", 16, 89));
        priorityQueue.offer(new Person("caocao", 6, 79));

        System.out.println(priorityQueue);

    }

    public static void main2(String[] args) {
        Person person1 = new Person("songjiang", 16, 89);
        Person person2 = new Person("tangseng", 26, 59);
        Person person3 = new Person("caocao", 6, 79);
        Person[] people = new Person[3];
        people[0] = person1;
        people[1] = person2;
        people[2] = person3;
        AgeComparator ageComparator = new AgeComparator();
        Arrays.sort(people,ageComparator);
        System.out.println(Arrays.toString(people));
    }

    public static void main1(String[] args) {
        Person person1 = new Person("songjiang", 16, 89);
        Person person2 = new Person("tangseng", 26, 59);

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(person1, person2));
        ScoreComparator scoreComparator = new ScoreComparator();
        System.out.println(scoreComparator.compare(person1, person2));
    }
}
