import java.util.Scanner;
import java.util.*;
/**
 * program: 20200603
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-03 11
 * Time:23
 */
class Test1 {
    public static void hello() {
        System.out.println("hello");
    }
}
public class TestDemo {
    public static void main1(String[] args) {
        Test1 test = null;
        test.hello();
    }



    public static int func(int n) {
            if (1 == n) {
                return 0;
            } else if (2 == n) {
                return 1;
            } else {
                int a = n / 3;
                int b = n % 3;
                int c = a + b;
                return a += func(c);
            }
        }
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            while (scan.hasNext()) {
                int num = scan.nextInt();
                if (num == 0) {
                    break;
                }
                System.out.println(func(num));
            }
        }
}
