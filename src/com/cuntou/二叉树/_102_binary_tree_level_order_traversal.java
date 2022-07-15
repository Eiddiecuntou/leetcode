package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : _102_binary_tree_level_order_traversal  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/13  21:18
 */

public class _102_binary_tree_level_order_traversal {
    /* 102. 二叉树的层序遍历
        给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
        （即逐层地，从左到右访问所有节点）。
     */
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //每次循环处理一个节点
            TreeNode curr = queue.poll();
            res.add(curr.val);
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return res;

    }
    //层序遍历
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
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
        return res;
    }
    //使用前序遍历(递归)实现层序遍历
    public List<List<Integer>> levelOrder3(TreeNode root) {
       List<List<Integer>> res = new ArrayList<>();
       preorder(root,0,res);
       return res;
    }
    private void preorder(TreeNode node, int currLevel, List<List<Integer>> res) {
        if (node == null) return;

        //处理当前的节点
        if (res.size() == currLevel) {
            List<Integer> levelNodes = new ArrayList<>();
            levelNodes.add(node.val);
            res.add(levelNodes);
        } else {
            res.get(currLevel).add(node.val);
        }

        preorder(node.left, currLevel + 1, res);
        preorder(node.right,currLevel + 1,res);
    }
}
