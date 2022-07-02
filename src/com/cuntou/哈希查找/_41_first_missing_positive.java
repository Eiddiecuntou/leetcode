package com.cuntou.哈希查找;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : _41_first_missing_positive  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/18  18:51
 */

public class _41_first_missing_positive {
    /*
    leetcode 41 号算法题：缺失的第一个正数

    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

    输入：nums = [1,2,3]
    输出： 4

    输入：nums = [3,4,-1,1]
    输出： 2

    - 0 <= nums.length <= 300
    - -2^31 <= nums[i] <= 2^31 - 1

    进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
     */
    //暴力
    public int firstMissingPositive1(int[] nums) {
        for (int i = 1; i < nums.length ; i++) {
            boolean isExists = false;
            //线性查找
            for (int j = 0; j < nums.length ; j++) {
                if (nums[j] == i) isExists = true;
            }
            if (!isExists) return i;
        }
        return nums.length + 1;
    }
    //哈希查找
    public int firstMissingPositive2(int[] nums) {
        Set<Integer> ser = new HashSet<>();
        for (int num :nums) ser.add(num);

        for (int i = 0; i < nums.length ; i++) {
            //哈希查找
            if (!ser.contains(i)) return i;
        }
        return nums.length + 1;

    }
}
