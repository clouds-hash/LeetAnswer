public class Leet01 {
    //两数之和
}

class Solution01 {
    public int[] twoSum(int[] nums, int target) {
        //方法一，暴力求解
        //我就强行遍历两边，把每一种结果都算出来
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }

            }

        }
        return null;
    }
}