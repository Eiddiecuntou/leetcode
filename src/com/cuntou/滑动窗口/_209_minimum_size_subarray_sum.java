package com.cuntou.滑动窗口;

/**
 * @ClassName : _209_minimum_size_subarray_sum  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/30  21:57
 */

public class _209_minimum_size_subarray_sum {
    /* leetcode 209. 长度最小的子数组
    给定一个含有 n 个正整数的数组和一个正整数 target 。

    找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 
    [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
    如果不存在符合条件的子数组，返回 0 。

    示例 1：
    输入：target = 7, nums = [2,3,1,2,4,3]
    输出：2

    解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    示例 2：
    输入：target = 4, nums = [1,4,4]
    输出：1

    示例 3：
    输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    输出：0
     
    提示：
    1 <= target <= 10^9
    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^5
     
    进阶：
    如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。

     */
    public int minSubArrayLen1 (int target,int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            int sum = 0;
            for (int j = i; j < nums.length ; j++) {
                sum += nums[j];
                //这一步是我没有想到得, 挨个添加直接继续使用循环去做得
                if (sum >= target) {
                    ans = Math.max(ans,j - i + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //使用滑动窗口
    public int minSubArrayLen2 (int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0,right = 0;
        int windowSum = 0;
        while (right < nums.length) {
            windowSum += nums[right];
            while ( windowSum >= target) {
                ans = Math.min(ans, right - left + 1);
                windowSum -= nums[left];
                left++;
            }
            right++;
        }
        return  ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
