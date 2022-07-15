package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

/**
 * @ClassName : _404_sum_of_left_leaves  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/15  13:59
 */

public class _404_sum_of_left_leaves {
     /* 404. 左叶子之和
       计算给定二叉树的所有左叶子之和。

        示例：

            3
           / \
          9  20
            /  \
           15   7

        输出：24
     */
    //找到所有的左子节点的和
    private int sum = 0;
    public int sumOfLeftLeaves1(TreeNode root) {
        preorder(root,root);
        return sum;
    }
    private void preorder(TreeNode node,TreeNode parent) {
        if (node == null) return;
        //不添加父亲节点的话，你无法知道他是否是左节点
        if (node.left == null &&
                node.right == null &&
                parent.left == node  ) {
             sum += node.left.val;
        }
        preorder(node.left, node);
        preorder(node.right, node);


    }
}
