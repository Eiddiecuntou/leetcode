package com.cuntou.动态规划._53;

/**
 * @ClassName : _53_MaxSubArray05  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/7/25  14:54
 */

public class _53_MaxSubArray05 {
    //数组的时候经常使用的一个前缀和的使用方法
    public int maxSubArray(int[] nums) {
        //状态定义：prefixSum[i]，表示数组[0,i]的累加和
        int[] prefixSum = new int[nums.length];
        //状态初始化
        prefixSum[0] = nums[0];
        int maxSum = prefixSum[0];
        for (int i = 1; i < nums.length ; i++) {
            prefixSum[i] = prefixSum[i -1] + nums[i];
            maxSum = Math.max(maxSum,prefixSum[i]);
        }
        //转移方程了
        for (int i = 1; i < nums.length ; i++) {
            for (int j = i; j < nums.length ; j++) {
                int sum = prefixSum[j] - prefixSum[i - 1];
                maxSum = Math.max(maxSum,sum);
            }
        }
        return maxSum;
     }
}
