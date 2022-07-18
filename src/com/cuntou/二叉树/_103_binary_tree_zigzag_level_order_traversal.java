package com.cuntou.二叉树;

import com.cuntou.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : _103_binary_tree_zigzag_level_order_traversal  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/15  20:59
 */

public class _103_binary_tree_zigzag_level_order_traversal {
    /* 103. 二叉树的锯齿形层序遍历
    给定一个二叉树，返回其节点值的锯齿形层序遍历。
    （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

    输入：
        3
       / \
      9  20
        /  \
       15   7
   输出：
    [
        [3],
        [20,9]
        [15,7]
    ]
     */
    //z 形状就是在程序遍历啊
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            //每一轮遍历的话，只处理一层的结点
            int size = queue.size();
            //怎么来判断他是第几层，看他对2取模
            boolean fromRight = level % 2 == 0;
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                TreeNode curr = queue.poll();
                if (fromRight) {
                    //因为遍历的话，都是从左往右，如果要实现这个状况的话，使用这个最好
                    levelNodes.add(0,curr.val);
                } else {
                    levelNodes.add(curr.val);
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(levelNodes);
            level++;
        }
        return res;
    }
    //使用DFS来做的话，怎么做
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        preorder(root,0,res);
        return res;
    }

    private void preorder(TreeNode node, int currLevel, List<List<Integer>> res) {
        if (node == null) return;

        //处理当前遍历的结点
        if (res.size() == currLevel) {
            List<Integer> levelNodes = new LinkedList<>();
            res.add(levelNodes);
        }

        
    }

}
