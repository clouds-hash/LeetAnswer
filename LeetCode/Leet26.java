import java.util.TreeSet;
import java.util.Collections;
import java.util.Arrays;
import java.util.Iterator;

public class Leet26 {

}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(Integer i:nums){
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        int i=0;
        while(iterator.hasNext()){
            nums[i++]=iterator.next();
        }
        return set.size();

    }
}

