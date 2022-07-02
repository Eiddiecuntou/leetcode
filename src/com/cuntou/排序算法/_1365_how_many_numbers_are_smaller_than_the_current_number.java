package com.cuntou.排序算法;

import java.util.Arrays;

/**
 * @ClassName : _1365_how_many_numbers_are_smaller_than_the_current_number  //类名
 * @Description :   //描述
 * @Author : 村头 //作者
 * @Date: 2022/6/8  21:39
 */

public class _1365_how_many_numbers_are_smaller_than_the_current_number {
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int n = nums.length;
        //维护元素值 -> 使用元素关系,
        //排完序之后的索引在哪里,就在哪里,主要是索引
        //行就是这些个整个元素的值,
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            // bug 修复：第二个值存储索引
            data[i][1] = i;
        }

        // 按照元素值升序排序
        Arrays.sort(data, (o1, o2) -> o1[0] - o2[0]);

        int[] ans = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ans[data[i][1]] = prev;
        }

        return ans;

    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n ; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
            ret[i] = cnt;
        }
        return ret;
    }
}
