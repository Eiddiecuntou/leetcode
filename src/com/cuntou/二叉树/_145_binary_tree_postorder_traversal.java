package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;
import com.cuntou.链表.Node;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : _145_binary_tree_postorder_traversal  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/13  21:00
 */

public class _145_binary_tree_postorder_traversal {
    /* 145. 二叉树的后序遍历
    给定一个二叉树，返回它的 后序 遍历。
     */
    public List<Integer> postOrder(TreeNode root, List<Integer> res) {
        List<Integer> res1 = new ArrayList<>();
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        Collections.reverse(res);
        return res1;
    }

    //递归解法
    public List<Integer> postOrder1(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) return null;
        postorder(node,res);
        return res;

    }
    public void postorder(TreeNode node, List<Integer> res) {
        if (node == null) return;

        postOrder(node.left, res);
        postOrder(node.right,res);
        res.add(node.val);

    }
}
