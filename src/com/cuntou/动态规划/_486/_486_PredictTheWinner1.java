package com.cuntou.动态规划._486;

/**
 * @ClassName : _486_PredictTheWinner1  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/26  15:26
 */

public class _486_PredictTheWinner1 {
    //预测赢家
    //只能从两端取值
    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1) >= 0;
    }

    private int dfs(int[] nums, int i, int j) {
        if (i == j) return nums[i];

        int pickI = nums[i] - dfs(nums, i + 1, j);
        int pickJ = nums[j] - dfs(nums, i, j - 1);

        return Math.max(pickI, pickJ);
    }

}
