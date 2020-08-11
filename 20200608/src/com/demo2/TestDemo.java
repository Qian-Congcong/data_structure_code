package com.demo2;

/**
 * program: 20200608
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-09 15
 * Time:29
 */
public class TestDemo {
    public static int count(int[] A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        return mergeSortInternal(A,0,n - 1);
    }

    private static int mergeSortInternal(int[] a, int low, int high) {
        if (low == high) {
            return 0;
        }
        //分解
        int mid = (high + low) >>> 1;
        return mergeSortInternal(a, low, mid) + mergeSortInternal(a,mid + 1, high)
                + merge(a, low, mid, high);
    }

    private static int merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        int num = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                tmp[index++] = a[i++];
            }else {
                num += (mid - i + 1);
                tmp[index++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = a[i++];
        }
        while (j <= right) {
            tmp[index++] = a[j++];
        }
        for (int k = 0; k < tmp.length; k++) {
            a[left++] = tmp[k];
        }
        return num;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(count(array, array.length));
    }
}
