import java.util.Scanner;

/**
 * program: 20200530
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-01 14
 * Time:32
 */
public class TestDemo {
    public static int func(String strA, String strB) {
        if (strA == null && strB == null) {
            return -1;
        }

        int left = 0;
        int right = strA.length() - 1;
        int count = 0;
        int i = 0;
        while (left < right) {
            i = 0;
            while (i < strB.length() && strA.charAt(left) != strB.charAt(right)) {
                if (strA.charAt(left) == strB.charAt(i) || strA.charAt(right) == strB.charAt(i)) {
                    count++;
                }
                i++;
            }
            left++;
            right--;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            int ret = func(str1, str2);
            System.out.println(ret);
        }

    }
}
