package com.cuntou.动态规划._53;

/**
 * @ClassName : _53_MaxSubArray07  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  15:18
 */

public class _53_MaxSubArray07 {
    //状态压缩
    public int maxSubArray(int[] nums) {
        //状态初始化
        int prevMaxSum = nums[0];
        int maxSum = prevMaxSum;

        //状态转移
        for (int i = 1; i < nums.length; i++) {
            prevMaxSum = Math.max(prevMaxSum + nums[i],nums[i]);
            maxSum = Math.max(maxSum,prevMaxSum);
        }
        return maxSum;
    }
}
