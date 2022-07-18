package com.cuntou.回溯;

import com.cuntou.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @ClassName : _112_PathSum1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/17  19:43
 */

public class _112_PathSum1 {
    public List<List<Integer>> allPath(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, res);
        return res;
    }

    private void dfs(TreeNode node,
                     List<Integer> path,
                     List<List<Integer>> res){
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(node.left,path,res);
        dfs(node.right,path,res);

        path.remove(path.size() - 1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(2);
        node1.left = node3;
        node3.left = node4;
        node3.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        node2.left = node6;
        node2.right = node7;
        node7.left = node8;
        node7.right = node9;

        System.out.println(new _112_PathSum1().allPath(root));
    }
}
