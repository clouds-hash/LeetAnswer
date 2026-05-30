
import java.util.Arrays;
class Solution66 {
  public int[] plusOne(int[] digits) {
        int LastIndex = digits.length - 1;
        digits[LastIndex]++;
        if(digits[LastIndex]<10) return digits;
        else{
            //先复位变得影响后续判断
            digits[LastIndex]--;
            //表示最后一位要进位
            //方法，从最后一位开始看，有多少个9，把所有9都变为0，找到最左边的9的索引位置
            int index=findIndex(digits);
            if(index!=-1){
                //表示最高位不用进位把所有9开始都变为0
                digits[index]++;
                for(int i=index+1;i<digits.length;i++){
                    digits[i]=0;
                }
                return digits;

            }else{
                //表示所有位都是9
                int[] newArr=new int[digits.length+1];
                Arrays.fill(newArr,0);
                newArr[0]=1;
                return newArr;
            }
        }
    }
    public int findIndex(int[] digits){
 

        int index=digits.length-1;//这个表示最后一位的索引
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                return i;
            }
        }
        
        return -1;//表示所有位都为9

    }
}