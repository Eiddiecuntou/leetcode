package com.cuntou.动态规划._494;

/**
 * @ClassName : _494_target_sum  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/29  13:58
 */

public class _494_target_sum {
     /* 494. 目标和
    给你一个整数数组 nums 和一个整数 target 。

    向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

    例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，
    然后串联起来得到表达式 "+2-1 = 1" 。
    返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。


    示例 1：
    输入：nums = [1,1,1,1,1], target = 3
    输出：5
    解释：一共有 5 种方法让最终目标和为 3 。
    -1 + 1 + 1 + 1 + 1 = 3
    +1 - 1 + 1 + 1 + 1 = 3
    +1 + 1 - 1 + 1 + 1 = 3
    +1 + 1 + 1 - 1 + 1 = 3
    +1 + 1 + 1 + 1 - 1 = 3

     */
    //目标和 转换成
    // 背包问题
    //物品-数组的问题
    //首先 数组中的总数之和sum
    //负数之和是neg,设置为正数的数字的总和为sum - neg
    //（sum - neg) - neg = target =》（sum - target) / 2 = neg
    public int findTargetSunWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += sum;
        }

        int diff = sum - target;
        if (diff < 0 || diff % 2 == 1) return 0;

        int neg = diff / 2;

        // 在数组 nums 列表中不可重复的选择数字组合，使得组合中所有数字之和为 neg
        // 求有多少组合数？
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length ; i++) {
            for (int c = neg; c >= nums[i] ; c--) {
                dp[c] = dp[c] + dp[c - nums[i]];
            }
        }

        return dp[neg];
    }

}
