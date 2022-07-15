package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : _104_maximum_depth_of_binary_tree  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/13  22:40
 */

public class _104_maximum_depth_of_binary_tree {
    /* 104. 二叉树的最大深度
       给定一个二叉树，找出其最大深度。
       二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
       说明: 叶子节点是指没有子节点的节点。

       输入：
            3
           / \
          9  20
            /  \
           15   7
       输出：3
     */
    //BFS
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            levels++;
        }
        return levels;
    }

    //首先的话递归的话是要全部下去，到时候记录一下就可以了
    private int res = 0;
    public int maxDepth(TreeNode root) {
        preorder(root,1);
        return res;
    }

    private void preorder(TreeNode node, int depth) {
        if (node == null) return;
        //处理当前的节点
        if (node.left == null && node.right == null) {
            res = Math.max(res, depth);
        }

        preorder(node.left, depth + 1);
        preorder(node.right,depth + 1);

    }

    //后序遍历
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDepth = maxDepth2(root.left);
        int rightMathDepth = maxDepth2(root.right);

        return Math.max(leftMaxDepth,rightMathDepth) + 1;
    }

    //从下往上的了
    //找到左右子树的最大深度


}
