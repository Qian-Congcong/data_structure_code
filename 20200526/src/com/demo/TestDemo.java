package com.demo;

/**
 * program: 20200526
 * Created with IntelliJ IDEA.
 * Description:
 * 实例内部类
 * 静态内部类
 * 匿名内部类
 * User: YouName
 * Date:2020-05-27 19
 * Time:55
 */

class OuterClass {
    public int data1 = 1;
    public static int data2 = 2;

    private int data4 = 4;

    /**
     * 实例内部类  -> 看作是一个普通的实例数据成员
     */
    class InnerClass {
        public int data3 = 3;
        public int data1 = 10;
        public static final int a = 99;//编译

        public void func() {
            System.out.println(data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(OuterClass.this.data1);// 额外的开销this
            System.out.println(data4);
        }
    }
}
public class TestDemo {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.func();
    }
}
