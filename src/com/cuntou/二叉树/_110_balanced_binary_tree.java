package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

/**
 * @ClassName : _110_balanced_binary_tree  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/15  9:49
 */

public class _110_balanced_binary_tree {
    /*  110. 平衡二叉树
        给定一个二叉树，判断它是否是高度平衡的二叉树。
        本题中，一棵高度平衡二叉树定义为：
            一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

        输入：
              1
             / \
            2   3
           / \
          4   5
        输出：true

        输入：
              1
             / \
            2   3
           / \
          4   5
         / \
        6   7
        输出：false
     */
    //定义的是二叉树
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) >= 0 ;
    }

    //后序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);

        //只要返回-1就说明根节点这块很多都不平衡了
        //求二叉树的时候，就可以找到这个了，这个相差的值
        //只有有一个不平衡的话就可以直接返回-1
        //在大问题的时候，也是直接考虑分成两个子树
        if (maxLeftDepth == -1 || maxRightDepth == -1) {
            return -1;
        }

        if (Math.abs(maxLeftDepth - maxRightDepth) > 1) {
            return -1;
        }

        //处理根节点
        return Math.max(maxLeftDepth,maxRightDepth) + 1;
    }

}
