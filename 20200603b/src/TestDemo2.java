
import java.util.Scanner;


/**
 * program: 20200603
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-03 19
 * Time:27
 */
public class TestDemo2 {

    /**
     * 回文串
     * 1、插入字符组成新字符串
     * 2、检查是否回文
     */
    public static boolean check(String str) {
        int left = 0;
        int right = str.length()-1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int retString(String str3, String str4) {
        int count = 0;
        int len = str3.length();
        for (int i = 0; i <= len; i++) {
            StringBuffer sb = new StringBuffer(str3);
            sb.insert(i,str4);      //将字符串插入到此字符序列中
            if (check(sb.toString())) {     //转换成字符串检查
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str1 = "aba";
        String str2 = "b";
        System.out.println(retString(str1, str2));
        /*Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str1 = scan.nextLine();//aba
            String str2 = scan.nextLine();//b
            System.out.println(retString(str1, str2));
        }*/
    }

    /**
     * 快排
     *
     * @return
     */
    public static int findKth(int[] a, int n, int K) {
        // write code here
        quick(a, 0, n - 1);
        return a[n-K];
    }

    public static void quick(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int par = partiton(a, left, right);
        quick(a, par + 1, right);
        quick(a, left, par - 1);
    }

    public static int partiton(int[] array, int low, int high) {
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

    public static void main2(String[] args) {
        int[] array = {1332802, 1177178, 1514891, 871248, 753214,
                123866, 1615405, 328656, 1540395, 968891, 1884022,
                252932, 1034406, 1455178, 821713, 486232, 860175,
                1896237, 852300, 566715, 1285209, 1845742, 883142,
                259266, 520911, 1844960, 218188, 1528217, 332380,
                261485, 1111670, 16920, 1249664, 1199799, 1959818,
                1546744, 1904944, 51047, 1176397, 190970, 48715, 349690,
                673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
        System.out.println(findKth(array, 49, 24));
    }


    public static int fibonacci(int num) {
        if (num == 0) {
            return -1;
        }
        int n = 0;
        int m = 1;
        int c = 0;
        while (num > n) {
            c = m + n;
            n = m;
            m = c;

            if (m >= num) {
                int min = Math.abs(n - num);
                int max = Math.abs(m - num);
                if (min > max) {
                    return max;
                } else {
                    return min;
                }
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            System.out.println(fibonacci(num));
        }
    }
}
