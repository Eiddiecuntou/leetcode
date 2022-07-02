package com.cuntou.TreeNode;



/**
 * @ClassName : P226InvertBinaryTree  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/4/24  19:49
 */

public class P226InvertBinaryTree {
    public static void main(String[] args){
        Solution solution = new P226InvertBinaryTree().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public javax.swing.tree.TreeNode invertTree(TreeNode root) {
            //递归函数的终止条件，节点为空的时候返回
            if (root == null) {
                return null;
            }
            //下面单据就是将当前的结点左右子树进行交换
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            //递归的交换当前节点的子树
            invertTree(root.left);
            invertTree(root.right);
            return (javax.swing.tree.TreeNode) root;

        }
    }
}
