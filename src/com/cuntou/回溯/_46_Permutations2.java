package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _46_Permutations2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/18  9:02
 */

public class _46_Permutations2 {
    //框架
    //本质上是树的深度优先遍历
    public List<List<Integer>>  permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, res);
        return res;
    }
    public void dfs(int[] nums,
                    List<Integer> path,
                    List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, path, res);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(new _46_Permutations2().permute(new int[]{1, 2, 3}));
    }
}

