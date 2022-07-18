package com.cuntou.回溯;

import com.cuntou.TreeNode.TreeNode;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _112_PathSum4  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/17  20:53
 */

public class _112_PathSum4 {
    //使用目标值来使用的,就是挨个去减掉
    public boolean hasPathSum(TreeNode root, int target) {
        List<Integer> res = new ArrayList<>();
        dfs(root, target, res);
        System.out.println(res);
        for (int onePath : res) {
            if (onePath == 0) return true;
        }
        return false;
    }

    private void dfs(TreeNode node,
                     int parentNodeTarget,
                     List<Integer> res) {
        if (node == null) return;
        int currNodeTarget = parentNodeTarget - node.val;
        if (node.left == null && node.right == null) {
            res.add(currNodeTarget);
        }
        dfs(node.left,currNodeTarget,res);
        dfs(node.right,currNodeTarget,res);
    }


    }
