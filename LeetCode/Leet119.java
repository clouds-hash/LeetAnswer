import java.util.ArrayList;
import java.util.List;
public class Leet119 {
    public static void main(String[] args) {
        Solution119 solution = new Solution119();
        List<Integer> row = solution.getRow(3);
        System.out.println(row);
        
        List<Integer> row2 = solution.getRow(0);
        System.out.println(row2);
        
        List<Integer> row3 = solution.getRow(1);
        System.out.println(row3);
    }
}

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        // 一次性创建数组，用于记忆化
        // 杨辉三角从第0行开始，所以需要rowIndex+1行
        int[][] arr = new int[rowIndex + 1][];
        for (int i = 0; i <= rowIndex; i++) {
            arr[i] = new int[i + 1];
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(getNumber(arr, rowIndex, i));
        }
        return list;
    }

    public int getNumber(int[][] arr, int rowIndex, int k) {
        if (arr[rowIndex][k] != 0) {
            return arr[rowIndex][k];
        }
        
        if (k == 0 || k == rowIndex) {
            arr[rowIndex][k] = 1;
            return 1;
        }
        
        int x = getNumber(arr, rowIndex - 1, k - 1);
        int y = getNumber(arr, rowIndex - 1, k);
        arr[rowIndex][k] = x + y;
        return arr[rowIndex][k];
    }
}
