import java.util.ArrayList;
import java.util.List;

public class Leet102 {

}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        List<TreeNode> temp=new ArrayList<>();//一个完整流程的队列
        temp.add(root);
        while(!temp.isEmpty()){
            //这个队列不为空，
            int size=temp.size();//第一层有多少个节点 用于记录每一层的节点数
            List<Integer> resList=new ArrayList<>();
            for(int i=0;i<size;i++){
                //取出每一层的节点，放到结果集合里面去
                
                //把队首的节点的左右孩子放入队列
                if(temp.get(0).left!=null){
                    //表示头结点有左孩子
                    temp.add(temp.get(0).left);
                }
                if(temp.get(0).right!=null){
                    //表示头结点有右孩子
                    temp.add(temp.get(0).right);
                }
                //可以取出队首元素添加到临时集合里面
                resList.add(temp.get(0).val);
                temp.remove(0);

            }
            //循环结束之后，把临时集合添加到结果集合里面
            res.add(resList);
        }
        return res;
    }
}
