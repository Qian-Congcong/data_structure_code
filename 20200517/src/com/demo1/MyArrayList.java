package com.demo1;

import java.util.Arrays;

/**
 * program: 20200517
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-17 19
 * Time:53
 */
public class MyArrayList<E> {
    public Object[] elem;
    public int usedSize;
    public static final int intCapacity = 10;

    public MyArrayList() {
        this.elem = new Object[intCapacity];
        this.usedSize = 0;
    }


    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();

        //System.out.println(Arrays.toString(this.elem));
    }

    private boolean isFull() {
        return this.elem.length == this.usedSize;
    }
    // 在 pos 位置新增元素
    public void add(int pos, Object data) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        if (pos < 0 || this.usedSize > pos) {
            return;
        }
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(E toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return true;
    }
    // 查找某个元素对应的位置
    public int search(E toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }
    // 获取 pos 位置的元素
    public Object getPos(int pos) {
        if (isEmpty()) {
            throw new RuntimeException("顺序表为空！");
        }
        if (pos < 0 || pos >= this.usedSize) {
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (i == pos) {
                return this.elem[i];
            }
        }
        return -1;
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, E value) {
        if (pos < 0 || pos > this.usedSize) {
            return;
        }
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (pos == i) {
                this.elem[i] = value;
                return;
            }
        }
        this.elem[this.usedSize] = value;
        this.usedSize++;
    }

    private int prevRemove(E toRemove) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toRemove) {
                return i;
            }
        }
        return -1;
    }
    //删除第一次出现的关键字key
    public void remove(E toRemove) {
        int index = prevRemove(toRemove);
        if (index == -1) {
            return;
        }
        for (int i = index; i < this.usedSize; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}
