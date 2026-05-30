import java.util.Stack;

public class Leet232_Standard {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        
        // 测试用例
        queue.push(1);
        queue.push(2);
        queue.push(3);
        
        System.out.println("pop: " + queue.pop());   // 应该输出 1
        System.out.println("peek: " + queue.peek()); // 应该输出 2
        System.out.println("pop: " + queue.pop());   // 应该输出 2
        
        queue.push(4);
        System.out.println("pop: " + queue.pop());   // 应该输出 3
        System.out.println("pop: " + queue.pop());   // 应该输出 4
        System.out.println("empty: " + queue.empty()); // 应该输出 true
    }
}

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        // 关键修复：只有当 stack2 为空时，才需要倒腾
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {
        // 关键修复：只有当 stack2 为空时，才需要倒腾
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
