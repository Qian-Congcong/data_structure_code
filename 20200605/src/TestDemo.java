import java.util.Stack;

/**
 * program: 20200605
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-06-05 16
 * Time:36
 */
public class TestDemo {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //入队列
    public void push(int node) {
        stack1.push(node);
    }

    //删除队列头元素
    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
