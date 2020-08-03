package com.demo2;

/**
 * program: 20200512
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-13 13
 * Time:28
 */

/**
 * 泛型的意义
 * 1、可以自动进行类型的检查
 * 2、可以自动进行类型的转换
 *
 * 面试问题： 泛型怎么编译的？
 * 四个字：擦除机制
 * 重要：泛型只是编译时期的一种机制 --》 擦除机制。 在运行时，不存在泛型这种说法。
 * 所有的处理均在编译阶段已经处理
 *
 * 擦除机制：在编译的时候，泛型类型被擦除为Object了，不是替换
 *
 * 泛型的坑
 * 1、不能new 泛型类型的数组， this.elem = new T[10];
 * 2、简单类型不能作为泛型类型的参数
 *      MyArrayList<float> myArrayList2 = new MyArrayList<>();
 * 3、泛型的类型，不参与类型的组成
 *      MyArrayList<Integer> myArrayList = new MyArrayList<>();
 *      com.demo2.MyArrayList@a14482
 * @param <T>
 */
public class MyArrayList<T> {
    public T[] elem;
    public int usedSize;

    public MyArrayList() {
        //this.elem = new T[10];
        this.elem = (T[])new Object[10];
        this.usedSize = 0;
    }

    //默认放到数组最后
    public void add(T val) {
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }

    public T getVal(int pos) {
        return this.elem[pos];
    }
}
