package com.cuntou.贪心算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _45_JumpGame1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/21  14:33
 */

public class _45_JumpGame1 {
    //给定一个整数数组，你最初位于数组的第一个位置
    //数组中的每个元素代表在该位置上可以旋转跳跃
    //你的目标就是使用最少的跳跃次数达到数组的最候一个位置
    private int minSteps = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return minSteps == Integer.MAX_VALUE ? 0 : minSteps;
    }

    private void dfs(int[] nums, int jumpIndex, List<Integer> path) {
        if (jumpIndex == nums.length - 1) {
            minSteps = Math.min(minSteps, path.size());
        }

        for (int i = 1; i <= nums[jumpIndex] ; i++) {
            if (jumpIndex + i >= nums.length) continue;
            path.add(i);
            dfs(nums, jumpIndex + i, path);
            path.remove(path.size() - 1);
        }
    }
}
