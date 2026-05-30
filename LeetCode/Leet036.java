public class Leet036 {
    //逆波兰表达式



}

class Solution036 {
    public int evalRPN(String[] tokens) {
        GenericStack036<String> stack = new GenericStack036<String>();
        for(int i=0;i<tokens.length;i++){
            //扫描tokens的每一个元素
            if(judge(tokens[i])){
                //表示是一个操作符
                switch(tokens[i]){
                    case "+":
                        int a = Integer.parseInt(stack.pop());
                        int b = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(b + a));
                        break;
                    case "-":
                        int a1 = Integer.parseInt(stack.pop());
                        int b1 = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(b1 - a1));
                        break;
                    case "*":
                        int a2 = Integer.parseInt(stack.pop());
                        int b2 = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(b2 * a2));
                        break;
                    case "/":
                        int a3 = Integer.parseInt(stack.pop());
                        int b3 = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(b3 / a3)); // Fixed: Use division instead of multiplication
                        break;
                }
            }
            else{
                //是一个操作数，直接入栈
                stack.push(tokens[i]);
            }
        }
        //返回栈顶元素
        return Integer.parseInt(stack.peek());
    }
    public boolean judge(String token){
        if( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) return true;
        else return false;
    }
}
//先写一个栈
// 泛型栈实现
// 泛型栈实现，使用 E[] 数组存储元素
class GenericStack036<E> {
    private int top = 0;
    private int size;
    private int count;
    private E[] data; // 使用泛型数组存储元素

    @SuppressWarnings("unchecked")
    public GenericStack036() {
        data = (E[]) new Object[1000];
        size = 1000;
        count = 0;
    }

    @SuppressWarnings("unchecked")
    public GenericStack036(int size) {
        data = (E[]) new Object[size];
        this.size = size;
        count = 0;
    }

    public boolean push(E value) {
        if (isFull()) {
            expand();
        }
        data[top] = value;
        top++;
        count++;
        return true;
    }

    public E pop() {
        if (isEmpty()) return null;
        top--;
        count--;
        return data[top];
    }

    public E peek() {
        if (isEmpty()) return null;
        return data[top - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    @SuppressWarnings("unchecked")
    public void expand() {
        E[] newArr = (E[]) new Object[size * 2];
        System.arraycopy(data, 0, newArr, 0, data.length);
        size *= 2;
        data = newArr;
    }
}
class MyStack036<E> {
    private int top = 0;
    private int size;
    private int count;
    private Object[] data; // 使用 Object 数组存储泛型元素

    public MyStack036() {
        data = new Object[1000];
        size = 1000;
        count = 0;
    }

    public MyStack036(int size) {
        data = new Object[size];
        this.size = size;
        count = 0;
    }

    public boolean push(E value) {
        if (isFull()) {
            expand();
        }
        data[top] = value;
        top++;
        count++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) return null;
        top--;
        count--;
        return (E) data[top];
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) return null;
        return (E) data[top - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public void expand() {
        Object[] newArr = new Object[size * 2];
        System.arraycopy(data, 0, newArr, 0, data.length);
        size *= 2;
        data = newArr;
    }
}
class MyStackInt036{
    private int top=0;
    private int size;
    private int count;
    private int[] data;

    public MyStackInt036(){
        data=new int[1000];
        size=1000;
        count=0;
    }
    public MyStackInt036(int size){
        data=new int[size];
        this.size=size;
        count=0;
    }

    public boolean push(int value){
        if(isFUll()) {
            expand();
        }
        data[top]=value;
        top++;
        count++;
        return true;
    }

    public int pop(){
        if(isEmpty()) return -1;
        top--;
        count--;
        return data[top];
    }
    public int peek(){
        if(isEmpty()) return -1;
        return data[top-1];
    }

    public boolean isEmpty(){
        return count==0;
    }

    public boolean isFUll(){
        return count==size;
    }

    public void expand(){
        int[] newArr=new int[size*2];
        System.arraycopy(data, 0, newArr, 0, data.length);
        size*=2;
        data=newArr;
    }

}
