package com.demo;

/**
 * program: 20200526
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-27 20
 * Time:39
 */
class OuterClass2 {
    public int data1 = 1;
    public static int data2 = 2;

    private int data4 = 4;

    /**
     * 静态内部类
     * 静态内部类当中 不能访问外部类的非静态的数据成员
     */
    static class InnerClass {
        public int data3 = 3;
        public OuterClass2 out;

        public InnerClass (OuterClass2 out) {
            this.out = out;
        }

        public void func() {
            System.out.println(this.out.data1);//1
            System.out.println(data2);//2
            System.out.println(data3);//3
            System.out.println(this.out.data4);//4
        }
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        OuterClass2 outerClass = new OuterClass2();
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass(outerClass);
        innerClass.func();
    }


}

