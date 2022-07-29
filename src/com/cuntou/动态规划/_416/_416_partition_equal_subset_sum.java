package com.cuntou.动态规划._416;

/**
 * @ClassName : _416_partition_equal_subset_sum  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/29  14:34
 */

public class _416_partition_equal_subset_sum {
    /* 416. 分割等和子集
    给你一个 只包含正整数 的 非空 数组 nums 。
    请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

    示例 1：
    输入：nums = [1,5,11,5]
    输出：true
    解释：数组可以分割成 [1, 5, 5] 和 [11] 。

    示例 2：
    输入：nums = [1,2,3,5]
    输出：false
    解释：数组不能分割成两个元素和相等的子集。
     
    提示：
    1 <= nums.length <= 200
    1 <= nums[i] <= 100

     */
    //每个元素只能使用一次，那么就是0 1 背包问题
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) return false;

        int target = sum / 2;

        //dp[c]:表示从nums中是否可以找到等于c的元素组合
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int i = 0; i < nums.length ; i++) {
            for (int c = target; c >= 0 ; c--) {
                dp[c] = dp[c] || dp[c - nums[i]];
            }
        }

        return dp[target];
    }
}
