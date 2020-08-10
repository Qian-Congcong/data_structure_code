import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * program: 20200605
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-05 14
 * Time:21
 */
public class TestMain {

    /**
     * 神奇口袋
     * 1、录入数据
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            int n = Integer.valueOf(s), v;  //一个保存由string参数表示的值的 Integer对象。
            int[] a = new int[41];
            for (int i = 0; i < n; i++) {
                v = Integer.valueOf(br.readLine());
                for (int j = 40; j > v; j--) {
                    a[j] += a[j - v];
                }
                a[v] += 1;
            }
            System.out.println(a[40]);
        }


        /*Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(magicPoc(num, arr));*/
    }

    public static void main4(String[] args) {
        int x;
        int y;
        x = 5 >> 2;
        y = x >>> 2;
        System.out.println(y);
    }

    public static void main3(String[] args) throws InterruptedException{
        Thread t = new  Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("2");
            }
        });
        t.start();
        t.join();
        System.out.println("1");
    }

    /**
     * 删除字符串
     *
     */
    public static String deletString(String s1, String s2) {
        StringBuffer sb = new StringBuffer();   //构造一个没有字符的字符串缓冲区，初始容量为16个字符。
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            //indexOf(int ch) 返回指定字符第一次出现的字符串内的索引。
            //codePointAt(int index) 返回指定索引处的字符
            if ((s2.indexOf(ch)) == -1) {
                sb.append(ch);  //将 char参数的字符串表示附加到此序列。
            }
        }
        return sb.toString();
    }

    public static void main2(String[] args) throws IOException { //
        //从字符输入流读取文本，缓冲字符，以提供字符，数组和行的高效读取。
        //BufferedReader(Reader in) 创建使用默认大小的输入缓冲区的缓冲字符输入流。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine().toString();     //readLine() 读一行文字
        String str2 = br.readLine().toString();

        String ret = deletString(str1, str2);
        System.out.println(ret);
    }

    /**
     * 买苹果
     * 6 8 12 14 16 18 20 22 24 26 28 30 32
     */
    public static int appleBags(int num) {
        if (num < 1) {
            return -1;
        }
        int count = 0;
        if (num == 6 || num == 8) {
            return 1;
        }else if (num >= 12 && (num % 2) == 0) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    int tmpA = i*6;
                    int tmpB = j*8;
                    if (tmpA + tmpB == num) {
                        return i+j;
                    }
                }
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(appleBags(n));
        }

    }
}
