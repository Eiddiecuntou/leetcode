package com.cuntou.排序算法;

/**
 * @ClassName : SecondMaxNumber  //类名
 * @Description :
 * 阿里面试题
 * 在一个很长很长的数组中,如何找到第二大的元素,注意时间复杂度和空间复杂度
 * 输入:nums = [1,2,3,4]
 * 输出:3
 * @Author : 村头 //作者
 * @Date: 2022/5/30  21:07
 */

public class SecondMaxNumber {
    public int getSecondMax(int[] nums) {
        //找最大值就直接使用的是最小值
        int first = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        return second;
    }

}
