package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : _144_binary_tree_preorder_traversal  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/13  20:04
 */

public class _144_binary_tree_preorder_traversal {
    //二叉树的前序遍历
    //迭代解法
    //使用迭代的时候可以直接先记下来,记下来之后再去处理这些
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) stack.push(root.right);
            if (curr.left != null) stack.push(root.left);
        }
        return res;
    }

    //递归的解法
    public List<Integer> preorderTraversal2 (TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preOrder(root,res);
        return res;
    }

    private void preOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        //处理这个节点
        res.add(node.val);
        preOrder(node.left,res);
        preOrder(node.right,res);
    }
}
