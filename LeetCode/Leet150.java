public class Leet150 {

}


class Solution150 {
    public int evalRPN(String[] tokens) {
        MyStack150 stack = new MyStack150(tokens.length);
        for(int i=0;i<tokens.length;i++){
            switch(tokens[i]){
                case "+"->{
                    int a=Integer.parseInt(stack.pop());//出栈一个
                    int b=Integer.parseInt(stack.pop());//出栈两个
                    stack.push(String.valueOf(a+b));
                }
                case "-"->{
                    int a=Integer.parseInt(stack.pop());//出栈一个
                    int b=Integer.parseInt(stack.pop());//出栈两个
                    stack.push(String.valueOf(b-a));
                }
                case "*"->{
                    int a=Integer.parseInt(stack.pop());//出栈一个
                    int b=Integer.parseInt(stack.pop());//出栈两个
                    stack.push(String.valueOf(a*b));
                }
                case "/"->{
                    int a=Integer.parseInt(stack.pop());//出栈一个
                    int b=Integer.parseInt(stack.pop());//出栈两个
                    stack.push(String.valueOf(b/a));
                }
                default->{
                    //是数字，直接入栈
                    stack.push(tokens[i]);
                }


            }


        }
        return Integer.parseInt(stack.pop());
    }
}


class MyStack150{
    private String[] data; 
    private int top;
    private int size;
    private int count;

    public MyStack150(int size) {
        this.size = size;
        data = new String[size];
        top = 0;
        count = 0;
    }
    public boolean isFull() {
        return count==size;
    }
    public boolean isEmpty() {
        return count==0;
    }
    public boolean push(String value){
        if(isFull()){
            expand();
        }
        data[top++] = value;
        count++;
        return true;
    }
    public String pop(){
        if(isEmpty()){
            return null;
        }
        String value = data[--top];
        count--;
        return value;
    }

    public void expand(){
        String[] newData = new String[size*2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
        size = size*2;
    }


}