public class Leet104 {

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root.left==null&&root.right==null) return 1;//表示树的高度为1

        //递归三要素 
        //1.确定递归函数的参数和返回值
        // 传入根节点，返回以该节点为根的树的最大深度
        //2.确定递归函数的终止条件
        //3.确定递归函数的单层逻辑

        int leftDepth=maxDepth(root.left);//左子树的深度
        int rightDepth=maxDepth(root.right);//右子树的深度
        //数的深度就是 左右子树深度的最大值加一
        return Math.max(leftDepth,rightDepth)+1;
    }
}
