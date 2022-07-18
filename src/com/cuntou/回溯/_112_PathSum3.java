package com.cuntou.回溯;

import com.cuntou.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _112_PathSum3  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/17  20:45
 */

public class _112_PathSum3 {
    //找到所有的路径和
    public boolean hasPathSum(TreeNode root, int target) {
        List<Integer> res = new ArrayList<>();
        dfs(root,0,res);
        System.out.println(res);
        for (int onePath : res) {
            if (onePath == target) return true;
        }
        return false;
    }
    public void dfs(TreeNode node,
                    int parentNodePathSum,
                    List<Integer> res) {
        if (node == null) return;
        int currNodePathSum = parentNodePathSum + node.val;
        if (node.left == null && node.right == null) {
            res.add(currNodePathSum);
        }
        dfs(node.left,currNodePathSum,res);
        dfs(node.right,currNodePathSum,res);
    }
}
