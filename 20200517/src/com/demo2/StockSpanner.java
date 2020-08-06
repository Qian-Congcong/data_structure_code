package com.demo2;

import java.util.Arrays;

/**
 * program: 20200517
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-18 15
 * Time:50
 */
public class StockSpanner {
    public int[] elem;
    public int usedSize;
    public static final int intCapacty = 10;

    public StockSpanner() {
        this.elem = new int[intCapacty];
        this.usedSize = 0;
    }

    public int next(int price) {
        if (this.usedSize == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        this.usedSize++;
        this.elem[this.usedSize-1] = price;

        int sum = 1;
        if (this.usedSize == 1) {
            return sum;
        }

        for (int i = this.usedSize -1; i > 0; i--) {
            if (this.elem[i-1] <= this.elem[this.usedSize - 1]) {
                sum += 1;
            }else {
                return sum;
            }
        }
        return sum;
    }
}
