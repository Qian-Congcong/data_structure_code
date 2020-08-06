package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * program: 20200521
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-23 21
 * Time:24
 */
public class TestDemo {
    public static int[] smallestK(int[] arr, int k) {
        //参数检测
        if (null == arr || k <= 0) {
            return new int[0];
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(arr.length);

        //将数组中的元素一次方到堆中
        for (int i = 0; i < arr.length; ++i) {
            q.offer(arr[i]);
        }

        //将优先级队列的前K 个元素放到数组中
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = q.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] ret = smallestK(arr,4);
        System.out.println(Arrays.toString(ret));
    }

    public static void main3(String[] args) {
        int[] arr = {4,1,9,2,8,0,7,3,6,5};

        //一般在创建优先级队列对象时，如果知道元素个数，建议就直接将底层容量给好
        //否则在插入时需要不多的扩容、
        //扩容机制： 开辟更大的空间，拷贝元素，这样效率会比较低
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int e: arr) {
            q.offer(e);
        }

        System.out.println(q.size());
        System.out.println(q.peek());

        //
        q.poll();
        q.poll();
        System.out.println(q.size());//8
        System.out.println(q.peek());//2

        q.offer(0);
        System.out.println(q.peek());//0

        q.clear();
        if(q.isEmpty()) {
            System.out.println("优先级队列已经为空！");
        }else {
            System.out.println("优先级队列不为空！");
        }
    }

    public static void main2(String[] args) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        q1.offer(10);
        q1.offer(2);
        q1.offer(1);
        q1.offer(6);

        System.out.println(q1.peek());
        System.out.println(q1.poll());
        System.out.println(q1.peek());

    }

    public static void main1(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();

        //创建一个空的优先级队列，底层默认容量是11
        PriorityQueue<Integer> q1 = new PriorityQueue<>();

        //创建一个空的优先级队列，底层的容量为initialCapacity
        PriorityQueue<Integer> q2 = new PriorityQueue<>();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        //用ArrayList对象来构造一个优先级队列的对象
        //q3中包含三个元素
        PriorityQueue<Integer> q3 = new PriorityQueue<>(list);
        Object[] arr = q3.toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(q3.size());
        System.out.println(q3.peek());
    }
}
