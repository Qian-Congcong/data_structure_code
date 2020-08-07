package com.demo1;

import com.sun.crypto.provider.HmacMD5KeyGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * program: 20200522
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-25 20
 * Time:43
 */
class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class TopK {
    /**
     * 求前K 个最大的 -》 大小为K 的小堆
     * 求前K 个最小的 -》 大小为K 的大堆
     * @param
     */
    public static Integer[] topK(int[] array, int k) {
        MyComparator myComparator = new MyComparator();
        //方法一
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(myComparator);

        //方法二
        // 匿名内部类
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            }else {
                Integer val = maxHeap.peek();
                if (val != null && val > array[i]) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        Integer[] ret = new Integer[k];
        for (int i = 0; i < k; i++) {
            int v = maxHeap.poll();
            ret[i] = v;
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        Integer[] ret = topK(array,4);
        System.out.println(Arrays.toString(ret));
    }

}
