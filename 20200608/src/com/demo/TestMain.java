package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * program: 20200608
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-09 10
 * Time:05
 */

public class TestMain {


    /**
     * 找出 n 个数里最小的 k 个
     */

    public static int[] minSort(int[] a, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            queue.add(a[i]);
        }
        int[] ret = new int[k];
        for (int j = 0; j < k; j++) {
            ret[j] = queue.poll();
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int k = Integer.parseInt(str[str.length - 1]);
        int[] ret = minSort(arr,k);
        for (int i = 0; i < ret.length - 1; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println(ret[ret.length-1]);
    }

    /**
     * 删数
     *
     */
    public static int deleteNum(int[] arr) {
        int count = arr.length;
        int repeat = 0;
        for (int i = 0; i < arr.length;) {
            if (arr[i] != -1) {
                repeat++;
            }
            if (repeat == 3) {
                arr[i] = -1;
                repeat = 0;
                count--;
                if (count == 0) {
                    return i;
                }
            }
            i = ++i % arr.length;
        }
        return -1;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        num = Math.min(num,1000);
        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = i;
        }
        System.out.println(deleteNum(a));
    }

    public static void main1(String[] args) {
        double x = 3.0;
        int y = 5;
        x /= --y;
        System.out.println(x);
    }
}
