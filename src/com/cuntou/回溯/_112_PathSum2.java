package com.cuntou.回溯;

import com.cuntou.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _112_PathSum2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/17  20:07
 */

public class _112_PathSum2 {
    public boolean hasPathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs (root, path, res);
        for (List<Integer> onePath : res) {
            int sum = 0;
            for (int val : onePath) {
                sum += val;
            }
            if (sum == target) return true;
        }
        return false;
    }
    public void dfs(TreeNode node,
                    List<Integer> path,
                    List<List<Integer>> res) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, path ,res);
        dfs(node.right, path ,res);

        path.remove(path.size() - 1);
    }

}
