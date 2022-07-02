package com.cuntou.排序算法;

import java.util.regex.Pattern;

/**
 * @ClassName : _51_nums_nisort  //类名
 * @Description : 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 * @Author : 村头 //作者
 * @Date: 2022/5/31  15:56
 */

public class _51_nums_nisort {
    public int reversePairs0(int[] nums) {
        //暴力解法
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 两个两个的比较，对比每个元素之间的关系
     * 两个有序的数组来进行合并，两个子数组之间
     * 合并的过程中 怎么计算有序的子数组
     * 34 小于 9  9的前面有多少个元素 mid - i + 1
     * 主要比较这些的数据[i] 和 [j] 比较谁小，谁小就进逆序对。
     */

    public int reversePairs1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 为了不改变原数组，这里先将原数组拷贝一份
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[nums.length];
        return reversePairs(copy, 0, nums.length - 1, temp);

    }

    private int reversePairs(int[] nums, int left,
                             int right, int[] temp) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int leftReversePairs = reversePairs(nums, left, mid, temp);
        int rightReversePairs = reversePairs(nums, mid + 1, right, temp);

        //合并 分治之后
        int mergeReversePairs = mergeAndCountReversePairs(nums, left, mid, right, temp);
        //计算逆序对，左边排序的之后和右边排序之后就会有这么多 将
        return leftReversePairs + rightReversePairs + mergeReversePairs;

    }

    private int mergeAndCountReversePairs(int[] data, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++) {
            tmp[i] = data[i];
        }

        int count = 0;
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                //左边没有元素，右边有元素
                data[k] = tmp[j++];
            } else if (j == right + 1) {
                //右边没有元素，左边有元素
                data[k] = tmp[i++];
            } else if (tmp[i] <= tmp[j]) {
                data[k] = tmp[i++];
            } else {
                data[k] = tmp[j++];
                //计算tmp[j]的逆序对
                count += mid - i + 1;
            }
        }
        return count;

    }
}
