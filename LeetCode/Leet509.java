public class Leet509 {

}

class Solution509 {
    public int fib(int n) {
        int[] arr=new int[n+10];
        arr[0]=0;
        arr[1]=1;
        return fib2(n,arr);
    }

    public int fib2(int n,int[] arr){
        if(arr[n]!=-1) return arr[n];
        int x=fib2(n-1,arr);
        int y=fib2(n-2,arr);
        arr[n]=x+y;
        return arr[n];
    }
}