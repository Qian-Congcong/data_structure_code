package com.demo1;

import java.util.Comparator;

/**
 * program: 20200522
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-26 16
 * Time:04
 */
public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }
}
