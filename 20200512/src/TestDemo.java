import java.util.ArrayList;
import java.util.List;

/**
 * program: 20200512
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-13 16
 * Time:59
 */

class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
public class TestDemo {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) {
            return ret;
        }
        List<Integer> oneRows = new ArrayList<>();
        ret.add(oneRows);
        ret.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRows = new ArrayList<>();
            curRows.add(1);
            List<Integer> prevRows = ret.get(i-1);
            for (int j = 1; j < i; j++) {
                //[i,j] = [i-1, j] + [i-1, j-1]
                int x = prevRows.get(j);
                int y = prevRows.get(j-1);
                curRows.add(x+y);
            }
            curRows.add(1);
            ret.add(curRows);
        }
        return ret;
    }


    public static void main(String[] args) {
        A<String> a = new A<>("秦岭山");
        System.out.println(a.get());
    }
}
