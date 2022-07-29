package com.cuntou.动态规划._377;

/**
 * @ClassName : _377_combination_sum_iv  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/29  13:15
 */

public class _377_combination_sum_iv {
    /* 377. 组合总和 Ⅳ
    给你一个由 不同 整数组成的数组 nums ，
    和一个目标整数 target 。
    请你从 nums 中找出并返回总和为 target 的元素组合的个数。

    题目数据保证答案符合 32 位整数范围。

    示例 1：
    输入：nums = [1,2,3], target = 4
    输出：7
    解释：
    所有可能的组合为：
    (1, 1, 1, 1)
    (1, 1, 2)
    (1, 2, 1)
    (1, 3)
    (2, 1, 1)
    (2, 2)
    (3, 1)
    请注意，顺序不同的序列被视作不同的组合。

    示例 2：
    输入：nums = [9], target = 3
    输出：0
 

    提示：
    1 <= nums.length <= 200
    1 <= nums[i] <= 1000
    nums 中的所有元素 互不相同
    1 <= target <= 1000

     */
    //完全背包问题
    //用一堆数字来满足一个目标
    //在nums列表中可重复的数字组合中，使组合的之和等他target
    public int combinationSum5(int[] nums, int target) {
        //1.状态定义：dp[c] :能够凑成target为C的组合数
        int[] dp = new int[target + 1];

        //2.状态初始化
        //当选择0的时候可以知道是不选择任何的数,只有一种组合
        dp[0] = 1;

        for (int c = 1; c <= target; c++) {
            for (int i = 0; i < nums.length; i++) {
                if (c >= nums[i]) dp[c] = dp[c] + dp[c - nums[i]];
            }
        }

        return dp[target];

    }
}
