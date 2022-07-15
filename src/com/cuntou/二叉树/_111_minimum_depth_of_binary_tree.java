package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;
import sun.font.DelegatingShape;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName : _111_minimum_depth_of_binary_tree  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/15  10:12
 */

public class _111_minimum_depth_of_binary_tree {
    /* 111. 二叉树的最小深度
        给定一个二叉树，找出其最小深度。
        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
        说明：叶子节点是指没有子节点的节点。

        输入：
              1
             / \
            2   3
           / \
          4   5

         输出：2

        输入：
              1
             / \
            2  NULL
           /
          4
         /
        5
       /
      6
         输出： 5
     */
    //DFS 后序遍历
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int leftMathDepth = minDepth(root.left);
        int rightMathDepth = minDepth(root.right);

        //这个时候考虑的是使用这个,没有考虑清除当左边为空的话，直接就是左边为空
        //要么就是右边和左边都为空
        if (root.left == null) {
            return rightMathDepth + 1;
        } else if(root.right == null) {
            return leftMathDepth + 1;
        } else {
            return Math.min(leftMathDepth, rightMathDepth) + 1;
        }

    }

    //使用的是迭代的DFS-前序遍历
    private class Node {
        TreeNode node;
        int depth;

        Node (TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

    }
    public int minDepth1 (TreeNode root) {
        if(root == null) return 0;

        //求最小值
        int res = Integer.MAX_VALUE;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root,1));
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            TreeNode curr = node.node;
            int currDepth = node.depth;

            if(curr.left == null && curr.right == null) {
                res = Math.min(res, currDepth);
            }

            if (curr.right != null) {
                stack.push(new Node(curr.right, currDepth + 1));
            }
            if (curr.left != null) {
                stack.push(new Node(curr.left, currDepth + 1));
            }
        }
        return res;

    }

    //DFS递归 -- 前序遍历
    private int res = Integer.MAX_VALUE;
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        preorder(root,1);
        return res;
    }

    private void preorder(TreeNode node, int depth) {
        if (node == null) return;
        //处理当前节点
        if (node.left == null && node.right == null) {
            res = Math.min(res,depth);
        }

        preorder(node.left, depth + 1);
        preorder(node.right, depth + 1);
    }

    //BFS使用
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            levels++;
            for (int i = 0; i < size ; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return levels;
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return levels;
    }

}
