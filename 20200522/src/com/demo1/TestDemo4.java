package com.demo1;

/**
 * program: 20200522
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-26 16
 * Time:21
 */
class Animal {
    public void func() {
        System.out.println("Hello!");
    }
}

public class TestDemo4 {
    public static void main(String[] args) {
        //匿名内部类
        new Animal() {
            @Override
            public void func() {
                System.out.println("重写方法！");
            }
        }.func();
    }
}
