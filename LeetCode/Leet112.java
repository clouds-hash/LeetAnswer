public class Leet112 {

}
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //递归来做吧  函数的作用是  传入根节点 传入目标值 看从根节点到叶子节点的和是否等于目标值 
        //子问题：传入根节点的子节点  传入目标值-根节点的值  看子节点是否等于目标值
        if(root==null) return false;
        if(root.left==null && root.right==null){
            //表示是叶子节点
            return root.val==targetSum;
        }
        boolean leftanswer=hasPathSum(root.left, targetSum-root.val);
        boolean rightanswer=hasPathSum(root.right, targetSum-root.val);
        return leftanswer || rightanswer;
        
    }
}