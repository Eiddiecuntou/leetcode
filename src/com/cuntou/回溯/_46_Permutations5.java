package com.cuntou.回溯;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : _46_Permutations2  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/18  9:02
 */
//时间复杂度
//含有重复元素的数组，这样就会被取消了

public class _46_Permutations5 {
    //框架
    //本质上是树的深度优先遍历
    // O(n! * n^2)
    public List<List<Integer>>  permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        //排序一下,整个去重的基础
        Arrays.sort(nums);
        dfs(nums, path, res, used);
        return res;
    }
    public void dfs(int[] nums,
                    List<Integer> path,
                    List<List<Integer>> res,
                    boolean[] used) {
        //O (n^2)
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        //O (n)
        for (int i = 0; i < nums.length; i++) {
            //剪枝的问题
            //遍历了所有的元素，查询了一下，时间复杂度是O（n）
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, path, res, used);
            //这个是O（1）
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        System.out.println(new _46_Permutations5().permute(new int[]{1, 2, 3}));
    }
}

