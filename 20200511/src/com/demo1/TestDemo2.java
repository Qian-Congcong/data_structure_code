package com.demo1;

/**
 * program: 20200511
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-11 15
 * Time:53
 */
public class TestDemo2 {
    public static void main(String[] args) {
        System.out.println(divide(10, 0));
    }
    public static int divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("抛出除 0 异常");
        }
        return x / y;
    }

    public static void main1(String[] args) {
        int[] arr = {1,2,3};
        try {
            System.out.println("before");
            System.out.println(arr[100]);
            System.out.println("after");
        }catch (ArrayIndexOutOfBoundsException e) {
            //打印出现异常的调用栈
            e.printStackTrace();
        }finally {
            System.out.println("finally code");
        }
        System.out.println("after try catch");
    }
}
