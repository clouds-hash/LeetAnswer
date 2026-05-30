import java.util.TreeSet;
import java.util.ArrayList;

public class Leet88 {

}
class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            list.add(nums2[i]);
        }
        int i=0;
        list.sort(null);
        for(Integer number:list){
            nums1[i++]=number;
        }

    }
}