/**
 * program: 20200603
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-04 08
 * Time:03
 */
class Test {
    private int data;
    int result = 0;

    public void m() {
        result += 2;
        data += 2;
        System.out.print(result + " " + data);
    }
}

class ThreadExample extends Thread {
    private Test mv;

    public ThreadExample(Test mv) {
        this.mv = mv;
    }

    public void run() {
        synchronized (mv) {//synchronized修饰代码块
            mv.m();
        }
    }
}

public class TestDemo3 {
    public static void main(String args[]) {
        Test mv = new Test();
        Thread t1 = new ThreadExample(mv);
        Thread t2 = new ThreadExample(mv);
        Thread t3 = new ThreadExample(mv);
        t1.start();//
        t2.start();//
        t3.start();//
        System.out.println("fsf");
    }
}