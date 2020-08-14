import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * program: 20200622
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-22 14
 * Time:32
 */
public class TestDemo {

    static class Stu {
        String name;
        int grade;
        public Stu(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (br.ready()) {
            int n = Integer.parseInt(br.readLine());
            int s = Integer.parseInt(br.readLine());
            Stu[] stus = new Stu[n];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                stus[i] = new Stu(str[0],Integer.parseInt(str[1]));
            }
            Arrays.sort(stus, new Comparator<Stu>() {
                @Override
                public int compare(Stu o1, Stu o2) {
                    if (s == 1) {
                        return o1.grade - o2.grade;
                    }
                    return o2.grade - o1.grade;
                }
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(stus[i].name + " " + stus[i].grade + "\n");
                System.out.println(sb.substring(0,sb.length() - 1));
            }
        }
    }

    public static void main2(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str;
            while ((str = br.readLine()) != null) {
                int count = Integer.parseInt(str);
                int sortType = Integer.parseInt(br.readLine());

                String[] users = new String[count];
                int[] scores = new int[count];
                for (int i = 0; i < count; i++) {
                    String line = br.readLine();
                    String[] parts = line.split(" ");
                    String user = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    if (sortType == 0) {
                        int j = 0;
                        for (j = i - 1; j >= 0; j--) {
                            if (scores[j] < score) {
                                scores[j+1] = scores[j];
                                users[j+1] = users[j];
                            }else {
                                break;
                            }
                        }
                        scores[j+1] = score;
                        users[j+1] = user;
                    }else {
                        int j = 0;
                        for (j = i - 1; j >= 0; j--) {
                            if (scores[j] > score) {
                                scores[j+1] = scores[j];
                                users[j+1] = users[j];
                            }else {
                                break;
                            }
                        }
                        scores[j + 1] = score;
                        users[j + 1] = user;
                    }
                }
                for (int i = 0; i < count; i++) {
                    System.out.println(users[i] + " " + scores[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (s.contains(p[i])) {
                res[i] = true;
            }else {
                res[i] = false;
            }
        }
        return res;
    }

    public static void main3(String[] args) {
        int rich = 0;
        int stranger = 0;
        int k = 1;
        for (int i = 0; i < 30; i++) {
            stranger += k;
            k *= 2;
            rich += 10;
        }
        System.out.println(rich + "万元 " + stranger + "分");
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine())!= null) {
            int maxRadio = 0;
            int index = 0;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i <= str.length() - n; i++) {
                int tmp = getMaxRadio(str.substring(i,i+n));
                if (tmp > maxRadio) {
                    maxRadio = tmp;
                    index = i;
                }
            }
            System.out.println(str.substring(index,index + n));
        }
    }

    private static int getMaxRadio(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('G' == str.charAt(i) || 'C' == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
