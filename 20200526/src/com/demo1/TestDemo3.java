package com.demo1;

/**
 * program: 20200526
 * Created with IntelliJ IDEA.
 * Description: 泛型的边界
 * User: YouName
 * Date:2020-05-26 19
 * Time:06
 */

/**
 * 写一个泛型类， 包含一个方法。该方法是找到数组当中的最大值。
 * 写一个方法，该方法传入参数T[] ，找到最大值并且返回
 *
 * T extends Comparable<T>  上界
 * T 一定是实现了 Comparable接口的
 *
 * 下界？？ 泛型没有下界
 */
class Generic<T extends Comparable<T>> { //边界
    public T maxNum(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}

/**
 * 类型推到 --》 根据实参的类型推导出形参的类型
 *
 */
class Generic2 {

    public static <T extends Comparable<T>> T maxNum(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        Integer[] integers = {12, 4, 2, 89, 5, 19};
        System.out.println(Generic2.<Integer>maxNum(integers));

        String[] strings = {"abc", "hello", "bit"};
        System.out.println(Generic2.<String>maxNum(strings));
    }

    public static void main1(String[] args) {
        Generic<Integer> generic = new Generic<>();
        Integer[] integers = {12,4,2,89,5,19};
        System.out.println(generic.maxNum(integers));

        Generic<String> generic2 = new Generic<>();
        String[] strings = {"abc", "hello", "bit"};
        System.out.println(generic2.maxNum(strings));
    }
}
