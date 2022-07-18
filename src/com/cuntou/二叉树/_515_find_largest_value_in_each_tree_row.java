package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : _515_find_largest_value_in_each_tree_row  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/16  10:09
 */

public class _515_find_largest_value_in_each_tree_row {
    /* 515. 在每个树行中找最大值
    您需要在二叉树的每一行中找到最大的值。

    输入:

          1
         / \
        3   2
       / \   \
      5   3   9

    输出: [1, 3, 9]

     */
    //BFS
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每轮遍历都要循环一个节点
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                maxValue = Math.max(maxValue,curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(maxValue);
        }
        return res;
    }

    //前序遍历 递归实现这个层序遍历
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,0,res);
        return res;
    }

    private void preorder(TreeNode node, int currLevel, List<Integer> res) {
        if (node == null) return;

        //处理当前遍历的节点
        if (res.size() == currLevel) {
            res.add(node.val);
        } else {
            int maxValue = Math.max(res.get(currLevel) , node.val);
            res.add(currLevel,maxValue);
        }

        preorder(node.left,currLevel + 1,res);
        preorder(node.right,currLevel + 1,res);
    }
}
