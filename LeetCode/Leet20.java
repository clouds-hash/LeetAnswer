class Solution20 {
    public boolean isValid(String s) {
        //让1表示 )  让 2 表示是 ]  让 3 表示是 }
        MyStack20 stack=new MyStack20(1000);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(1);
            }
            else if(s.charAt(i)=='['){
                stack.push(2);
            }
            else if(s.charAt(i)=='{'){
                stack.push(3);
            }
            else if(s.charAt(i)==')'){
                if(stack.pop()!=1) return false;
            }
            else if(s.charAt(i)==']'){
                if(stack.pop()!=2) return false;
            }
            else if(s.charAt(i)=='}'){
                if(stack.pop()!=3) return false;
            }
        }
        if(stack.isEmpty()==false) return false;
        return true;

    }
}


class MyStack20{
    private int size;
    private int count;
    private int top;
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    {
        top=0;
    }

    public MyStack20(){
        data=new int[DEFAULT_SIZE];
        size=DEFAULT_SIZE;
        count=0;
    }
    public MyStack20(int size){
        data=new int[size];
        this.size=size;
        count=0;
    
    }

    //入栈
    public boolean push(int value){
        if(isFUll()) {
            expand();
        }
        data[top]=value;
        top++;
        count++;
        return true;
    }
    //出栈
    public int pop(){
        if(isEmpty()) return -1;
        int returned = data[top-1];
        top--;
        count--;
        return returned;
    }

    //栈满
    public boolean isFUll(){
        return count==size;
    }

    //栈空
    public boolean isEmpty(){
        return count==0;
    }

    //栈顶元素
    public int peek(){
        if(isEmpty()) return -1;
        return data[top-1];
    }
    //扩容操作
    public void expand(){
        int[] newArr=new int[size*2];
        System.arraycopy(data, 0, newArr, 0, data.length);
        size*=2;
        data=newArr;

    }
}