import java.util.Queue;
import java.util.LinkedList;

public class Leet225 {
    // 单队列实现栈
}


class MyStack {
    private Queue<Integer> queue1;


    public MyStack() {
        queue1 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue1.add(x);
        //把所有元素都移到队列的头部
        for (int i = 1; i < queue1.size(); i++) {
            queue1.add(queue1.remove());
        }
    }
    
    public int pop() {
        return queue1.remove();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}