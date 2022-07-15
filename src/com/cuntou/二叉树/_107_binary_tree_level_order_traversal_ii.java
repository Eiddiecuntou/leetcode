package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

import java.util.*;

/**
 * @ClassName : _107_binary_tree_level_order_traversal_ii  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/13  22:06
 */

public class _107_binary_tree_level_order_traversal_ii {
    /* 107. 二叉树的层序遍历 II
        给定一个二叉树，返回其节点值自底向上的层序遍历。
        （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

        输入：
            3
           / \
          9  20
            /  \
           15   7
        输出：
        [
            [15, 7],
            [9, 20],
            [3]
        ]
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //循环遍历处理每一层的结点
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                TreeNode curr = queue.poll();
                levelNodes.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(levelNodes);
        }
        // 反转
        Collections.reverse(res);
        return res;
     }

     //前序遍历,实现的层序遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        preorder(root,0,res);
        Collections.reverse(res);
        return res;
    }

    private void preorder(TreeNode node, int currlevel, List<List<Integer>> res) {
        if (node == null) return;

        //处理当前遍历的节点
        //看看当时有没有这个节点,有的话就不用进行初始化了,没有的话,需要初始化
        if (res.size() == currlevel) {
            //当大小相等的时候,就说明要初始化一个新的了,因为是0 ,1,2的等级
            //而size
            List<Integer> levelNodes = new ArrayList<>();
            levelNodes.add(node.val);
            res.add(levelNodes);
        } else {
            res.get(currlevel).add(node.val);
        }
        preorder(node.left, currlevel + 1, res);
        preorder(node.right, currlevel + 1, res);
    }
}
