package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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

    //如果使用的是后序遍历

    private int postorder(TreeNode node,TreeNode parent) {
        if (node == null) return 0;
        //不添加父亲节点的话，你无法知道他是否是左节点
        if (node.left == null &&
                node.right == null &&
                parent.left == node  ) {
            return node.val;
        }

        int leftLeavesSum = postorder(node.left,node);
        int rightLeavesSum = postorder(node.right,node);

        //
        return leftLeavesSum + rightLeavesSum;
    }

    //BFS
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    sum += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null && !isLeafNode(node.right)) {
                queue.offer(node.right);
            }
        }
        return sum;
    }
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
