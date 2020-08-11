package com.demo2;

/**
 * program: 20200608
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-09 15
 * Time:00
 */
public class mergeDemo {

    public static void mergeSort(int[] array) {
        mergeSortInternal(array,0,array.length - 1);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        //分解
        int mid = (low + high) >>> 1;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid+1, high);
        //合并
        merge(array, low, mid, high);
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid + 1;
        int len = high - low + 1;
        int[] ret = new int[len];
        int i = 0;//用来表示ret数组的下标

        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                ret[i++] = array[s1++];
            }else {
                ret[i++] = array[s2++];
            }
        }

        while (s1 <= mid) {
            ret[i++] = array[s1++];
        }

        while (s2 <= high) {
            ret[i++] = array[s2++];
        }

        for (int j = 0; j < ret.length; j++) {
            array[j + low] = ret[j];
        }
    }

}
