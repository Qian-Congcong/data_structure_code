package com.demo;

/**
 * program: 20200526
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-27 20
 * Time:39
 */
class Animal {
    public void func() {
        System.out.println("Hello Boy!");
    }
}
public class TestDemo3 {
    public static void main(String[] args) {
        /**
         * 匿名内部类
         *
         */
        new Animal() {
            @Override
            public void func() {
                System.out.println("重写方法！");
            }
        }.func();
    }
}
