package com.cuntou.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _46_Permutations1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/17  21:20
 */

public class _46_Permutations1 {
    //DFS
    public List<List<Integer>>  permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, -1,path,res);
        return res;
    }

    private void dfs(int[] nums, int index,
                     List<Integer> path,
                     List<List<Integer>> res) {
        if (path.size() == nums.length) return;

        if (index != -1) path.add(nums[index]);
        //所以不能放到同一个地方去
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length ; i++) {
            dfs(nums, i, path, res);
        }
        // 回溯的过程中，将当前的节点从 path 中删除
        if (index != -1) path.remove(path.size() - 1);
    }
}
