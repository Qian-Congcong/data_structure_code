import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * program: 20200608
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-08 14
 * Time:05
 */
public class TestMain {

    public static int func(int num) {
        int total = 0;
        while (num > 2) {
            total = total + num / 3;
            num = num / 3 + num % 3;
        }
        if (2 == num) {
            total = total + 1;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            System.out.println(func(num));
        }
    }

    public static boolean isAdmin(String userld) {
        return userld.toLowerCase() == "sdmin";
    }

    public static void main3(String[] args) {
        System.out.println(isAdmin("Admin"));
    }

    /**
     * 网格盒子放蛋糕
     *
     */
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] strings = s.split(" ");

        int w = Integer.parseInt(strings[0]);
        int h = Integer.parseInt(strings[1]);
        int count = 0;
        if (w % 4 == 0 || h % 4 == 0) {
            count = w * h / 2;
        }else if (w % 2 == 0 && h % 2 == 0) {
            count = (w * h / 4 + 1) / 2;
        }else {
            count = (w * h) / 2 + 1;
        }
        System.out.println(count);
    }

    /**
     * 最小公倍数
     */
    public static int comMultiple(int num1, int num2) {
        int tmp = 0;
        if (num1 < num2) {
            tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        tmp = 0;
        while (true) {
            tmp = num1 % num2;
            if (tmp == 0) {
                break;
            }
            num1 = num2;
            num2 = tmp;
        }
        return num2;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            System.out.println((n1 * n2) / comMultiple(n1, n2));
        }
    }
}
