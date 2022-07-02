package com.cuntou.stack;

import java.util.TreeMap;

/**
 * @ClassName : _456_132_pattern  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/22  9:40
 */

public class _456_132_pattern {
     /* leetcode 456 号算法题：132 模式
        给你一个整数数组 nums ，数组中共有 n 个整数。
        132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
        并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
        如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。

        输入：nums = [1,2,3,4]
        输出：false

        输入：nums = [3,1,4,2]
        输出：true

        输入：nums = [-1,3,2,0]
        输出：true

        n == nums.length
        1 <= n <= 10^4
        -10^9 <= nums[i] <= 10^9
     */
    //暴力 用三个指针
    public boolean find132pattern1 (int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n ; j++) {
                for (int k = j + 1; k < n ; k++) {
                    //从这里开始优化
                    if ( nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean find132pattern2 (int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int nums1 = nums[0];

        //找到所有的K值来判断是否可以存在K值
        return false;
    }

}
