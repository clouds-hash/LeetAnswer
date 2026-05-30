import java.util.ArrayList;
import java.util.List;


public class Leet118 {
    public static void main(String[] args) {
        Solution118 solution = new Solution118();
        List<List<Integer>> list = solution.generate(5);
        System.out.println(list);
    }
}

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            list.add(Rows(i));
        }
        return list;
    }


    //这个方法是用于获取第row行的杨辉三角
    public List<Integer> Rows(int row){
        List<Integer> list=new ArrayList<Integer>();
        //返回第row行，第i列的列表
        for(int i=1;i<=row;i++){
            list.add(getNumber(row,i));
        }
        return list;

    }
    public int getNumber(int[][] arr,int i,int j){
        if(arr[i][j]!=0){
            return arr[i][j];
        }

        if(j==1||j==i){
            arr[i][j]=1;
            return 1;
        }
        int x=getNumber(arr,i-1, j-1);
        int y=getNumber(arr,i-1, j);
        arr[i][j]=x+y;
        return x+y;

    }
    public int getNumber(int i,int j){
        int[][] arr=new int[i+1][];// 可以确定行有多少个，列有多少个不确定
        for(int k=1;k<=i;k++){
            arr[k]=new int[k+1]; //第k行有k+1个元素
        }
        //这样数组就初始化完成了
        return getNumber(arr,i,j);
    }



}
