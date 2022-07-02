package com.cuntou.滑动窗口;

import jdk.nashorn.internal.ir.WhileNode;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @ClassName : _643_maximum_average_subarray_i  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/30  19:31
 */

public class _643_maximum_average_subarray_i {
    /* leetcode 643. 子数组最大平均数 I
    给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

    示例：
    输入：[1,12,-5,-6,50,3], k = 4
    输出：12.75
    解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
    2、51、42

    提示：
    1 <= k <= n <= 30,000。
    所给数据范围 [-10,000，10,000]。
     */
    //暴力解法
    public double findMaxAverage (int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1 ; i++) {
            int sum = 0;
            for (int j = i; j < i + k ; j++) {
                sum += nums[j];
            }
            maxSum = Math.max(maxSum, sum);

        }
        return (double) maxSum / k;

    }
    //重复计算过多,可以考虑到前缀和的实现
    public double findMaxAverage1 (int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length ; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1 ; i++) {
            int sum = prefixSum[i + k] - prefixSum[i];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }
    //滑动窗口
    public double findMaxAverage3 (int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int left = 0,right = 0;
        int windowSum = 0;
        //在维护每一个窗口得时候需要进行维护每一个窗口得值,可以降低空间复杂度
        //在滑动得时候去降低空间复杂度
        while (right < nums.length) {
            windowSum += nums[right];
            //满足窗口的条件,达到了固定的窗口的大小
            if (right - left + 1 == k  ) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[left];
                left++;
            }
            right++;
        }
        return (double) maxSum / k;
    }


}
