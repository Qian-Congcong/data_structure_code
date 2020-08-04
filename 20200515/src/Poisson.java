import java.util.Scanner;

/**
 * program: 20200515
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-20 13
 * Time:42
 */
public class Poisson {
    public static double poissonDistribution(double lambda, int n) {
        double e = Math.E;
        //e^-10λ  =  Math.pow(e,(-1)*num);
        double m1 = Math.pow(e,(-1)*lambda);
        //(10λ)^n = Math.pow(num,n);
        double m2 = Math.pow(lambda,n);
        //num1 = n!;
        int m3 = 1;
        while (n > 0) {
            m3 *= n;
            n--;
        }
        double m4 = m1 * m2;

        return m4 / m3;
    }

    public static void main(String[] args) {
        /*double  num1 = 1.571527035;
        int num3 = 5;
        System.out.println(poissonDistribution(num1,num3));*/
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            double num = scan.nextDouble();//λ
            int num3 = scan.nextInt();//n
            System.out.println(poissonDistribution(num,num3));
            System.out.println("=============泊松分布=============");
        }
    }
}
