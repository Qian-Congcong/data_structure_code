import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * program: 20200617
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-18 09
 * Time:11
 */
public class TestDemo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) {
                return;
            }
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int num = sc.nextInt();
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (num == arr[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static int[] groupsSort(String[] str) {
        int l = 0;
        int n = 0;
        int group = Integer.parseInt(str[l++]);
        int[] num = new int[2];
        int[] ret = new int[str.length - 1 - 2 * group];
        while (group != 0) {
            num[0] = Integer.parseInt(str[l++]);
            num[1] = Integer.parseInt(str[l++]);
            int k = num[1];
            int[] a1 = new int[num[0]];
            int[] a2 = new int[num[0]];

            for (int i = 0; i < 2 * num[0]; i++) {
                ret[n + i] = Integer.parseInt(str[l++]);
            }

            for (int i = 0; i < k; i++) {

                int x = 0;
                int y = 0;
                for (int j = 0; j < 2 * num[0]; j++) {
                    if (j < num[0] && x < num[0]) {
                        a1[x++] = ret[n + j];
                    } else if (j >= num[0] && y < num[0]){
                        a2[y++] = ret[n + j];
                    }
                }
                for (int j = 0; j < 2 * num[0]; j++) {
                    if ((j + 1) % 2 != 0 && y >= 0) {
                        ret[n + j] = a2[--y];
                    }
                    if ((j + 1) % 2 == 0 && x >= 0) {
                        ret[n + j] = a1[--x];
                    }
                }
                int t = 2 * num[0] - 1;
                for (int j = 0; j < num[0]; j++) {
                    int tmp = ret[n + j];
                    ret[n + j] = ret[n + t];
                    ret[n + t] = tmp;
                    t--;
                }
            }
            n += 2 * num[0];
            group--;
        }
        return ret;
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        int[] ret = groupsSort(str);
        for (int i = 0; i < ret.length - 1; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println(ret[ret.length - 1]);
    }

    public static int eatPower(int x) {
        int count = 1;
        if (x > 0 && x < 1000000007) {
            int n1 = 4 * x + 3;
            int n2 = 8 * x + 7;
            while (true) {
                if (n1 >= 1000000007 || n2 >= 1000000007) {
                    return count;
                }else {
                    n1 = 4 * n1 + 3;
                    n2 = 8 * n2 + 7;
                    count++;
                    if (count > 100000) {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(eatPower(num));
    }

    public static int addAB(int A, int B) {
        int xor = 0;
        int and = 0;
        while (B != 0) {
            xor = A ^ B;
            and = (A & B) << 1;
            A = xor;
            B = and;
        }
        return A;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(",");
        int num1 = Integer.parseInt(s[0]);
        int num2 = Integer.parseInt(s[1]);
        System.out.println(addAB(num1, num2));
    }


}
