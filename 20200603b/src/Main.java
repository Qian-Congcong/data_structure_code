/**
 * program: 20200603
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-04 10
 * Time:15
 */

import java.util.*;

public class Main {
    /**
     * 第K大的数
     *
     */
    public static int findKth(int[] a, int n, int K) {
        if (a.length == 0) {
            return -1;
        }
        return findKth(a,0,n-1,K);
    }
    private static int findKth(int[] a, int low, int high, int K) {
        int par = partition(a,low,high);
        if (par - low + 1 == K) {
            return a[par];
        }else if (par - low + 1 > K) {
            return findKth(a,low,par - 1,K);
        }else {
            return findKth(a,par + 1,high,K - par + low - 1);
        }
    }

    private static int partition(int[] a, int left, int right) {
        int tmp = a[left];
        while (left < right) {
            while (left < right && a[right] >= tmp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= tmp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = tmp;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,2,2};
        System.out.println(findKth(array, 5, 3));
    }

    /**
     * 回文串
     * 1、拼接
     * 2、检查回文串
     * @return
     */

    public static boolean isHuiWen(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        int count = 0;
        for (int i = 0; i <= str1.length(); i++) {
            StringBuffer sb = new StringBuffer(str1);
            sb.insert(i,str2);
            if (isHuiWen(sb.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main2(String[] args) {
        String str1 = "aba";
        String str2 = "b";
        StringBuffer sb = new StringBuffer(str1);
        StringBuffer ret = sb.insert(1,str2);
        System.out.println(ret);
    }


    public static boolean isHuiWen1(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int number(String a, String b) {
        int count = 0;
        int len = a.length();
        for (int i = 0; i <= len; i++) {
            String str = a.substring(0, i) + b + a.substring(i, len);
            if (isHuiWen1(str)) {
                count++;
            }
        }
        return count;
    }

    public static void main1(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String a = s.nextLine();
            String b = s.nextLine();
            System.out.println(number(a, b));
        }
    }
}
