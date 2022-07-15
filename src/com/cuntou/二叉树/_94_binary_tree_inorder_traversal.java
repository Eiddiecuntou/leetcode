package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : _94_binary_tree_inorder_traversal  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/13  20:41
 */

public class _94_binary_tree_inorder_traversal {
    //94.中序遍历.给定一个root来进行返回
    public List<Integer> inOrderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);

            curr = curr.right;
        }
        return res;
    }

    //递归解法
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right,res);
    }
}
