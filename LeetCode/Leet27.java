import java.util.ArrayList;

public class Leet27 {
    
}
class Solution27 {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val) list.add(nums[i]);
        }
        int i=0;
        for(Integer num:list){
            nums[i++]=num;
        }
        return list.size();
     
    }
}