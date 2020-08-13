import java.util.Arrays;
import java.util.Scanner;

/**
 * program: 20200617
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-17 22
 * Time:17
 */
public class TestDemo {
    public static String getSequeOddNum(int m) {
        int[] ret = new int[m];
        int sum = 0;
        int tmp = m;
        while (tmp != 0) {
            sum += tmp;
            tmp--;
        }
        int k = 2*(sum - 1) + 1;
        for (int i = m; i >= 1; i--) {
            ret[i - 1] = k;
            k -= 2;
        }
        String str = "";
        for (int i = 0; i < ret.length; i++) {
            if (i != ret.length - 1) {
                str += ret[i] + "+";
            }else {
                str += ret[i] + "";
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(getSequeOddNum(num));
    }

    public static int[] minNum(String str) {
        String[] s = str.split(" ");
        int[] arr = new int[s.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
            count = count + arr[i];
        }

        int[] arr2 = new int[count];
        int i = 1;
        while (i <= 9) {
            if (arr[i] != 0) {
                arr2[0] = i;
                arr[i] = arr[i] - 1;
                break;
            } else {
                i++;
            }
        }
        if (i > 9) {
            System.out.println("输入不合法！");
            return null;
        }
        int j = 0;
        i = 1;
        while (j <= 9) {
            if (arr[j] != 0) {
                arr2[i] = j;
                arr[j] = arr[j] - 1;
                i++;
            } else {
                j++;
            }
        }
        return arr2;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] ret = minNum(str);
        //System.out.println(Arrays.toString(arr2));
        for (int a : ret) {
            System.out.print(a);
        }
        System.out.println();
    }
}
