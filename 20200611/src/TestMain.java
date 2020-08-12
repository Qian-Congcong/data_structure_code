import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * program: 20200611
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-11 19
 * Time:33
 */
public class TestMain {

    public int[] multiply(int[] A) {
        int[] arr = new int[A.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
            for (int j = 0; j < i; j++) {
                arr[i] = arr[i] * A[j];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] str = s.split(",");
            int[] a = new int[str.length];
            for (int i = 0; i < s.length(); i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            int[] ret = multiply(a);
            for (int n :ret){
                System.out.print(n + " ");
            }
        }
    }

    public static void main3(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] ret = new int[10];
        for (int i = 0; i < s.length(); i++) {
            //s.charAt(i)-'0'得到s[i]中存储的数字字符对应baia数组中哪一个下标du，也是将字符转成数字，再记数加一
            ret[s.charAt(i) - '0']++;
        }
        for (int i = 0; i <= 9; i++) {
            if (ret[i] != 0) {
                System.out.println(i + ":" + ret[i]);
            }
        }
    }

    public int countWays(int x, int y) {
        // write code here
        int ans = 0;

        int top = 1;
        for (int i = 0; i < y - 1; i++) {
            top *= x+y - 2 - i;
        }
        int bottom = 1;
        for (int j = y -1; j >= 1; j--) {
            bottom *= j;
        }
        ans = top / bottom;

        return ans;
    }
    
    private static void testMethod() {
        System.out.println("testMethod");
    }
    public static void main1(String[] args) {
        ((TestMain)null).testMethod();
        int m = 10;
        String s = Integer.toString(m);
    }
}
