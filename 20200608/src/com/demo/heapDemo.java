package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * program: 20200608
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-09 11
 * Time:46
 */
public class heapDemo {

    public static void shiftDown(int[] array, int parent) {
        //child 先标记 parent 的左孩子，因为 parent 可能有左没有右
        int child = 2 * parent + 1;
        int size = array.length;

        while (child < size) {
            // 如果右孩子存在，找到左右孩子中较小的孩子,用child进行标记
            if (child + 1 < size && array[child+1] < array[child]) {
                child += 1;
            }
            //
            if (array[parent] <= array[child]) {
                break;
            }else {
                // 将双亲与较小的孩子交换
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;

                //parent中大的元素往下移动，可能会造成子树不满足堆的性质，因此需要继续向下调整
                parent = child;
                child = parent * 2 + 1;
            }
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int k = Integer.parseInt(str[str.length - 1]);
        int[] ret = heapSort(arr,k);
        for (int i = 0; i < ret.length - 1; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println(ret[ret.length - 1]);
    }

    private static int[] heapSort(int[] arr, int k) {
        createHeap(arr);
        int[] ret = new int[k];
        int x = 0;
        int end = arr.length - 1;
        while (k > 0 && end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            ret[x++] = arr[end];
            adjustDown(arr,0, end);
            end--;
            k--;
        }
        return ret;
    }

    public static void createHeap(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(arr, i, arr.length);
        }
    }

    private static void adjustDown(int[] arr, int root, int len) {
        int parent = root;
        int child = 2*parent + 1;
        while (child < len) {
            while (child + 1 < len && arr[child + 1] < arr[child]) {
                child++;
            }
            if (arr[child] < arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;

                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }
    }
}
