package com.demo1;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * program: 20200522
 * Created with IntelliJ IDEA.
 * Description:
 *      7种排序
 * User: YouName
 * Date:2020-05-22 19
 * Time:08
 */
public class TestSort {
    /**
     * 时间复杂度：
     *      最坏情况：O(n^2)         最好情况(有序的情况)： O(n)
     *      越有序越快
     * 空间复杂度： O(1)
     * 稳定性： 稳定
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     * 稳定性：
     * @param array
     */
    public static void halfInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if(tmp >= array[mid]) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }

            for (int j = i; j > left; j--) {
                array[j] = array[j - 1];
            }
            array[left] = tmp;
        }
    }

    /**
     * 时间复杂度：
     *      最好情况： O(n)      最坏情况：O(n^2)
     * 空间复杂度： O(1)
     * 稳定性： 不稳定
     * @param array
     * @param gap
     */
    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                }else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int[] drr= {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    /**
     * 时间复杂度 ： O(n^2)
     * 空间复杂度 ：O(1)
     * 稳定性：不稳定 排序
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    /**
     * 时间复杂度： O(nlogn) 不管有序还是无序都是
     * 空间复杂度： O(1)
     * 稳定性： 不稳定
     * @param array
     */
    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }

    public static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
    }

    public static void adjustDown(int[] array, int root, int len) {
        int parent = root;
        int child = 2*parent + 1;
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    /**
     * 时间复杂度： O(n^2)
     * 空间复杂度： O(1)
     * 稳定性： 稳定的排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        //i:循环的趟数
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    //优化       时间复杂度： 最好情况： O(n)
    public static void bubbleSort2(int[] array) {
        boolean flg = false;
        for (int i = 0; i < array.length - 1; i++) {
            flg = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if (!flg) {
                return;
            }
        }
    }
    /**
     * 时间复杂度：
     *      O(nlogn)   最坏情况：1 2 3 4 5 6 7 8 9 /O(n^2)
     * 空间复杂度：
     *      O(logn)    最坏情况: O(n)
     * 稳定性： 有跳跃性，不稳定
     * 找基准 par
     * @param array
     * @param low
     * @param high
     */
    public static int partition(int[] array,int low,int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    public static void quick(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        //优化方式一： 当待排序序列的数据个数小于等于100，使用直接插入排序
        if (right - left + 1 < 100) {
            insert_Sort(array,left,right);
            return;
        }
        //优化二：三数取中法
        three_num_mid(array,left,right);

        int par = partition(array,left,right);
        quick(array,left,par-1);
        quick(array,par+1,right);
    }
    public static void quickSort1(int[] array) {
        quick(array,0,array.length-1);
    }

    public static void insert_Sort(int[] array, int start, int end) {
        for (int i = start+1; i <= end; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= start; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void three_num_mid(int[] array,int left,int right) {
        //array[mid] <= array[left] <= array[high]
        int mid = (right + left)/2;
        if (array[mid] > array[right]) {
            swap(array,mid,right);
        }
        if (array[left] < array[mid]){
            swap(array,left,mid);
        }
        if(array[left] > array[right]) {
            swap(array,left,right);
        }
    }

    /**
     * 非递归实现快速排序
     * @param array
     */
    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();

        int left = 0;
        int right = array.length-1;

        int par = partition(array,left,right);
        if(par > left+1) {
            stack.push(left);
            stack.push(par-1);
        }
        if(par < right-1) {
            stack.push(par+1);
            stack.push(right);
        }
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            par = partition(array,left,right);

            if(par > left+1) {
                stack.push(left);
                stack.push(par-1);
            }
            if(par < right-1) {
                stack.push(par+1);
                stack.push(right);
            }
        }
    }

    /**
     * 时间复杂度： O(nlogn)
     * 空间复杂度： O(n)
     * 稳定性： 稳定的排序
     * 外排序: 磁盘
     * @param array
     */
    //归并 -->
    public static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid + 1;
        int len = high - low + 1;
        int[] ret = new int[len];
        int i = 0;//下标

        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
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
            array[j+low] = ret[j];
        }
    }

    public static void mergeSortInternal(int[] array, int low,int high) {
        if (low >= high) {
            return;
        }
        //分解
        int mid = (low + high) >>> 1;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }

    public static void mergeSort1(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }

    /**
     * 非递归实现归并排序    常用于外部排序
     * @param array
     */
    public static void mergeNor(int[] array,int gap) {
        int[] ret = new int[array.length];
        int k = 0;//ret的下标
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1 :  array.length-1;

        //1、肯定是有两个归并段的
        while (s2 < array.length) {
            //2、对应的s1位置和s2位置进行比较
            while (s1 <= e1 && s2 <= e2) {
                if(array[s1] > array[s2]) {
                    ret[k++] = array[s2++];
                }else {
                    ret[k++] = array[s1++];
                }
            }

            //3、上述第2步在比较的过程当中，肯定会有一个下标先走完一个归并段
            //4、判断是谁没走完，把剩下的数据拷贝到结果数组当中
            while (s1 <= e1) {
                ret[k++] = array[s1++];
            }
            while (s2 <= e2) {
                ret[k++] = array[s2++];
            }
            //5、接着确定新的s1,e1,s2,e2
            s1 = s2;
            e1 = s1+gap-1;
            s2 = e1 + 1;
            e2 = s2+gap-1 < array.length ? s2+gap-1 :  array.length-1;
        }
        //6、还需要考虑另外的归并段
        while (s1 <= array.length-1) {
            ret[k++] = array[s1++];
        }
        for (int i = 0; i < ret.length; i++) {
            array[i] = ret[i];
        }
    }

    public static void mergeSort(int[] array) {
        for (int gap = 1; gap < array.length; gap *= 2) {
            mergeNor(array,gap);
        }
    }

    public static void main2(String[] args) {
        int[] array = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            //array[i] = random.nextInt(10_0000);
        }
        long start = System.currentTimeMillis();
        quickSort1(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    public static void main(String[] args) {
        int[] array = {6,1,2,7,9,3,4,5,10,8};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
