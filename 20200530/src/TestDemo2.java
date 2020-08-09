import java.util.Stack;

/**
 * program: 20200530
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-01 15
 * Time:06
 */
public class TestDemo2 {
    public static int findKth1(int[] a, int n, int K) {
        // write code here
        if (K > n) {
            throw new RuntimeException("K 不合法！");
        }
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (tmp < a[j]) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = tmp;
        }
        return a[K-1];
    }

    public static int findKth(int[] a, int n, int K) {
        if (K > n) {
            throw new RuntimeException("K 不合法！");
        }
        quickSort(a);
        return a[K];
    }

    public static int partition(int[] array, int low, int high) {
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
    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();

        int left = 0;
        int right = array.length - 1;

        int par = partition(array, left, right);
        if (par > left + 1) {
            stack.push(left);
            stack.push(par - 1);
        }
        if (par < right - 1) {
            stack.push(par + 1);
            stack.push(right);
        }
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            par = partition(array, left, right);

            if (par > left + 1) {
                stack.push(left);
                stack.push(par - 1);
            }
            if (par < right - 1) {
                stack.push(par + 1);
                stack.push(right);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,2,2};
        System.out.println(findKth(array, 5, 3));
    }
}
